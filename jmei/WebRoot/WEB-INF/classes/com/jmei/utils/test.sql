
SELECT * FROM COLLECTIONTOBUSER COL,JUSER JU,BUSER BU,COUNTRY COU WHERE COL.JID=JU.JID AND COL.BID=BU.BID AND  COU.COUNTRYID=BU.COUNTRYID  AND JU.JID=10000020;
SELECT COL.CID,JU.JID,JU.JNAME,JU.JPWD,JU.JEMAIL,JU.JTEL,JU.JGENDER,JU.JBIR,JU.JUSERISVAL,JU.JPIC,BU.BID,BU.BNAME,BU.BLOGO,BU.B_ISVAL,BU.BPWD,BU.BINTRODUCTION,BU.BPIC,BU.BMPIC,BU.COL_VAL,BU.COUNTRYID,COU.COUNTRYID,COU.COUNTRY,COU.CPIC
 FROM COLLECTIONTOBUSER COL,JUSER JU,BUSER BU,COUNTRY COU  
WHERE COL.JID=JU.JID AND COL.BID=BU.BID AND JU.JID=10000020 AND  COU.COUNTRYID=BU.COUNTRYID ;
SELECT * FROM JUSER;
SELECT * FROM COUNTRY;
/*
Buser�������COUNTRYID��Country���COUNTRYID��һ������û�������
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

o --rid number(20) primary key,  --���--
	---gid number(20),				--��Ʒ���--10000001
	--jid number(20),				--��ͨ�û�id--10000020
	--aid number(20),				--��ַid--10000001
	--jis_val number(2),			--����״̬--
	--onumber number				--����������Ʒ����--
gid number(20) primary key,  --���--
	bid number(20),				--��ҵ�û�id--
	pid number(20),				--��Ʒid--
	bnumber number,				--��Ʒ�������--
	pri number(20),				--��Ʒ�۸�--
	sale_val number,			--����--
	col_val number,				--�ղ�����--
	uptime varchar2(20),		--�ϼ�ʱ��--
	introduction varchar2(200),	--��Ʒ���--
	detailname varchar2(50) 	--��ϸ����--
	bid number(20) primary key,  		--���--
	bname varchar2(50),    				--��ҵ�û���--
	blogo varchar2(100),				--��ҵ�û�logo--
	B_isVal number (2),					--�Ƿ�ɾ��--
	bpwd varchar2(20),					--��ҵ�û�����--
	bintroduction varchar2(200), 		--��ҵ���--
	bpic varchar2(100),					--��ҵͼƬ--
	bmpic varchar2(100),				--�е�ͼƬ--
	col_val number(10),                 --�ղ���--
	countryid number(20)				--����id--
countryid number(20) primary key,		--���--
	country varchar2(20),					--������--					
	cpic varchar2(20)						--����ͼƬ--
pid number(20) primary key,  	--���--
	pname varchar2(20),    			--��Ʒ��--
	p_isVal number (2)				--�Ƿ�ɾ��--
jid number(20) primary key,  --���--
	jname varchar2(50),			--�û���--
	jpwd varchar2(20),			--�û�����--
	jemail varchar2(20),		--�û�����--
	jtel varchar2(20),			--�û��绰����--
	jgender number(2),			--�û��Ա�--
	jbir varchar2(20),			--�û�����--
	juserisval number(2),		--�Ƿ�ɾ��--
	jpic varchar2(20)			--�û�ͷ��--
aid number(20) primary key,  --���--
	jid number(20),				--��ͨ�û���--10000020
	address varchar2(100),		--��ַ--
	consigneename varchar2(50),	--�ջ�������--
	consigneeid varchar2(20),	--�ջ������֤����--
	detailaddress varchar2(100),--��ϸ��ַ--
	tel varchar2(20),			--�绰����--
	pnumber varchar2(20)		--�̶�����--
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