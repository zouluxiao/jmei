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

--insert into buser values(bu_seq.nextVal,'卡姿兰','kazilanlogo.jpg','0','123456',
--'','kazilanpic.jpg','kazilanmiddle.jpg');
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

--insert into product values(pro_seq.nextVal,'面膜','0');	--"0"表示未删除;

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

--insert into goods values(goods.nextVal,'卡姿兰',''	
--7.商品图片表--
drop table pic;
create table pic(
	picid number(20) primary key,		--编号--
	picname varchar2(20),				--商品图片名--					
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
	gid number(20),				--商品编号--
	jid number(20),				--普通用户id--
	aid number(20),				--地址id--
	jis_val number(2),			--订单状态--
	onumber number				--订单数量商品数量--
);
	
--订单表的id的序列-
drop sequence order_seq;
create sequence order_seq start with 10000000 increment by 1;

--9.地址表--
drop table address;
create table address(
	aid number(20) primary key,  --编号--
	jid number(20),				--普通用户名--
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
select * from juser;
delete from juser where jtel='15364240309';
commit;
--普通用户表的id的序列--
drop sequence ju_seq;
create sequence ju_seq start with 10000000 increment by 1;

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


SELECT bid,bname,blogo,isVal,bpwd,bintroduction,bpic,bmpic,col_val,cou.countryid,cou.country,cou.cpic 
FROM country cou,BUSER bu where bu.countryid = cou.countryid

insert into country values(country_seq.nextval,'法国','France');
insert into country values(country_seq.nextval,'英国','England');
insert into country values(country_seq.nextval,'美国','America');
insert into country values(country_seq.nextval,'德国','Germany');

insert into Buser values(bu_seq.nextval,'卡姿兰','kazilan',0,123456,'简介暂时为空','mu','mu',0,10000001);
insert into Buser values(bu_seq.nextval,'欧莱雅','oulaiya',0,123456,'简介暂时为空','mu','mu',0,10000002);
insert into Buser values(bu_seq.nextval,'兰蔻','lankou',0,123456,'简介暂时为空','mu','mu',0,10000003);
insert into Buser values(bu_seq.nextval,'美宝莲','meibaolian',0,123456,'简介暂时为空','mu','mu',0,10000001);

insert into Product values(pro_seq.nextval,'粉饼',0);
insert into Product values(pro_seq.nextval,'唇膏',0);
insert into Product values(pro_seq.nextval,'口红',0);
insert into Product values(pro_seq.nextval,'香水',0);
select * from Goods
select *　from Buser
insert into Goods values(goods_seq.nextval,10000001,10000001,10,100.00,0,0,'20160502','k','kkkk');
insert into Goods values(goods_seq.nextval,10000002,10000001,10,100.00,0,0,'20160502','k','kkkk');
insert into Goods values(goods_seq.nextval,10000002,10000002,10,100.00,0,0,'20160502','k','kkkk');
insert into Goods values(goods_seq.nextval,10000002,10000003,10,100.00,0,0,'20160502','k','kkkk');

commit;
select * from product
select * from COUNTRY

/*
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
*/
SELECT GID,bnumber,pri,sale_val,col_val,uptime,introduction,detailname, FROM Goods

/*
	gid number(20),       --商品编号--
	eid number(20)		  --功效编号--
*/
SELECT * from GOODSTOEFFECT

/*
	acid number(20) primary key,  --编号--
	acpic varchar2(20),			--精选活动图片--
	bid number(20)				--企业id--
*/

/*
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
*/
insert into ACTIVITY values(activity_seq.nextval,'wu',10000001);
insert into ACTIVITY values(activity_seq.nextval,'wu',10000002);
insert into ACTIVITY values(activity_seq.nextval,'wu',10000001);
commit;
SELECT a.acid,a.acpic,b.bid,b.bname,b.blogo,b.B_isVal,b.bpwd,
b.bintroduction,b.bpic,b.bmpic,b.col_val,cou.countryid,cou.country,
cou.cpic
FROM ACTIVITY a,BUSER b,COUNTRY cou
WHERE a.bid = b.bid and b.countryid = cou.countryid
and a.acid=10000001



/*
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

	gid number(20),       --商品编号--
	eid number(20)		  --功效编号--
*/
insert into goodsToEffect values(10000001,10000001);
insert into goodsToEffect values(10000001,10000002);
commit;

insert into EFFECT VALUES(ef_seq.nextval,'功效1');
insert into EFFECT VALUES(ef_seq.nextval,'功效2');
insert into EFFECT VALUES(ef_seq.nextval,'功效3');
commit;
SELECT g.gid,g.eid,good.gid,good.bid,good.pid,good.bnumber,
good.pri,good.sale_val,good.col_val,good.uptime,good.introduction,
good.detailname,b.bid, b.bname, b.blogo, b.b_isval, 
b.bpwd, b.bintroduction, b.bpic, b.bmpic, b.col_val,
p.pid, p.pname, p.p_isval,c.countryid, c.country, c.cpic,
e.ename
FROM goodsToEffect g,GOODS good,BUSER b,PRODUCT p, country c,
Effect e
WHERE g.gid = good.gid and c.countryid = b.countryid and 
p.pid = good.pid and good.bid = b.bid and e.eid = g.eid
and g.gid = 10000001
commit;

SELECT g.gid,g.eid,good.gid,good.bid,good.pid,good.bnumber,
good.pri,good.sale_val,good.col_val,good.uptime,good.introduction,
good.detailname,b.bid, b.bname, b.blogo, b.b_isval,
b.bpwd, b.bintroduction, b.bpic, b.bmpic, b.col_val,
p.pid, p.pname, p.p_isval,c.countryid, c.country, c.cpic,e.ename 
FROM goodsToEffect g,GOODS good,BUSER b,PRODUCT p, country c,Effect e
WHERE g.gid = good.gid and c.countryid = b.countryid and 
p.pid = good.pid and good.bid = b.bid  and e.eid = g.eid
and g.gid = 10000001

SELECT　* FROM goodsToEffect
insert into goodsToEffect VALUES(10000002,10000001);
commit;
select * from Goods
SELECT * FROM GOODSTOEFFECT
SELECT　* FROM EFFECT

SELECT　* FROM GoodsToType
insert into gtype VALUES(type_seq.nextval,'类型1');
insert into gtype VALUES(type_seq.nextval,'类型2');
insert into gtype VALUES(type_seq.nextval,'类型3');
insert into gtype VALUES(type_seq.nextval,'类型4');
insert into gtype VALUES(type_seq.nextval,'类型5');
insert into gtype VALUES(type_seq.nextval,'类型6');
commit;
insert into GoodsToType VALUES(10000001,10000001);
insert into GoodsToType VALUES(10000001,10000002);
insert into GoodsToType VALUES(10000001,10000003);
insert into GoodsToType VALUES(10000002,10000001);
insert into GoodsToType VALUES(10000002,10000001);



SELECT g.gid,g.tid,good.gid,good.bid,good.pid,good.bnumber,
good.pri,good.sale_val,good.col_val,good.uptime,good.introduction,
good.detailname,b.bid, b.bname, b.blogo, b.b_isval,
b.bpwd, b.bintroduction, b.bpic, b.bmpic, b.col_val,
p.pid, p.pname, p.p_isval,c.countryid, c.country, c.cpic,e.tname 
FROM GoodsToType g,GOODS good,BUSER b,PRODUCT p, country c,gtype e
WHERE g.gid = good.gid and c.countryid = b.countryid and 
p.pid = good.pid and good.bid = b.bid  and e.tid = g.tid
and g.tid = 10000001


/*
	orid number(20) primary key,  --编号--
	gid number(20),				--商品编号--
	jid number(20),				--普通用户id--
	aid number(20),				--地址id--
	jis_val number(2),			--订单状态--
	onumber number				--订单数量商品数量--
*/

/*
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
*/
SELECT
j.orid,j.gid,j.jis_val,j.onumber,j.jid,j.aid,
g.gid,g.bid,g.pid,g.bnumber,g.pri,g.sale_val,g.col_val,
g.uptime,g.introduction,g.detailname,
a.aid,a.jid,a.address,a.consigneename,a.consigneeid,
a.tel,a.pnumber,a.detailaddress,
b.bid,b.bname,b.blogo,b.B_isVal,b.bpwd,b.bintroduction,
b.bpic,b.bmpic,b.col_val,b.countryid,
p.pid,p.pname,p.p_isVal,
ac.countryid,ac.country,ac.cpic,
ju.jid,ju.jname,ju.jpwd,ju.jemail,ju.jtel,ju.jgender,
ju.jbir,ju.juserisval,ju.jpic 
FROM jorder j,address a,goods g,buser b,product p,country ac,
juser ju
WHERE b.countryid = ac.countryid and g.bid = b.bid and g.pid=p.pid
 and j.jid = ju.jid and a.aid = j.aid and j.gid = g.gid
 and j.jid = 10000001


/*
	orid number(20) primary key,  --编号--
	gid number(20),				--商品编号--
	jid number(20),				--普通用户id--
	aid number(20),				--地址id--
	jis_val number(2),			--订单状态--
	onumber number				--订单数量商品数量--
*/
SELECT * FROM jorder

/*
	aid number(20) primary key,  --编号--
	jid number(20),				--普通用户名--
	address varchar2(100),		--地址--
	consigneename varchar2(50),	--收货人姓名--
	consigneeid varchar2(20),	--收货人身份证号码--
	detailaddress varchar2(100),--详细地址--
	tel varchar2(20),			--电话号码--
	pnumber varchar2(20)		--固定号码--
*/
insert into address VALUES(ad_seq.nextval,10000001,'地址1','汤亮','12322333232323','详细地址','1232213233','32323232');
insert into address VALUES(ad_seq.nextval,10000001,'地址2','王五','12322333232323','详细地址','1232213233','32323232');
insert into address VALUES(ad_seq.nextval,10000001,'地址3','赵六','12322333232323','详细地址','1232213233','32323232');
commit;

insert into juser VALUES(ju_seq.nextval,'zhangsan','123456','7766555@qq.com','323232323',0,'2323',0,'sfasdfa');
insert into juser VALUES(ju_seq.nextval,'王五','123456','7766555@qq.com','323232323',0,'2323',0,'sfasdfa');
insert into juser VALUES(ju_seq.nextval,'zhaoliu','123456','7766555@qq.com','323232323',0,'2323',0,'sfasdfa');
insert into juser VALUES(ju_seq.nextval,'xiaoxiaoxin8','123456','7766555@qq.com','323232323',0,'2323',0,'sfasdfa');
commit;

insert into jorder VALUES(order_seq.nextval,10000001,10000001,10000001,0,1);
insert into jorder VALUES(order_seq.nextval,10000002,10000002,10000002,0,1);
insert into jorder VALUES(order_seq.nextval,10000003,10000001,10000003,0,1);
insert into jorder VALUES(order_seq.nextval,10000004,10000003,10000004,0,1);
commit;

select * from activity;


