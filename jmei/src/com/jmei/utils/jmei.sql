select * from user_tables;
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
insert into buser values(bu_seq.nextVal,'������','kazilan.jsp',0,'123456',
'lalal','kazilanpic.jpg','kazilanmi.jpg',100,00000001);
insert into buser values(bu_seq.nextVal,'������','kazilan.jsp',0,'123456',
'lalal','kazilanpic.jpg','kazilanmi.jpg',100,10000001);
--insert into buser values(bu_seq.nextVal,'������','kazilanlogo.jpg','0','123456',
--'','kazilanpic.jpg','kazilanmiddle.jpg');
select * from buser;
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
select * from product;
insert into product values(pro_seq.nextVal,'��Ĥ','0');	--"0"��ʾδɾ��;

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
select * from goods;
insert into goods values(goods_seq.nextVal,10000020,10000001,2,100,20,24,'2015-11-23',null,null);
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
insert into country values(country_seq.nextVal,'�й�','country.jsp');

--insert into goods values(goods.nextVal,'������',''	
--7.��ƷͼƬ��--
drop table pic;
create table pic(
	picid number(20) primary key,		--���--
	pname varchar2(20),					--��Ʒ��--					
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
	gid number(20),				--��Ʒ���--10000001
	jid number(20),				--��ͨ�û�id--10000020
	aid number(20),				--��ַid--10000001
	jis_val number(2),			--����״̬--
	onumber number				--����������Ʒ����--
	);
	
--�������id������-
drop sequence order_seq;
create sequence order_seq start with 10000000 increment by 1;
select * from goods;
select * from juser;
select * from address;
select * from jorder;
insert into jorder values(order_seq.nextVal,10000001,10000020,10000001,0,0);
--9.��ַ��--
drop table address;
create table address(
	aid number(20) primary key,  --���--
	jid number(20),				--��ͨ�û���--10000020
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
insert into address values(ad_seq.nextVal,10000020,null,null,null,null,null,null);
select * from address;
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
--��ͨ�û����id������--
drop sequence ju_seq;
create sequence ju_seq start with 10000000 increment by 1;
insert into juser values(ju_seq.nextVal,'zoululala','123456','1207408431@qq.com','18075878071'
,0,'1996-03-09',0,'juser.png');
select * from juser;
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
select * from collectionToGoods;
insert into collectionToGoods values(cog_seq.nextVal,10000020,10000001);
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
insert into collectionToBuser values(cob_seq.nextVal,10000001,10000001);
SELECT * FROM collectionToBuser;
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


