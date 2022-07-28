create schema if not exists repo;

drop table if exists repo.user;

create table repo.user (
  id    serial primary key,
  email varchar(50)
);

insert into repo.user (email) values ('tom@icloud.com');
insert into repo.user (email) values ('johan@icloud.com');
insert into repo.user (email) values ('bob@icloud.com');
insert into repo.user (email) values ('alex@icloud.com');