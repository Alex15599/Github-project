alter table ops_information_system add column address varchar(500) after status;
alter table ops_host add column host_ipv6 varchar(500) after host_vip;