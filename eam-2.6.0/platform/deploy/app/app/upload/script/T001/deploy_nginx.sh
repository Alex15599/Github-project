#!/bin/sh
###################################
#version 1.2.3 modify at 20210412
#sh cmd.sh nginx.tar.gz /app/nginx nginx
###################################
soft=$1
nginxdir=$2
nginxuser=$3
if [[ -d $nginx ]];then
	echo "deploy error,nginxdir exist,please remove first"
	exit 1
fi
c1=`id $nginxuser|wc -l`
if [[ $c1 -eq 0 ]];then
	echo "deploy error,nginxuser:$nginxuser not exist"
	exit 1
fi
cd /tmp
if [[ ! -f $soft ]];then
	echo "deploy error,soft not exist"
	exit 1
fi
sn=`date +%s`
tempdir="nginx.$sn"
mkdir $tempdir
cp $soft $tempdir
cd $tempdir
tar xvf $soft
onedir=`ls -rtl |grep -v tar|grep -v gz|grep -v zip |tail -1 |awk '{print $NF}'`
cd $onedir
mkdir -p $nginxdir
./configure --prefix=$nginxdir
make
make install
chown -R $nginxuser:$nginxuser $nginxdir
sed -i 's/80/7799/g' $nginxdir/conf/nginx.conf
sed -i '/nginx/d' /etc/rc.d/rc.local
echo "su - $nginxuser -c \"$nginxdir/sbin/nginx -c $nginxdir/conf/nginx.conf\"">>/etc/rc.d/rc.local
su - $nginxuser -c "$nginxdir/sbin/nginx -c $nginxdir/conf/nginx.conf"
exit 0