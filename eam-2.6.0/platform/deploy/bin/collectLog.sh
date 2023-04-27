#!/bin/sh
cur_dir=$(cd `dirname $0`; pwd)
app_dir=$cur_dir/..
fileId=$1
echo "fileId=$1"
collect_dir="$app_dir/tmp/collect_$$"
if [[ ! -d $collect_dir ]];then
  mkdir -p $collect_dir
fi
echo "collect_dir:$collect_dir"
TIME=`date +%Y%m%d_%H_%M_%S`
echo "start to collect app_log"
if [[ -d $app_dir/app/app/app_logs ]];then
  cd $app_dir/app/app/app_logs
  tar cvf app_log_$TIME.tar ./info.log  ./debug.log ./error.log
  mv app_log_$TIME.tar  $collect_dir
fi
echo "start to collect bpm_log"
if [[ -d $app_dir/app/bpm/bpm_logs ]];then
  cd $app_dir/app/bpm/bpm_logs
  tar cvf bpm_log_$TIME.tar ./info.log  ./debug.log ./error.log
  mv bpm_log_$TIME.tar $collect_dir
fi

echo "start to collect job_log"
if [[ -d $app_dir/app/job/job_logs ]];then
  cd $app_dir/app/job/job_logs
  tar cvf job_log_$TIME.tar ./info.log  ./debug.log ./error.log
  mv job_log_$TIME.tar  $collect_dir
fi
cd $collect_dir
tar zcvf collect_log_$TIME.tar.gz ./*
echo "collect log finish"
rm -rf app_log_*.tar
rm -rf bpm_log_*.tar
rm -rf job_log_*.tar
echo "collect file show:"
ls -rtl $collect_dir/collect_log_$TIME.tar.gz

if [[ ! -d $app_dir/app/app/upload/collect/log ]];then
  mkdir -p $app_dir/app/app/upload/collect/log
fi
if [[ $1 ]];then
  echo "copy to $app_dir/app/app/upload/collect/log"
  cp $collect_dir/collect_log_$TIME.tar.gz $app_dir/app/app/upload/collect/log/$fileId.tar.gz
fi
exit 0
