#!/bin/sh
#version 1.2.3 modify at 20210412
#sh cmd.sh wasuser AppSrv01 /was/IBM /was/IBM/WebSphere/AppServer 18000
wasuser=$1
fdmgr=$2
waspath=$3
apppath=$4
wasadmin=wasadmin
waspwd=wasadmin
host=`hostname`
sport=$5
fcell=Cell01
fnode=${host}MgrNode01
c1=`id $wasuser|wc -l`
if [[ $c1 -eq 0 ]];then
  echo "deploy error,wasuser:$wasuser not exist"
  exit 1
fi
if [[ -n $5 ]];then
	sport=$5
fi
if [[ ! -f $waspath/WebSphere/AppServer/bin/manageprofiles.sh ]] ;then
  echo "manageprofiles.sh not exist"
  exit 1
fi
if [[ -d $apppath/profiles/$fdmgr ]];then
  echo "error,$apppath/profiles/$fdmgr exist,please remove it first"
  exit 1
fi
su - $wasuser -c "$waspath/WebSphere/AppServer/bin/manageprofiles.sh -create -templatePath $waspath/WebSphere/AppServer/profileTemplates/dmgr -profileName $fdmgr -profilePath $apppath/profiles/$fdmgr -cellName $fcell -nodeName $fnode -hostName $host -startingPort $sport -enableAdminSecurity true -adminUserName $wasadmin -adminPassword $waspwd"
sed -i '/bin\/startManager.sh/d' /etc/rc.d/rc.local
echo "su - $wasuser -c \"$apppath/profiles/$fdmgr/bin/startManager.sh\"">>/etc/rc.d/rc.local
su - $wasuser -c "$apppath/profiles/$fdmgr/bin/startManager.sh"
cat $apppath/profiles/$fdmgr/properties/portdef.props
exit 0
