#!/bin/sh
###################################
#version 1.2.3 modify at 20210412
#user:app
#appfile:/tmp/tomcat.tar.gz
#appdir:/app
#appsubdir:tomcat
#sh cmd.sh /app appfilename app tomcat port
###################################
appdir="/app" 
appfilename="tomcat.tar.gz"
user="app"
appsubdir="tomcat"
port=8080
if [[ -n $1 ]];then
	appdir=$1
else
	echo "parameter error"
	exit 1
fi
if [[ -n $2 ]];then
	appfilename=$2
else
	echo "parameter error"
	exit 1
fi
if [[ -n $3 ]];then
	user=$3
else
	echo "parameter error"
	exit 1
fi
if [[ -n $4 ]];then
	appsubdir=$4
else
	echo "parameter error"
	exit 1
fi
if [[ -n $5 ]];then
	port=$5
fi
c1=`id $user|wc -l`
if [[ $c1 -eq 0 ]];then
	echo "deploy error,user:$user not exist"
	exit 1
fi
if [[ -d "${appdir}/$appsubdir" ]];then
	echo "deploy error,${appdir}/$appsubdir exist"
	exit 1
fi 

echo "deploy info:appdir=$appdir,appfilename=$appfilename,app=$app,appsubdir=$appsubdir"
########deploy##########
mkdir -p $appdir
cp ${appfile} ${appdir}/
cd $appdir
tar xvf /tmp/$appfilename
onedir=`ls -rtl |tail -1 |awk '{print $NF}'`
echo "onedir:$onedir"
if [[ -d "$appdir/$onedir/webapps" ]];then
  if [[ -d $appsubdir ]];then
	echo "deploy error!tomcat is exists"
    exit 1
    sn=`date +%s`
    mv $appsubdir ${appsubdir}.${sn}.bak
  fi
  cd $appdir
  echo "mv $onedir $appsubdir"
  mv $onedir $appsubdir
  onedir=$appsubdir
  rm -rf $appdir/$onedir/webapps/*
  chown -R $user:$user $appdir/$onedir
  chmod +x /etc/rc.d/rc.local
  sed -i '\/'"${onedir}"'\/bin\/startup.sh/d' /etc/rc.d/rc.local
  echo "su - $user -c \"sh $appdir/$onedir/bin/startup.sh\"">>/etc/rc.d/rc.local
  sed -i "s@port=\"8080\"@port=\"$port\"@g"  $appdir/$onedir/conf/server.xml
  su - $user -c "$appdir/$onedir/bin/startup.sh"
else
  echo "deploy failed!"
fi
exit 0