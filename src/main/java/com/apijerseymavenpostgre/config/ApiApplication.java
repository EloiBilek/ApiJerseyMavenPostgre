package com.apijerseymavenpostgre.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.apijerseymavenpostgre.resource.UserResource;

/**
 * @author eloi eloibilek@gmail.com
 */

@ApplicationPath("v1")
public class ApiApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> s = new HashSet<Class<?>>();
		s.add(UserResource.class);
		return s;
	}
}
