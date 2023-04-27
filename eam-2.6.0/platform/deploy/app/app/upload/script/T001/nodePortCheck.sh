#!/bin/sh
###################################
#sh run.sh
###################################
#configure methon1
port_10_22_6_213='127.0.0.1:22 127.0.0.1:25'
#configure methon2
port_list='
10.22.6.213|127.0.0.1:22,127.0.0.1:22
10.22.6.212|127.0.0.1:22,127.0.0.1:22
'
######################################################
if [[ ! -f "nodePortCheck.py" ]];then
	echo "nodePortCheck.py not exist"
	exit 1
fi
curip=`ifconfig -a |grep -v inet6|grep inet|grep -v "127.0.0.1"|grep -v grep|head -1|sed "s@addr:@ @g"|awk '{print $2}'`
echo "#################current ip:$curip"
#######execute port_ip conf
curip_c=`echo $curip| sed "s@\.@_@g"`
curip_portvar=`echo port_$curip_c`
curip_portstr=`eval echo \\$$curip_portvar`
c1=`echo ${#curip_portstr}`
if [[ $c1 -lt 4 ]];then
	echo try to read data from filesystem
	cf="/tmp/port_${curip}.txt"
	if [[ -f "$cf" ]];then
		curip_portstr=`cat $cf`
	fi
fi
#python hostPortCheck.py $curip_portstr
#######execute ports conf
other_node=" "
for node in $port_list 
do
	#echo "node:$node"
	ip=`echo $node|awk -F '|' '{print $1}'`
	port=`echo $node|awk -F '|' '{print $2}'`
	if [[ $ip == $curip ]];then
		rp=`echo $port|sed 's/ //g'|sed "s@,@ @g"`
		#echo "rport:$rp"
		other_node="$other_node $rp"
	fi 
done
#######execute 
c1=`echo ${#curip_portstr}`
c2=`echo ${#other_node}`
if [[ $c1 -gt 4 || $c2 -gt 4 ]];then
	python nodePortCheck.py $curip_portstr $other_node
else
	echo "Check data not matched"
fi
exit 0
 