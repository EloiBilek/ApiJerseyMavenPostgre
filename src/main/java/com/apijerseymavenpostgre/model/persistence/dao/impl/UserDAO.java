package com.apijerseymavenpostgre.model.persistence.dao.impl;

import javax.inject.Singleton;

import com.apijerseymavenpostgre.model.entity.User;
import com.apijerseymavenpostgre.model.persistence.dao.IUserDAO;
import com.apijerseymavenpostgre.model.persistence.dao.common.AbstractJpaDao;

/**
 * @author eloi eloibilek@gmail.com
 */
@Singleton
public class UserDAO extends AbstractJpaDao<User> implements IUserDAO {

	public UserDAO() {
		setClazz(User.class);
	}

}
