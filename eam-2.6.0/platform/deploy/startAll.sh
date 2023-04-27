#!/bin/sh
cur_dir=$(cd `dirname $0`; pwd)
cd $cur_dir

echo "to start App"
sh startApp.sh
echo "to start Bpm"
sh startBpm.sh
echo "to start Job"
sh startJob.sh
echo "to start Nginx"
sh startNginx.sh

exit 0

