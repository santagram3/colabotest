CREATE TABLE news (
	aid number primary key,
	title VARCHAR2(100) NOT NULL,
	img VARCHAR2(200) NOT NULL,
	regdate date default sysdate,
	content VARCHAR2(4000) NOT NULL
);

create table comments(
	commentAid number primary key,
	nickname VARCHAR2(50) NOT NULL,
	commentContent VARCHAR2(3000) NOT NULL,
	commentDate date default sysdate,
	aid number NOT NULL,
	foreign key (aid) references news(aid) on delete cascade
);


select * from news;
select * from comments;


insert into comments(commentAid, nickname, commentContent, commentDate, aid)
			values (1, '김재욱', '1번 댓글입니다', sysdate, 43);
insert into comments(commentAid, nickname, commentContent, commentDate, aid)
			values (2, '김쟁구', '2번 댓글입니다', sysdate, 43);
insert into comments(commentAid, nickname, commentContent, commentDate, aid)
			values (3, '재욱', '3번 댓글입니다', sysdate, 43);
insert into comments(commentAid, nickname, commentContent, commentDate, aid)
			values (4, 'jaewook', '1번 댓글입니다', sysdate, 42);