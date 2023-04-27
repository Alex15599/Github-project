#!/bin/sh
hostname=`hostname`
cur_dir=$(cd `dirname $0`; pwd)
conf_file=$cur_dir/app.conf
echo "cur_dir:$cur_dir";
echo "conf_file:$conf_file";
maven_dir=`cat $conf_file|grep ${hostname}.maven_dir|awk -F "=" '{print $2}'`
echo "maven_dir:$maven_dir"
if [[ -d "$maven_dir/com/foxnicweb" ]];then
  cd $maven_dir/com/foxnicweb
  t=`date +"%Y%m%d%H%M%S"`
  tar zcvf ../foxnic_${t}.tar.gz ./*
  cd $maven_dir/com/foxnicweb
  echo "start to clear foxnic maven lib";
#  rm -rf foxnic*
#  rm -rf web*
#  rm -rf par*
#  rm -rf cangaroo*
  rm -rf *
fi



#if [[ -d "$maven_dir/com/github/foxnic" ]];then
#  cd $maven_dir/com/github
#  t=`date +"%Y%m%d%H%M%S"`
#  tar zcvf foxnic_${t}.tar.gz ./foxnic/*
#  cd $maven_dir/com/github/foxnic
#  echo "start to clear foxnic maven lib";
#  rm -rf foxnic*
#  rm -rf web*
#  rm -rf par*
#  rm -rf cangaroo*
#fi

cd $maven_dir
rm -rf org/springframework/beans/cangariza
if [[ -d "/Users/lank/IdeaProjectsnew/eam/logs" ]];then
  cd /Users/lank/IdeaProjectsnew/eam/logs
  rm -rf *
fi
exit 0

