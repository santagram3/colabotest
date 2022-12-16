
-- 외부에서 지정해줌 ! 
--ALTER TABLE 테이블명 
--ADD CONSTRAINTS 외래키 이름 FOREIGN KEY (참조컬럼) 
--REFERENCES 참조 테이블명(참조컬럼)

------------ 예시 ------------------------------  
--ALTER TABLE profileImg
--ADD CONSTRAINTS profileImg_FK FOREIGN KEY (userEmail) 
--REFERENCES userTable(userEmail);
-------------예시 ------------------------------
--ALTER TABLE profileImg 
--! profileImg 테이블을 바꾸겠다는 소리   
--ADD CONSTRAINTS profileImg_FK FOREIGN KEY (userEmail)
--! 제약조건을 건다는 뜻 // 그 제약조건의 이름은 profileImg_FK 이고 
--! //내용은 FOREIGN KEY로 만든다는 뜻 profileImg 테이블에 userEmail 컬럼을 
--REFERENCES userTable(userEmail);
--!  참조 하는데 userTable에 (userEmail)를(PK)


create SEQUENCE qna_sequence; -- qna 
create SEQUENCE qReply_sequence; -- qna 댓글 
create SEQUENCE companyPosting_sequence; 
-- 댓글 신고 시퀀스 
create SEQUENCE qnaReport_sequence;
create SEQUENCE qReplyReport_sequence;

drop table userTable;
drop table profileImg;
drop table qnaTable;
drop table qnaImg;
drop table qReply; 
drop table CompanyPostingTable ;
drop table CompanyPostingImg;
drop table companyUser ;
drop table qnaReport ;
drop table qReplyReport ; 

-- 사용자 테이블 
create table userTable(
   userEmail varchar2(50) not null primary key , -- 아이디겸 이메일 
   userPw varchar2(50) not null , -- 비밀번호 
   nickName varchar2(50) not null, -- 닉네임 
   birthday date not null, -- 생일 날짜를 받아둬야 몇살인지 알지 ~ 
   userGrade varchar2(10) default '1', -- 1은 일반유저 2는 구인공고 하는사람 3은 어드민  
   selfIntroduce varchar2(200) not null -- 간단한 자기소개 100자로 작성 하시오  
)


select * from userTable;
select count(*) from userTable where userEmail = '123@123';



-- 프로필 이미지 - 프사 
create table profileImg (
   userEmail varchar2(30) not null , -- 아이디겸 이메일 
   profileImg clob  -- 경로로 받을지 // 바이너리 파일로 받을지 몰라서 .. 그냥 이렇게 함 
)
ALTER TABLE profileImg
ADD CONSTRAINTS profileImg_FK FOREIGN KEY (userEmail) 
REFERENCES userTable(userEmail); --00

-------------------------------------QNA 이건 나중에 하는걸로 ! 
-- qna 테이블 질문 테이블 
drop table qnaTable ;
create table qnaTable( 
   qno number not null primary key , -- 작성 번호 
   qWriter varchar2(50) not null , -- 작성자 
   qtitle varchar2(50) not null ,  -- 제목 
   qcontent clob not null,  -- 질문 내용 
   qdate date default sysdate -- 작성일자 
)
select * from qnaTable;
-- qna 이미지 받는 테이블 
drop table qnaTable;
create table qnaImg (
qno number not null , -- 게시글 번호 
qnaImg clob  -- 게시글 이미지 
)
select * from qnaImg; --00

drop table qReply;
create table qReply (
	qReplyBno number not null primary key , -- 댓글 번호 
	qreWriter varchar2(20) not null , -- 작성자  
	qcontent clob not null , -- 댓글 내용 
	qno number not null ,-- qna 글 번호 
	qReDate date default sysdate -- 작성시간 
)
select * from qReply; --00 

-- qnaImg 제약조건 ! 
ALTER TABLE qnaImg 
ADD CONSTRAINTS qnaImg_FK FOREIGN KEY (qno) 
REFERENCES qnaTable(qno);

-- qReply 제약조건 ! 
ALTER TABLE qReply
ADD CONSTRAINTS qReply_FK FOREIGN KEY (qno) 
REFERENCES qnaTable(qno); --00 


--Q&A글 신고 
drop table qnaReport;
create table qnaReport(
	qnaReportNo number primary key , -- qna 신고 번호 
	qno number not null , -- fk 걸꺼임 qna 번호 
	reportWriter varchar2(20) not null ,-- 신고한사람 -- 이메일 세션에서 꺼내올거임,  
	qnaReportContent clob not null -- 신고내용
)
select * from qnaReport; --00 

alter table qnaReport
ADD CONSTRAINTS qnaReport_FK FOREIGN KEY (qno) 
REFERENCES qnaTable(qno); --00 

--Q&A 댓글 신고  
create table qReplyReport(
	qReReno number primary key , -- 작성자 qna 댓글 신고 번호 
	qReReportWriter varchar2(20) not null ,-- 댓글 신고자 
	qReplyBno number not null , -- 댓글 번호 fk
	qReWriter varchar2(20) not null , -- 댓글 작성자 !
	qReContent clob not null -- 신고 내용 
) --00
--qReplyReport FK 제약조건
alter table qReplyReport
ADD CONSTRAINTS qReplyReport_FK FOREIGN KEY (qReplyBno) 
REFERENCES qReply(qReplyBno); --00 

alter table qReplyReport drop CONSTRAINTS qReplyReport_FK;


-- 사업자 회원 가입 
create table companyUser (
BusinessNumber varchar2(50) primary key not null, -- 사업자 번호 
companyEmail varchar2(50) not null,	-- 회사 이메일 // 로그인
companyPwd varchar2(50) not null,  -- 회사 비밀번호 
companyName varchar2(50) not null , -- 회사이름 
userGrade varchar2(10) default '2' -- 2번은 회사 계정 
)
select * from companyUser; -- 00
 
-- 구인공고 ! 
create table CompanyPostingTable(
	cno number primary key not null , -- posting 번호 
	cTitle  varchar2(50) not null ,  -- 제목 
	cWriter varchar2(50) not null ,-- 구인공고 작성자
	cContent clob not null,  -- 구인공고 내용 
	cDate date default sysdate not null ,-- 작성 날짜 
	cDueDate date not null ,-- 마감 날짜 
	cAddress varchar2(50) not null  -- 회사 주소 
)
select * from CompanyPostingTable; --00 
create sequence CompanyPostingTable_sequence;

insert into CompanyPostingTable values (1,'1번구인공고','작성자1','첫번째구인공고입니다.',sysdate,'2022-12-31','서울시');

-- 구인공고 이미지 
create table CompanyPostingImg (
	 cno number not null, -- fk 걸꺼임 
	 companyImg clob not null  -- 회사 사진 
)
select * from CompanyPostingImg ; --00 

-----------------------------------------------------------------------------
create sequence BoastTable_sequence;
create sequence BoastReport_sequence;
create sequence BoastReply_sequence;  


-- 공부 자랑 글 테이블 
create table BoastTable(
   
   bNoSP NUMBER PRIMARY KEY,--글번호 시퀀스
   bTitle VARCHAR2(100) NOT NULL,--글제목
   bWriter VARCHAR2(30) NOT NULL,--글작성자 -usertable의 userEmail과 같은 값
   bContent CLOB NOT NULL,--글내용 / 이미지는 BoastImg이미지테이블참조
   bDate DATE default sysdate NOT NULL--글작성일자
   );   
   
create TABLE BoastReport(
   bReportNoS NUMBER NOT NULL,--신고테이블글번호-sequence
   bReportNoF NUMBER NOT NULL,--게시판글번호-foreign
   bWriter VARCHAR2(30) NOT NULL,--BoastTable글작성자
   bReporter VARCHAR2(30) NOT NULL,--BoastReport테이블의 신고자
   bReportContent CLOB NOT NULL--신고테이블의 신고내용

);
   
ALTER TABLE BoastReport
ADD CONSTRAINTS bReport_FK FOREIGN KEY (bReportNoF)--BoastTable의 bNoSP를 참조하는 foreign key bReportNoF
REFERENCES BoastTable(bNoSP);
      
-- 별점 
CREATE TABLE BoastStar(
   bStarNoF Number NOT NULL,-- BoastTable글번호-foreign
   bStar Number NOT NULL--별점 점수
)   

ALTER TABLE BoastStar
ADD CONSTRAINTS BoastStar_FK FOREIGN KEY (bStarNoF)--BoastStar 의 bStarNoF가 BoastTable의 bNoSP가 되어야 함
REFERENCES BoastTable(bNoSP);
   
-- 자랑글 이미지 
CREATE TABLE BoastImage(
   bImageNoF NUMBER NOT NULL,--BoastTable의 글번호-foreign
   bImage CLOB NOT NULL--이미지이름
   
)
   
ALTER TABLE BoastImage
ADD CONSTRAINTS BoastImg_FK FOREIGN KEY (bImageNoF)--BoastImage의 bNoSP가 foreign키 
REFERENCES BoastTable(bNoSP);
   

create TABLE BoastReply (

   bReplyNoSP NUMBER primary key , -- 댓글테이블 글번호
   bReplyNoF NUMBER NOT NULL, -- boast테이블 글번호 -BoastTable의 Primarykey를 참조하는 foreignkey 
   bReplyWriter VARCHAR2(30) NOT NULL, -- 댓글 작성자  
   bReplyContent CLOB NOT NULL, -- 댓글 내용 
   bReplyDate DATE default sysdate NOT NULL--댓글 작성일자
);

ALTER TABLE Reply
ADD CONSTRAINTS bReply_FK FOREIGN KEY (bReplyNoF)--BoastTable의 bNoSP를 참조하는 foreign key bReplyNoF
REFERENCES BoastTable(bNoSP);

create TABLE BoastReplyReport(
   bReplyReportNoS NUMBER NOT NULL,--댓글신고테이블의 글번호 -sequence
   bReplyReportNoF NUMBER NOT NULL,--댓글테이블의 글번호 -foreign
   bReplyNo NUMBER NOT NULL,--댓글번호
   bReplyWriter VARCHAR2(30) NOT NULL,--댓글작성자
   bReplyReportReporter VARCHAR2(30) NOT NULL,--댓글신고 작성자(신고자)
   bReplyReportContent CLOB NOT NULL--댓글신고사유
);
   
ALTER TABLE BoastReplyReport
ADD CONSTRAINTS bReplyReport_FK FOREIGN KEY (bReplyReportNoF)--BoastReply의 bReplyNoSP를 참조하는 foreign key bReplyReportNoF
REFERENCES BoastReply(bReplyNoSP);

--drop table BoastTable;
--drop table BoastReport;
--drop table BoastReply;
--drop table BoastReplyReport;
--drop table BoastStar;
--drop table BoastImage;












