#!/bin/sh
cur_dir=$(cd `dirname $0`; pwd)
cd $cur_dir
sh restartApp.sh
sh restartBpm.sh
sh restartJob.sh
exit 0

