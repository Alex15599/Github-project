#####record dbft start
dbft_dbname=docs
dbft_record=sl_$dbft_dbname
dbft_name=$dbft_dbname
dbft_aliasname=$dbft_record
dbft_file=/tmp/db_backup_${dbft_record}.log
dbft_id=`date +"%Y%m%d%H%M%S"`
dbft_stime=`date +"%Y-%m-%d %H:%M:%S.000"`
#####record dbft end
#dbft_dfile=`ls -rtl |grep 001|tail -1|awk '{print $NF}'`
dbft_dfile=$dir/fullbackup.$time.sql
dbft_etime=`date +"%Y-%m-%d %H:%M:%S.000"`
dbft_size=0
if [[ -f $dbft_dfile ]];then
	dbft_size=`du -sm $dbft_dfile|awk '{print $1}'`
fi
echo "$dbft_etime|stime=$dbft_stime,etime=$dbft_etime,id=$dbft_id,action=finish,name=$dbft_name,alias_name=$dbft_aliasname,size=$dbft_size,result=success">>$dbft_file

