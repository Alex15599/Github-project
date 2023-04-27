#!/bin/sh
cur_dir=$(cd `dirname $0`; pwd)
app_dir=$cur_dir/..
echo "cur_dir:$cur_dir"
prod_app_dir=/app/app
app_conf="${cur_dir}/app.conf"
tpl_update_par_cnt=`cat $app_conf|grep -v "#"|grep APP_TPL_UPDATE=|wc -l`
if [[ $tpl_update_par_cnt -eq 0 ]];then
  tpl_update=0
else
  tpl_update=`cat $app_conf|grep -v "#"|grep APP_TPL_UPDATE=|awk -F "=" '{print $2}'`
fi
echo "tpl_update value:$tpl_update"
if [[ ! -d "$prod_app_dir/app/app/lib" ]];then
  echo "directory config error"
  exit 1
fi
#app.jar will overwrite if exist
echo "######## start to update app.jar ##############"
if [[ -f "$prod_app_dir/app/app/app.jar" ]];then
  cd $app_dir/app/app
  echo "cp app.jar $prod_app_dir/app/app/"
  cp app.jar $prod_app_dir/app/app/
  ls -rtl $prod_app_dir/app/app/
else
  echo "app.jar error"
  exit 1
fi
echo ""
echo ""
#app lib will copy
echo " ########start to update app.lib ##############"
if [[ -d $prod_app_dir/app/app/lib ]];then
  rm -rf $prod_app_dir/app/app/lib/*
  cd $app_dir/app/app/lib/
  echo "cp * $prod_app_dir/app/app/lib"
  cp * $prod_app_dir/app/app/lib/
  ls -rtl $prod_app_dir/app/app/lib/*
else
  echo "$prod_app_dir/app/app/lib  error"
  exit 1
fi
echo ""
echo ""
#bpm.jar will overwrite
echo "######## start to update bpm.jar ##############"
if [[ -f "$prod_app_dir/app/bpm/bpm.jar" ]];then
  cd $app_dir/app/bpm
  echo "cp bpm.jar $prod_app_dir/app/bpm/"
  cp bpm.jar $prod_app_dir/app/bpm/
  ls -rtl $prod_app_dir/app/bpm/
else
  echo "bpm.jar error"
  exit 1
fi
echo ""
echo ""
#sh file will overwrite
echo "######## start to update script file ##############"
cd $app_dir/bin/
scriptFileList=`ls -rtl |grep ".sh"|awk '{print $NF}'`
for scriptFile in $scriptFileList
do
  echo "script:$scriptFile"
  if [[ -f "$prod_app_dir/bin/$scriptFile" ]];then
    rm -rf $prod_app_dir/bin/$scriptFile
    cp $scriptFile $prod_app_dir/bin/
  fi
done
chmod +x $prod_app_dir/bin/*.sh
ls -rtl $prod_app_dir/bin/*.sh
#Tpl File
echo "######## start to update tpl file ##############"
if [[ $tpl_update -eq 1 ]];then
  echo "start to overwrite tpl file"
  if [[ -d "$prod_app_dir/app/app/upload/tpl/T001" ]];then
    t=`date +%Y%m%d_%H_%M_%S`
    mv $prod_app_dir/app/app/upload/tpl/T001 $prod_app_dir/app/app/upload/tpl/T001_$t
    mkdir -p $prod_app_dir/app/app/upload/tpl/T001
    cd $app_dir/app/app/upload/tpl/T001
    cp * $prod_app_dir/app/app/upload/tpl/T001
    ls -rtl $prod_app_dir/app/app/upload/tpl/T001
  else
     echo "$prod_app_dir/app/app/upload/tpl/T001 error"
     exit 1
  fi
fi
#restart
echo "######## restart app ##############"
cd $prod_app_dir
sh restartAll.sh
exit 0
