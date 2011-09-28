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
  echo "Usage: $0 {tomcat|jetty|mysql|postgresql|tc-my|tc-pg|jt-my|jt-pg}"
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


#
# server config
#

# change SERVER_NAME property in build.properties
if [ "tomcat" == "$SERVER" ] ; then
  sed -i 's/{.*.home}/{catalina.home}/' src/main/resources/log4j.xml
elif [ "jetty" == "$SERVER" ] ; then
  sed -i 's/{.*.home}/{jetty.home}/' src/main/resources/log4j.xml
fi      


#
# database config
#

JDBCDRIVER=
JDBCURL=

if [ "mysql" == "$DATABASE" ] ; then
  JDBCDRIVER="com.mysql.jdbc.Driver"
  JDBCURL="jdbc:mysql:\/\/localhost:3306\/topper"

  # hbm.xml change to remove postgres specific sequence
  sed -i '/<param name="sequence">employees_id_seq/d' \
        src/main/resources/org/jostho/topper/domain/employee.hbm.xml

elif [ "postgresql" == "$DATABASE" ] ; then
  JDBCDRIVER="org.postgresql.Driver"
  JDBCURL="jdbc:postgresql:\/\/localhost:5432\/topper"

  # hbm.xml change to add postgres specific sequence
  sed -i '/generator class="native"/a \
        <param name="sequence">employees_id_seq</param> ' \
        src/main/resources/org/jostho/topper/domain/employee.hbm.xml
fi

if [ -n "$JDBCDRIVER" -a -n "$JDBCURL" ] ; then
  sed -i -e "s/jdbc.driverClassName=.*/jdbc.driverClassName=$JDBCDRIVER/" \
    -e "s/jdbc.url=.*/jdbc.url=$JDBCURL/" src/main/resources/jdbc.properties

  # black magic using back references
  sed -i -e "s/\(driverClassName=\"\).*\"/\1$JDBCDRIVER\"/" \
    -e "s/\(url=\"\).*\"/\1$JDBCURL\"/" src/main/webapp/META-INF/context.xml
  sed -i -e "s/\(driverClassName\">\).*</\1$JDBCDRIVER</" \
    -e "s/\(url\">\).*</\1$JDBCURL</" src/main/webapp/WEB-INF/jetty-env.xml
fi

