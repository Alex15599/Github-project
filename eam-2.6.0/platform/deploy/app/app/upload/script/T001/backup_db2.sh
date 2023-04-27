#!/bin/bash
#30 2 * * * sh /dbbak/backup_db2.sh /home/cmsinst/sqllib/db2profile /dbbak CMS /arch/cmsinst/CMS/NODE0000/LOGSTREAM0000/C0000000
PROFILE=$1
BAKDIR=$2
DBNAME=$3
DBLOGBAKDIR=$4
echo "PROFILE:$PROFILE"
echo "BAKDIR:$BAKDIR"
echo "DBNAME:$DBNAME"
echo "DBLOGBAKDIR:$DBLOGBAKDIR"
if [[ ! -f $PROFILE ]];then
	echo "PROFILE Configure Error"
	exit 1
fi
if [[ ! -d $BAKDIR ]];then
	echo "BAKDIR Configure Error"
	exit 1
fi
. $PROFILE
#####record dbft start
dbft_dbname=$DBNAME
dbft_record=$dbft_dbname
dbft_name=$dbft_dbname
dbft_aliasname=$dbft_record
dbft_file=/tmp/db_backup_${dbft_record}.log
dbft_id=`date +"%Y%m%d%H%M%S"`
dbft_stime=`date +"%Y-%m-%d %H:%M:%S.000"`
echo "$dbft_stime|id=$dbft_id,action=start,name=$dbft_name,alias_name=$dbft_aliasname">>$dbft_file
cd ${BAKDIR}
echo "start backup"
db2 backup db ${DBNAME} online to ${BAKDIR} compress include logs >> ${BAKDIR}/dbbackup.log
#####record dbft end
dbft_dfile=`ls -rtl |grep 001|tail -1|awk '{print $NF}'`
dbft_etime=`date +"%Y-%m-%d %H:%M:%S.000"`
dbft_size=0
if [[ -f $dbft_dfile ]];then
	dbft_size=`du -sm $dbft_dfile|awk '{print $1}'`
fi
echo "$dbft_etime|id=$dbft_id,action=end,name=$dbft_name,alias_name=$dbft_aliasname,size=$dbft_size,result=success">>$dbft_file
if [[ -d ${BAKDIR} ]];then
	cd ${BAKDIR}
	bcnt=`ls -rtl |grep $DBNAME|grep -v grep |wc -l`
	if [[ $bcnt -gt 3 ]];then
		echo "start to clear backup file"
		find ${BAKDIR} -name "${DBNAME}*DB*001" -mtime +7 -exec rm -rf {} \;
	fi 
fi
if [[ -d ${DBLOGBAKDIR} ]];then
	echo "start to clear archlog"
	find ${DBLOGBAKDIR} -name "*.LOG" -mtime +100 -exec rm -rf {} \;
fi
exit 0