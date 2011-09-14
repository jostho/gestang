Overview
----------
This project provides sample code to get started with spring.

Environment
-------------
    * JDK 1.6
    * Maven 2.0
    * Tomcat 7.0 / Jetty 8.0
    * Eclipse 3.5 (galileo)

All projects requires maven 2 to build. The dependencies are pulled from the 
m2 central repository. Make sure you are connected to the network, when doing 
the first build. See the README for each project in the sources.

To setup the workspace for eclipse, run 'mvn eclipse:eclipse'. Then, import 
the projects into eclipse (import > existing projects into workspace). 
You may also need to set the M2_REPO classpath variable (pointing to your 
local maven2 repository) to get started. 

To see the dependency list for a project, run ' mvn dependency:tree'. 


Monsoon
---------
Monsoon is a simple project demonstrating the core features of spring framework.

Topper
--------
Topper is a simple web application using spring web mvc.

Houston
---------
Houston is a simple web application using spring security.

Zurich
--------
Zurich is a simple web application using spring ws.

