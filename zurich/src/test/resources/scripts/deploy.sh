#!/bin/bash

# deploy.sh 
# deploys zurich.war to tomcat webapps

# CHANGE ME ! 
#TOMCAT_HOME=/opt/apache-tomcat-5.5.23
TOMCAT_HOME=$APPS_HOME/apache-tomcat-6.0.16

cp target/zurich.war $TOMCAT_HOME/webapps
