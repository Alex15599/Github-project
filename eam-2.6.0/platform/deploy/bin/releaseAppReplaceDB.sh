#!/bin/sh
#
#app_release_tar replace db.tar.gz file
#sh releaseAppReplaceDb.sh /tmp/app_release_last.tar.gz  /app/app/backup/db/db.tar.gz
##
cur_dir=$(cd `dirname $0`; pwd)
app_dir=$cur_dir/..
cd $cur_dir

file=app_release_last.tar.gz
tmp_dir="/tmp"
app_release_tar=""
db_tar=""
if [[ -n "$1" ]];then
  app_release_tar=$1
else
  echo "app_release_tar parameter not exist"
  exit 1
fi
if [[ -n "$2" ]];then
  db_tar=$2
else
  echo "db_tar parameter not exist"
  exit 1
fi
if [[ ! -f $app_release_tar ]];then
  echo "app_release_tar file not exist."
  exit 1
fi
if [[ ! -f $db_tar ]];then
  echo "db_tar file not exist."
  exit 1
fi
t=`date +"%Y%m%d%H%M%S"`
flag="replace_${t}"
replace_dir=${tmp_dir}/${flag}
if [[ -d $replace_dir ]];then
  echo "$replace_dir exist"
fi

mkdir -p $replace_dir
cd $replace_dir
cp $app_release_tar .
tar xvf $app_release_tar
rm -rf ./bin/sql/db.tar.gz
cp $db_tar ./bin/sql/

# rm app.tar.gz
rm -rf $file
## action other


##
# start tar
tar zcvf $file ./*
if [[ -f $tmp_dir/$file ]];then
  rm -rf $tmp_dir/$file
fi
mv $file $tmp_dir
rm -rf $replace_dir
echo "action success,file:$tmp_dir/$file"
exit 0



