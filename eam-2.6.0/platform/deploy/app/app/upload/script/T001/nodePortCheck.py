#! /usr/bin/env python
import socket
import sys
ipaddress = [
'127.0.0.1:22'
]
def check_ip(ip,port):
        try:
                sk = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
                sk.settimeout(3)
                sk.connect((ip,port))
                return True
        except socket.error as e:
                return False
        finally:
                sk.close()

if __name__ == '__main__':
        args = sys.argv
        del(args[0])
        if len(args) > 0:
                ipaddress = args
        print('ip size:',len(ipaddress))
        for ipaddr in ipaddress:
                port = int(ipaddr.split(":",1)[1])
                ip = ipaddr.split(":",1)[0]
                status = check_ip(ip,port)
                if status == True:
                        info = 'IP \033[1;32m %s \033[0m port \033[1;32m %s \033[0m is successed!' %(ip,port)
                        print(info)
                else:
                        info = 'IP \033[1;31m %s \033[0m port \033[1;31m %s \033[0m is fail!' %(ip,port)
                        print(info)

