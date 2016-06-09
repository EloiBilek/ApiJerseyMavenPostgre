package com.apijerseymavenpostgre.model.dao.impl;

import javax.inject.Singleton;

import com.apijerseymavenpostgre.model.dao.IUserDAO;
import com.apijerseymavenpostgre.model.dao.common.AbstractJpaDao;
import com.apijerseymavenpostgre.model.entity.User;

/**
 * @author eloi eloibilek@gmail.com
 */
@Singleton
public class UserDAO extends AbstractJpaDao<User> implements IUserDAO {

	public UserDAO() {
		setClazz(User.class);
	}

}
