#!/bin/sh
cur_dir=$(cd `dirname $0`; pwd)
cd $cur_dir
sh stopNginx.sh
sleep 1
sh startNginx.sh
exit 0
