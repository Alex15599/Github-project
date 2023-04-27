#!/bin/sh
###################################
#sh cmd.sh cdrom
###################################
cdrom=$1
if [[ $cdrom -eq 1 ]];then
	echo "[local]              "   >/etc/yum.repos.d/local.repo
	echo "name=local           "  >>/etc/yum.repos.d/local.repo
	echo "baseurl=file:///mnt  "  >>/etc/yum.repos.d/local.repo
	echo "enabled=1            "  >>/etc/yum.repos.d/local.repo
	echo "gpgcheck=0           "  >>/etc/yum.repos.d/local.repo
	mount /dev/cdrom /mnt
	yum -y install unzip net-tools wget telnet
fi
sed -i 's/SELINUX=enforcing/SELINUX=disabled/' /etc/selinux/config
chmod +x /etc/rc.d/rc.local
systemctl stop      firewalld.service
systemctl disable   firewalld.service
systemctl stop 		postfix.service        
systemctl disable   postfix.service 


