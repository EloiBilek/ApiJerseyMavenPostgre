package com.apijerseymavenpostgre.controller;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.apijerseymavenpostgre.model.entity.User;
import com.apijerseymavenpostgre.model.service.IUserService;

/**
 * @author eloi eloibilek@gmail.com
 */

@Path("users")
@RequestScoped
public class UserController {

	@Inject
	IUserService userService;

	public UserController() {
		super();
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<User> findAll() {
		try {
			return userService.findAll();
		} catch (Exception e) {
			throw new WebApplicationException(e.getCause(), 500);
		}
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/{id}")
	public User findById(@PathParam("id") final Long id) {
		try {
			return userService.findById(id);
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response create(User resource) {
		try {
			resource = userService.create(resource);
			return Response.status(201).entity(resource).build();
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response update(User resource) {
		try {
			resource = userService.update(resource);
			return Response.status(200).entity(resource).build();
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}

	@DELETE
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/{id}")
	public Response delete(@PathParam("id") final Long id) {
		try {
			userService.deleteById(id);
			return Response.status(200).entity("User id " + id + " - deleted.").build();
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}

}
