create sequence seq_board; -- 자동번호 객체 생성

create table tbl_board (
	bno number(10,0),
	title varchar2(200) not null,
	content varchar2(2000) not null,
	writer varchar2(50) not null,
	regdate date default sysdate,
	updatedate date default sysdate
); -- tbl_board 테이블 생성(번호, 제목, 내용, 작성자, 작성일, 수정일)

alter table tbl_board add constraint pk_board primary key (bno);

select * from tbl_board;

select sysdate from dual

insert into tbl_board (bno, title, content, writer) 
values (seq_board.nextval, '테스트 제목', '테스트 내용', 'user00');

create table review(
rno Number(10,0) constraint rno_pk primary key,
bno number(10,0),
reply varchar2(2000) not null,
replyer varchar2(50) not null,
replyDate date default sysdate,
update_date date default sysdate
)

create sequence rno_seq
start with 1
increment by 1
nocycle
nocache;


