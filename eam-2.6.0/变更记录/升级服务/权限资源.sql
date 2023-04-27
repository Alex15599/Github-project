delete from sys_licence_free_full;
delete from sys_licence_free_sta;

insert into sys_licence_free_full select * from sys_licence;
insert into sys_licence_free_sta select * from sys_licence;




-- backup sys_menu sys_menu_resource
drop table sys_config_bak1;
create table sys_config_bak1 as select * from sys_config;

drop table sys_menu_bak1;
create table sys_menu_bak1 as select * from sys_menu;

drop table sys_menu_resource_bak1;
create table sys_menu_resource_bak1 as select * from sys_menu_resource;

-- delete sys_resourze,sys_menu,sys_menu_resource
delete from sys_resourze;
delete from sys_menu;
delete from sys_menu_resource;

-- source or insert into from
insert into sys_resourze select * from eam_clone.sys_resourze;
insert into sys_menu select * from eam_clone.sys_menu;
insert into sys_menu_resource select * from eam_clone.sys_menu_resource;

-- update
update sys_menu a set hidden=1 where a.id in (select id from sys_menu_bak1 where hidden=1);






