drop table if exists user;
create table user (
  id   int auto_increment not null
  comment '编号',
  name varchar(20)        not null
  comment '名字',
  sex  boolean            null
  comment '性别',
  age  int                null
  comment '年龄'
);