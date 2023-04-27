#!/bin/sh
cur_dir=$(cd `dirname $0`; pwd)
cd $cur_dir
sh stopNginx.sh
if [[ -f ./app/nginx/sbin/nginx ]];then
  echo "to start nginx"
  ./app/nginx/sbin/nginx
fi
exit 0
