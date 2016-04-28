package com.jmei.service;

import java.util.List;

import com.jmei.bean.Effect;
import com.jmei.exception.DAOException;
import com.jmei.exception.EffectExistException;
import com.jmei.exception.EffectNotExistException;
/**
 * EffectService�ӿ�
 * @since 2016-04-27
 * @author ����
 * **/

public interface EffectService {
	/**
	 * ��ӹ�Ч
	 * @param  effect ��Ч����
	 * @throws DAOException ���ݿ��쳣
	 * @throws EffectExistException  ��Ч�����쳣
	 */
	public void addEffect(Effect effect)throws DAOException,EffectExistException;
	
	/**
	 * ɾ����Ч
	 * @param  eid ��Чid
	 * @throws DAOException ���ݿ��쳣
	 * @throws EffectNotExistException  ����Ա�������쳣
	 */
	public void removeEffect(int eid)throws DAOException,EffectNotExistException;
	
    /**
     * �޸Ĺ�Ч��Ϣ
     * @param eid ��Ч��id
     * @param ename ��Ч��
     * @throws DAOException ���ݿ��쳣
	 * @throws EffectNotExistException  ��Ч�������쳣
     */
	public void updateByEffectInfo(int eid,String ename)throws DAOException,EffectNotExistException;
	
	/**
	 * ��ȡ���й�Ч
	 * @return ��Ч�ļ���
	 * @throws DAOException ���ݿ��쳣
	 */
	public List<Effect> searchAllEffect()throws DAOException,EffectNotExistException;
	
}
