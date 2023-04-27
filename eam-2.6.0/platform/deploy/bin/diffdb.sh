#!/bin/sh
cur_dir=$(cd `dirname $0`; pwd)
cd $cur_dir
ps -ef|grep database-compare-mysq|grep -v grep|awk '{print $2}'|xargs kill -9
nohup java -jar database-compare-mysql5.7.jar.1 &
exit 0


