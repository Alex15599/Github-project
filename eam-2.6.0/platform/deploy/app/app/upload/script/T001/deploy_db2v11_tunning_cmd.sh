#!/bin/sh
##########################################
#version 1.2.5 modify at 20200412
#sh cmd.sh db.soft.tar DB2INST1 DB2APPUSER 
##########################################
########################################
#Deploy Db2
########################################
DB2INST1="db2inst1"
DB2APPUSER="db2user"
DB2INST1=$1
DB2APPUSER=$2
echo "DB2INST1=$DB2INST1"
echo "DB2APPUSER=$DB2APPUSER"
c1=`id $DB2INST1|wc -l`
c2=`id $DB2APPUSER|wc -l`
if [[ $c1 -eq 0 ]];then
	echo "deploy error,db2inst1:$DB2INST1 not exist"
	exit 1
fi
if [[ $c2 -eq 0 ]];then
	echo "deploy error,db2user:$DB2APPUSER not exist"
	exit 1
fi
echo "#######config limits.conf"
sed -i '/'"$DB2INST1"'/d' /etc/security/limits.conf
sed -i '/'"$DB2APPUSER"'/d' /etc/security/limits.conf
echo "$DB2APPUSER soft nofile 16384 ">>/etc/security/limits.conf
echo "$DB2APPUSER hard nofile 16384 ">>/etc/security/limits.conf
echo "$DB2APPUSER soft nproc 16384 ">>/etc/security/limits.conf
echo "$DB2APPUSER hard nproc 65536 ">>/etc/security/limits.conf
echo "$DB2INST1 soft nofile 16384 ">>/etc/security/limits.conf
echo "$DB2INST1 hard nofile 16384 ">>/etc/security/limits.conf
echo "$DB2INST1 soft nproc 16384 ">>/etc/security/limits.conf
echo "$DB2INST1 hard nproc 65536 ">>/etc/security/limits.conf
echo "$DB2INST1 soft rss -1 ">>/etc/security/limits.conf
echo "$DB2INST1 hard rss -1 ">>/etc/security/limits.conf
echo "$DB2INST1 soft fsize -1 ">>/etc/security/limits.conf
echo "$DB2INST1 hard fsize -1 ">>/etc/security/limits.conf
echo "$DB2INST1 soft cpu -1 ">>/etc/security/limits.conf
echo "$DB2INST1 hard cpu -1 ">>/etc/security/limits.conf
echo "$DB2INST1 soft stack -1 ">>/etc/security/limits.conf
echo "$DB2INST1 hard stack -1 ">>/etc/security/limits.conf
echo "$DB2INST1 soft locks -1 ">>/etc/security/limits.conf
echo "$DB2INST1 hard locks -1 ">>/etc/security/limits.conf
echo "$DB2INST1 soft memlock -1 ">>/etc/security/limits.conf
echo "$DB2INST1 hard memlock -1 ">>/etc/security/limits.conf
echo "$DB2INST1 soft as -1 ">>/etc/security/limits.conf
echo "$DB2INST1 hard as -1 ">>/etc/security/limits.conf
echo "#######config sysctl.conf"
sed -i '/vm.swappiness/d'  /etc/sysctl.conf
sed -i '/vm.overcommit_memory/d'  /etc/sysctl.conf
sed -i '/kernel.randomize_va_space/d'  /etc/sysctl.conf
sed -i '/kernel.sem/d'  /etc/sysctl.conf
sed -i '/kernel.msgmax/d'  /etc/sysctl.conf
sed -i '/kernel.msgmnb/d'  /etc/sysctl.conf
echo "vm.swappiness=5">>/etc/sysctl.conf
echo "vm.overcommit_memory=0">>/etc/sysctl.conf
echo "kernel.randomize_va_space=0">>/etc/sysctl.conf
echo "kernel.msgmax=65536">>/etc/sysctl.conf
echo "kernel.msgmnb=65536">>/etc/sysctl.conf
sed -i '/kernel.shmmni/d'  /etc/sysctl.conf
sed -i '/kernel.shmmax/d'  /etc/sysctl.conf
sed -i '/kernel.shmall/d'  /etc/sysctl.conf
sed -i '/kernel.msgmni/d'  /etc/sysctl.conf
sed -i '/kernel.sem/d'     /etc/sysctl.conf
sed -i '/ip_local_port_range/d' /etc/sysctl.conf
echo "net.ipv4.ip_local_port_range=1024 65000" >>/etc/sysctl.conf
echo "#######config sysctl.conf"
pagesize=`getconf PAGESIZE`
if [[ $? -ne 0 ]];then
	pagesize=4096
fi 
memtotal=`free -g|grep Mem|awk '{print $2}'`
shmmni=`echo $memtotal|awk '{print $1*256}'`
shmmax=`echo $memtotal |awk '{print $1*1024*1024*1024}'`
#shmall=`echo $memtotal $pagesize|awk '{print $1*1024*1024*1024*0.9/$2}'`
shmall=`echo $memtotal $pagesize|awk '{printf "%d",$1*1024*1024*1024*0.9/$2}'`
msgmni=`echo $memtotal|awk '{print $1*4}'`
sem=`echo $memtotal$|awk '{print $1*256}'`
if [[ $shmmni -gt 512 ]];then
	echo "kernel.sem=250 256000 32 $sem">>/etc/sysctl.conf
fi
if [[ $shmmni -gt 256 ]];then
	echo "kernel.shmmni=$shmmni">>/etc/sysctl.conf
fi
if [[ $shmmax -gt 1073741824 ]];then
	echo "kernel.shmmax=$shmmax">>/etc/sysctl.conf
fi
if [[ $shmall -gt 235930 ]];then
	echo "kernel.shmall=$shmall">>/etc/sysctl.conf
fi
if [[ $msgmni -gt 1024 ]];then
	echo "kernel.msgmni=$msgmni">>/etc/sysctl.conf
fi
sysctl -p
#echo "if db2 config HDR,to set list"
#echo 1 >/proc/sys/net/ipv4/tcp_timestamps
#echo 1 >/proc/sys/net/ipv4/tcp_window_scaling
#echo 1 >/proc/sys/net/ipv4/tcp_stack
#echo 1024000 >/proc/sys/net/core/rmem_default
#echo 4096000 >/proc/sys/net/core/rmem_max
#echo 1024000 >/proc/sys/net/core/wmem_default
#echo 4096000 >/proc/sys/net/core/wmem_max
#echo "echo 1 >/proc/sys/net/ipv4/tcp_timestamps      ">>/etc/rc.d/rc.local
#echo "echo 1 >/proc/sys/net/ipv4/tcp_window_scaling  ">>/etc/rc.d/rc.local
#echo "echo 1 >/proc/sys/net/ipv4/tcp_stack           ">>/etc/rc.d/rc.local
#echo "echo 1024000 >/proc/sys/net/core/rmem_default  ">>/etc/rc.d/rc.local
#echo "echo 4096000 >/proc/sys/net/core/rmem_max      ">>/etc/rc.d/rc.local
#echo "echo 1024000 >/proc/sys/net/core/wmem_default  ">>/etc/rc.d/rc.local
#echo "echo 4096000 >/proc/sys/net/core/wmem_max      ">>/etc/rc.d/rc.local
exit 0