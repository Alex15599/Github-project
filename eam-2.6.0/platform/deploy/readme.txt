

################  应用日常维护,启动停止服务 ################
#启动所有服务
sh startAll.sh

#停止所有服务
sh stopAll.sh

#重启所有服务
sh restartAll.sh


#检查环境
sh bin/checkAppEnvironment.sh

#crontab -e
###APP CRONTAB
0 */1 * * * sh /app/app/bin/checkIfRestartApp.sh
2 2 * * * sh /app/app/bin/backupAppDB.sh foxnic




