#!/bin/sh
cur_dir=$(cd `dirname $0`; pwd)
logFile=appd.log
cd $cur_dir
while true
do
  d=`date`
  echo "$d">>$logFile
  appStatus=`sh app.sh status app|grep "is running"|wc -l`
  if [[ $appStatus -gt 0 ]];then
    echo "app status is running" >>$logFile
  else
    echo "app restart" >>$logFile
    cd $cur_dir/..
    sh restartApp.sh
  fi
sleep 300
done
exit 0