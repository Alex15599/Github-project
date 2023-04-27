#!/bin/sh
ps -ef|grep "wrapper-camunda-0.0.2.RELEASE.jar" |grep -v grep |awk '{print $2}'|xargs kill -9
cd  /Users/lankl/IdeaProjects/eam/eam/wrapper/wrapper-camunda/target
nohup  java -noverify -Dfile.encoding=UTF-8 -Dloader.path=./lib/ -jar wrapper-camunda-0.0.2.RELEASE.jar &
exit 0






