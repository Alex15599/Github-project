#!/bin/sh
#2 2 * * * sh /app/app/bin/clearDataSpace.sh
log_file=/tmp/clearDataSpace.log

dbbackup=/app/app/backup/db
rcdtime=`date`
echo "#############clearDataSpace start at $rcdtime############">>$log_file

####db backup clear######
if [[ -d $dbbackup ]];then
  echo "clear db backup file start,dir:$dbbackup">>$log_file
  cd $dbbackup
  find ./ -mtime +90 -name "*backup_*.tar.gz" -exec rm -rf {} \;
  echo "clear db backup file finish">>$log_file
fi

####app logfile######
app_log_dir=/app/app/app/app/logs
if [[ -d "$app_log_dir" ]];then
  cd $app_log_dir
  echo "clear app log file start,dir:$app_log_dir">>$log_file
  find ./ -mtime +90 -name "*.log" -exec rm -rf {} \;
  echo "clear app log file finish">>$log_file
fi

####app tmp file ####
app_tmp_dir=/app/app/tmp
if [[ -d "$app_tmp_dir" ]];then
  cd $app_tmp_dir
  echo "clear tmp log file start,dir:$app_tmp_dir">>$log_file
  find ./ -mtime +90 -name "*.tmp" -exec rm -rf {} \;
  echo "clear tmp log file finish">>$log_file
fi
echo "#############clearDataSpace finish ############">>$log_file
echo "">>$log_file
echo "">>$log_file
echo "">>$log_file
exit 0


