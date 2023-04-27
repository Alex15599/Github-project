#!/bin/sh
uid=`id -u`
if [[ $uid -eq 0 ]];then
  rcd=`date +%s`
  crontab -l>/tmp/crontab_save_${rcd}.tmp
list="##############   Foxnic-APP start   #################
2 2 * * *   sh /app/app/bin/clearDataSpace.sh
0 */1 * * * sh /app/app/bin/checkIfRestartApp.sh
6 6 * * *   sh /app/app/bin/backupAppDB.sh foxnic
##############   Foxnic-APP finish   ################"
  IFS=$'\n'
  for cjob in $list
  do
    echo "to add job:$cjob"
    (crontab -l | grep -v "$cjob"; echo "$cjob") | crontab -
  done
fi
exit