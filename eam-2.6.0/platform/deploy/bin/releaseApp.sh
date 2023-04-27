#!/bin/sh
#
#sh releaseApp.sh /tmp/app_release_last.tar.gz
#
cur_dir=$(cd `dirname $0`; pwd)
app_dir=$cur_dir/..
cd $cur_dir
tmp_dir="/tmp"
app_release_tar=""
if [[ -n "$1" ]];then
  app_release_tar=$1
else
  echo "app_release_tar parameter not exist"
  exit 1
fi
if [[ ! -f $app_release_tar ]];then
  echo "app_release_tar file not exist."
  exit 1
fi
sh ./releaseAppCleanSQL.sh
sh ./releaseAppReplaceDB.sh $app_release_tar /app/app/backup/db/db.tar.gz

#默认输出位置为 /tmp/app_release_last.tar.gz

##deploy tomcat
if [ -f "/opt/tomcat/tomcat_shopprod/webapps/upload/app_dev_last.tar.gz" ];then
  rm -rf /opt/tomcat/tomcat_shopprod/webapps/upload/app_dev_last.tar.gz
  cp /tmp/app_release_last.tar.gz /opt/tomcat/tomcat_shopprod/webapps/upload/app_dev_last.tar.gz
fi

exit 0