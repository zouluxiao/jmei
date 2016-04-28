package com.jmei.service;

import java.util.List;

import com.jmei.bean.Juser;
import com.jmei.exception.DAOException;
import com.jmei.exception.EmailHasExist;
import com.jmei.exception.JuserIsNull;
import com.jmei.exception.NotHaveJuser;
import com.jmei.exception.NotHaveThisJuser;
import com.jmei.exception.NotHaveThisNameUser;
import com.jmei.exception.TelHasExist;
import com.jmei.exception.UserNameOrPwdException;

/**
 * ��ͨ�û�ģ��Service�ӿ� 
 * @author ���
 * @since 2016-04-26
 *
 */
public interface JuserService {
	/**
	 * ������ͨ�û�id��ѯ�û�������Ϣ
	 * @param jid ��ͨ�û�id
	 * @return Juser ���ص�Juser����
	 * @exception DAOException ���ݿ��쳣
	 * @exception NotHaveThisJuser û�и��û��쳣
	 * 
	 **/
	public Juser searchjUserByJid(int jid)throws DAOException,NotHaveThisJuser;
	
	/**
	 * ������ͨ�û�����ѯ�û�������Ϣ
	 * @param jname ��ͨ�û���
	 * @return Juser ���ص�Juser����
	 * @exception DAOException ���ݿ��쳣
	 * @exception NotHaveThisNameUser û�д��û����쳣
	 **/
	public Juser searchJuserByJname(String jname)throws DAOException,NotHaveThisNameUser;
	
	/**
	 * ���ݵ绰�����¼
	 * @param jtel �绰����
	 * @return Juser ���ص�Juser����
	 * @exception DAOException ���ݿ��쳣
	 * @exception NotHaveThisJuser �û��������쳣
	 * @exception UserNameOrPwdException �û������ڻ���������쳣
	 **/
	public void loginByJtel(String jtel,String pwd)throws DAOException,NotHaveThisJuser,UserNameOrPwdException;
	
	/**
	 * ���������¼
	 * @param jemail ����
	 * @return Juser ���ص�Juser����
	 * @exception DAOException ���ݿ��쳣
	 * @exception NotHaveThisJuser �û��������쳣
	 * @exception UserNameOrPwdException �û������ڻ��������
	 **/
	public void loginByJemail(String jemail,String pwd)throws DAOException,NotHaveThisJuser,UserNameOrPwdException;
	
	/**
	 * ��ѯ�����û�
	 * @param 
	 * @return List<Juser> ���ص�Juser���󼯺�
	 * @exception DAOException ���ݿ��쳣
	 * @exception NotHaveJuser û���û��쳣
	 * 
	 **/
	public List<Juser> queryAllJuser()throws DAOException,NotHaveJuser;
	
	/**
	 * �����û�idɾ���û�
	 * @param jid ��ͨ�û�id
	 * @param isVal �û�״̬
	 * @return 
	 * @exception DAOException ���ݿ��쳣
	 * @exception NotHaveThisJuser �û��������쳣
	 **/
	public void updateIsValByjid(int jid,int isVal)throws DAOException,NotHaveThisJuser;
	
	/**
	 * ������ͨ�û�id�޸��û���
	 * @param jid ��ͨ�û�id
	 * @param jname Ҫ�޸ĵ��û���
	 * @return 
	 * @exception DAOException ���ݿ��쳣
	 * 
	 **/
	public void updateJnameByJid(int jid,String jname)throws DAOException,NotHaveThisJuser;
	
	/**
	 * ������ͨ�û�id�޸�����
	 * @param jid ��ͨ�û�id
	 * @param jemail ����
	 * @return 
	 * @exception DAOException ���ݿ��쳣
	 * 
	 **/
	public void updateJemailByJid(int jid,String jemail)throws DAOException,NotHaveThisJuser,EmailHasExist;
	
	/**
	 * ������ͨ�û�id�޸ĵ绰����
	 * @param jid ��ͨ�û�id
	 * @param jtel �绰����
	 * @return 
	 * @exception DAOException ���ݿ��쳣
	 * 
	 **/
	public void updateTelByJid(int jid,String jtel)throws DAOException,NotHaveThisJuser,TelHasExist;
	
	/**
	 * �����û�id�޸�������Ϣ
	 * @param jid ��ͨ�û�id
	 * @param other ������Ϣ
	 * @return 
	 * @exception DAOException ���ݿ��쳣
	 * 
	 **/
	public void updateOtherByJid(Juser juser)throws DAOException,JuserIsNull,NotHaveThisJuser,TelHasExist,EmailHasExist;
	
	/**
	 * �����û� ���û����е���Ϣ��
	 * @param juser Juser����
	 * @exception DAOException ���ݿ��쳣
	 * @exception EmailHasExist �����Ѵ����쳣
	 * @exception TelHasExist  �绰�����Ѵ����쳣
	 **/
	public void addJuser(Juser juser)throws DAOException,EmailHasExist,TelHasExist,JuserIsNull;
	
	/**
	 * ע�᷽��������ע�ᣬ����û��������룬�绰���룬״̬��
	 * @param jname �û���
	 * @param jpwd  �û�����
 	 * @param jtel  �û��绰����
	 * @param is_val �û�״̬
	 * @exception DAOException ���ݿ��쳣
	 * @exception TelHasExist �绰�����Ѵ����쳣
	 */
	public void reg(String jname,String jpwd,String jtel,int isVal)throws DAOException,TelHasExist;
	
	
	


}
