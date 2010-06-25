#!/bin/bash

# deploy.sh 
# deploys topper.war to tomcat webapps

# CHANGE ME ! 
#TOMCAT_HOME=/opt/apache-tomcat-5.5.23
TOMCAT_HOME=$APPS_HOME/apache-tomcat-6.0.16

cp target/topper.war $TOMCAT_HOME/webapps
