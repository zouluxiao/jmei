package com.jmei.service.impl;

import java.util.List;

import com.jmei.bean.Juser;
import com.jmei.dao.JuserDAO;
import com.jmei.exception.DAOException;
import com.jmei.exception.EmailHasExist;
import com.jmei.exception.JuserIsNull;
import com.jmei.exception.NotHaveJuser;
import com.jmei.exception.NotHaveThisJuser;
import com.jmei.exception.NotHaveThisNameUser;
import com.jmei.exception.TelHasExist;
import com.jmei.exception.UserNameOrPwdException;
import com.jmei.factory.DAOFactory;
import com.jmei.service.JuserService;
/**
 * ʵ��JuserService�ӿڵ���
 * @author ���
 * @since 2016-04-27
 *
 */

public class JuserServiceImpl implements JuserService {
	
	private final static String JUSER_DAO_KEY = "JuserDAOImpl";

	@Override
	public Juser searchjUserByJid(int jid) throws DAOException,NotHaveThisJuser {
		//1.��������JuserDAOImpl����
		JuserDAO userDAO = (JuserDAO)DAOFactory.newInstance(JUSER_DAO_KEY);
		//���ò�ѯ�û�����
		Juser juser = userDAO.queryjUserByJid(jid);
		//�ж��û��Ƿ�Ϊ��
		if(juser == null)
			throw new NotHaveThisJuser("�û�������!");
		return juser;
	}

	@Override
	public Juser searchJuserByJname(String jname) throws DAOException,NotHaveThisNameUser {
		//1.��������JuserDAOImpl����
		JuserDAO userDAO = (JuserDAO)DAOFactory.newInstance(JUSER_DAO_KEY);
		//���ò�ѯ�û�����
		Juser juser = userDAO.queryJuserByJname(jname);
		//�ж��û��Ƿ�Ϊ��
		if(juser == null)
			throw new NotHaveThisNameUser("�û�������!");
		return juser;
	}

	@Override
	public void loginByJtel(String jtel,String pwd) throws DAOException,NotHaveThisJuser,UserNameOrPwdException {
		//1.��������JuserDAOImpl����
		JuserDAO userDAO = (JuserDAO)DAOFactory.newInstance(JUSER_DAO_KEY);
		//���ò�ѯ�û�����
		Juser juser = userDAO.queryJuserByJtel(jtel);
		//�ж��û��Ƿ�Ϊ��
		if(juser == null)
			throw new NotHaveThisJuser("�û�������!");
		if(!pwd.equals(juser.getJpwd()))
			throw new UserNameOrPwdException("�û������ڻ��������!");
	}

	@Override
	public void loginByJemail(String jemail,String pwd) throws DAOException,
	NotHaveThisJuser,UserNameOrPwdException {
		//1.��������JuserDAOImpl����
		JuserDAO userDAO = (JuserDAO)DAOFactory.newInstance(JUSER_DAO_KEY);
		//���ò�ѯ�û�����
		Juser juser = userDAO.queryJuserByJemail(jemail);
		//�ж��û��Ƿ����
		if(juser == null)
			throw new NotHaveThisJuser("�û�������!");
		if(!pwd.equals(juser.getJpwd()))
			throw new UserNameOrPwdException("�û������ڻ��������!");
	}

	@Override
	public List<Juser> queryAllJuser() throws DAOException, NotHaveJuser {
		//1.��������JuserDAOImpl����
		JuserDAO userDAO = (JuserDAO)DAOFactory.newInstance(JUSER_DAO_KEY);
		//���ò�ѯ�û�����
		List<Juser> list = userDAO.queryAllJuser();
		if(list.size() == 0)
			throw new NotHaveJuser("û���û�!");
		return list;
	}

	@Override
	public void updateIsValByjid(int jid, int isVal) throws DAOException,NotHaveThisJuser {
		//1.��������JuserDAOImpl����
		JuserDAO userDAO = (JuserDAO)DAOFactory.newInstance(JUSER_DAO_KEY);
		//����ͨ���û�id��ѯ�û�����
		Juser user=userDAO.queryjUserByJid(jid);
		//�ж��û��Ƿ����
		if(user == null)
			throw new NotHaveThisJuser("�û�������!");
		//����ɾ���û�����
		userDAO.updateIsValByjid(jid, isVal);	
		

	}

	@Override
	public void updateJnameByJid(int jid, String jname) throws DAOException,NotHaveThisJuser {
		//1.��������JuserDAOImpl����
		JuserDAO userDAO = (JuserDAO)DAOFactory.newInstance(JUSER_DAO_KEY);
		//����ͨ���û�id��ѯ�û�����
		Juser user=userDAO.queryjUserByJid(jid);
		//�ж��û��Ƿ����
		if(user == null)
			throw new NotHaveThisJuser("�û�������!");
		//����ͨ���û�id�޸��û�������
		userDAO.updateJnameByJid(jid, jname);
	}

	@Override
	public void updateJemailByJid(int jid, String jemail) throws DAOException,NotHaveThisJuser,EmailHasExist {
		//1.��������JuserDAOImpl����
		JuserDAO userDAO = (JuserDAO)DAOFactory.newInstance(JUSER_DAO_KEY);
		//����ͨ���û�id��ѯ�û�����
		Juser user=userDAO.queryjUserByJid(jid);
		//�ж��û��Ƿ����
		if(user == null)
			throw new NotHaveThisJuser("�û�������!");
		//����ͨ�������ѯ�û�����
		Juser users = userDAO.queryJuserByJemail(jemail);
		//�ж������Ƿ��Ѵ���
		if(users !=null)
			throw new EmailHasExist("�����Ѵ���!");
		//����ͨ���û�id�޸��û�������
		userDAO.updateJemailByJid(jid, jemail);

	}

	@Override
	public void updateTelByJid(int jid, String jtel) throws DAOException,NotHaveThisJuser,TelHasExist {
		//1.��������JuserDAOImpl����
		JuserDAO userDAO = (JuserDAO)DAOFactory.newInstance(JUSER_DAO_KEY);
		//����ͨ���û�id��ѯ�û�����
		Juser user=userDAO.queryjUserByJid(jid);
		//�ж��û��Ƿ����
		if(user == null)
			throw new NotHaveThisJuser("�û�������!");
		//����ͨ���绰��������û�����
		Juser users =userDAO.queryJuserByJtel(jtel);
		//�жϵ绰�����Ƿ��Ѵ���
		if(users != null)
			throw new TelHasExist("�绰�����Ѵ���!");
		//����ͨ���û�id�޸��û�������
		userDAO.updateTelByJid(jid, jtel);

	}

	@Override
	public void updateOtherByJid(Juser juser) throws DAOException,JuserIsNull,NotHaveThisJuser,
		TelHasExist,EmailHasExist{
		//1.��������JuserDAOImpl����
		JuserDAO userDAO = (JuserDAO)DAOFactory.newInstance(JUSER_DAO_KEY);
		//�ж�juser�Ƿ�Ϊ��
		if(juser == null)
			throw new JuserIsNull("�û�����Ϊ��!");
		//����ͨ���û�id��ѯ�û�����
		Juser ju = userDAO.queryjUserByJid(juser.getJid());
		//�ж��û��Ƿ����
		if(ju == null)
			throw new NotHaveThisJuser("�û�������!");
		//����ͨ���绰�����ѯ�û�����
		Juser jusers = userDAO.queryJuserByJtel(juser.getJtel());
		//�жϵ绰�����Ƿ��Ѵ���
		if(jusers != null)
			throw new TelHasExist("�绰�����Ѵ���!");
		//ͨ������ͨ�������ѯ�û�����
		ju = userDAO.queryJuserByJemail(juser.getJemail());
		//�ж������Ƿ��Ѵ���
		if(ju != null)
			throw new EmailHasExist("�����Ѵ���!");
		//�����޸�������Ϣ����
		userDAO.updateOtherByJid(jusers);

	}

	@Override
	public void addJuser(Juser juser) throws DAOException, EmailHasExist,JuserIsNull,
			TelHasExist {
		//1.��������JuserDAOImpl����
		JuserDAO userDAO = (JuserDAO)DAOFactory.newInstance(JUSER_DAO_KEY);
		//�ж�juser�Ƿ�Ϊ��
		if(juser == null)
			throw new JuserIsNull("�û�����Ϊ��!");
		//����ͨ���绰�����ѯ�û�����
		Juser jusers = userDAO.queryJuserByJtel(juser.getJtel());
		//�жϵ绰�����Ƿ��Ѵ���
		if(jusers != null)
			throw new TelHasExist("�绰�����Ѵ���!");
		//ͨ������ͨ�������ѯ�û�����
		jusers = userDAO.queryJuserByJemail(juser.getJemail());
		//�ж������Ƿ��Ѵ���
		if(jusers != null)
			throw new EmailHasExist("�����Ѵ���!");
		//��������û�����
		userDAO.addJuser(jusers);

	}

	@Override
	public void reg(String jname, String jpwd, String jtel, int isVal)
			throws DAOException, TelHasExist {
		//1.��������JuserDAOImpl����
		JuserDAO userDAO = (JuserDAO)DAOFactory.newInstance(JUSER_DAO_KEY);
		//����ͨ���绰�����ѯ�û�����
		Juser jusers = userDAO.queryJuserByJtel(jtel);
		//�жϵ绰�����Ƿ��Ѵ���
		if(jusers != null)
			throw new TelHasExist("�绰�����Ѵ���!");
		//����ע�᷽��
		userDAO.addJuser(jname, jpwd, jtel, isVal);
	}

}
