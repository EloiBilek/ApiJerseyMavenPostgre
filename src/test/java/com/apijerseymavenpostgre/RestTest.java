/**
 * 
 */
package com.apijerseymavenpostgre;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.apijerseymavenpostgre.model.entity.User;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

/**
 * @author eloi
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RestTest {

	private static String URL_TEST = "http://localhost:8080/ApiJerseyMavenPostgre/v1/users";

	Client client = Client.create();
	WebResource webResource;
	
	private static long idUser;

	@Test
	public void a_postTest() {
		JSONObject jsonObject = new JSONObject();
		User user = new User();

		try {
			jsonObject.put("id", "");
			jsonObject.put("name", "Teste JUnit");
			jsonObject.put("dateBirth", "2016-05-22T15:02:02");
			jsonObject.put("email", "testejunit@teste.com");
			jsonObject.put("active", true);
		} catch (JSONException e) {
			fail(e.getMessage());
		}

		webResource = client.resource(URL_TEST);
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.post(ClientResponse.class, jsonObject.toString());
		user = response.getEntity(new GenericType<User>() {
		});

		assertEquals(201, response.getStatus());
		assertEquals("Teste JUnit", user.getName());
		assertTrue(user.getId() > 0);

		idUser = user.getId();
		System.out.println(response.toString());
		System.out.println(user.toString());
	}

	@Test
	public void b_getTest() {
		webResource = client.resource(URL_TEST);
		ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		List<User> users = response.getEntity(new GenericType<List<User>>() {
		});

		assertEquals(200, response.getStatus());
		assertTrue(users.size() > 0);

		System.out.println(response.toString());

		for (User user : users) {
			System.out.println(user.toString());
		}
	}

	@Test
	public void c_putTest() {
		JSONObject jsonObject = new JSONObject();
		User user = new User();

		try {
			jsonObject.put("id", idUser);
			jsonObject.put("name", "Teste JUnit update");
			jsonObject.put("dateBirth", "2016-05-22T15:02:02");
			jsonObject.put("email", "testejunitPUT@teste.com");
			jsonObject.put("active", true);
		} catch (JSONException e) {
			fail(e.getMessage());
		}

		webResource = client.resource(URL_TEST);
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.put(ClientResponse.class, jsonObject.toString());
		user = response.getEntity(new GenericType<User>() {
		});

		assertEquals(200, response.getStatus());
		assertEquals("Teste JUnit update", user.getName());
		assertTrue(idUser > 0);

		System.out.println(response.toString());
		System.out.println(user.toString());
	}

	@Test
	public void d_deleteTest() {
		webResource = client.resource(URL_TEST+"/"+idUser);
		ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).delete(ClientResponse.class);
		assertEquals(200, response.getStatus());
		System.out.println(response.toString());
	}

}
