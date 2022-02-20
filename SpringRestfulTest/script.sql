-- SpringRestfulTest > "script.sql"

select * from tabs order by table_name;

select * from tblAddress;

drop table tblAddress CASCADE CONSTRAINTS;

create table tblAddress (
    seq number primary key,
    name varchar2(30) not null,
    age number not null,
    tel varchar2(15) not null,
    address varchar2(100) not null
);

drop sequence seqAddress;
create sequence seqAddress;