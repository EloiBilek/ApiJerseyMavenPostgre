---
Title: ApiJerseyMavenPostgre
Description: API example using Jersey, CDI, JPA, Maven and Postgresql.
Author: Eloi Bilek
Tags: maven, restful, api, java, jersey
Created: 2016 Abr 02

---

# ApiJerseyMavenPostgre
=======================

It 's a very simple example of an RestFul API, CRUD of User.
Using:
* Java 8
* Maven 3
* Jersey 1.19
* Jboss Weld 3
* Hibernate 5
* DataSources/Resource Pools C3P0 0.9.1.2
* PostgreSQL 9.4.1208.jre7
* Tomcat 8
* Eclipse Java EE IDE - Version: Mars.1 Release (4.5.1)

## Note 1!
This project was started with: New > Maven > Maven Project.

![new maven project](https://github.com/EloiBilek/eloibilek.github.io/raw/master/SMP/new_maven_project.png)

After importing the project to the Eclipse workspace, run: ApiJerseyMavenPostgre> Maven> Update Project. This will load dependencies.

## Note 2!
This Project have a DataSource control to the pool of connections (C3P0) in:
/ApiJerseyMavenPostgre/src/main/java/META-INF/persistence.xml

Before starting project, set persistence.xml with the url of your database, username and password. If the database does not exist, set the hibernate.hbm2ddl.auto attribute to create it.

In Tomcat server, add the project, click Publish, make sure synchronized.
Start with Play or Debug.

To test requests (post, get, put and delete), I use the following plugin for chrome:

![rest plugin](https://github.com/EloiBilek/eloibilek.github.io/raw/master/SMP/chrome_rest_plugin.png)

Request example.

![request test](https://github.com/EloiBilek/eloibilek.github.io/raw/master/JMP/request_test.png)

Response example.

![response test](https://github.com/EloiBilek/eloibilek.github.io/raw/master/JMP/response_test.png)
