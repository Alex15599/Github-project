#!/bin/sh

logfile="/tmp/ali_deploy.log"
cur_dir=$(cd `dirname $0`; pwd)
app_dir=$cur_dir/..
cd $cur_dir

#覆盖
packageFile=/home/admin/app/app.tgz

if [[ ! -f $packageFile ]];then
  echo "$packageFile not exits">>$logfile
  exit 1
fi

if [[ -d "/tmp/app_yunxiao" ]];then
  rm -rf /tmp/app_yunxiao
fi
mkdir /tmp/app_yunxiao
cd /tmp/app_yunxiao
cp $packageFile .
tar xvf $packageFile

echo "releaseApp.sh">>$logfile
echo "rebuild sql"
cd /app/app/bin
sh releaseApp.sh /tmp/app_yunxiao/app_release_last.tar.gz

# update
if [[ -d "/opt/tomcat/tomcat_shopprod/webapps/upload" ]];then
  cd /opt/tomcat/tomcat_shopprod/webapps/upload
  if [[ -f "app_release_dev.tar.gz" ]];then
    rm -rf app_dev_last.tar.gz
  fi
  cp /tmp/app_release_last.tar.gz app_release_dev.tar.gz
fi

echo "update app">>$logfile
#sql 已更新，默认打包后在/tmp/app_release_last.tar.gz
#再次更新程序
t=`date +"%Y%m%d%H%M%S"`
flag="update_${t}"
update_dir=${tmp_dir}/${flag}
mkdir $update_dir
cd $update_dir
cp /tmp/app_release_last.tar.gz .
tar xvf app_release_last.tar.gz

cd bin
sh deployAppUpdate.sh
cd /tmp
rm -rf  $update_dir




rm -rf  $update_dir



exit 0

