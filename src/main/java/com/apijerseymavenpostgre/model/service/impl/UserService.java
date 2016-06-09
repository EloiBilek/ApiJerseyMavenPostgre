package com.apijerseymavenpostgre.model.service.impl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.apijerseymavenpostgre.model.common.IOperations;
import com.apijerseymavenpostgre.model.dao.IUserDAO;
import com.apijerseymavenpostgre.model.entity.User;
import com.apijerseymavenpostgre.model.service.IUserService;
import com.apijerseymavenpostgre.model.service.common.AbstractService;

/**
 * @author eloi eloibilek@gmail.com
 */
@RequestScoped
public class UserService extends AbstractService<User> implements IUserService {

	@Inject
	private IUserDAO dao;

	public UserService() {
	}

	@Override
	protected IOperations<User> getDao() {
		return dao;
	}

}
