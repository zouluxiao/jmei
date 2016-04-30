--1.��ҵ�û���-- 
drop table buser;
create table buser(
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
);

--��ҵ�û����id������-
drop sequence bu_seq;
create sequence bu_seq start with 10000000 increment by 1;

--insert into buser values(bu_seq.nextVal,'������','kazilanlogo.jpg','0','123456',
--'','kazilanpic.jpg','kazilanmiddle.jpg');
--2.��Ʒ��--
drop table product;
create table product(
	pid number(20) primary key,  	--���--
	pname varchar2(20),    			--��Ʒ��--
	p_isVal number (2)				--�Ƿ�ɾ��--
	);

--��Ʒ���id������-
drop sequence pro_seq;
create sequence pro_seq start with 10000000 increment by 1;

--insert into product values(pro_seq.nextVal,'��Ĥ','0');	--"0"��ʾδɾ��;

--3.��Ʒ����--
drop table goods;
create table goods(
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
	);
--��Ʒ�����id������-
drop sequence goods_seq;
create sequence goods_seq start with 10000000 increment by 1;

--4.��Ʒ�Ĺ�Ч��--
drop table goodsToEffect;
create table goodsToEffect(
	gid number(20),       --��Ʒ���--
	eid number(20)		  --��Ч���--
);
--5.��Ʒ�����ͱ�--
drop table goodsToType;
create table goodsToType(
	gid number(20),       --��Ʒ���--
	tid number(20)		  --���ͱ��-
);


--6.���ұ�--
drop table country;
create table country(
	countryid number(20) primary key,		--���--
	country varchar2(20),					--������--					
	cpic varchar2(20)						--����ͼƬ--
);
--���ұ��id������-
drop sequence country_seq;
create sequence country_seq start with 10000000 increment by 1;

--insert into goods values(goods.nextVal,'������',''	
--7.��ƷͼƬ��--
drop table pic;
create table pic(
	picid number(20) primary key,		--���--
	picname varchar2(20),				--��ƷͼƬ��--					
	gid number(20),						--��Ʒ�����--
	flag number                         --��ƷͼƬ������ 0 ����С��ͼƬ��1�����е�ͼƬ��2������ƫͼƬ�� 3�������ͼƬ--
);
--��ƷͼƬ���id������-
drop sequence pic_seq;
create sequence pic_seq start with 10000000 increment by 1;

--8.������--
drop table jorder;
create table jorder(
	orid number(20) primary key,  --���--
	gid number(20),				--��Ʒ���--
	jid number(20),				--��ͨ�û�id--
	aid number(20),				--��ַid--
	jis_val number(2),			--����״̬--
	onumber number				--����������Ʒ����--
);
	
--�������id������-
drop sequence order_seq;
create sequence order_seq start with 10000000 increment by 1;

--9.��ַ��--
drop table address;
create table address(
	aid number(20) primary key,  --���--
	jid number(20),				--��ͨ�û���--
	address varchar2(100),		--��ַ--
	consigneename varchar2(50),	--�ջ�������--
	consigneeid varchar2(20),	--�ջ������֤����--
	detailaddress varchar2(100),--��ϸ��ַ--
	tel varchar2(20),			--�绰����--
	pnumber varchar2(20)		--�̶�����--
	);
	
--��ַ���id������-
drop sequence ad_seq;
create sequence ad_seq start with 10000000 increment by 1;

--10.��ͨ�û���--
drop table juser;
create table juser(
	jid number(20) primary key,  --���--
	jname varchar2(50),			--�û���--
	jpwd varchar2(20),			--�û�����--
	jemail varchar2(20),		--�û�����--
	jtel varchar2(20),			--�û��绰����--
	jgender number(2),			--�û��Ա�--
	jbir varchar2(20),			--�û�����--
	juserisval number(2),		--�Ƿ�ɾ��--
	jpic varchar2(20)			--�û�ͷ��--
);
select * from juser;
delete from juser where jtel='15364240309';
commit;
--��ͨ�û����id������--
drop sequence ju_seq;
create sequence ju_seq start with 10000000 increment by 1;

--11.�ղ���Ʒ��--
drop table collectionToGoods;
create table collectionToGoods(
	cbid number(20) primary key,  --���--
	jid number(20),				--�û�id--
	gid number(20)				--��Ʒid--
);	
	
--�ղ���Ʒ���id������--
drop sequence cog_seq;
create sequence cog_seq start with 10000000 increment by 1;

--12.�ղ���ҵ��--
drop table collectionToBuser;
create table collectionToBuser(
	cid number(20) primary key,  --���--
	jid number(20),				--�û�id--
	bid number(20)				--��ҵid--
	);
	
--�ղ���ҵ���id������--
drop sequence cob_seq;
create sequence cob_seq start with 10000000 increment by 1;

--13.����Ա��--
drop table admin;
create table admin(
	adminid number(20) primary key,  --���--
	adminpwd varchar2(20)			--����Ա����--
	);
--����Ա���id������-
drop sequence admin_seq;
create sequence admin_seq start with 10000000 increment by 1;
	
--14.��Ч��--
drop table effect;
create table effect(
	eid number(20) primary key,  --���--
	ename varchar2(20)			--��Ч��--
	);
--��Ч���id������--
drop sequence ef_seq;
create sequence ef_seq start with 10000000 increment by 1;
	
--15.���ͱ�--
drop table gtype;
create table gtype(
	tid number(20) primary key,  --���--
	tname varchar2(20)		--������--
);	

--���ͱ��id������--
drop sequence type_seq;
create sequence type_seq start with 10000000 increment by 1;

--16.���շ�����--
drop table  mad_rush;
create table mad_rush(
	madid number(20) primary key,  --���--
	madpic varchar2(20),		--���շ���ͼƬ--
	bid number(20)				--��ҵid--
);	
--���id������-
drop sequence mad_seq;
create sequence mad_seq start with 10000000 increment by 1;

--17.����Ԥ���--
drop table  foreshow;
create table foreshow(
	foreid number(20) primary key,  --���--
	forepic varchar2(20),		--����Ԥ��ͼƬ--
	bid number(20)				--��ҵid--
);	
--���id������--
drop sequence fore_seq;
create sequence fore_seq start with 10000000 increment by 1;

--18.��ѡ���--
drop table  activity;
create table activity(
	acid number(20) primary key,  --���--
	acpic varchar2(20),			--��ѡ�ͼƬ--
	bid number(20)				--��ҵid--
);	
--���id������--
drop sequence activity_seq;
create sequence activity_seq start with 10000000 increment by 1;


SELECT bid,bname,blogo,isVal,bpwd,bintroduction,bpic,bmpic,col_val,cou.countryid,cou.country,cou.cpic 
FROM country cou,BUSER bu where bu.countryid = cou.countryid

insert into country values(country_seq.nextval,'����','France');
insert into country values(country_seq.nextval,'Ӣ��','England');
insert into country values(country_seq.nextval,'����','America');
insert into country values(country_seq.nextval,'�¹�','Germany');

insert into Buser values(bu_seq.nextval,'������','kazilan',0,123456,'�����ʱΪ��','mu','mu',0,10000001);
insert into Buser values(bu_seq.nextval,'ŷ����','oulaiya',0,123456,'�����ʱΪ��','mu','mu',0,10000002);
insert into Buser values(bu_seq.nextval,'��ޢ','lankou',0,123456,'�����ʱΪ��','mu','mu',0,10000003);
insert into Buser values(bu_seq.nextval,'������','meibaolian',0,123456,'�����ʱΪ��','mu','mu',0,10000001);

insert into Product values(pro_seq.nextval,'�۱�',0);
insert into Product values(pro_seq.nextval,'����',0);
insert into Product values(pro_seq.nextval,'�ں�',0);
insert into Product values(pro_seq.nextval,'��ˮ',0);
select * from Goods
select *��from Buser
insert into Goods values(goods_seq.nextval,10000001,10000001,10,100.00,0,0,'20160502','k','kkkk');
insert into Goods values(goods_seq.nextval,10000002,10000001,10,100.00,0,0,'20160502','k','kkkk');
insert into Goods values(goods_seq.nextval,10000002,10000002,10,100.00,0,0,'20160502','k','kkkk');
insert into Goods values(goods_seq.nextval,10000002,10000003,10,100.00,0,0,'20160502','k','kkkk');

commit;
select * from product
select * from COUNTRY

/*
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
*/
SELECT GID,bnumber,pri,sale_val,col_val,uptime,introduction,detailname, FROM Goods

/*
	gid number(20),       --��Ʒ���--
	eid number(20)		  --��Ч���--
*/
SELECT * from GOODSTOEFFECT

/*
	acid number(20) primary key,  --���--
	acpic varchar2(20),			--��ѡ�ͼƬ--
	bid number(20)				--��ҵid--
*/

/*
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

	gid number(20),       --��Ʒ���--
	eid number(20)		  --��Ч���--
*/
insert into goodsToEffect values(10000001,10000001);
insert into goodsToEffect values(10000001,10000002);
commit;

insert into EFFECT VALUES(ef_seq.nextval,'��Ч1');
insert into EFFECT VALUES(ef_seq.nextval,'��Ч2');
insert into EFFECT VALUES(ef_seq.nextval,'��Ч3');
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

SELECT��* FROM goodsToEffect
insert into goodsToEffect VALUES(10000002,10000001);
commit;
select * from Goods
SELECT * FROM GOODSTOEFFECT
SELECT��* FROM EFFECT

SELECT��* FROM GoodsToType
insert into gtype VALUES(type_seq.nextval,'����1');
insert into gtype VALUES(type_seq.nextval,'����2');
insert into gtype VALUES(type_seq.nextval,'����3');
insert into gtype VALUES(type_seq.nextval,'����4');
insert into gtype VALUES(type_seq.nextval,'����5');
insert into gtype VALUES(type_seq.nextval,'����6');
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
	orid number(20) primary key,  --���--
	gid number(20),				--��Ʒ���--
	jid number(20),				--��ͨ�û�id--
	aid number(20),				--��ַid--
	jis_val number(2),			--����״̬--
	onumber number				--����������Ʒ����--
*/

/*
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
	orid number(20) primary key,  --���--
	gid number(20),				--��Ʒ���--
	jid number(20),				--��ͨ�û�id--
	aid number(20),				--��ַid--
	jis_val number(2),			--����״̬--
	onumber number				--����������Ʒ����--
*/
SELECT * FROM jorder

/*
	aid number(20) primary key,  --���--
	jid number(20),				--��ͨ�û���--
	address varchar2(100),		--��ַ--
	consigneename varchar2(50),	--�ջ�������--
	consigneeid varchar2(20),	--�ջ������֤����--
	detailaddress varchar2(100),--��ϸ��ַ--
	tel varchar2(20),			--�绰����--
	pnumber varchar2(20)		--�̶�����--
*/
insert into address VALUES(ad_seq.nextval,10000001,'��ַ1','����','12322333232323','��ϸ��ַ','1232213233','32323232');
insert into address VALUES(ad_seq.nextval,10000001,'��ַ2','����','12322333232323','��ϸ��ַ','1232213233','32323232');
insert into address VALUES(ad_seq.nextval,10000001,'��ַ3','����','12322333232323','��ϸ��ַ','1232213233','32323232');
commit;

insert into juser VALUES(ju_seq.nextval,'zhangsan','123456','7766555@qq.com','323232323',0,'2323',0,'sfasdfa');
insert into juser VALUES(ju_seq.nextval,'����','123456','7766555@qq.com','323232323',0,'2323',0,'sfasdfa');
insert into juser VALUES(ju_seq.nextval,'zhaoliu','123456','7766555@qq.com','323232323',0,'2323',0,'sfasdfa');
insert into juser VALUES(ju_seq.nextval,'xiaoxiaoxin8','123456','7766555@qq.com','323232323',0,'2323',0,'sfasdfa');
commit;

insert into jorder VALUES(order_seq.nextval,10000001,10000001,10000001,0,1);
insert into jorder VALUES(order_seq.nextval,10000002,10000002,10000002,0,1);
insert into jorder VALUES(order_seq.nextval,10000003,10000001,10000003,0,1);
insert into jorder VALUES(order_seq.nextval,10000004,10000003,10000004,0,1);
commit;

select * from activity;


