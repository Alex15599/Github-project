#!/bin/sh
cur_dir=$(cd `dirname $0`; pwd)
cd $cur_dir/bin
sh app.sh start job
exit 0
