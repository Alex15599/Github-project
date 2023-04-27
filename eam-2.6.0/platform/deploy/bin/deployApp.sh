#!/bin/sh
modify_date="2023/04/25"
####################################################################################
# run:
#   sh appInstallFull.sh
# check list:
#   test on RedHat 7.9,8.0,8.2 or CentOS
#   check yum source is ok
#   check network connect is ok
# soft list:
#   mysql_soft:/tmp/mysql-5.7.37-linux-glibc2.12-x86_64.tar.gz
#   java_soft:/tmp/jdk-8u333-linux-x64.tar.gz
#   app_soft:/tmp/app_release_last.tar.gz
# clear all
#   rm -rf /app/java
#   rm -rf /app/db
#   rm -rf /app/app
#   ps -ef|grep java |grep -v grep |awk '{print $2}'|xargs kill -9
#   ps -ef|grep mysql |grep -v grep |awk '{print $2}'|xargs kill -9
#
#                                                                 modify at $modify_date
#                                                                 by lank
# action
#  sh deploy.sh         // app_release_last.tar.gz
#  sh deploy.sh 2.6.0   // app_release_2.6.0.tar.gz
####################################################################################
################################################################  config
echo "script version:$modify_date"
app_version="last"
MYSQL_PORT=3308
MYSQL_CNF=/etc/my_plat.cnf
MYSQL_SOCK_NAME=mysql_plat.sock
app_port=8089
db_port=$MYSQL_PORT
db_user=root
db_pwd=root_pwd
db_name=foxnic
db_host=127.0.0.1
bpm_port=8099
base_dir="/app"
echo "MYSQL_PORT:$MYSQL_PORT"
echo "MYSQL_CNF:$MYSQL_CNF"
echo "MYSQL_SOCK_NAME:$MYSQL_SOCK_NAME"
if [[ -n $1 ]];then
	app_version=$1
fi
soft_base_dir=/tmp
mysql_soft=$soft_base_dir/mysql-5.7.37-linux-glibc2.12-x86_64.tar.gz
mysql_soft_md5=423915249cc67bbfa75223d9753cde77
app_soft_name=app_release_${app_version}.tar.gz
app_soft=$soft_base_dir/$app_soft_name
java_file=jdk-linux-x64.tar.gz
java_soft=$soft_base_dir/$java_file
java_soft_md5=913c45332b22860b096217d9952c2ea4
java_soft_remote=1
## directory
java_dir="$base_dir/java"
app_dir="$base_dir/app"
mysql_dir="$base_dir/db"
## command
JAVA=$java_dir/java/bin/java
MYSQL_HOME=$mysql_dir/mysql
MYSQL=$mysql_dir/mysql/bin/mysql
################################################################ verify command,netstat
yum -y install nc libaio unzip zip telnet net-tools wget java numactl
yum -y install glibc-*
#strings command need it
yum -y install binutils*base*x86_64
#centos 8.0
yum -y install libncurses*
cd $soft_base_dir
echo "start to verify command"
which netstat>/dev/null
netstatRes=$?
if [[ $netstatRes -ne 0 ]];then
	echo "install check error,netstat command not exist,please install it first!"
	exit 1
fi
################################################################ check port
db_port_cnt=`netstat -ant|grep LISTEN|grep ":$db_port"|wc -l`
if [[ $db_port_cnt -ne 0 ]];then
	echo "install check error,db_port:$db_port already in use."
	exit 1
fi
app_port_cnt=`netstat -ant|grep LISTEN|grep ":$app_port"|wc -l`
if [[ $app_port_cnt -ne 0 ]];then
	echo "install check error,app_port:$app_port already in use."
	exit 1
fi
bpm_port_cnt=`netstat -ant|grep LISTEN|grep ":$bpm_port"|wc -l`
if [[ $bpm_port_cnt -ne 0 ]];then
	echo "install check error,bpm_port:$bpm_port already in use."
	exit 1
fi
################################################################ Install Function
function verifySoft(){
	if [[ -f $1 ]];then
		return 0
	else
		return 1
	fi
}
function clearTips(){
	echo "########################clear Tips########################"
	echo "if you want to reinstall full app,please run below commands"
	echo "rm -rf $java_dir"
	echo "rm -rf $mysql_dir"
	echo "rm -rf $app_dir"
	echo "ps -ef|grep java |grep -v grep |awk '{print \$2}'|xargs kill -9"
  echo "ps -ef|grep mysql |grep -v grep |awk '{print \$2}'|xargs kill -9"
}
function installJava(){
	echo "#############install java start#############"
	if [[ ! -d $java_dir ]];then
		echo "command:mkdir -p $java_dir"
		mkdir -p $java_dir
	fi
	verifySoft $java_soft
	java_soft_VR=$?
	if [[ $java_soft_VR -eq 1 ]];then
		echo "install error,java_soft:$java_soft not exist";
		clearTips
		echo "failed">$java_dir/result.txt
		echo "#############install java failed#############"
		exit 1
	fi
	cd $java_dir
	cp $java_soft .
	echo "start to tar $java_soft"
	tar xvf $java_soft >/dev/null
	cur_dir=`ls -rtl|grep j|grep -v gz|awk '{print $NF}'|tail -1`
	mv $cur_dir java
	echo "success">$java_dir/result.txt
	echo "#############install java success#############"
	echo ""
	echo ""
}
function installMysql(){
	echo "#############install mysql start#############"
	if [[ ! -d $mysql_dir ]];then
		echo "command:mkdir -p $mysql_dir"
		mkdir -p $mysql_dir
	fi
	verifySoft $mysql_soft
	mysql_soft_VR=$?
	if [[ $mysql_soft_VR -eq 1 ]];then
		echo "install error,mysql_soft:$mysql_soft not exist";
		echo "#############install mysql failed#############"
		clearTips
		exit 1
	fi
  which strings
  stringsR=$?
  ######stringsR check
  if [[ stringsR -eq 0 ]];then
    glibcnt=`strings /lib64/libc.so.6|grep GLIBC|grep 2.12|wc -l`
    if [[ $glibcnt -eq 0 ]];then
      echo "GLIBC 2.12 Match Failed"
      clearTips
      exit 1
    fi
  fi
	if [[ -d "${mysql_dir}/mysql/data" ]];then
		echo "${mysql_dir}/mysql/data Exists Deploy Failed,Please remove it first!"
		clearTips
		exit 1
	fi
	groupadd mysql
	useradd -r -g mysql mysql
	mkdir -p ${mysql_dir}/mysql/data
	mkdir -p /home/mysql
	chown mysql:mysql /home/mysql
	chmod 755 /home/mysql
	usermod -s /bin/bash mysql
	#chown -R mysql:mysql /usr/local/mysql
	if [[ -f "/etc/my.cnf" ]];then
		d=`date "+%Y_%m_%d_%H_%M_%S"`
		mv /etc/my.cnf /etc/my.cnf.$d
	fi
	mycnftmp="/tmp/my.cnf.tmp"
	mkdir -p /usr/local/mysql
	innodb_buffer_pool_size=1024;
	total_mem=`free -m|grep Mem|awk '{print $2}'`
  innodb_buffer_pool_size_pre=`echo "$total_mem"|awk '{printf "%d",$1*0.5*0.75}'`
  #<2048
  if [[ $total_mem -lt 2048 ]];then
    innodb_buffer_pool_size=512
  fi
  #2048<=v<4096
  if [[ $total_mem -ge 2048 && $total_mem -lt 4096 ]];then
    innodb_buffer_pool_size=1024
  fi
  #4096<=v<8192
  if [[ $total_mem -ge 4096 && $total_mem -lt 8192 ]];then
    innodb_buffer_pool_size=2048
  fi
  #8192<=v<16384
  if [[ $total_mem -ge 8192 && $total_mem -lt 16384 ]];then
    innodb_buffer_pool_size=$innodb_buffer_pool_size_pre
  fi
  #v>16384
  if [[ $total_mem -ge 16384 ]];then
    innodb_buffer_pool_size=8192
  fi
  echo "setting innodb_buffer_pool_size value:${innodb_buffer_pool_size}m"
	cat > $mycnftmp <<EOF
[mysqld]
lower_case_table_names = 1
max_allowed_packet = 100M
basedir=/usr/local/mysql
datadir=/usr/local/mysql/data
pid-file=/usr/local/mysql/mysqld.pid
socket=/usr/local/mysql/mysql.sock
log-error=/usr/local/mysql/mysqld.log
lc-messages=en_US
lc-messages-dir=/usr/local/mysql/share
symbolic-links=0
port=$db_port
sql_mode='STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION'
[client]
default-character-set=utf8
[mysql]
default-character-set=utf8
[mysqld]
server_id=1
log-bin=mysql-bin
expire_logs_days=15
binlog-format=ROW
binlog_cache_size=128m
max_binlog_cache_size=512m
max_binlog_size=256m
max_connections=1000
max_connect_errors=2000
max_allowed_packet=256M
skip-external-locking
skip-name-resolve
init_connect='set names utf8'
character-set-server=utf8
skip-character-set-client-handshake
slow_query_log=on
slow_query_log=1
long_query_time=3
slow_query_log_file=/usr/local/mysql/mysql_slow.log
back_log=500
open_files_limit=65535
connect_timeout=60
wait_timeout=3600
key_buffer_size=512m
interactive_timeout=3600
table_open_cache=2000
max_heap_table_size=10M
tmp_table_size=50M
read_buffer_size=10M
read_rnd_buffer_size=10M
sort_buffer_size=20M
join_buffer_size=20M
thread_cache_size=120
innodb_file_per_table=on
innodb_buffer_pool_instances=8
innodb_io_capacity_max=4000
innodb_io_capacity=2000
innodb_log_file_size=512m
innodb_log_buffer_size=64M
innodb_log_files_in_group=4
innodb_buffer_pool_size=${innodb_buffer_pool_size}m
innodb_open_files=65535
innodb_page_cleaners=8
innodb_lock_wait_timeout=10
innodb_read_io_threads=16
innodb_write_io_threads=16
innodb_flush_log_at_trx_commit=2
EOF
  #innodb_buffer_pool_size=75%memory
	smysqldir="/usr/local"
	cat $mycnftmp |sed "s:${smysqldir}:${mysql_dir}:g">$MYSQL_CNF
	cp $mysql_soft ${mysql_dir}/mysql
	cd $mysql_dir/mysql
	tar xvf $mysql_soft
	onedir=`ls -rtl |tail -1 |awk '{print $NF}'`
	mv $onedir/* .
	chown -R mysql:mysql $mysql_dir/mysql
	rm -rf /tmp/$MYSQL_SOCK_NAME
	ln -s $mysql_dir/mysql/mysql.sock /tmp/$MYSQL_SOCK_NAME
	$mysql_dir/mysql/bin/mysqld  --defaults-file=$MYSQL_CNF --initialize-insecure --user=mysql --basedir=$mysql_dir/mysql --datadir=$mysql_dir/mysql/data
	echo "start mysql command list:"
	echo "nohup $mysql_dir/mysql/bin/mysqld_safe --defaults-file=$MYSQL_CNF  &"
	su - mysql -c "nohup $mysql_dir/mysql/bin/mysqld_safe --defaults-file=$MYSQL_CNF  &"
	sleep 10
	echo "use mysql;">init.sql
	echo "update mysql.user set authentication_string=password('$db_pwd') where user='root' and Host = 'localhost';">>init.sql
	echo "grant all privileges on *.* to 'root'@'%' identified by '$db_pwd'  WITH GRANT OPTION; ">>init.sql
	echo "flush privileges;">>init.sql
	$mysql_dir/mysql/bin/mysql -uroot  -S/tmp/$MYSQL_SOCK_NAME <init.sql
	rm -rf init.sql
	chmod +x /etc/rc.d/rc.local
	chown mysql:mysql $MYSQL_CNF
	sed -i '/mysql/d' /etc/rc.d/rc.local
	echo "su - mysql -c \"nohup $mysql_dir/mysql/bin/mysqld_safe --defaults-file=$MYSQL_CNF &\"">> /etc/rc.d/rc.local
	chmod +x /etc/rc.d/rc.local
	cat /etc/rc.d/rc.local
	chown -R mysql:mysql $mysql_dir
	echo "#############install mysql success#############"
	echo ""
	echo ""
}
function installApp(){
	echo "#############install app start#############"
	if [[ ! -d $app_dir ]];then
		echo "command:mkdir -p $app_dir"
		mkdir -p $app_dir
	fi
	verifySoft $app_soft
	app_soft_VR=$?
	if [[ $app_soft_VR -eq 1 ]];then
		echo "install error,app_soft:$app_soft not exist";
		echo "#############install app failed#############"
		clearTips
		exit 1
	fi
	#app.jar
	cd $app_dir
	cp $app_soft .
	tar xvf $app_soft
	cd $app_dir/bin/sql
	tar xvf db.tar.gz
	if [[ -d $app_dir/bin/database-compare-data ]];then
	    rm -rf $app_dir/bin/database-compare-data
	    mkdir -p $app_dir/bin/database-compare-data
	fi
	appConf=$app_dir/bin/app.conf
	echo "">$appConf
	echo "JAVA=$JAVA"                                   >>$appConf
	echo "APP_UID=app"                                  >>$appConf
	echo "APP_NAME=app.jar"                             >>$appConf
	echo "APP_DIR=$app_dir"                             >>$appConf
	echo "BACKUP_DIR=$app_dir/backup"                   >>$appConf
	echo "APP_WEB_PORT=$app_port"                       >>$appConf
	echo "DATA_CLEAR=1"                                 >>$appConf
	echo "MYSQL=$mysql_dir/mysql/bin/mysql"             >>$appConf
	echo "MYSQL_DUMP=$mysql_dir/mysql/bin/mysqldump"    >>$appConf
	echo "MYSQL_ADMIN=$mysql_dir/mysql/bin/mysqladmin"  >>$appConf
	echo "DB_HOST=$db_host"                             >>$appConf
	echo "DB_PORT=$db_port"                             >>$appConf
	echo "DB_NAME=$db_name"                             >>$appConf
	echo "DB_USER=$db_user"                             >>$appConf
	echo "DB_PWD=$db_pwd"                               >>$appConf
	db_create_db_file=$app_dir/bin/sql/createdb.sql
	db_sql_file=$app_dir/bin/sql/db.sql
	db_file_conf_file=$app_dir/bin/sql/confuploadfile.sql
	db_procedure_file=$app_dir/bin/sql/nextVal.sql
	db_clear_data_file=$app_dir/bin/sql/cleardata.sql
	db_app_setting_file=$app_dir/bin/sql/settingapp.sql
	application_tpl_yml=$app_dir/app/app/application_tpl.yml
	application_yml=$app_dir/app/app/application.yml
	bpm_application_tpl_yml=$app_dir/app/bpm/application_tpl.yml
	bpm_application_yml=$app_dir/app/bpm/application.yml
	job_application_tpl_yml=$app_dir/app/job/application_tpl.yml
	job_application_yml=$app_dir/app/job/application.yml
	if [[ ! -f "$db_sql_file" ]];then
	  echo "Error|db sql file:$db_sql_file not exist"
	  echo "deploy failed!"
	  exit 1
	fi
	if [[ ! -f "$db_procedure_file" ]];then
	  echo "Error|db procedure file:$db_procedure_file not exist"
	  echo "deploy failed!"
	  exit 1
	fi
	app_upload_dir=$app_dir/app/app/upload
	MYSQL_DUMP=$mysql_dir/mysql/bin/mysqldump
	MYSQL_ADMIN=$mysql_dir/mysql/bin/mysqladmin
	echo "#########start to create database"
	echo "CREATE DATABASE $db_name DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;" > $db_create_db_file
	echo "CREATE DATABASE ${db_name}_upgrade DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;" >> $db_create_db_file
	db_cnt=`$MYSQL -u$db_user -p$db_pwd -P$MYSQL_PORT -S/tmp/$MYSQL_SOCK_NAME -e 'show databases;' 2>/dev/null|grep $db_name|wc -l `
	if [[ $db_cnt -gt 0 ]];then
	  echo "Error|db:$db_name exist!"
	  echo "deploy failed!"
	  exit 1
	fi
	$MYSQL -u$db_user -p$db_pwd -h$db_host -P$MYSQL_PORT -S/tmp/$MYSQL_SOCK_NAME < $db_create_db_file  2>/dev/null
	tab_cnt=`$MYSQL -u$db_user -p$db_pwd -P$MYSQL_PORT -S/tmp/$MYSQL_SOCK_NAME $db_name -e 'show tables' 2>/dev/null |wc -l`
	echo "create database success,table count:$tab_cnt"
	echo "#########start to backup db"
	$MYSQL_DUMP -u$db_user -p$db_pwd -h$db_host -P$MYSQL_PORT -S/tmp/$MYSQL_SOCK_NAME $db_name  > /tmp/db_backup.sql  2>/dev/null
	echo "#########start to load data"
	$MYSQL -u$db_user -p$db_pwd -h$db_host -P$MYSQL_PORT -S/tmp/$MYSQL_SOCK_NAME $db_name < $db_sql_file  2>/dev/null
	tab_cnt=`$MYSQL -u$db_user -p$db_pwd -P$MYSQL_PORT -S/tmp/$MYSQL_SOCK_NAME $db_name -e 'show tables' 2>/dev/null |wc -l`
	echo "load tables success,table count:$tab_cnt"
	if [[ $tab_cnt -lt 20 ]];then
	  echo "Error|db table count $tab_cnt"
	  echo "deploy failed!"
	  exit 1
	fi
	echo "#########start to create procedure $db_procedure_file"
	$MYSQL -u$db_user -p$db_pwd -h$db_host -P$MYSQL_PORT -S/tmp/$MYSQL_SOCK_NAME $db_name < $db_procedure_file  2>/dev/null
	echo "#########start to conf upload file data $db_file_conf_file"
	$MYSQL -u$db_user -p$db_pwd -h$db_host -P$MYSQL_PORT -S/tmp/$MYSQL_SOCK_NAME $db_name < $db_file_conf_file  2>/dev/null
	echo "#########start to clear data $db_clear_data_file"
	$MYSQL -u$db_user -p$db_pwd -h$db_host -P$MYSQL_PORT -S/tmp/$MYSQL_SOCK_NAME $db_name < $db_clear_data_file  2>/dev/null
	echo "#########start to app setting data $db_app_setting_file"
	$MYSQL -u$db_user -p$db_pwd -h$db_host -P$MYSQL_PORT -S/tmp/$MYSQL_SOCK_NAME $db_name < $db_app_setting_file  2>/dev/null
	echo "#########other setting"
	setting_file="/tmp/setting_file.sql"
	echo "">$setting_file
	echo "delete from sys_licence where 1=1;">>$setting_file
	echo "insert into sys_licence select * from sys_licence_free_full;">>$setting_file
	echo "update sys_resourze set access_type='LOGIN' where 1=1;">>$setting_file
	$MYSQL -u$db_user -p$db_pwd -h$db_host -P$MYSQL_PORT -S/tmp/$MYSQL_SOCK_NAME $db_name < $setting_file  2>/dev/null
	echo "#########start to create application.yml from $application_tpl_yml"
	cat $application_tpl_yml>$application_yml
	sed -i "s@APP_UPLOAD_DIR@$app_upload_dir@g"     $application_yml
	sed -i "s/APP_WEB_PORT/$app_port/g"             $application_yml
	sed -i "s/APP_DB_PORT/$db_port/g"               $application_yml
	sed -i "s/APP_DB_NAME/$db_name/g"               $application_yml
	sed -i "s/APP_DB_USERNAME/$db_user/g"           $application_yml
	sed -i "s/APP_DB_PASSWORD/$db_pwd/g"            $application_yml
	echo "#########start to create bpm_application.yml from $bpm_application_tpl_yml"
	if [[ -f $bpm_application_tpl_yml ]];then
	  cat $bpm_application_tpl_yml>$bpm_application_yml
	  sed -i "s/APP_DB_PORT/$db_port/g"               $bpm_application_yml
  	sed -i "s/APP_DB_NAME/$db_name/g"               $bpm_application_yml
	  sed -i "s/APP_DB_USERNAME/$db_user/g"           $bpm_application_yml
  	sed -i "s/APP_DB_PASSWORD/$db_pwd/g"            $bpm_application_yml
	fi
	echo "#########start to create job_application.yml from $job_application_tpl_yml"
	if [[ -f $job_application_tpl_yml ]];then
	  cat $job_application_tpl_yml>$job_application_yml
	  sed -i "s/APP_DB_PORT/$db_user/g"               $job_application_yml
  	sed -i "s/APP_DB_NAME/$db_pwd/g"                $job_application_yml
	  sed -i "s/APP_DB_USERNAME/$db_user/g"           $job_application_yml
	  sed -i "s/APP_DB_PASSWORD/$db_pwd/g"            $job_application_yml
	fi
	echo "#############install app success#############"
	#restart app
	chmod +x /etc/rc.d/rc.local
	echo "sleep 15">>/etc/rc.d/rc.local
	sed -i '/startAll/d' /etc/rc.d/rc.local
	echo "cd $app_dir;sh startAll.sh">>/etc/rc.d/rc.local
}
function stopFirewalld(){
  btcnt=`ps -ef|grep python|grep BT|grep -v grep|wc -l`
 if [[ $btcnt -gt 0 ]];then
    echo "firewalld don't stop it"
    return 1
  fi
  systemctl disable firewalld.service
  systemctl stop firewalld.service
}

function installNginx(){
  cd $app_dir/bin
  sh deployNginx.sh
  return 0
}
##########################################################################################
################################# Install Main Run Start #################################
#################################################################### download mysql start
total_mem=`free -m|grep Mem|awk '{print $2}'`
if [[ $total_mem -lt 3500 ]];then
  echo "your system memory:${total_mem}m,too lower!"
  exit 1
fi
cd $soft_base_dir
# java_soft_md5=913c45332b22860b096217d9952c2ea4
# mysql_soft_md5=423915249cc67bbfa75223d9753cde77
mysql_download=1
if [[ -f $mysql_soft ]];then
	md5=`md5sum $mysql_soft|awk '{print $1}'`
	echo "mysql md5:$md5"
	if [[ $md5 == $mysql_soft_md5 ]];then
		mysql_download=0
		echo "mysql_soft is checked."
	fi
fi
if [[ $mysql_download -eq 1 ]];then
	echo "start to download mysql"
	wget https://cdn.mysql.com/archives/mysql-5.7/mysql-5.7.37-linux-glibc2.12-x86_64.tar.gz
fi
#################################################################### download mysql finish
#################################################################### download java start
javaUrl1=https://repo.huaweicloud.com/java/jdk/8u202-b08/jdk-8u202-linux-x64.tar.gz
javaUrl2=http://prodshop.maimaiyouhuiquan.com/upload/jdk-8u333-linux-x64.tar.gz
javaUrl3=http://resource.rainbooow.com/jdk-8u333-linux-x64.tar.gz
javaUrl4=https://lank-public.oss-cn-hangzhou.aliyuncs.com/jdk-8u333-linux-x64.tar.gz
java_soft_remote=1
which java
javaR=$?
######java
if [[ $javaR -eq 0 ]];then
  javaVersion=`java -version 2>&1|grep 1.8 |wc -l`
  if [[ $javaVersion -gt 0 ]];then
    java_soft_remote=0
    JAVA=`which java|awk '{print $1}'`
  fi
fi
cd /tmp
###### java first download
if [[ $java_soft_remote -eq 1 ]];then
  if [[ -f $app_soft ]];then
    rm -rf $app_soft
  fi
  java_download=1
  wget -O $java_file $javaUrl1
fi
###### java second download
touch $java_file
if [[ $java_soft_remote -eq 1 ]];then
  java_size=`du -sm $java_file|awk '{print $1}'`
  if [[ $java_size -lt 60 ]];then
    java_download=1
    rm -rf $java_file
    wget -O $java_file $javaUrl2
  fi
fi
###### java third download
touch $java_file
if [[ $java_soft_remote -eq 1 ]];then
  java_size=`du -sm $java_file|awk '{print $1}'`
  if [[ $java_size -lt 60 ]];then
    java_download=1
    rm -rf $java_file
    wget -O $java_file $javaUrl3
  fi
fi
###### java fourth download
touch $java_file
if [[ $java_soft_remote -eq 1 ]];then
  java_size=`du -sm $java_file|awk '{print $1}'`
  if [[ $java_size -lt 60 ]];then
    java_download=1
    rm -rf $java_file
    wget -O $java_file $javaUrl4
  fi
fi
###### install java
if [[ $java_soft_remote -eq 1 ]];then
  installJava
fi
which $JAVA>/dev/null
java_command=$?
if [[ $java_command -eq 1 ]];then
	echo "install error,java command:$JAVA not exist";
	clearTips
	exit 1
fi
#################################################################### download java finish
#################################################################### download app start
echo "start to download app"
if [[ -f $app_soft ]];then
	 rm -rf $app_soft
fi
#app_release_last.tar.gz
# appUrl1=http://prodshop.maimaiyouhuiquan.com/upload/$app_soft_name
# appUrl2=http://resource.rainbooow.com/$app_soft_name
# appUrl3=https://lank-public.oss-cn-hangzhou.aliyuncs.com/$app_soft_name
appUrl1=http://prodshop.maimaiyouhuiquan.com/upload/$app_soft_name
appUrl2=http://prodshop.maimaiyouhuiquan.com/upload/$app_soft_name
appUrl3=http://prodshop.maimaiyouhuiquan.com/upload/$app_soft_name
echo "download:$appUrl1";
cd /tmp
appbkfile=${app_soft_name}_backup
if [[ -f "$appbkfile" ]];then
  cp $appbkfile $app_soft_name
fi
#first donwload
touch $app_soft_name
app_size=`du -sm $app_soft_name|awk '{print $1}'`
if [[ $app_size -lt 80 ]];then
  rm -rf $app_soft_name
  wget $appUrl1
fi
#second donwload
touch $app_soft_name
app_size=`du -sm $app_soft_name|awk '{print $1}'`
if [[ $app_size -lt 80 ]];then
  rm -rf $app_soft_name
  wget $appUrl2
fi
#second donwload
touch $app_soft_name
app_size=`du -sm $app_soft_name|awk '{print $1}'`
if [[ $app_size -lt 80 ]];then
  rm -rf $app_soft_name
  wget $appUrl3
fi
touch $app_soft_name
app_size=`du -sm $app_soft_name|awk '{print $1}'`
if [[ $app_size -lt 80 ]];then
  echo "app soft file maybe not right!"
  exit 1
fi
#################################################################### download app finish
#################################################################### verify soft start
#verify app
verifySoft $app_soft
app_soft_VR=$?
if [[ $app_soft_VR -eq 1 ]];then
	echo "install error,app_soft:$app_soft not exist";
	clearTips
	exit 1
fi
#verify mysql
verifySoft $mysql_soft
mysql_soft_VR=$?
if [[ $mysql_soft_VR -eq 1 ]];then
	echo "install error,mysql_soft:$mysql_soft not exist";
	clearTips
	exit 1
fi
#verify java
if [[ $java_soft_remote -eq 1 ]];then
  verifySoft $java_soft
  java_soft_VR=$?
  if [[ $java_soft_VR -eq 1 ]];then
    echo "install error,java_soft:$java_soft not exist";
    clearTips
    exit 1
  fi
fi
#################################################################### verify soft finish
#################################################################### install start
## install mysql
installMysql
which $MYSQL>/dev/null
mysql_command=$?
if [[ $mysql_command -eq 1 ]];then
	echo "install error,mysql command:$MYSQL not exist,mysql server install error.";
	clearTips
	exit 1
fi
db_port_cnt=`netstat -ant|grep LISTEN|grep ":$db_port"|wc -l`
if [[ $db_port_cnt -eq 0 ]];then
	echo "install check error,db_port:$db_port not exist,mysql server may not running."
	clearTips
	exit 1
else
	echo "mysql install success,password:$db_pwd"
fi
## install app
installApp
## stop Firewalld
#process firewalld
which firewall-cmd
firewall_cmd_r=$?
if [[ $firewall_cmd_r -eq 0 ]];then
  #acl rule
  firewall-cmd --zone=public --add-port=$bpm_port/tcp --permanent
  firewall-cmd --zone=public --add-port=$app_port/tcp --permanent
fi
stopFirewalld
## start app
cd $app_dir
sh startAll.sh
# start to install nginx
installNginx
########## setting environment
tmpdate=`date`
echo "$tmpdate,first setup time record!">$base_dir/app/bin/setupApp.log
echo "#for lank app quick command list:">>~/.bash_profile
echo "alias ga='cd $base_dir/app/app/app'" >>~/.bash_profile
echo "alias gb='cd $base_dir/app/app/bpm'" >>~/.bash_profile
echo "alias gj='cd $base_dir/app/app/job'" >>~/.bash_profile
echo "alias gn='cd $base_dir/app/app/nginx'" >>~/.bash_profile
echo "alias g='cd $base_dir/app'" >>~/.bash_profile
echo "alias k='sh $base_dir/app/bin/help.sh'" >>~/.bash_profile
echo "alias ka_restart='cd $base_dir/app;sh restartApp.sh'" >>~/.bash_profile
echo "alias kb_restart='cd $base_dir/app;sh restartBpm.sh'" >>~/.bash_profile
echo "alias kj_restart='cd $base_dir/app;sh restartJob.sh'" >>~/.bash_profile
echo "alias kn_restart='cd $base_dir/app;sh restartNginx.sh'" >>~/.bash_profile
echo "alias tdb='$base_dir/db/mysql/bin/mysql -h$db_host -P$db_port -u$db_user -p$db_pwd $db_name'" >>~/.bash_profile
echo "alias tdb_none='$base_dir/db/mysql/bin/mysql -h$db_host -P$db_port -u$db_user -p$db_pwd '" >>~/.bash_profile
echo "Please wait about 25 seconds,Application is starting.."
sleep 10
echo "################## install result ###################"
echo "------------------------------- result -----------------------------------------"
echo "Install finish."
echo "Application can be visit about 30 second later"
echo "App install directory list:$mysql_dir,$app_dir"
echo "App web address:http://ip:$app_port"
echo "App mobile address:https://ip:8091"
echo "Login info user:admin"
echo "Login info password:123456"
echo "Mysql info port=$db_port"
echo "Mysql info userName=$db_user"
echo "Mysql info password=$db_pwd"
echo "Quick command list:"
echo "k:help list"
echo "ga: go to $base_dir/app/app/app"
echo "gb: go to $base_dir/app/app/bpm"
echo "gj: go to $base_dir/app/app/job"
echo "gn: go to $base_dir/app/app/nginx"
echo "g:  go to $base_dir/app"
echo "ka_restart:restartApp"
echo "kb_restart:restartBpm"
echo "kj_restart:restartJob"
echo "kn_restart:restartNginx"
echo "tdb: go to connect to database"
echo "--------------------------------- end ---------------------------------------"
exit 0
#################################################################### install finish
##########################################################################################
##########################################################################################
##########################################################################################
##########################################################################################
##########################################################################################
##########################################################################################
##########################################################################################
##########################################################################################
##########################################################################################
rm -rf /app/java
rm -rf /app/db
rm -rf /app/app
rm -rf /app/nginx
ps -ef|grep java |grep -v grep |awk '{print $2}'|xargs kill -9
ps -ef|grep mysql |grep -v grep |awk '{print $2}'|xargs kill -9
ps -ef|grep nginx |grep -v grep |awk '{print $2}'|xargs kill -9

