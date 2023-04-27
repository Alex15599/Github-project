#!/bin/sh
#cron:
#   0 */1 * * * sh /app/app/bin/checkIfRestartApp.sh
checkfile="/tmp/checkAppRunning.log"
cur_dir=$(cd `dirname $0`; pwd)
app_dir=$cur_dir/..
d=`date +"%Y-%m-%d %H:%M:%S"`
port=`cat $app_dir/app/app/application.yml |grep -v "#"|grep port|head -1|awk -F ":" '{print $NF}'|awk '{print $NF}'`
## connect-timeout 5s
## -m 10s
echo "Command:curl --connect-timeout 10 -m 10 http://127.0.0.1:$port/login.html 2>/dev/null"
c=`curl -I --connect-timeout 5 -m 10 http://127.0.0.1:8089/login.html|grep 200|grep HTTP|wc -l`
if [[ $c -eq "1" ]];then
  echo "$d | check success,value is $c"
  echo "$d | check success,value is $c">>$checkfile
else
  cd $app_dir
  echo "$d | check failed,value is $c,will go to restart!"
  echo "$d | check failed,value is $c,will go to restart!">>$checkfile
  sh restartApp.sh
fi
exit 0

