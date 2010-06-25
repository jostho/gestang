README 
--------

Houston is a webapp to demonstrate a simple spring webmvc application using 
spring security.


Environment
-------------
  * jdk 1.6.0
  * tomcat 6.0 / jetty 6.1 
  * eclipse 3.5 (galileo)
  * maven 2.0
  * firefox 3.5  
  
  
Build
--------

NOTE - The dependencies are pulled from the m2 central repository - http://repo1.maven.org/maven2/. 
Make sure you are connected to the network, when doing the first build.
 
To build the app, use 
$ mvn    

To run the webapp, copy houston.war to webapps folder in tomcat / jetty. 
Else run it using the maven plugin ('mvn tomcat:run' OR 'mvn jetty:run') and 
then point the browser @ http://localhost:8080/houston/

