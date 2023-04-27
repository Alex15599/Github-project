drop table sys_user_bak_1;
create table sys_user_bak_1 as select * from sys_user;
UPDATE sys_user aa SET account = ifnull( (SELECT bb.badge FROM
    (
        select a.id,a.account,c.badge from sys_user a,sys_user_tenant b,hrm_employee c
        where a.id=b.user_id
          and a.account not in (select account from sys_auto_user_predefined where deleted=0)
          and b.employee_id=c.id
          and a.deleted=0
          and b.deleted=0
          and c.deleted=0
    ) bb
WHERE bb.id = aa.id and aa.account is not null), aa.account)


select concat('update sys_user set account=\'',c.badge,'\' where id=\'',a.id,'\';') from sys_user a,sys_user_tenant b,hrm_employee c
where a.id=b.user_id
  and a.account not in (select account from sys_auto_user_predefined where deleted=0)
  and b.employee_id=c.id
  and a.deleted=0
  and b.deleted=0
  and c.deleted=0