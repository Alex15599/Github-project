#!/bin/sh
JAVA=java

hostname=`hostname`
cur_dir=$(cd `dirname $0`; pwd)
conf_file=$cur_dir/app.conf
echo "cur_dir:$cur_dir";
echo "conf_file:$conf_file";


ops_jar_dir=`cat $conf_file|grep ${hostname}.ops_jar_dir|awk -F "=" '{print $2}'`
tmp_dir=`cat $conf_file|grep ${hostname}.ops_dir|awk -F "=" '{print $2}'`
ops_remotefile_recreate_file="$tmp_dir/deploy_ops_app.sh"
ops_node_file="$tmp_dir/ops.node"
ops=$ops_jar_dir/ops.jar
file=h5.tar.gz

cd /Users/lankl/Documents/HBuilderProjects/eamApp/unpackage/dist/build/h5
tar zcvf $file ./*
if [[ -f "$tmp_dir/$file" ]];then
    rm -rf $tmp_dir/$file
fi 
mv h5.tar.gz $tmp_dir

echo "">$ops_remotefile_recreate_file
echo "UPLOAD sf=$tmp_dir/$file         @@ dd=/tmp @@ df=h5.tar.gz"        >>$ops_remotefile_recreate_file
echo "cd /tmp/"                                           >>$ops_remotefile_recreate_file
echo "cd /usr/local/nginx/html"                           >>$ops_remotefile_recreate_file
echo "rm -rf * "                                         >>$ops_remotefile_recreate_file
echo "cp /tmp/h5.tar.gz ."                              >>$ops_remotefile_recreate_file
echo "tar xvf h5.tar.gz"                                   >>$ops_remotefile_recreate_file
echo "exit 0"											 >>$ops_remotefile_recreate_file

####################### Deploy ######################################
echo "##########"
echo "$JAVA  -jar $ops -e action -n $ops_node_file -c $ops_remotefile_recreate_file">>/tmp/ops.log
$JAVA  -jar $ops -e action -n $ops_node_file -c $ops_remotefile_recreate_file

exit 0

