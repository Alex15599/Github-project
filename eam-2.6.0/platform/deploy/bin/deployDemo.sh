#!/bin/sh
logfile="/tmp/ali_deploy.log"
cur_dir=$(cd `dirname $0`; pwd)
app_dir=$cur_dir/..
cd $cur_dir
java -jar appSourceSync.jar
sleep 15
curl --header "Content-Type: application/json" --request POST --data '{}' http://flow-openapi.aliyun.com/pipeline/webhook/PII1nKYMPImJiCM9kPL9
exit 0



