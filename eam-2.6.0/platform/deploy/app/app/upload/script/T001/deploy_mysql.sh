#!/bin/sh
##########################################
#version 1.2.3 modify at 20210412
#sh cmd.sh mysqlsoft mysqldir mysqlpwd
##########################################
mysqlsoft="mysql-5.7.32-linux-glibc2.12-x86_64.tar.gz"
mysqldir="/usr/local"
mysqlpwd="Root@aKb@Root"
########################################
#Deploy Mysql
########################################
echo "start to deploy mysql"
mysqldir="/usr/local"
soft="soft.tar.gz"
if [[ -n $1 ]];then
	soft=$1
else
	echo "deploy error!parameter failed"
	exit 1
fi
if [[ -n $2 ]];then
	mysqldir=$2
else
	echo "deploy error!parameter failed"
	exit 1
fi
if [[ -n $3 ]];then
	mysqlpwd=$3
else
	echo "deploy error!parameter failed"	
	exit 1
fi
cd /tmp/
if [[ ! -f $soft ]];then
	echo "Deply Soft Match Failed"
	exit 1
fi
if [[ -d $mysqldir ]];then
	echo "deploy error,mysqldir:$mysqldir exist,please remove it first."
	exit 1
fi
glibcnt=`strings /lib64/libc.so.6|grep GLIBC|grep 2.12|wc -l`
if [[ $glibcnt -eq 0 ]];then
	echo "GLIBC 2.12 Match Failed"
	exit 1
fi
ifx86=`cat /proc/version|grep x86_64|wc -l`
if [[ $ifx86 -eq 0 ]];then
	echo "Linux x86_64 Match Failed"
	exit 1
fi
if [[ -d "${mysqldir}/mysql/data" ]];then
	echo "${mysqldir}/mysql/data Exists Deploy Failed,Please remove it first!"
	exit 1
fi
user=mysql
groupadd $user
useradd -r -g $user $user
echo 'OracleDbaOracle' |passwd --stdin  $user
mkdir -p ${mysqldir}/mysql/data
chown -R $user:$user /usr/local/mysql
if [[ -f "/etc/my.cnf" ]];then
	d=`date "+%Y_%m_%d_%H_%M_%S"`
	mv /etc/my.cnf /etc/my.cnf.$d
fi
if [[ -f "/etc/security/limits.conf" ]];then
	sed -i '/'"$user"'/d' /etc/security/limits.conf
	echo "$user soft nofile 16384 ">>/etc/security/limits.conf
	echo "$user hard nofile 16384 ">>/etc/security/limits.conf
	echo "$user soft nproc 16384 ">>/etc/security/limits.conf
	echo "$user hard nproc 65536 ">>/etc/security/limits.conf
fi
mycnftmp="/tmp/my.cnf.tmp"
cat > $mycnftmp <<EOF
[mysqld]
basedir=/usr/local/mysql
datadir=/usr/local/mysql/data
pid-file=/usr/local/mysql/mysqld.pid
socket=/usr/local/mysql/mysql.sock
log-error=/usr/local/mysql/mysqld.log
lc-messages=en_US
lc-messages-dir=/usr/local/mysql/share
symbolic-links=0
port=3306
sql_mode='STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION'
[client]
default-character-set=utf8
[mysql]
default-character-set=utf8
[mysqld]
log-bin=mysql-bin
binlog-format=ROW
server_id=1
max_connections=1000
init_connect='set collation_connection = utf8_unicode_ci'
init_connect='set names utf8'
character-set-server=utf8
collation-server=utf8_unicode_ci
skip-character-set-client-handshake
EOF
smysqldir="/usr/local"
cat $mycnftmp |sed "s:${smysqldir}:${mysqldir}:g">/etc/my.cnf
cp $soft ${mysqldir}/mysql
cd $mysqldir/mysql
tar xvf $soft
onedir=`ls -rtl |tail -1 |awk '{print $NF}'`
mv $onedir/* .
chown -R $user:$user $mysqldir/mysql
rm -rf /tmp/mysql.sock
ln -s $mysqldir/mysql/mysql.sock /tmp/mysql.sock
$mysqldir/mysql/bin/mysqld --initialize-insecure --user=mysql --basedir=$mysqldir/mysql--datadir=$mysqldir/mysql/data
echo "start mysql command list:"
echo "nohup $mysqldir/mysql/bin/mysqld_safe &"
su - $user -c "nohup $mysqldir/mysql/bin/mysqld_safe &"
sleep 10
echo "use mysql;">init.sql
echo "update mysql.user set authentication_string=password('$mysqlpwd') where user='root' and Host = 'localhost';">>init.sql
echo "grant all privileges on *.* to 'root'@'%' identified by '$mysqlpwd'  WITH GRANT OPTION; ">>init.sql
echo "flush privileges;">>init.sql
$mysqldir/mysql/bin/mysql -uroot <init.sql
rm -rf init.sql
chmod +x /etc/rc.d/rc.local
chown $user:$user /etc/my.cnf
sed -i '/mysql/d' /etc/rc.d/rc.local
echo "su - $user -c \"nohup $mysqldir/mysql/bin/mysqld_safe &\"">> /etc/rc.d/rc.local
cat /etc/rc.d/rc.local
exit 0
