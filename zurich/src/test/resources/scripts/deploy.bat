@echo off

REM deploy.bat
REM deploys zurich.war to tomcat webapps

REM CHANGE ME ! 
REM set TOMCAT_HOME=C:\apps\apache-tomcat-5.5.23
set TOMCAT_HOME=C:\apps\apache-tomcat-6.0.16

copy /y target\zurich.war %TOMCAT_HOME%\webapps