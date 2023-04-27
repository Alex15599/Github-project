#!/bin/sh
#version 1.2.3 modify at 20210412
#sh cmd.sh wasuser AppSrv01 /was/IBM /was/IBM/WebSphere/AppServer 18555
wasuser=$1
fsrv=$2
waspath=$3
apppath=$4
wasadmin=wasadmin
waspwd=wasadmin
sport=18555
host=`hostname`
fcell=Cell01
fnode=${host}AppNode01
c1=`id $wasuser|wc -l`
if [[ -n $5 ]];then
	sport=$5
fi
if [[ $c1 -eq 0 ]];then
  echo "deploy error,wasuser:$wasuser not exist"
  exit 1
fi
if [[ ! -f $waspath/WebSphere/AppServer/bin/manageprofiles.sh ]] ;then
  echo "error,manageprofiles.sh not exist"
  exit 1
fi
if [[ -d $apppath/profiles/$fsrv ]];then
  echo "error,$apppath/profiles/$fsrv exist,please remove it first"
  exit 1
fi
su - $wasuser -c "$waspath/WebSphere/AppServer/bin/manageprofiles.sh -create -templatePath $waspath/WebSphere/AppServer/profileTemplates/default -profileName $fsrv -profilePath $apppath/profiles/$fsrv -cellName $fcell -nodeName $fnode -hostName $host -startingPort $sport -enableAdminSecurity true -adminUserName $wasadmin -adminPassword $waspwd"
sed -i '/bin\/startNode.sh/d' /etc/rc.d/rc.local
echo "su - $wasuser -c \"$apppath/profiles/$fsrv/bin/startNode.sh\"">>/etc/rc.d/rc.local
cat $apppath/profiles/$fsrv/properties/portdef.props
exit 0
