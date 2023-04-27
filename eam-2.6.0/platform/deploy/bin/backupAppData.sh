#!/bin/sh
#cron:
#   12 12 * * * sh /app/app/bin/backupAppData.sh
########################################
cur_dir=$(cd `dirname $0`; pwd)
app_conf="${cur_dir}/app.conf"
app_dir=$cur_dir/..
backup_dir=$app_dir/app/backup
curTime=`date +"%Y%m%d%H%M%S"`
if [[ ! -d $backup_dir ]];then
  mkdir -p $backup_dir
fi

if [[ ! -d $backup_dir ]];then
  echo "backup dir $backup_dir not exist";
  exit 1
fi

echo "Start to backup application!"
cd $app_dir/app/app/
backupfile=app_backup_${curTime}.tar.gz
tar zcvf $backupfile ./lib/* *.jar *.yml
if [[ ! -f "app_backup_${curTime}.tar.gz" ]];then
  echo "Backup Application Failed!";
  exit 1;
fi
echo "backup dir:$backup_dir/$backupfile,success!"
mv $backupfile $backup_dir/

exit 0

