#!/bin/sh
#30 2 * * * sh /dbbak/backup_mysql.sh 
user=root
pwd=Ndhb@Sldb001
dbname=docs
time=`date "+%Y-%m-%d"`
echo $time
dir=/dbbak/data
bkdump=/db/mysql/mysql/bin/mysqldump
#####record dbft start
dbft_dbname=$dbname
dbft_record=$dbft_dbname
dbft_name=$dbft_dbname
dbft_aliasname=$dbft_record
dbft_file=/tmp/db_backup_${dbft_record}.log
dbft_id=`date +"%Y%m%d%H%M%S"`
dbft_stime=`date +"%Y-%m-%d %H:%M:%S.000"`
echo "$dbft_stime|id=$dbft_id,action=start,name=$dbft_name,alias_name=$dbft_aliasname">>$dbft_file
$bkdump -u$user -p$pwd -h127.0.0.1 $dbname >$dir/fullbackup.$time.sql
dbft_dfile=$dir/fullbackup.$time.sql
dbft_etime=`date +"%Y-%m-%d %H:%M:%S.000"`
dbft_size=0
if [[ -f $dbft_dfile ]];then
	dbft_size=`du -sm $dbft_dfile|awk '{print $1}'`
fi
echo "$dbft_etime|id=$dbft_id,action=end,name=$dbft_name,alias_name=$dbft_aliasname,size=$dbft_size,result=success">>$dbft_file
if [[ -d ${dir} ]];then
 echo "del backup"
 cd $dir
 find ${dir} -name "*.sql" -mtime +60 -exec rm -rf {} \;
fi
exit 0
