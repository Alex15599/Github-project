 #!/bin/sh
###################################
#sh cmd.sh 
###################################
yum install -y ntp
crontab -l
cnt=`crontab -l|grep -v "#"|grep ntpdate|wc -l`
if [[ $cnt -eq 0 ]];then
    sed -i /time.dh.com/d /etc/hosts
	echo "10.0.1.53 time.dh.com">>/etc/hosts
	echo "*/30 * * * * ntpdate -s time.dh.com">>/var/spool/cron/root
fi
crontab -l
exit 0