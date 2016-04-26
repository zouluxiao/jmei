
SELECT * FROM COLLECTIONTOBUSER COL,JUSER JU,BUSER BU,COUNTRY COU WHERE COL.JID=JU.JID AND COL.BID=BU.BID AND  COU.COUNTRYID=BU.COUNTRYID  AND JU.JID=10000020;
SELECT COL.CID,JU.JID,JU.JNAME,JU.JPWD,JU.JEMAIL,JU.JTEL,JU.JGENDER,JU.JBIR,JU.JUSERISVAL,JU.JPIC,BU.BID,BU.BNAME,BU.BLOGO,BU.B_ISVAL,BU.BPWD,BU.BINTRODUCTION,BU.BPIC,BU.BMPIC,BU.COL_VAL,BU.COUNTRYID,COU.COUNTRYID,COU.COUNTRY,COU.CPIC
 FROM COLLECTIONTOBUSER COL,JUSER JU,BUSER BU,COUNTRY COU  
WHERE COL.JID=JU.JID AND COL.BID=BU.BID AND JU.JID=10000020 AND  COU.COUNTRYID=BU.COUNTRYID ;
SELECT * FROM JUSER;
SELECT * FROM COUNTRY;
/*
Buser表里面的COUNTRYID与Country表的COUNTRYID不一制所以没查出数据
*/
SELECT * FROM BUSER;
select * from juser;
select * from goods;
select * from Address;
SELECT * FROM COLLECTIONTOBUSER;
insert into COLLECTIONTOBUSER values(cob_seq.nextVal,10000020,10000001);
insert into COLLECTIONTOBUSER values(cob_seq.nextVal,10000001,10000020);
DELETE FROM COLLRCTIONTOBUSER WHERE JID=10000001;
insert into buser values()
select * from country;
INSERT INTO COLLRCTIONTOBUSER VALUES();
//10000003 10000001
select * from product;
insert into 
insert into COLLECTIONTOGOODS values(cog_seq.nextVal,10002,10202);
select * from COLLECTIONTOGOODS;
select * from COLLECTIONTOBUSER;
SELECT CBID,JU.JID,JU.JNAME,JU.JPWD,JU.JEMAIL,
JU.JTEL,JU.JGENDER,JU.JBIR,JU.JUSERISVAL,JU.JPIC,GO.GID,
				BU.BID,BU.BNAME,BU.BLOGO,BU.B_ISVAL,BU.BPWD,BU.BINTRODUCTION,BU.BPIC,BU.BMPIC,BU.COL_VAL,
				COU.COUNTRYID,COU.COUNTRY,COU.CPIC,PR.PID,PR.PNAME,PR.P_ISVAL,
				GO.BNUMBER,GO.PRI,GO.SALE_VAL,GO.COL_VAL,GO.UPTIME,GO.INTRODUCTION,GO.DETAILNAME 
				FROM COLLECTIONTOGOODS COL,JUSER JU,GOODS GO,BUSER BU,PRODUCT PR,COUNTRY COU 
				WHERE COL.JID=JU.JID AND COL.GID=GO.GID AND GO.BID=BU.BID AND GO.PID=PR.PID AND COU.COUNTRYID=BU.COUNTRYID AND JU.JID=10000020;

10000020
SELECT
OR.ORID,GO.GID,BU.BID,BU.BNAME,BU.BLOGO,BU.B_ISVAL,BU.BPWD,BU.BINTRODUCTION,BU.BPIC,BU.BMPIC,BU.COL_VAL,
				COU.COUNTRYID,COU.COUNTRY,COU.CPIC,
				PR.PID,PR.PNAME,PR.P_ISVAL,
				GO.BNUMBER,GO.PRI,GO.SALE_VAL,GO.COL_VAL,GO.UPTIME,GO.INTRODUCTION,GO.DETAILNAME,
				JU.JID,JU.JNAME,JU.JPWD,JU.JEMAIL,JU.JTEL,JU.JGENDER,JU.JBIR,JU.JUSERISVAL,JU.JPIC,
				AD.AID,AD.ADDRESS,AD.CONSIGNEENAME,AD.CONSIGNEEID,AD.DETAILADDRESS,AD.TEL,AD.PNUMBER,
				OR.JIS_VAL,OR.ONUMBER 

				FROM JORDER OR,GOODS GO,JUSER JU,ADDRESS AD,BUSER BU,COUNTRY COU,PRODUCT PR 
				WHERE OR.GID=GO.GID AND OR.JID=JU.JID AND OR.AID=AD.AID AND 
				GO.BID=BU.BID AND BU.COUNTRYID=COU.COUNTRYID AND GO.PID=PR.PID AND AD.JID=JU.JID AND JU.JID=10000020;

o --rid number(20) primary key,  --编号--
	---gid number(20),				--商品编号--10000001
	--jid number(20),				--普通用户id--10000020
	--aid number(20),				--地址id--10000001
	--jis_val number(2),			--订单状态--
	--onumber number				--订单数量商品数量--
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
countryid number(20) primary key,		--编号--
	country varchar2(20),					--国家名--					
	cpic varchar2(20)						--国家图片--
pid number(20) primary key,  	--编号--
	pname varchar2(20),    			--商品名--
	p_isVal number (2)				--是否删除--
jid number(20) primary key,  --编号--
	jname varchar2(50),			--用户名--
	jpwd varchar2(20),			--用户密码--
	jemail varchar2(20),		--用户邮箱--
	jtel varchar2(20),			--用户电话号码--
	jgender number(2),			--用户性别--
	jbir varchar2(20),			--用户生日--
	juserisval number(2),		--是否删除--
	jpic varchar2(20)			--用户头像--
aid number(20) primary key,  --编号--
	jid number(20),				--普通用户名--10000020
	address varchar2(100),		--地址--
	consigneename varchar2(50),	--收货人姓名--
	consigneeid varchar2(20),	--收货人身份证号码--
	detailaddress varchar2(100),--详细地址--
	tel varchar2(20),			--电话号码--
	pnumber varchar2(20)		--固定号码--
 or.orid,or.jis_val,or.onumber,
	go.gid,go.bnumber,go.pri,go.sale_val,go.col_val,go.uptime,go.introduction,go.detailname,
				bu.bid,bu.bname,bu.blogo,bu.B_isVal,bu.bpwd,bu.bintroduction,bu.bpic,bu.bmpic,bu.col_val,
				cou.countryid,cou.country,cou.cpic,
				pro.pid,pro.pname,pro.p_isVal,
				ju.jid,ju.jname,ju.jpwd,ju.jemail,ju.jtel,ju.jgender,ju.jbir,ju.juserisval,ju.jpic,
				ad.aid,ad.address,ad.consigneename,ad.consigneeid,ad.detailaddress,ad.tel,ad.pnumber
				
select
	or.orid,or.jis_val,or.onumber,
	go.gid,go.bnumber,go.pri,go.sale_val,go.col_val,go.uptime,go.introduction,go.detailname,
				bu.bid,bu.bname,bu.blogo,bu.B_isVal,bu.bpwd,bu.bintroduction,bu.bpic,bu.bmpic,bu.col_val,
				cou.countryid,cou.country,cou.cpic,
				pro.pid,pro.pname,pro.p_isVal,
				ju.jid,ju.jname,ju.jpwd,ju.jemail,ju.jtel,ju.jgender,ju.jbir,ju.juserisval,ju.jpic,
				ad.aid,ad.address,ad.consigneename,ad.consigneeid,ad.detailaddress,ad.tel,ad.pnumber
		from jorder or,goods go,juser ju,address ad,buser bu,country cou,product pro where or.gid=go.gid and or.jid=ju.jid and or.aid=ad.aid and ad.jid=ju.jid and 
				go.bid=bu.bid and go.pid=pro.pid and bu.countryid=cou.countryid and ju.jid=10000020;				