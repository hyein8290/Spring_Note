-- SpringFileTest > "script.sql"

-- 게시판 + 파일업로드(1개)
create table tblFileBoard (
    seq number primary key,                     --PK
    subject varchar2(100) not null,             --제목
    name varchar2(30) not null,                 --작성자
    regdate date default sysdate not null,      --작성일
    filename varchar2(100) null,                --파일명(저장)
    orgfilename varchar2(100) null              --파일명(원본)
);

create sequence seqFileBoard;

select * from tblFileBoard;

drop table tblFileBoard;
drop sequence seqFileBoard;

-- 게시판 + 파일업로드(N개)
create table tblFileBoard (
    seq number primary key,                     --PK
    subject varchar2(100) not null,             --제목
    name varchar2(30) not null,                 --작성자
    regdate date default sysdate not null       --작성일
);

create table tblFile (
    seq number primary key,                     --PK
    filename varchar2(100) null,                --파일명(저장)
    orgfilename varchar2(100) null,             --파일명(원본)
    bseq number not null references tblFileBoard(seq)
);

create sequence seqFileBoard;
create sequence seqFile;

select * from tblFile;










