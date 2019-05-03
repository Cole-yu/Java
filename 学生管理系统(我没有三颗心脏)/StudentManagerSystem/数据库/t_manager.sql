-- Create table
create table T_MANAGER
(
  ID       NUMBER not null,
  USERNAME VARCHAR2(20) not null,
  PASSWORD VARCHAR2(40) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table T_MANAGER
  add constraint IDS primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );



insert into t_manager (ID, USERNAME, PASSWORD, ROWID)
values (1, '123', '123', 'AAANuoAAEAAAAJtAAA');

insert into t_manager (ID, USERNAME, PASSWORD, ROWID)
values (2, '李四1', '123', 'AAANuoAAEAAAAJtAAB');

