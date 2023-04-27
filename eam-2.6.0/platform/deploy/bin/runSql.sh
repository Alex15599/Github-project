#!/bin/sh
#
#   sh runSql.sh sql db_name
#
###############################################################
cur_dir=$(cd `dirname $0`; pwd)
app_conf="${cur_dir}/app.conf"
app_dir=$cur_dir/..
MYSQL=`cat $app_conf|grep -v "#"|grep MYSQL=|awk -F "=" '{print $2}'`
DB_HOST=`cat $app_conf|grep -v "#"|grep DB_HOST=|awk -F "=" '{print $2}'`
DB_USER=`cat $app_conf|grep -v "#"|grep DB_USER=|awk -F "=" '{print $2}'`
DB_PWD=`cat $app_conf|grep -v "#"|grep DB_PWD=|awk -F "=" '{print $2}'`


if [[ -n $1 ]];then
  echo "run sql file:$1";
else
  echo "Please input sql file path!"
  exit 1
fi
SQL=$1

if [[ ! -f $1 ]];then
  echo "Please input sql file not exist!"
  exit 1
fi


if [[ -n $2 ]];then
  echo "run dbname:$2";
else
  echo "Please input db_name!"
  exit 1
fi
DB_NAME=$2

if [[ ! -f $SQL ]];then
  echo "sql file path not exist!"
  exit 1
fi

$MYSQL -u$DB_USER -p$DB_PWD -h$DB_HOST $DB_NAME < $SQL

exit 0

