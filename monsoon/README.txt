README
========

Monsoon is a sample application using spring framework. Weather service provides 
you with the weather in a particular city :-)


Environment
-------------
  1. jdk 1.6.0
  2. maven 2.0 
  3. eclipse 3.5 (galileo)


Dependencies
-------------
The dependencies are pulled from m2 central repository.
  1. spring 3.0
  2. junit 4.7  
  3. log4j 1.2.14 


Getting started
-----------------
Extract the archive to a location. Import the archive into eclipse as follows - 
Import > General > Existing projects into Workspace. 
Run 'mvn test' from the command line to test the service. You may need to set 
the 'M2_REPO' classpath variable (pointing to your local maven2 repository) to 
get started in eclipse.
  

Introduction
--------------
The 'weather service' is a typical spring application, cleanly separating out 
the service layer from the DAO layer. The simple concept is that you could 
easily plugin in a different DAO Implementation which could get the weather 
from a database or through a web service call.


How to run
-----------
The service can be launched through a JUnit test. You can launch the test either 
through eclipse or through maven.
