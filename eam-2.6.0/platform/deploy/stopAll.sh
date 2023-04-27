#!/bin/sh
cur_dir=$(cd `dirname $0`; pwd)
cd $cur_dir

echo "to stop App"
sh stopApp.sh
echo "to stop Bpm"
sh stopBpm.sh
echo "to stop Job"
sh stopJob.sh
echo "to stop Nginx"
sh stopNginx.sh

exit 0

