-- SpringBoard > "script.sql"

select * from tblUser;

drop table tblSpringBoard;

create table tblSpringBoard (
    seq number primary key,                          --글번호(PK)
    id varchar2(30) not null references tblUser(id), --작성자(FK)
    subject varchar2(500) not null,                  --제목
    content varchar2(2000) not null,                 --내용
    regdate date default sysdate not null,           --작성시간
    orgfilename varchar2(100) null,                  --첨부파일
    filename varchar2(100) null                      --첨부파일
);

create sequence seqSpringBoard;

insert into tblSpringBoard (seq, id, subject, content, regdate, orgfilename, filename) 
    values (seqSpringBoard.nextVal, 'hong', '스프링 게시판입니다.', '내용입니다.', default, null, null);
    
update tblSpringBoard set subject = '스프링 게시판입니다.', content = '내용입니다.', orgfilename = '', filename = '' where seq = 1;

delete from tblSpringBoard where seq = 1;

select * from tblSpringBoard;

select 
    seq, id, 
    (select name from tblUser where id = tblSpringBoard.id) as name,
    subject,
    regdate,
    filename
        from tblSpringBoard; --list.do

commit;

select * from tblSpringBoard;

-- 페이지 접속 로그 테이블
create table tblSpringLog (
    
    seq number primary key,                 --PK
    url varchar2(100) not null,             --페이지
    id varchar2(30) not null,               --유저아이디 or 익명(anony)
    regdate date default sysdate not null   --발생 시각
);

create sequence seqSpringLog;

select * from tblspringlog;








