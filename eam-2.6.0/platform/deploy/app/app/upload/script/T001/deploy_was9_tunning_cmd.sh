#!/bin/sh
#version 1.2.3 modify at 20210412
#sh cmd.sh wasuser
wasuser=$1
c1=`id $wasuser|wc -l`
if [[ $c1 -eq 0 ]];then
  echo "deploy error,wasuser:$wasuser not exist"
  exit 1
fi
sed -i '/'"$wasuser"'/d' /etc/security/limits.conf
echo "$wasuser soft nofile 16384 ">>/etc/security/limits.conf
echo "$wasuser hard nofile 16384 ">>/etc/security/limits.conf
echo "$wasuser soft nproc 16384 ">>/etc/security/limits.conf
echo "$wasuser hard nproc 65536 ">>/etc/security/limits.conf
echo "#######config sysctl.conf"
sed -i '/net.ipv4.ip_local_port_range/d' /etc/sysctl.conf
sed -i '/net.ipv4.tcp_keepalive_time/d'  /etc/sysctl.conf
sed -i '/fs.aio-max-nr/d'  /etc/sysctl.conf
sed -i '/vm.swappiness/d'  /etc/sysctl.conf
sed -i '/kernel.msgmax/d'  /etc/sysctl.conf
sed -i '/kernel.msgmnb/d'  /etc/sysctl.conf
sed -i '/kernel.shmmni/d'  /etc/sysctl.conf
sed -i '/kernel.shmmax/d'  /etc/sysctl.conf
sed -i '/kernel.shmall/d'  /etc/sysctl.conf
sed -i '/kernel.msgmni/d'  /etc/sysctl.conf
echo "net.ipv4.tcp_keepalive_time=300">>/etc/sysctl.conf
echo "net.ipv4.ip_local_port_range=9000 65500">>/etc/sysctl.conf
echo "fs.aio-max-nr=4194303">>/etc/sysctl.conf
echo "vm.swappiness=10">>/etc/sysctl.conf
echo "kernel.msgmax=65536">>/etc/sysctl.conf
echo "kernel.msgmnb=65536">>/etc/sysctl.conf
memtotal=`free -g|grep Mem|awk '{print $2}'`
pagesize=`getconf PAGESIZE`
if [[ $? -ne 0 ]];then
	pagesize=4096
fi 
shmmni=`echo $memtotal|awk '{print $1*256}'`
shmmax=`echo $memtotal |awk '{print $1*1024*1024*1024}'`
#shmall=`echo $memtotal $pagesize|awk '{print $1*1024*1024*1024*0.9/$2}'`
shmall=`echo $memtotal $pagesize|awk '{printf "%d",$1*1024*1024*1024*0.9/$2}'`
msgmni=`echo $memtotal|awk '{print $1*4}'`
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
exit 0