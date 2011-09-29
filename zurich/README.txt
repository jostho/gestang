README 
========

Zurich is a project to demonstrate a simple webapp using spring ws.


Environment
-------------
  * jdk 1.6.0
  * tomcat 7.0 / jetty 8.0
  * eclipse 3.5 (galileo)
  * maven 3.0
  * curl 7.20

    
Build
-------
NOTE - The dependencies are pulled from the m2 central repository - http://repo1.maven.org/maven2/. 
Make sure you are connected to the network, when doing the first build.

To build the app, use 
$ mvn    

To run the webapp, copy zurich.war to webapps folder in tomcat / jetty. 
Else run it using the maven plugin - 'mvn tomcat:run' (OR 'mvn jetty:run') 
and then point the browser @ http://localhost:8080/topper/ (OR http://localhost:8080/)


JAXB classes
--------------
The JAXB classes (requires JDK 6) are generated as follows- 
$ xjc -p org.jostho.zurich.jaxb -d src/main/java -target 2.0 src/main/resources/org/jostho/zurich/GetUser.xsd


WSDL
--------
The wsdl is available at src/test/resources/wsdl/getuser.wsdl. The wsdl is also exposed automatically
$ curl http://localhost:8080/zurich/getuser.wsdl


Firing requests
-----------------
Requests can be fired through curl
$ curl -i -H 'Content-type: text/xml' -d @src/test/resources/examples/GetUserRQ.xml http://localhost:8080/zurich/


Web server
--------------
For tomcat
$ sed -i 's/{.*.home}/{catalina.home}/' src/main/resources/log4j.xml
For jetty
$ sed -i 's/{.*.home}/{jetty.home}/' src/main/resources/log4j.xml