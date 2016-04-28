package com.jmei.dao;

import java.util.List;

import com.jmei.bean.Juser;
import com.jmei.exception.DAOException;

/**
 * ����collectionToBuser���ȡ���ݵ�DAO
 * @since 2016-4-23
 * @author ���
 * */
public interface JuserDAO {
	/**
	 * ������ͨ�û�id��ѯ�û�������Ϣ
	 * @param jid ��ͨ�û�id
	 * @return Juser ���ص�Juser����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣
	 * 
	 **/
	public Juser queryjUserByJid(int jid)throws DAOException;
	
	/**
	 * ������ͨ�û�����ѯ�û�������Ϣ
	 * @param jname ��ͨ�û���
	 * @return Juser ���ص�Juser����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣
	 * 
	 **/
	public Juser queryJuserByJname(String jname)throws DAOException;
	
	/**
	 * ���ݵ绰�����ѯ�û�������Ϣ
	 * @param jtel �绰����
	 * @return Juser ���ص�Juser����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣
	 * 
	 **/
	public Juser queryJuserByJtel(String jtel)throws DAOException;
	/**
	 * ���������ѯ�û�������Ϣ
	 * @param jemail ����
	 * @return Juser ���ص�Juser����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣
	 * 
	 **/
	public Juser queryJuserByJemail(String jemail)throws DAOException;
	
	/**
	 * ��ѯ�����û�
	 * @param 
	 * @return List<Juser> ���ص�Juser���󼯺�
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣
	 * 
	 **/
	public List<Juser> queryAllJuser()throws DAOException;
	
	/**
	 * �����û�idɾ���û�
	 * @param jid ��ͨ�û�id
	 * @param isVal �û�״̬
	 * @return 
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣
	 * 
	 **/
	public void updateIsValByjid(int jid,int isVal)throws DAOException;
	
	/**
	 * ������ͨ�û�id�޸��û���
	 * @param jid ��ͨ�û�id
	 * @param jname Ҫ�޸ĵ��û���
	 * @return 
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣
	 * 
	 **/
	public void updateJnameByJid(int jid,String jname)throws DAOException;
	
	/**
	 * ������ͨ�û�id�޸�����
	 * @param jid ��ͨ�û�id
	 * @param jemail ����
	 * @return 
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣
	 * 
	 **/
	public void updateJemailByJid(int jid,String jemail)throws DAOException;
	
	/**
	 * ������ͨ�û�id�޸ĵ绰����
	 * @param jid ��ͨ�û�id
	 * @param jtel �绰����
	 * @return 
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣
	 * 
	 **/
	public void updateTelByJid(int jid,String jtel)throws DAOException;
	
	/**
	 * �����û�id�޸�������Ϣ
	 * @param jid ��ͨ�û�id
	 * @param other ������Ϣ
	 * @return 
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣
	 * 
	 **/
	public void updateOtherByJid(Juser juser)throws DAOException;
	
	/**
	 * �����û� ���û����е���Ϣ��
	 * @param juser Juser����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣
	 * 
	 **/
	public void addJuser(Juser juser)throws DAOException;
	
	/**
	 * �����û�������ע�ᣬ����û��������룬�绰���룬״̬��
	 * @param jname �û���
	 * @param jpwd
 	 * @param jtel
	 * @param is_val
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣
	 */
	public void addJuser(String jname,String jpwd,String jtel,int isVal)throws DAOException;
	
	/**
	 * ͨ���û�id�޸�ͷ��
	 * @param jid �û�id
	 * @param jpic ��Ҫ�޸ĵ�ͷ��ͼƬ
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣
	 */
	public void updateJpic(int jid,String jpic)throws DAOException;
	
	

}
