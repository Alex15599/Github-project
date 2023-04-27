#!/bin/sh
###################################
#version 1.2.3
#modify at 20210408
#port:6379
#sport:6380
#sh cmd.sh redis.tar /redis redis 6379 6380 master masterip masterport pwd
###################################
soft=$1
appdir=$2
user=$3
port=$4
sport=$5
role=$6
masterip=$7
masterport=$8
pwd="Redis@Pwd001"
if [[ -d "$appdir/redis" ]];then
	echo "appdir:$appdir/redis is exist,please remove it,first"
	exit 1
fi
if [[ -d "$appdir/sentinel" ]];then
	echo "appdir:$appdir/sentinel is exist,please remove it,first"
	exit 1
fi
c1=`id $user|wc -l`
if [[ $c1 -eq 0 ]];then
	echo "deploy error,$user:$user not exist"
	exit 1
fi
if [[ -n $9 ]];then
	pwd=$9
fi
cd /tmp
if [[ ! -f $soft ]];then
	echo "soft is not exist,"
	exit 1
fi
mkdir -p $appdir/redis/{data,logs,etc,run,bin}
mkdir -p $appdir/sentinel/{data,logs,etc,run,bin}
sn=`date +%s`
mkdir redis_$sn
cp $soft redis_$sn
cd redis_$sn
tar xvf $soft
onedir=`ls -rtl |grep -v tar|grep -v gz|grep -v zip |tail -1 |awk '{print $NF}'`
cd $onedir
make 
cp redis.conf    $appdir/redis/etc
cp sentinel.conf $appdir/sentinel/etc
cd src
cp redis-sentinel redis-check-aof redis-benchmark redis-check-rdb redis-cli redis-server $appdir/sentinel/bin
cp redis-sentinel redis-check-aof redis-benchmark redis-check-rdb redis-cli redis-server $appdir/redis/bin
chown -R $user:$user $appdir/redis
chown -R $user:$user $appdir/sentinel
echo "##############start config redis##############"
cd $appdir/redis/etc
cp redis.conf redis.conf_$sn.bak
sed -i "s@bind 127.0.0.1@bind 0.0.0.0@g"                              		  $appdir/redis/etc/redis.conf
sed -i "s@port 6379@port $port@g"                              			      $appdir/redis/etc/redis.conf
sed -i "s@daemonize no@daemonize yes@g"                               		  $appdir/redis/etc/redis.conf
sed -i "s@protected-mode yes@protected-mode no@g"                     		  $appdir/redis/etc/redis.conf
sed -i "s@redis_6379.pid@redis_${port}.pid@g"                         		  $appdir/redis/etc/redis.conf
sed -i "s@logfile \"\"@logfile \"$appdir/redis/logs/redis_${port}.log\"@g"    $appdir/redis/etc/redis.conf
sed -i "s@dir ./@dir $appdir/redis/data@g"                            		  $appdir/redis/etc/redis.conf
sed -i "s@redis_6379.pid@redis_${port}.pid@g"                              	  $appdir/redis/etc/redis.conf
sed -i "s@appendonly no@appendonly yes@g"                              	      $appdir/redis/etc/redis.conf
sed -i '/masterauth <master-password>/d' 									  $appdir/redis/etc/redis.conf
echo "masterauth $pwd">>													  $appdir/redis/etc/redis.conf
sed -i '/# requirepass/d' 													  $appdir/redis/etc/redis.conf
echo "requirepass $pwd">>													  $appdir/redis/etc/redis.conf
if [[ $role == "slave" ]];then
	echo "slaveof $masterip $masterport">>									  $appdir/redis/etc/redis.conf
fi
echo "$port">>																  $appdir/redis/etc/$port.port
echo "##############start config sentinel##############"
cd $appdir/sentinel/etc
cp sentinel.conf sentinel.conf_$sn.bak
sed -i "s@bind 127.0.0.1@bind 0.0.0.0@g"                                        $appdir/sentinel/etc/sentinel.conf
sed -i "s@port 26379@port $sport@g"                              			    $appdir/sentinel/etc/sentinel.conf
sed -i "s@daemonize no@daemonize yes@g"                               			$appdir/sentinel/etc/sentinel.conf
sed -i "s@redis-sentinel.pid@redis-sentinel_${sport}.pid@g"                     $appdir/sentinel/etc/sentinel.conf
sed -i "s@logfile \"\"@logfile \"$appdir/sentinel/logs/redis_${sport}.log\"@g"  $appdir/sentinel/etc/sentinel.conf
sed -i "s@dir /tmp@dir $appdir/sentinel/data@g"                                 $appdir/sentinel/etc/sentinel.conf
sed -i '/# protected-mode no/d' 												$appdir/sentinel/etc/sentinel.conf
sed -i '/sentinel down-after-milliseconds mymaster/d' 							$appdir/sentinel/etc/sentinel.conf
sed -i '/sentinel failover-timeout mymaster/d' 									$appdir/sentinel/etc/sentinel.conf
sed -i '/sentinel auth-pass mymaster/d' 										$appdir/sentinel/etc/sentinel.conf
sed -i '/sentinel monitor mymaste/d'											$appdir/sentinel/etc/sentinel.conf
sed -i '/sentinel parallel-syncs mymaster/d'									$appdir/sentinel/etc/sentinel.conf
echo "protected-mode no">>														$appdir/sentinel/etc/sentinel.conf
echo "bind 0.0.0.0">>															$appdir/sentinel/etc/sentinel.conf
echo "sentinel monitor mymaster $masterip $masterport 2">>						$appdir/sentinel/etc/sentinel.conf
echo "sentinel auth-pass mymaster $pwd">>										$appdir/sentinel/etc/sentinel.conf
echo "sentinel down-after-milliseconds mymaster 5000">>							$appdir/sentinel/etc/sentinel.conf
echo "sentinel failover-timeout mymaster 180000">>								$appdir/sentinel/etc/sentinel.conf
echo "sentinel config-epoch mymaster 24">>										$appdir/sentinel/etc/sentinel.conf
echo "sentinel leader-epoch mymaster 24">>										$appdir/sentinel/etc/sentinel.conf
echo "sentinel current-epoch 24">>												$appdir/sentinel/etc/sentinel.conf
echo "$sport">>																	$appdir/sentinel/etc/$sport.port
echo "##############start config system##############"
chmod +x /etc/rc.d/rc.local
sed -i "/\\$appdir\/redis\/bin\/redis-server/d"   /etc/rc.d/rc.local
sed -i "/\\$appdir\/redis\/bin\/redis-sentinel/d" /etc/rc.d/rc.local
echo "su - $user -c \"nohup $appdir/redis/bin/redis-server $appdir/redis/etc/redis.conf &\""        >>/etc/rc.d/rc.local
echo "su - $user -c \"nohup $appdir/redis/bin/redis-sentinel $appdir/sentinel/etc/sentinel.conf &\"">>/etc/rc.d/rc.local
sed -i '/never/d' /etc/rc.d/rc.local
echo "echo never > /sys/kernel/mm/transparent_hugepage/enabled">>/etc/rc.d/rc.local
echo never > /sys/kernel/mm/transparent_hugepage/enabled
sed -i '/vm.overcommit_memory/d' /etc/sysctl.conf
echo "vm.overcommit_memory = 1">>/etc/sysctl.conf
sed -i '/net.core.somaxconn/d' /etc/sysctl.conf
echo "net.core.somaxconn = 1024">>/etc/sysctl.conf
sed -i '/'"$user"'/d' /etc/security/limits.conf
echo "$user soft nofile 65536" >>/etc/security/limits.conf
echo "$user hard nofile 65536" >>/etc/security/limits.conf
echo "$user soft nproc 65536" >>/etc/security/limits.conf
echo "$user hard nproc 65536" >>/etc/security/limits.conf
sysctl -p
su - $user -c "nohup $appdir/redis/bin/redis-server $appdir/redis/etc/redis.conf &"
su - $user -c "nohup $appdir/redis/bin/redis-sentinel $appdir/sentinel/etc/sentinel.conf &"
exit 0