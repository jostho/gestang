#!/bin/bash

# profile.sh
# script to change the topper profile

# supported servers - tomcat, jetty 
# supported databases - mysql, postgresql 
# the default profile is "tomcat mysql"

# entity variables
SERVER=
DATABASE=

# read arguments
case $1 in 
tomcat|tc) 
  SERVER=tomcat
  ;; 
jetty|jt) 
  SERVER=jetty
  ;;
mysql|my) 
  DATABASE=mysql
  ;; 
postgresql|pg) 
  DATABASE=postgresql
  ;;
tomcat-mysql|tc-my) 
  SERVER=tomcat
  DATABASE=mysql
  ;; 
tomcat-postgresql|tc-pg) 
  SERVER=tomcat
  DATABASE=postgresql
  ;; 
jetty-mysql|jt-my) 
  SERVER=jetty
  DATABASE=mysql
  ;;
jetty-postgresql|jt-pg) 
  SERVER=jetty
  DATABASE=postgresql
  ;;
esac

# function to print usage and exit
usage() {
  echo "Changes topper profile to the provided 'server' 'database' combination"
  echo "Usage: $0 {tomcat|jetty|mysql|postgresql|tomcat-mysql|tomcat-postgresql|jetty-mysql|jetty-postgresql}"
  exit 2
}

# if both are empty, print usage
if [ -z "$SERVER" -a -z "$DATABASE" ] ; then
  usage
fi 

# print selected profile
echo "Using $SERVER $DATABASE"

# reach root from src/main/scripts/
cd `dirname $0`/../../..
