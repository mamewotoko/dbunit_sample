#! /bin/sh

mysql <<EOF
create database test;
connect test;
create table names (name TEXT(1024));
insert into names values("hoge");
EOF
