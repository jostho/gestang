#!/bin/bash

# profile.sh
# script to change the topper profile

# supported servers - tomcat, jetty 
# supported databases - mysql, postgresql 
# the default profile is "tomcat mysql"

# entity variables
SERVER=
DATABASE=

# print usage and exit
usage() {
  echo "Changes topper profile to the provided 'server' 'database' combination"
  echo "Usage: $0 {tomcat|jetty} {mysql|postgresql}"
  exit 2
}

# read server, 1st arg
case $1 in 
tomcat|tc) 
  SERVER=tomcat
  ;; 
jetty|jt) 
  SERVER=jetty
  ;;
esac

# read database, 2nd arg
case $2 in 
mysql|my) 
  DATABASE=mysql
  ;; 
postgresql|pg) 
  DATABASE=postgresql
  ;;
esac

# if either is null, print usage
# TODO fix this to support just a single entity  
if [ -z "$SERVER" -o -z "$DATABASE" ] ; then
  usage
fi 

# reach root from src/main/scripts/
cd `dirname $0`/../../..

