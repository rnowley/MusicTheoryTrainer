drop table if exists users;
drop table if exists authorities;

create table users(
  id identity,
  username varchar_ignorecase(50) not null,
  password varchar_ignorecase(50) not null,
  enabled boolean not null);

create table authorities (
  username varchar_ignorecase(50) not null,
  authority varchar_ignorecase(50) not null,
  foreign key (username) references users(username));
  create index auth_username ON authorities(username, authority)