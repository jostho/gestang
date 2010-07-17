README 
--------

Topper is a webapp to demonstrate a simple spring webmvc application.


Environment
-------------
  * jdk 1.6.0
  * tomcat 6.0 / jetty 6.1 
  * mysql 5.1 / postgresql 8.4   
  * eclipse 3.5 (galileo)
  * maven 2.0

  
Build
--------
NOTE - The dependencies are pulled from the m2 central repository - http://repo1.maven.org/maven2/. 
Make sure you are connected to the network, when doing the first build.
 
To build the app, use 
$ mvn    

To run the webapp, copy topper.war to webapps folder in tomcat / jetty. 
Else run it using the maven plugin ('mvn tomcat:run' OR 'mvn jetty:run') and 
then point the browser @ http://localhost:8080/topper/
 

Database
----------
The employee data is persisted in a database. You can choose between mysql 
or postgresql. Setup topper database using the script here - 
src/main/resources/topper.sql . 

For running tests, an H2 embedded DB is used. See the configuration here -
src/test/resources/test-topper-datasource.xml .  


Tomcat
--------
Copy jdbc driver to to $TOMCAT_HOME/lib .
 * mysql-connector-java-5.1.10.jar (for mysql)
 * postgresql-8.4-701.jdbc4.jar (for postgresql)

Jetty
-------
Copy jdbc driver to to $TOMCAT_HOME/lib .
 * mysql-connector-java-5.1.10.jar (for mysql)
 * postgresql-8.4-701.jdbc4.jar (for postgresql)
Also copy the below 2 jars to $JETTY_HOME/lib
 * commons-dbcp-1.2.2.jar
 * commons-pool-1.5.4.jar
Start Jetty with plusConfig enabled. 

TODO
-----------  
  * Mandatory fields need to be validated in add/edit screen
  * Show search box (by employeeId) in search screen

  
