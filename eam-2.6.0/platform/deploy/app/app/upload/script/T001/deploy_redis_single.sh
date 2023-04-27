#!/bin/sh
###################################
#version 1.2.3 modify at 20210412
#sh cmd.sh redis.tar /redis redis 6379
###################################
soft=$1
appdir=$2
user=$3
port=6379
if [[ -d $appdir ]];then
	echo "appdir:$appdir is exist,please remove it,first"
	exit 1
fi 
cd /tmp
if [[ ! -f $soft ]];then
	echo "soft is not exist,"
	exit 1
fi
if [[ -n $4 ]];then
	port=$4
fi
c1=`id $user|wc -l`
if [[ $c1 -eq 0 ]];then
	echo "deploy error,user:$user not exist"
	exit 1
fi
mkdir -p $appdir
mkdir -p $appdir/{data,logs,etc,run,bin}
sn=`date +%s`
mkdir redis_$sn
cp $soft redis_$sn
cd redis_$sn
tar xvf $soft
onedir=`ls -rtl |grep -v tar|grep -v gz|grep -v zip |tail -1 |awk '{print $NF}'`
cd $onedir
make 
cp redis.conf $appdir/etc
cd src
cp redis-sentinel redis-check-aof redis-benchmark redis-check-rdb redis-cli redis-server $appdir/bin
chmod +x /etc/rc.d/rc.local
sed -i '/redis/d' /etc/rc.d/rc.local
echo "su - $user -c \"nohup $appdir/bin/redis-server $appdir/etc/redis.conf &\"">>/etc/rc.d/rc.local
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
chown -R $user:$user $appdir
cd $appdir/etc
cp redis.conf redis.conf_$sn.bak
sed -i "s@bind 127.0.0.1@bind 0.0.0.0@g"                              			redis.conf
sed -i "s@port 6379@port $port@g"                              			        redis.conf
sed -i "s@daemonize no@daemonize yes@g"                               			redis.conf
sed -i "s@protected-mode yes@protected-mode no@g"                     			redis.conf
sed -i "s@redis_6379.pid@redis_${port}.pid@g"                         			redis.conf
sed -i "s@logfile \"\"@logfile \"$appdir/logs/redis_${port}.log\"@g"      		redis.conf
sed -i "s@dir ./@dir $appdir/data@g"                             				redis.conf
sed -i "s@redis_6379.pid@redis_${port}.pid@g"                              		redis.conf
su - $user -c "nohup $appdir/bin/redis-server $appdir/etc/redis.conf &"
exit 0