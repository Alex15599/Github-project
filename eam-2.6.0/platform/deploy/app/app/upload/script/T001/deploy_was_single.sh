#!/bin/sh
#version 1.2.3 modify at 20210412
#sh cmd.sh  /was was imsoft wassoft 
wasdir=$1
wasuser=$2
imsoft=$3
wassoft=$4
jdksoft=$5
cd /tmp
if [[ ! -f $imsoft ]];then
    echo "deploy error,imsoft=$imsoft not exist."
    exit 1
fi
if [[ ! -f $wassoft ]];then
    echo "deploy error,wassoft=$wassoft not exist."
    exit 1
fi
if [[ ! -f $jdksoft ]];then
    echo "deploy error,jdksoft=$jdksoft not exist."
    exit 1
fi
c1=`id $wasuser|wc -l`
if [[ $c1 -eq 0 ]];then
	echo "deploy error,wasuser:$wasuser not exist"
	exit 1
fi
if [[ -d "$wasdir/IBM/InstallationManager" ]];then
    echo "deploy error,wasdir=$wasdir/IBM/InstallationManager is exist,please remove it first."
    exit 1
fi
sn=`date +%s`
chmod +x /etc/rc.d/rc.local
chown $wasuser:$wasuser $imsoft
chown $wasuser:$wasuser $wassoft
chown $wasuser:$wasuser $jdksoft
mkdir -p $wasdir
mkdir -p /tmp/soft_$sn/im
mkdir -p /tmp/soft_$sn/was
mkdir -p /tmp/soft_$sn/java
cp $imsoft  /tmp/soft_$sn/im
cp $wassoft /tmp/soft_$sn/was
cp $jdksoft /tmp/soft_$sn/java
chown -R $wasuser:$wasuser /tmp/soft_$sn
chown $wasuser:$wasuser $wasdir
echo "start to install im"
su - $wasuser -c "cd /tmp/soft_$sn/im;unzip $imsoft;/tmp/soft_$sn/im/userinstc -acceptLicense -installationDirectory $wasdir/IBM/InstallationManager -showProgress"
echo "start to install was"
#if can't install,first uninstallAll
#su - $wasuser -c "$wasdir/IBM/InstallationManager/eclipse/tools/imcl uninstallAll"
su - $wasuser -c "cd /tmp/soft_$sn/java;unzip $jdksoft;cd /tmp/soft_$sn/was;unzip $wassoft;$wasdir/IBM/InstallationManager/eclipse/tools/imcl install com.ibm.websphere.ND.v90_9.0.5001.20190828_0616 com.ibm.java.jdk.v8_8.0.5035.20190422_0948 -repositories /tmp/soft_$sn/java/$jdksoft,/tmp/soft_$sn/was/$wassoft -installationDirectory $wasdir/IBM/WebSphere/AppServer -sharedResourcesDirectory $wasdir/IBM/IMShared -properties cic.selector.nl=zh -showProgress -acceptLicense"
exit 0
