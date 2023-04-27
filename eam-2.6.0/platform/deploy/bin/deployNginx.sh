#!/bin/sh
#8091,8090
########################################
cur_dir=$(cd `dirname $0`; pwd)
app_dir=$cur_dir/..
nginx_name=nginx-1.24.0.tar.gz.1
mkdir -p $app_dir/app/nginx
nginx_dir=$app_dir/app/nginx
echo "install nginx,dir:$nginx_dir"
echo "app dir dir:$app_dir"
function help(){
	echo "cd $nginx_dir"
	echo "$nginx_dir/sbin/nginx -s stop"
	echo "rm -rf nginx-1.24.0"
	echo "rm -rf sbin"
	echo "rm -rf html"
	echo "rm -rf *temp"
	echo "rm -rf logs"
	echo "rm -rf conf"
}
if [[ ! -d $nginx_dir ]];then
  echo "nginx directory not exist";
  exit 1
fi
if [[ -f $nginx_dir/conf/nginx.conf ]];then
	echo "nginx already exists!you can remove it,";
	help
	exit 1
fi
nginx_tar=$nginx_dir/$nginx_name
yum -y install gcc wget gcc-c++ automake autoconf libtool libxml2-devel libxslt-devel perl-devel perl-ExtUtils-Embed pcre-devel openssl-devel
cd $nginx_dir
tar xvf $nginx_name
ng=`ls -rtl |grep nginx-1|grep -v tar.gz|grep -v conf|awk '{print $NF}'`
cd $ng
echo "start to install nginx"
./configure --prefix=$nginx_dir --with-stream --with-http_ssl_module --with-stream_ssl_module --with-http_stub_status_module
make && make install
#clear
cd $nginx_dir
rm -rf $ng
#deploy h5 html
cd $nginx_dir
mkdir -p html
mkdir -p cert
h5tar=h5.tar.gz.1
if [[ -f $h5tar ]];then
  cp $h5tar html
  cd html
  tar xvf $h5tar
fi
#deploy h5 html
cd $nginx_dir
if [[ -f nginx.conf ]];then
  cat nginx.conf>conf/nginx.conf
fi
#start
if [[ -f ./sbin/nginx ]];then
  ./sbin/nginx
else
  echo "nginx install failed,./sbin/nginx not exist"
  exit 1
fi
exit 0
#to clear
./sbin/nginx -s stop
rm -rf nginx-1.24.0
rm -rf sbin
rm -rf html
rm -rf *temp
rm -rf logs
rm -rf conf

