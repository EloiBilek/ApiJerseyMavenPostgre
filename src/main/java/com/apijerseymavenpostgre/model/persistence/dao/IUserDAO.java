/**
 * 
 */
package com.apijerseymavenpostgre.model.persistence.dao;

import java.util.List;

import com.apijerseymavenpostgre.model.common.IOperations;
import com.apijerseymavenpostgre.model.entity.User;

/**
 * @author eloi
 *
 */
public interface IUserDAO extends IOperations<User>{
	
	public User findById(final long id);

	public List<User> findAll();

	public User create(final User user);

	public User update(final User user);

	public void deleteById(final long entityId);

}
