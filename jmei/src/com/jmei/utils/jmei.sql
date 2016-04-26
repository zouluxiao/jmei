select * from user_tables;
--1.企业用户表-- 
drop table buser;
create table buser(
	bid number(20) primary key,  		--编号--
	bname varchar2(50),    				--企业用户名--
	blogo varchar2(100),				--企业用户logo--
	B_isVal number (2),					--是否删除--
	bpwd varchar2(20),					--企业用户密码--
	bintroduction varchar2(200), 		--企业简介--
	bpic varchar2(100),					--企业图片--
	bmpic varchar2(100),				--中等图片--
	col_val number(10),                 --收藏量--
	countryid number(20)				--国家id--
);

--企业用户表的id的序列-
drop sequence bu_seq;
create sequence bu_seq start with 10000000 increment by 1;
insert into buser values(bu_seq.nextVal,'卡兹拉','kazilan.jsp',0,'123456',
'lalal','kazilanpic.jpg','kazilanmi.jpg',100,00000001);
insert into buser values(bu_seq.nextVal,'卡兹拉','kazilan.jsp',0,'123456',
'lalal','kazilanpic.jpg','kazilanmi.jpg',100,10000001);
--insert into buser values(bu_seq.nextVal,'卡姿兰','kazilanlogo.jpg','0','123456',
--'','kazilanpic.jpg','kazilanmiddle.jpg');
select * from buser;
--2.商品表--
drop table product;
create table product(
	pid number(20) primary key,  	--编号--
	pname varchar2(20),    			--商品名--
	p_isVal number (2)				--是否删除--
	);

--商品表的id的序列-
drop sequence pro_seq;
create sequence pro_seq start with 10000000 increment by 1;
select * from product;
insert into product values(pro_seq.nextVal,'面膜','0');	--"0"表示未删除;

--3.商品库存表--
drop table goods;
create table goods(
	gid number(20) primary key,  --编号--
	bid number(20),				--企业用户id--
	pid number(20),				--商品id--
	bnumber number,				--商品库存数量--
	pri number(20),				--商品价格--
	sale_val number,			--销量--
	col_val number,				--收藏数量--
	uptime varchar2(20),		--上架时间--
	introduction varchar2(200),	--商品简介--
	detailname varchar2(50) 	--详细名称--
	);
--商品库存表的id的序列-
drop sequence goods_seq;
create sequence goods_seq start with 10000000 increment by 1;
select * from goods;
insert into goods values(goods_seq.nextVal,10000020,10000001,2,100,20,24,'2015-11-23',null,null);
--4.商品的功效表--
drop table goodsToEffect;
create table goodsToEffect(
	gid number(20),       --商品编号--
	eid number(20)		  --功效编号--
);
--5.商品的类型表--
drop table goodsToType;
create table goodsToType(
	gid number(20),       --商品编号--
	tid number(20)		  --类型编号-
);


--6.国家表--
drop table country;
create table country(
	countryid number(20) primary key,		--编号--
	country varchar2(20),					--国家名--					
	cpic varchar2(20)						--国家图片--
);
--国家表的id的序列-
drop sequence country_seq;
create sequence country_seq start with 10000000 increment by 1;
insert into country values(country_seq.nextVal,'中国','country.jsp');

--insert into goods values(goods.nextVal,'卡姿兰',''	
--7.商品图片表--
drop table pic;
create table pic(
	picid number(20) primary key,		--编号--
	pname varchar2(20),					--商品名--					
	gid number(20),						--商品库存编号--
	flag number                         --商品图片的类型 0 代表小型图片，1代表中等图片，2代表中偏图片， 3代表大型图片--
);
--商品图片表的id的序列-
drop sequence pic_seq;
create sequence pic_seq start with 10000000 increment by 1;

--8.订单表--
drop table jorder;
create table jorder(
	orid number(20) primary key,  --编号--
	gid number(20),				--商品编号--10000001
	jid number(20),				--普通用户id--10000020
	aid number(20),				--地址id--10000001
	jis_val number(2),			--订单状态--
	onumber number				--订单数量商品数量--
	);
	
--订单表的id的序列-
drop sequence order_seq;
create sequence order_seq start with 10000000 increment by 1;
select * from goods;
select * from juser;
select * from address;
select * from jorder;
insert into jorder values(order_seq.nextVal,10000001,10000020,10000001,0,0);
--9.地址表--
drop table address;
create table address(
	aid number(20) primary key,  --编号--
	jid number(20),				--普通用户名--10000020
	address varchar2(100),		--地址--
	consigneename varchar2(50),	--收货人姓名--
	consigneeid varchar2(20),	--收货人身份证号码--
	detailaddress varchar2(100),--详细地址--
	tel varchar2(20),			--电话号码--
	pnumber varchar2(20)		--固定号码--
	);
	
--地址表的id的序列-
drop sequence ad_seq;
create sequence ad_seq start with 10000000 increment by 1;
insert into address values(ad_seq.nextVal,10000020,null,null,null,null,null,null);
select * from address;
--10.普通用户表--
drop table juser;
create table juser(
	jid number(20) primary key,  --编号--
	jname varchar2(50),			--用户名--
	jpwd varchar2(20),			--用户密码--
	jemail varchar2(20),		--用户邮箱--
	jtel varchar2(20),			--用户电话号码--
	jgender number(2),			--用户性别--
	jbir varchar2(20),			--用户生日--
	juserisval number(2),		--是否删除--
	jpic varchar2(20)			--用户头像--
);
--普通用户表的id的序列--
drop sequence ju_seq;
create sequence ju_seq start with 10000000 increment by 1;
insert into juser values(ju_seq.nextVal,'zoululala','123456','1207408431@qq.com','18075878071'
,0,'1996-03-09',0,'juser.png');
select * from juser;
--11.收藏商品表--
drop table collectionToGoods;
create table collectionToGoods(
	cbid number(20) primary key,  --编号--
	jid number(20),				--用户id--
	gid number(20)				--商品id--
	);	
	
--收藏商品表的id的序列--
drop sequence cog_seq;
create sequence cog_seq start with 10000000 increment by 1;
select * from collectionToGoods;
insert into collectionToGoods values(cog_seq.nextVal,10000020,10000001);
--12.收藏企业表--
drop table collectionToBuser;
create table collectionToBuser(
	cid number(20) primary key,  --编号--
	jid number(20),				--用户id--
	bid number(20)				--企业id--
	);
	
--收藏企业表的id的序列--
drop sequence cob_seq;
create sequence cob_seq start with 10000000 increment by 1;
insert into collectionToBuser values(cob_seq.nextVal,10000001,10000001);
SELECT * FROM collectionToBuser;
--13.管理员表--
drop table admin;
create table admin(
	adminid number(20) primary key,  --编号--
	adminpwd varchar2(20)			--管理员密码--
	);
--管理员表的id的序列-
drop sequence admin_seq;
create sequence admin_seq start with 10000000 increment by 1;
	
--14.功效表--
drop table effect;
create table effect(
	eid number(20) primary key,  --编号--
	ename varchar2(20)			--功效名--
	);
--功效表的id的序列--
drop sequence ef_seq;
create sequence ef_seq start with 10000000 increment by 1;
	
--15.类型表--
drop table gtype;
create table gtype(
	tid number(20) primary key,  --编号--
	tname varchar2(20)		--类型名--
);	

--类型表的id的序列--
drop sequence type_seq;
create sequence type_seq start with 10000000 increment by 1;

--16.今日疯抢表--
drop table  mad_rush;
create table mad_rush(
	madid number(20) primary key,  --编号--
	madpic varchar2(20),		--今日疯抢图片--
	bid number(20)				--企业id--
);	
--表的id的序列-
drop sequence mad_seq;
create sequence mad_seq start with 10000000 increment by 1;

--17.明日预告表--
drop table  foreshow;
create table foreshow(
	foreid number(20) primary key,  --编号--
	forepic varchar2(20),		--明日预告图片--
	bid number(20)				--企业id--
);	
--表的id的序列--
drop sequence fore_seq;
create sequence fore_seq start with 10000000 increment by 1;

--18.精选活动表--
drop table  activity;
create table activity(
	acid number(20) primary key,  --编号--
	acpic varchar2(20),			--精选活动图片--
	bid number(20)				--企业id--
);	
--表的id的序列--
drop sequence activity_seq;
create sequence activity_seq start with 10000000 increment by 1;


