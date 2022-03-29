JoinFaces War Example
=====
[![Heroku](http://heroku-badge.herokuapp.com/?app=joinfaces-example-war&root=starter.jsf)](https://joinfaces-example-war.herokuapp.com)
[![Build Status](https://github.com/joinfaces/joinfaces-maven-war-example/actions/workflows/maven.yml/badge.svg)](https://github.com/joinfaces/joinfaces-maven-war-example/actions)
[![Codecov](https://codecov.io/gh/joinfaces/joinfaces-maven-war-example/branch/4.7.x/graph/badge.svg)](https://codecov.io/gh/joinfaces/joinfaces-maven-jar-example)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=joinfaces_joinfaces-maven-war-example&metric=bugs)](https://sonarcloud.io/dashboard?id=joinfaces_joinfaces-maven-war-example)
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

3- Copy into tomcat

4- Start tomcat

5- Access starter page at **http://localhost:8080/joinfaces-example/** with credentials

User | Password | Roles
-----| -------- | -----
persapiens | 123 | ROLE_ADMIN
nyilmaz | qwe | ROLE_USER

## Key Files

### pom.xml

Includes joinfaces starter dependency. All other jsf dependencies are included transitively.

```xml
<properties>
   <joinfaces.version>5.0.0-m2</joinfaces.version>
</properties>

<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.joinfaces</groupId>
            <artifactId>joinfaces-dependencies</artifactId>
            <version>${joinfaces.version}</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>

<dependencies>
  <dependency>
    <groupId>org.joinfaces</groupId>
    <artifactId>jsf-spring-boot-starter</artifactId>
  </dependency>
</dependencies>
```

Note that **security-spring-boot-starter** is included to secure the application.

```xml
<dependencies>
    <dependency>
        <groupId>org.joinfaces</groupId>
        <artifactId>security-spring-boot-starter</artifactId>
    </dependency>
</dependencies>
```

### src/main/resources/application.yml

Configure jsf.PROJECT_STATE and jsf.primefaces.THEME properties.

```yml
joinfaces:
  jsf:
    PROJECT_STAGE: Development
  primefaces: 
    theme: overcast
```

### src/main/webapp/starter.xhtml

Example page to help you choose the right JoinFaces Starter for you. 

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

Managed bean using ViewScoped CDI annotation. The equivalent spring scope of ViewScoped annotation is configured automatically by JoinFaces Starter.

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
