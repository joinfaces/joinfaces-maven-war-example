JoinFaces War Example
=====
[![Heroku](http://heroku-badge.herokuapp.com/?app=joinfaces-example-war&root=index.jsf)](https://joinfaces-example-war.herokuapp.com)
[![Build Status](https://travis-ci.org/joinfaces/joinfaces-maven-war-example.svg?branch=master)](https://travis-ci.org/joinfaces/joinfaces-example-war)
[![Dependency Status](https://www.versioneye.com/user/projects/5791525051500e003188708b/badge.svg?style=flat)](https://www.versioneye.com/user/projects/5791525051500e003188708b)
[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

This project illustrates JSF usage inside WAR packaged Spring Boot Application.

[JoinFaces](http://joinfaces.org) autoconfigures [PrimeFaces](http://primefaces.org/), [OmniFaces](http://omnifaces.org/), [Mojarra](https://javaserverfaces.java.net/) and [MyFaces](http://myfaces.apache.org) libraries to run at [Tomcat](http://tomcat.apache.org/), [Jetty](http://www.eclipse.org/jetty) or [Undertow](http://undertow.io/).

## Run Example Application locally

1- Clone this project
```Shell
git clone https://github.com/joinfaces/joinfaces-example-war.git
```

2- Build
```Shell
mvn clean install
```

3- Copy into tomcat, jetty or undertow

4- Start tomcat, jetty or undertow

5- Access helloWorld page at **http://localhost:8080/joinfaces-example/helloWorld.jsf** with credentials

User | Password | Roles
-----| -------- | -----
persapiens | 123 | ROLE_ADMIN
nyilmaz | qwe | ROLE_USER

## Key Files

### pom.xml

Includes joinfaces starter dependency. All other jsf dependencies are included transitively.

```xml
<parent>
    <groupId>org.joinfaces</groupId>
    <artifactId>joinfaces-parent</artifactId>
    <version>3.0.0.RC1</version>
    <relativePath/>
</parent>

<dependencies>
    <dependency>
      <groupId>org.joinfaces</groupId>
      <artifactId>jsf-spring-boot-starter</artifactId>
    </dependency>
</dependencies>
```

If you prefer **Jetty** instead of **Tomcat**, change artifactId jsf-spring-boot-starter to **jsf-jetty-spring-boot-starter** in order to use **Jetty** servlet container. 

If you prefer **Undertow** instead of **Tomcat**, change artifactId jsf-spring-boot-starter to **jsf-undertow-spring-boot-starter** in order to use **Undertow** servlet container. 

If you prefer **MyFaces** instead of **Mojarra**, change artifactId jsf-spring-boot-starter to **jsf-myfaces-spring-boot-starter** in order to use **MyFaces** JSF Implementation. 

If you prefer **Jetty** instead of **Tomcat** and **MyFaces** instead of **Mojarra**, change artifactId jsf-spring-boot-starter to **jsf-jetty-mojarra-spring-boot-starter**. 

If you prefer **Undertow** instead of **Tomcat** and **MyFaces** instead of **Mojarra**, change artifactId jsf-spring-boot-starter to **jsf-undertow-mojarra-spring-boot-starter**. 

Note that **spring-boot-starter-security** is included to secure the application.

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
</dependencies>
```

### src/main/resources/application.yml

Configure jsf.PROJECT_STATE and jsf.primefaces.THEME properties.

```yml
jsf:
  PROJECT_STAGE: Development
  primefaces: 
    theme: overcast
```

### src/main/resources/META-INF/resources/starter.xhtml

Example page. 

Note that xhtml, js, css and images files should be located at **src/main/resources/META-INF/resources** directory to JSF use them.

Look at **authorize** and **anonymous** jsf spring security facelet tags in action to secure page information.

```xhtml
  <sec:authorize access="hasRole('ROLE_ADMIN')">
    <p:panelGrid columns="1" rendered="#{sec:isFullyAuthenticated()}">
      <p:link title="Logout" href="/logout">
        <p:outputLabel value="You are logged in as an ADMIN" />
      </p:link>
    </p:panelGrid>
  </sec:authorize>
```

### src/main/java/org/joinfaces/example/JoinFacesExampleApplication.java

Very simple spring main application. Only SpringBootApplication configuration is required.

<pre>
@SpringBootApplication
public class JoinFacesExampleApplication {
</pre>

### src/main/java/org/joinfaces/example/SecurityConfig.java

Spring Security configuration class to secure authentication with credentials to persapiens and nyilmaz users.

### src/main/java/org/joinfaces/example/view/HelloWorldMBean.java

Managed bean using ViewScoped CDI annotation. The equivalent spring scope of ViewScoped annotation is configured automatically by Jsf Spring Boot Starter.

<pre>
@Named
<b>@ViewScoped</b>
public class StarterMBean {
</pre>

## Getting Help

* Report questions and bugs at [github.com/joinfaces/joinfaces/issues](https://github.com/joinfaces/joinfaces/issues).

## Contributing

* Report documentation, features, enhancement and bugs at [github.com/joinfaces/joinfaces/issues](https://github.com/joinfaces/joinfaces/issues).
* Pull requests are welcome.
