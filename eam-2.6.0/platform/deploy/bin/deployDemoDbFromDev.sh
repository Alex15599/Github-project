#!/bin/sh
cur_dir=$(cd `dirname $0`; pwd)
app_dir=$cur_dir/..

cd $cur_dir
sh backupAppDB.sh foxnic
sh runSql.sh $app_dir/backup/db/db.sql foxnic_demo

exit 0