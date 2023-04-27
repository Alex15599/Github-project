#!/bin/sh
cur_dir=$(cd `dirname $0`; pwd)
app_dir=$cur_dir/..
cd $app_dir/bin/
sh backupAppDB.sh foxnic
sh runSql.sh /app/app/backup/db/db.sql eam_demo
sh runSql.sh /app/app/bin/sql/cleardata.sql eam_demo
sh runSql.sh /app/app/bin/sql/settingapp.sql eam_demo
sh backupAppDB.sh eam_demo
sh runSql.sh /app/app/backup/db/db.sql eam_demo
exit 0



