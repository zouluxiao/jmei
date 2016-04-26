package com.jmei.service;

import java.util.List;

import com.jmei.bean.Juser;
import com.jmei.exception.DAOException;
import com.jmei.exception.EmailHasExist;
import com.jmei.exception.EmailHasNotExist;
import com.jmei.exception.NotHaveJuser;
import com.jmei.exception.TelHasExist;
import com.jmei.exception.TelHasNotExist;

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
	 * 
	 **/
	public Juser searchjUserByJid(int jid)throws DAOException;
	
	/**
	 * ������ͨ�û�����ѯ�û�������Ϣ
	 * @param jname ��ͨ�û���
	 * @return Juser ���ص�Juser����
	 * @exception DAOException ���ݿ��쳣
	 * 
	 **/
	public Juser searchJuserByJname(String jname)throws DAOException;
	
	/**
	 * ���ݵ绰�����¼
	 * @param jtel �绰����
	 * @return Juser ���ص�Juser����
	 * @exception DAOException ���ݿ��쳣
	 * @exception TelHasNotExist �绰���벻�����쳣
	 **/
	public Juser loginByJtel(String jtel)throws DAOException,TelHasNotExist;
	
	/**
	 * ���������¼
	 * @param jemail ����
	 * @return Juser ���ص�Juser����
	 * @exception DAOException ���ݿ��쳣
	 * @exception EmailHasNotExist ���䲻�����쳣
	 **/
	public Juser loginByJemail(String jemail)throws DAOException,EmailHasNotExist;
	
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
	 * 
	 **/
	public void updateIsValByjid(int jid,int isVal)throws DAOException;
	
	/**
	 * ������ͨ�û�id�޸��û���
	 * @param jid ��ͨ�û�id
	 * @param jname Ҫ�޸ĵ��û���
	 * @return 
	 * @exception DAOException ���ݿ��쳣
	 * 
	 **/
	public void updateJnameByJid(int jid,String jname)throws DAOException;
	
	/**
	 * ������ͨ�û�id�޸�����
	 * @param jid ��ͨ�û�id
	 * @param jemail ����
	 * @return 
	 * @exception DAOException ���ݿ��쳣
	 * 
	 **/
	public void updateJemailByJid(int jid,String jemail)throws DAOException;
	
	/**
	 * ������ͨ�û�id�޸ĵ绰����
	 * @param jid ��ͨ�û�id
	 * @param jtel �绰����
	 * @return 
	 * @exception DAOException ���ݿ��쳣
	 * 
	 **/
	public void updateTelByJid(int jid,String jtel)throws DAOException;
	
	/**
	 * �����û�id�޸�������Ϣ
	 * @param jid ��ͨ�û�id
	 * @param other ������Ϣ
	 * @return 
	 * @exception DAOException ���ݿ��쳣
	 * 
	 **/
	public void updateOtherByJid(Juser juser)throws DAOException;
	
	/**
	 * �����û� ���û����е���Ϣ��
	 * @param juser Juser����
	 * @exception DAOException ���ݿ��쳣
	 * @exception EmailHasExist �����Ѵ����쳣
	 * @exception TelHasExist  �绰�����Ѵ����쳣
	 **/
	public void addJuser(Juser juser)throws DAOException,EmailHasExist,TelHasExist;
	
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
