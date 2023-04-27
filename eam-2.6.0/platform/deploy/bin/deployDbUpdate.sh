#!/bin/sh
cur_dir=$(cd `dirname $0`; pwd)
app_conf="${cur_dir}/app.conf"
app_dir=$cur_dir/..
t=`date +%Y%m%d%H%M%S`
cacheSql="/tmp/cache.sql"
updateSql="/tmp/update.sql"
db_name=foxnic
#########app cache key
echo "########### execute update sql list #########"
if [[ -f $updateSql ]];then
  echo "execute update sql list"
  cat $updateSql
  sh $app_dir/bin/runSql.sh updateSql $db_name
else
  echo "$updateSql not exist"
fi
echo ""
echo ""

#########app cache key
echo "########### execute cache sql list #########"
cat $cacheSql
echo "update sys_config set value='$t' where code='system.cachekey';">$cacheSql
sh $app_dir/bin/runSql.sh $cacheSql $db_name
echo ""
echo ""

echo "########### update finish #########"
echo ""
echo ""

exit 0