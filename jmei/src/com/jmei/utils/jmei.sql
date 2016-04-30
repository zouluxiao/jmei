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
	introduction varchar2(800),	--商品简介--
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

--插入国家表--
insert into country values(country_seq.nextval,'韩国','Korea.jpg');
insert into country values(country_seq.nextval,'美国','America.jpg');
insert into country values(country_seq.nextval,'日本','Japan.jpg');
insert into country values(country_seq.nextval,'中国','China.jpg');
commit;
select * from country

--插入类型表--
insert into Gtype values(type_seq.nextval,'面部护肤');
insert into Gtype values(type_seq.nextval,'彩妆');
insert into Gtype values(type_seq.nextval,'家居日用');
insert into Gtype values(type_seq.nextval,'男士护理');
insert into Gtype values(type_seq.nextval,'美容工具');
insert into Gtype values(type_seq.nextval,'妈妈专区');
insert into Gtype values(type_seq.nextval,'身体护理');
insert into Gtype values(type_seq.nextval,'女士套装');
insert into Gtype values(type_seq.nextval,'男士套装');
insert into Gtype values(type_seq.nextval,'保健类');
insert into Gtype values(type_seq.nextval,'配饰');
insert into Gtype values(type_seq.nextval,'瘦身类');
insert into Gtype values(type_seq.nextval,'食品类');
insert into Gtype values(type_seq.nextval,'时尚饰品');
insert into Gtype values(type_seq.nextval,'喂养用品');
insert into Gtype values(type_seq.nextval,'运动');
commit;
select * from Gtype;

--插入功效表--
insert into effect values(ef_seq.nextval,'保湿');
insert into effect values(ef_seq.nextval,'补水');
insert into effect values(ef_seq.nextval,'滋润');
insert into effect values(ef_seq.nextval,'清洁');
insert into effect values(ef_seq.nextval,'嫩肤');
insert into effect values(ef_seq.nextval,'去角质');
insert into effect values(ef_seq.nextval,'清爽');
insert into effect values(ef_seq.nextval,'紧致');
insert into effect values(ef_seq.nextval,'修护');
insert into effect values(ef_seq.nextval,'舒缓');
insert into effect values(ef_seq.nextval,'温和');
insert into effect values(ef_seq.nextval,'改善肤质');
insert into effect values(ef_seq.nextval,'修护肌肤');
insert into effect values(ef_seq.nextval,'均匀肤色');
insert into effect values(ef_seq.nextval,'淡化黑色素');
insert into effect values(ef_seq.nextval,'美白');
insert into effect values(ef_seq.nextval,'控油');
insert into effect values(ef_seq.nextval,'收敛毛孔');
insert into effect values(ef_seq.nextval,'持久');
commit;
select * from effect

-- 插入商品表（PRODUCT）--
insert into product values(pro_seq.nextval,'面膜',0);
insert into product values(pro_seq.nextval,'口红',0);
insert into product values(pro_seq.nextval,'粉饼',0);
insert into product values(pro_seq.nextval,'眼霜',0);
insert into product values(pro_seq.nextval,'BB霜',0);
insert into product values(pro_seq.nextval,'香水',0);
insert into product values(pro_seq.nextval,'洗面奶',0);
insert into product values(pro_seq.nextval,'爽肤水',0);
insert into product values(pro_seq.nextval,'唇彩',0);
insert into product values(pro_seq.nextval,'防晒霜',0);
insert into product values(pro_seq.nextval,'乳液',0);
insert into product values(pro_seq.nextval,'眉笔',0);
insert into product values(pro_seq.nextval,'祛痘',0);
insert into product values(pro_seq.nextval,'洗发水',0);
insert into product values(pro_seq.nextval,'眼影',0);
insert into product values(pro_seq.nextval,'腮红',0);
select * from product;
commit;

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
--插入企业表--
insert into Buser values(bu_seq.nextval,'卡姿兰','kazilan.jpg',0,'123456','简介暂无','kazilan.jpg','kazilan.jpg',0,10000004);
insert into Buser values(bu_seq.nextval,'韩束','hansu.jpg',0,'123456','简介暂无','hansu.jpg','hansu.jpg',0,10000004);
commit;
insert into Buser values(bu_seq.nextval,'佰草集','baicaoji.jpg',0,'123456','简介暂无','baicaoji.jpg','baicaoji.jpg',0,10000004);
insert into Buser values(bu_seq.nextval,'御泥坊','yunifang.jpg',0,'123456','简介暂无','yunifang.jpg','yunifang.jpg',0,10000004);
commit;
select * from Buser


--插入商品表--
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
insert into Goods values(goods_seq.nextval,10000001,10000001,100,99.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','卡姿兰玻尿酸面膜两件装');
insert into Goods values(goods_seq.nextval,10000001,10000002,100,99.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','卡姿兰口红');
insert into Goods values(goods_seq.nextval,10000001,10000003,100,199.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','卡姿兰粉饼');
insert into Goods values(goods_seq.nextval,10000001,10000004,100,299.00,0,0,'2016-04-30',' 蜗牛红参滚珠眼霜（2支装），重磅来袭！用事实告诉你，“脂肪粒”和“营养吸收”真的不冲突！无菌滚珠直接接触眼周肌肤，避免给脆弱的眼周肌肤带来伤害！紧致眼周肌肤；摆脱眼袋；防止脂肪粒；告别黑眼圈！修复保湿、淡化眼纹、紧致眼部肌肤、去黑眼圈。 ','卡姿兰眼霜');
commit;
insert into Goods values(goods_seq.nextval,10000002,10000005,100,23.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','韩束BB霜面膜两件装');
insert into Goods values(goods_seq.nextval,10000002,10000006,100,44.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','韩束香水');
insert into Goods values(goods_seq.nextval,10000002,10000007,100,89.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','韩束洗面奶');
insert into Goods values(goods_seq.nextval,10000002,10000008,100,129.00,0,0,'2016-04-30',' 蜗牛红参滚珠眼霜（2支装），重磅来袭！用事实告诉你，“脂肪粒”和“营养吸收”真的不冲突！无菌滚珠直接接触眼周肌肤，避免给脆弱的眼周肌肤带来伤害！紧致眼周肌肤；摆脱眼袋；防止脂肪粒；告别黑眼圈！修复保湿、淡化眼纹、紧致眼部肌肤、去黑眼圈。 ','韩束爽肤水');

insert into Goods values(goods_seq.nextval,10000003,10000009,100,55.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','卡姿兰玻尿酸面膜两件装');
insert into Goods values(goods_seq.nextval,10000003,10000010,100,44.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','卡姿兰口红');
insert into Goods values(goods_seq.nextval,10000003,10000011,100,990.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','卡姿兰粉饼');
insert into Goods values(goods_seq.nextval,10000003,10000012,100,1234.00,0,0,'2016-04-30',' 蜗牛红参滚珠眼霜（2支装），重磅来袭！用事实告诉你，“脂肪粒”和“营养吸收”真的不冲突！无菌滚珠直接接触眼周肌肤，避免给脆弱的眼周肌肤带来伤害！紧致眼周肌肤；摆脱眼袋；防止脂肪粒；告别黑眼圈！修复保湿、淡化眼纹、紧致眼部肌肤、去黑眼圈。 ','卡姿兰眼霜');

insert into Goods values(goods_seq.nextval,10000004,10000013,100,87.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','卡姿兰玻尿酸面膜两件装');
insert into Goods values(goods_seq.nextval,10000004,10000014,100,987.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','卡姿兰口红');
insert into Goods values(goods_seq.nextval,10000004,10000015,100,1.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','卡姿兰粉饼');
insert into Goods values(goods_seq.nextval,10000004,10000016,100,9.00,0,0,'2016-04-30',' 蜗牛红参滚珠眼霜（2支装），重磅来袭！用事实告诉你，“脂肪粒”和“营养吸收”真的不冲突！无菌滚珠直接接触眼周肌肤，避免给脆弱的眼周肌肤带来伤害！紧致眼周肌肤；摆脱眼袋；防止脂肪粒；告别黑眼圈！修复保湿、淡化眼纹、紧致眼部肌肤、去黑眼圈。 ','卡姿兰眼霜');

insert into Goods values(goods_seq.nextval,10000002,10000005,100,23.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','韩束BB霜面膜两件装');
insert into Goods values(goods_seq.nextval,10000002,10000006,100,44.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','韩束香水');
insert into Goods values(goods_seq.nextval,10000002,10000007,100,89.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','韩束洗面奶');
insert into Goods values(goods_seq.nextval,10000002,10000008,100,129.00,0,0,'2016-04-30',' 蜗牛红参滚珠眼霜（2支装），重磅来袭！用事实告诉你，“脂肪粒”和“营养吸收”真的不冲突！无菌滚珠直接接触眼周肌肤，避免给脆弱的眼周肌肤带来伤害！紧致眼周肌肤；摆脱眼袋；防止脂肪粒；告别黑眼圈！修复保湿、淡化眼纹、紧致眼部肌肤、去黑眼圈。 ','韩束爽肤水');

insert into Goods values(goods_seq.nextval,10000003,10000009,100,55.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','卡姿兰玻尿酸面膜两件装');
insert into Goods values(goods_seq.nextval,10000003,10000010,100,44.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','卡姿兰口红');
insert into Goods values(goods_seq.nextval,10000003,10000011,100,990.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','卡姿兰粉饼');
insert into Goods values(goods_seq.nextval,10000003,10000012,100,1234.00,0,0,'2016-04-30',' 蜗牛红参滚珠眼霜（2支装），重磅来袭！用事实告诉你，“脂肪粒”和“营养吸收”真的不冲突！无菌滚珠直接接触眼周肌肤，避免给脆弱的眼周肌肤带来伤害！紧致眼周肌肤；摆脱眼袋；防止脂肪粒；告别黑眼圈！修复保湿、淡化眼纹、紧致眼部肌肤、去黑眼圈。 ','卡姿兰眼霜');

insert into Goods values(goods_seq.nextval,10000004,10000013,100,87.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','卡姿兰玻尿酸面膜两件装');
insert into Goods values(goods_seq.nextval,10000004,10000014,100,987.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','卡姿兰口红');
insert into Goods values(goods_seq.nextval,10000004,10000015,100,1.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','卡姿兰粉饼');
insert into Goods values(goods_seq.nextval,10000004,10000016,100,9.00,0,0,'2016-04-30',' 蜗牛红参滚珠眼霜（2支装），重磅来袭！用事实告诉你，“脂肪粒”和“营养吸收”真的不冲突！无菌滚珠直接接触眼周肌肤，避免给脆弱的眼周肌肤带来伤害！紧致眼周肌肤；摆脱眼袋；防止脂肪粒；告别黑眼圈！修复保湿、淡化眼纹、紧致眼部肌肤、去黑眼圈。 ','卡姿兰眼霜');insert into Goods values(goods_seq.nextval,10000002,10000005,100,23.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','韩束BB霜面膜两件装');
insert into Goods values(goods_seq.nextval,10000002,10000006,100,44.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','韩束香水');
insert into Goods values(goods_seq.nextval,10000002,10000007,100,89.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','韩束洗面奶');
insert into Goods values(goods_seq.nextval,10000002,10000008,100,129.00,0,0,'2016-04-30',' 蜗牛红参滚珠眼霜（2支装），重磅来袭！用事实告诉你，“脂肪粒”和“营养吸收”真的不冲突！无菌滚珠直接接触眼周肌肤，避免给脆弱的眼周肌肤带来伤害！紧致眼周肌肤；摆脱眼袋；防止脂肪粒；告别黑眼圈！修复保湿、淡化眼纹、紧致眼部肌肤、去黑眼圈。 ','韩束爽肤水');

insert into Goods values(goods_seq.nextval,10000003,10000009,100,55.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','卡姿兰玻尿酸面膜两件装');
insert into Goods values(goods_seq.nextval,10000003,10000010,100,44.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','卡姿兰口红');
insert into Goods values(goods_seq.nextval,10000003,10000011,100,990.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','卡姿兰粉饼');
insert into Goods values(goods_seq.nextval,10000003,10000012,100,1234.00,0,0,'2016-04-30',' 蜗牛红参滚珠眼霜（2支装），重磅来袭！用事实告诉你，“脂肪粒”和“营养吸收”真的不冲突！无菌滚珠直接接触眼周肌肤，避免给脆弱的眼周肌肤带来伤害！紧致眼周肌肤；摆脱眼袋；防止脂肪粒；告别黑眼圈！修复保湿、淡化眼纹、紧致眼部肌肤、去黑眼圈。 ','卡姿兰眼霜');

insert into Goods values(goods_seq.nextval,10000004,10000013,100,87.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','卡姿兰玻尿酸面膜两件装');
insert into Goods values(goods_seq.nextval,10000004,10000014,100,987.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','卡姿兰口红');
insert into Goods values(goods_seq.nextval,10000004,10000015,100,1.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','卡姿兰粉饼');
insert into Goods values(goods_seq.nextval,10000004,10000016,100,9.00,0,0,'2016-04-30',' 蜗牛红参滚珠眼霜（2支装），重磅来袭！用事实告诉你，“脂肪粒”和“营养吸收”真的不冲突！无菌滚珠直接接触眼周肌肤，避免给脆弱的眼周肌肤带来伤害！紧致眼周肌肤；摆脱眼袋；防止脂肪粒；告别黑眼圈！修复保湿、淡化眼纹、紧致眼部肌肤、去黑眼圈。 ','卡姿兰眼霜');
insert into Goods values(goods_seq.nextval,10000002,10000005,100,23.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','韩束BB霜面膜两件装');
insert into Goods values(goods_seq.nextval,10000002,10000006,100,44.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','韩束香水');
insert into Goods values(goods_seq.nextval,10000002,10000007,100,89.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','韩束洗面奶');
insert into Goods values(goods_seq.nextval,10000002,10000008,100,129.00,0,0,'2016-04-30',' 蜗牛红参滚珠眼霜（2支装），重磅来袭！用事实告诉你，“脂肪粒”和“营养吸收”真的不冲突！无菌滚珠直接接触眼周肌肤，避免给脆弱的眼周肌肤带来伤害！紧致眼周肌肤；摆脱眼袋；防止脂肪粒；告别黑眼圈！修复保湿、淡化眼纹、紧致眼部肌肤、去黑眼圈。 ','韩束爽肤水');

insert into Goods values(goods_seq.nextval,10000003,10000009,100,55.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','卡姿兰玻尿酸面膜两件装');
insert into Goods values(goods_seq.nextval,10000003,10000010,100,44.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','卡姿兰口红');
insert into Goods values(goods_seq.nextval,10000003,10000011,100,990.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','卡姿兰粉饼');
insert into Goods values(goods_seq.nextval,10000003,10000012,100,1234.00,0,0,'2016-04-30',' 蜗牛红参滚珠眼霜（2支装），重磅来袭！用事实告诉你，“脂肪粒”和“营养吸收”真的不冲突！无菌滚珠直接接触眼周肌肤，避免给脆弱的眼周肌肤带来伤害！紧致眼周肌肤；摆脱眼袋；防止脂肪粒；告别黑眼圈！修复保湿、淡化眼纹、紧致眼部肌肤、去黑眼圈。 ','卡姿兰眼霜');

insert into Goods values(goods_seq.nextval,10000004,10000013,100,87.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','卡姿兰玻尿酸面膜两件装');
insert into Goods values(goods_seq.nextval,10000004,10000014,100,987.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','卡姿兰口红');
insert into Goods values(goods_seq.nextval,10000004,10000015,100,1.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','卡姿兰粉饼');
insert into Goods values(goods_seq.nextval,10000004,10000016,100,9.00,0,0,'2016-04-30',' 蜗牛红参滚珠眼霜（2支装），重磅来袭！用事实告诉你，“脂肪粒”和“营养吸收”真的不冲突！无菌滚珠直接接触眼周肌肤，避免给脆弱的眼周肌肤带来伤害！紧致眼周肌肤；摆脱眼袋；防止脂肪粒；告别黑眼圈！修复保湿、淡化眼纹、紧致眼部肌肤、去黑眼圈。 ','卡姿兰眼霜');insert into Goods values(goods_seq.nextval,10000002,10000005,100,23.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','韩束BB霜面膜两件装');
insert into Goods values(goods_seq.nextval,10000002,10000006,100,44.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','韩束香水');
insert into Goods values(goods_seq.nextval,10000002,10000007,100,89.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','韩束洗面奶');
insert into Goods values(goods_seq.nextval,10000002,10000008,100,129.00,0,0,'2016-04-30',' 蜗牛红参滚珠眼霜（2支装），重磅来袭！用事实告诉你，“脂肪粒”和“营养吸收”真的不冲突！无菌滚珠直接接触眼周肌肤，避免给脆弱的眼周肌肤带来伤害！紧致眼周肌肤；摆脱眼袋；防止脂肪粒；告别黑眼圈！修复保湿、淡化眼纹、紧致眼部肌肤、去黑眼圈。 ','韩束爽肤水');

insert into Goods values(goods_seq.nextval,10000003,10000009,100,55.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','卡姿兰玻尿酸面膜两件装');
insert into Goods values(goods_seq.nextval,10000003,10000010,100,44.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','卡姿兰口红');
insert into Goods values(goods_seq.nextval,10000003,10000011,100,990.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','卡姿兰粉饼');
insert into Goods values(goods_seq.nextval,10000003,10000012,100,1234.00,0,0,'2016-04-30',' 蜗牛红参滚珠眼霜（2支装），重磅来袭！用事实告诉你，“脂肪粒”和“营养吸收”真的不冲突！无菌滚珠直接接触眼周肌肤，避免给脆弱的眼周肌肤带来伤害！紧致眼周肌肤；摆脱眼袋；防止脂肪粒；告别黑眼圈！修复保湿、淡化眼纹、紧致眼部肌肤、去黑眼圈。 ','卡姿兰眼霜');

insert into Goods values(goods_seq.nextval,10000004,10000013,100,87.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','卡姿兰玻尿酸面膜两件装');
insert into Goods values(goods_seq.nextval,10000004,10000014,100,987.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','卡姿兰口红');
insert into Goods values(goods_seq.nextval,10000004,10000015,100,1.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','卡姿兰粉饼');
insert into Goods values(goods_seq.nextval,10000004,10000016,100,9.00,0,0,'2016-04-30',' 蜗牛红参滚珠眼霜（2支装），重磅来袭！用事实告诉你，“脂肪粒”和“营养吸收”真的不冲突！无菌滚珠直接接触眼周肌肤，避免给脆弱的眼周肌肤带来伤害！紧致眼周肌肤；摆脱眼袋；防止脂肪粒；告别黑眼圈！修复保湿、淡化眼纹、紧致眼部肌肤、去黑眼圈。 ','卡姿兰眼霜');insert into Goods values(goods_seq.nextval,10000002,10000005,100,23.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','韩束BB霜面膜两件装');
insert into Goods values(goods_seq.nextval,10000002,10000006,100,44.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','韩束香水');
insert into Goods values(goods_seq.nextval,10000002,10000007,100,89.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','韩束洗面奶');
insert into Goods values(goods_seq.nextval,10000002,10000008,100,129.00,0,0,'2016-04-30',' 蜗牛红参滚珠眼霜（2支装），重磅来袭！用事实告诉你，“脂肪粒”和“营养吸收”真的不冲突！无菌滚珠直接接触眼周肌肤，避免给脆弱的眼周肌肤带来伤害！紧致眼周肌肤；摆脱眼袋；防止脂肪粒；告别黑眼圈！修复保湿、淡化眼纹、紧致眼部肌肤、去黑眼圈。 ','韩束爽肤水');

insert into Goods values(goods_seq.nextval,10000003,10000009,100,55.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','卡姿兰玻尿酸面膜两件装');
insert into Goods values(goods_seq.nextval,10000003,10000010,100,44.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','卡姿兰口红');
insert into Goods values(goods_seq.nextval,10000003,10000011,100,990.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','卡姿兰粉饼');
insert into Goods values(goods_seq.nextval,10000003,10000012,100,1234.00,0,0,'2016-04-30',' 蜗牛红参滚珠眼霜（2支装），重磅来袭！用事实告诉你，“脂肪粒”和“营养吸收”真的不冲突！无菌滚珠直接接触眼周肌肤，避免给脆弱的眼周肌肤带来伤害！紧致眼周肌肤；摆脱眼袋；防止脂肪粒；告别黑眼圈！修复保湿、淡化眼纹、紧致眼部肌肤、去黑眼圈。 ','卡姿兰眼霜');

insert into Goods values(goods_seq.nextval,10000004,10000013,100,87.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','卡姿兰玻尿酸面膜两件装');
insert into Goods values(goods_seq.nextval,10000004,10000014,100,987.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','卡姿兰口红');
insert into Goods values(goods_seq.nextval,10000004,10000015,100,1.00,0,0,'2016-04-30','想要肌肤能够迅速补水达到非凡保湿效果吗？韩束(KanS)玻尿酸面膜两件装(23ml*5片)*2，蕴含丰富玻尿酸，具有良好的亲肤性和保水性，快速透润角质层，深入滋润干燥肌肤，充足补水，在肌肤表面形成水分子保湿隐形网，持续锁水达到肌肤保湿平衡。','卡姿兰粉饼');

insert into Goods values(goods_seq.nextval,10000004,10000016,100,9.00,0,0,'2016-04-30',' 蜗牛红参滚珠眼霜（2支装），重磅来袭！用事实告诉你，“脂肪粒”和“营养吸收”真的不冲突！无菌滚珠直接接触眼周肌肤，避免给脆弱的眼周肌肤带来伤害！紧致眼周肌肤；摆脱眼袋；防止脂肪粒；告别黑眼圈！修复保湿、淡化眼纹、紧致眼部肌肤、去黑眼圈。 ','卡姿兰眼霜');
commit;
select * from Goods

--插入商品图片表--
/*
	picid number(20) primary key,		--编号--
	picname varchar2(20),				--商品图片名--					
	gid number(20),						--商品库存编号--
	flag number                         --商品图片的类型 0 代表小型图片，1代表中等图片，2代表中偏图片， 3代表大型图片--
*/
select * from pic
insert into pic values(pic_seq.nextval,'10000002.jpg',10000002,2);
insert into pic values(pic_seq.nextval,'10000003.jpg',10000003,2);
insert into pic values(pic_seq.nextval,'10000004.jpg',10000004,2);
insert into pic values(pic_seq.nextval,'10000005.jpg',10000005,2);
insert into pic values(pic_seq.nextval,'10000006.jpg',10000006,2);
insert into pic values(pic_seq.nextval,'10000007.jpg',10000007,2);
insert into pic values(pic_seq.nextval,'10000008.jpg',10000008,2);
insert into pic values(pic_seq.nextval,'10000009.jpg',10000009,2);
insert into pic values(pic_seq.nextval,'10000010.jpg',10000010,2);
insert into pic values(pic_seq.nextval,'10000011.jpg',10000011,2);
insert into pic values(pic_seq.nextval,'10000012.jpg',10000012,2);
insert into pic values(pic_seq.nextval,'10000013.jpg',10000013,2);
insert into pic values(pic_seq.nextval,'10000014.jpg',10000014,2);
insert into pic values(pic_seq.nextval,'10000015.jpg',10000015,2);
insert into pic values(pic_seq.nextval,'10000016.jpg',10000016,2);
insert into pic values(pic_seq.nextval,'10000017.jpg',10000017,2);
insert into pic values(pic_seq.nextval,'10000018.jpg',10000018,2);
insert into pic values(pic_seq.nextval,'10000019.jpg',10000019,2);
insert into pic values(pic_seq.nextval,'10000020.jpg',10000020,2);
insert into pic values(pic_seq.nextval,'10000021.jpg',10000021,2);
insert into pic values(pic_seq.nextval,'10000022.jpg',10000022,2);
commit;

