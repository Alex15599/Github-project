#!/bin/sh
##########################################
#version 1.2.5 modify at 20200412
#sh cmd.sh db.soft.tar db2inst1 db2fenc1 dasusr1 
##########################################
soft="DB2v11.1.4fp5_linux64_server.tar.gz"
########################################
#Deploy Db2
########################################
DB2INST1="db2inst1"
DB2FENC1="db2fenc1"
DASUSR1="dasusr1"
echo "start to deploy db2"
if [[ -n $1 ]];then
	soft=$1
else
	echo "deploy error!parameter failed"
	exit 1
fi
DB2INST1=$2
DB2FENC1=$3
DASUSR1=$4
echo "SOFT=$soft"
echo "DB2INST1=$DB2INST1"
echo "DB2FENC1=$DB2FENC1"
echo "DASUSR1=$DASUSR1"
c1=`id $DB2INST1|wc -l`
c2=`id $DB2FENC1|wc -l`
c3=`id $DASUSR1|wc -l`
if [[ $c1 -eq 0 ]];then
	echo "deploy error,db2inst1:$DB2INST1 not exist"
	exit 1
fi
if [[ $c2 -eq 0 ]];then
	echo "deploy error,db2fenc1:$DB2FENC1 not exist"
	exit 1
fi
if [[ $c3 -eq 0 ]];then
	echo "deploy error,dasusr1:$DASUSR1 not exist"
	exit 1
fi
cd /tmp/
if [[ ! -f $soft ]];then
	echo "Deply Soft Match Failed"
	exit 1
fi 
if [[ ! -f "/tmp/db2v11_db2ese_c.lic" ]];then
	echo "deploy error,dasusr1:lic not exist"
	exit 1
fi
if [[ -d "/opt/ibm/db2/V11.1" ]];then
	echo "deploy error,please remove /opt/ibm/db2/V11.1 first."
	exit 1
fi 
echo "start to deploy"
cd /tmp
if [[ -d "server_t" ]];then
	s=`date +%s`
	mv server_t server_t_$s.bak
fi
if [[ ! -d "/tmp/server_t" ]];then	
	tar xvf $soft
fi
cd /tmp/server_t
./db2_install -b /opt/ibm/db2/V11.1 -p SERVER -f NOTSAMP -t /tmp/db2_install.trc -l /tmp/db2_install.log -y -n
/opt/ibm/db2/V11.1/adm/db2licm -a /tmp/db2v11_db2ese_c.lic
/opt/ibm/db2/V11.1/adm/db2licm -l 
/opt/ibm/db2/V11.1/instance/db2icrt -p 60000 -u $DB2FENC1 $DB2INST1
sed -i '/'"$DB2INST1"'/d' /etc/rc.d/rc.local
echo "su - $DB2INST1 -c \"db2start\"">>/etc/rc.d/rc.local
chmod +x /etc/rc.d/rc.local
cat /etc/rc.d/rc.local
su - $DB2INST1 -c "db2start"
exit 0