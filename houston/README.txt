README 
--------

Houston is a webapp to demonstrate a simple spring webmvc application using 
spring security.


Environment
-------------
  * jdk 1.6.0
  * tomcat 7.0 / jetty 8.0
  * eclipse 3.5 (galileo)
  * maven 3.0
  
  
Build
--------

NOTE - The dependencies are pulled from the m2 central repository - http://repo1.maven.org/maven2/. 
Make sure you are connected to the network, when doing the first build.
 
To build the app, use 
$ mvn    

To run the webapp, copy houston.war to webapps folder in tomcat / jetty. 
Else run it using the maven plugin - 'mvn tomcat:run' (OR 'mvn jetty:run') 
and then point the browser @ http://localhost:8080/topper/ (OR http://localhost:8080/)


Web server
--------------
For tomcat
$ sed -i 's/{.*.home}/{catalina.home}/' src/main/resources/log4j.xml
For jetty
$ sed -i 's/{.*.home}/{jetty.home}/' src/main/resources/log4j.xml

