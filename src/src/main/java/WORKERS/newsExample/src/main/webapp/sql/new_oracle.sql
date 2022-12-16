-- 테이블 생성 
CREATE TABLE news (
	aid number primary key,
	title VARCHAR2(100) NOT NULL,
	img VARCHAR2(200) NOT NULL,
	regdate date default sysdate,
	content VARCHAR2(4000) NOT NULL
);
-- 시퀀스 번호 생성 
create sequence new_seq; 
-- 생성된것 확인 ,안에 내용물 확인 ! 
select new_seq;

select * from news;

-- 이건 맞거든 ? 
update news set title='파인애플', content='파인애플로' ,img='/img/pineapple.jpeg'
where aid = 26;

