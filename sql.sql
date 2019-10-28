
create table board(
	bno int not null auto_increment primary key,
    title varchar(100) not null,
    content varchar(1000) not null,
    writer varchar(50) not null,
    regdate datetime default now(),
    updatedate datetime default now(),
    fix int default '0',
    replyCnt int default '0',
    groupNo int default null,
    groupOrd int default null,
    depth int default null
);

drop table board;
insert into board (title, content, writer) values('제목', '내용', '작성자');
insert into board (title, content, writer, fix) values('공지', '공지내용', '관리', '1');
insert into board (title, content, writer, groupNo, groupOrd) values('15본글', '15z', 'ㅎㅎ', '16', '0');

select * from board;
select * from reply;
select * from board order by groupNo desc, groupOrd asc;

create table reply(
	rno int not null auto_increment primary key,
    bno int not null default '0',
    reply varchar(1000) not null,
    replyer varchar(50) not null,
    replyDate datetime default now(),
    updateDate datetime default now()
);

alter table reply add constraint board foreign key (bno) references board(bno) on delete cascade;

update board set replyCnt = (select count(rno) from reply where reply.bno=board.bno);

















create table article(
	bno int not null auto_increment primary key,
    title varchar(100) not null,
    content varchar(1000) not null,
    writer varchar(50) not null,
    regdate datetime default now(),
    updatedate datetime default now()
);

select * from article;

insert into article(title, content, writer) values('yo','ya','ki');

create table comment(
	rno int not null auto_increment primary key,
    bno int not null default '0',
    reply varchar(1000) not null,
    replyer varchar(50) not null,
    replyDate datetime default now(),
    updateDate datetime default now()
);
select * from comment;

alter table comment add groupNo int;
alter table comment add depth int default '0';
alter table comment add seq int default '0';

alter table comment drop depth;
insert into comment (bno, reply, replyer, groupNo, depth, seq) values(55, '안녕', '주누', '55', '1', '1');
insert into comment (bno, reply, replyer, groupNo, depth, seq) values(55, '답글안녕', '주누', '55', '2', '2');
insert into comment (bno, reply, replyer, groupNo, depth, seq) values(54, '안녕2', '주누2', '54', '1', '1');

select bno, rno, replyer, reply, groupNo, depth, seq from comment where bno = 55 order by depth asc;

alter table comment add constraint article foreign key (bno) references article(bno);

insert into comment(bno, reply, replyer) values('55', 'dd', 'dss');