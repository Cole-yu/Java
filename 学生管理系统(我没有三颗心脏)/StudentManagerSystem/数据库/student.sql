create table STUDENT2
(
  STID      VARCHAR2(25),
  STNAME    VARCHAR2(10),
  STSEX     VARCHAR2(10),
  STAGE     VARCHAR2(10),
  STTEL     VARCHAR2(20),
  STDEPT    VARCHAR2(20),
  STADDRESS VARCHAR2(50)
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

-- Create sequence 
create sequence STU2_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 25
increment by 1
nocache;

insert into student2 (STID, STNAME, STSEX, STAGE, STTEL, STDEPT, STADDRESS, ROWID)
values ('24', '大明', '男', '23', '15866742101', '医学系', '山东潍坊市', 'AAANujAAEAAAAIPAAB');

insert into student2 (STID, STNAME, STSEX, STAGE, STTEL, STDEPT, STADDRESS, ROWID)
values ('15', '邵玉先', '男', '19', '13653548652', '化学系', '山东济南市', 'AAANujAAEAAAAIQAAA');

insert into student2 (STID, STNAME, STSEX, STAGE, STTEL, STDEPT, STADDRESS, ROWID)
values ('17', '李四', '女', '20', '16535476665', '农学系', '山东潍坊市', 'AAANujAAEAAAAIQAAC');

insert into student2 (STID, STNAME, STSEX, STAGE, STTEL, STDEPT, STADDRESS, ROWID)
values ('18', '小龙', '女', '21', '15695845635', '美术系', '山东临沂市', 'AAANujAAEAAAAIQAAD');

insert into student2 (STID, STNAME, STSEX, STAGE, STTEL, STDEPT, STADDRESS, ROWID)
values ('19', '王芳', '女', '22', '12355668542', '音乐系', '山东威海市', 'AAANujAAEAAAAIQAAE');

insert into student2 (STID, STNAME, STSEX, STAGE, STTEL, STDEPT, STADDRESS, ROWID)
values ('20', '红红', '女', '18', '16546542363', '历史系', '山东青岛市', 'AAANujAAEAAAAIQAAF');

insert into student2 (STID, STNAME, STSEX, STAGE, STTEL, STDEPT, STADDRESS, ROWID)
values ('21', '李逸', '男', '18', '14365976365', '物理系', '山东菏泽市', 'AAANujAAEAAAAIQAAG');

insert into student2 (STID, STNAME, STSEX, STAGE, STTEL, STDEPT, STADDRESS, ROWID)
values ('22', '李侯名', '男', '20', '15899635412', '计算机系', '山东济宁市', 'AAANujAAEAAAAIQAAH');

