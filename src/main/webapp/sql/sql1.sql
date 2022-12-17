select * from BOASTTABLE
update BoastTable set bWriter = 'jjy' where bNoSP=1
delete from BoastTable where bWriter = 'jjy'
COMMIT

ALTER table BoastImage RENAME COLUMN bImageSeq TO bImageSeq;

insert into BoastTable(bNoSP,bTitle,bContent,bDate,bWriter) values('1','A','A',sysdate,'yoonjjy@hanmail.net');
insert into userTable(userEmail,userPw,nickName,birthday,userGrade,selfIntroduce) values('yoonjjy@hanmail.net','tlvus20:5','gunit','19931022','1','friendinneedfriendindeed')
 userEmail varchar2(50) not null primary key , -- 아이디겸 이메일 
   userPw varchar2(50) not null , -- 비밀번호 
   nickName varchar2(50) not null, -- 닉네임 
   birthday date not null , -- 생일 날짜를 받아둬야 몇살인지 알지 ~ 
   userGrade varchar2(10) default '1', -- 1은 일반유저 2는 구인공고 하는사람 3은 어드민  
   selfIntroduce varchar2(200) not null -- 간단한 자기소개 100자로 작성 하시오  
