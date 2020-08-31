#!/usr/bin/env bash


#make your script exit when a command fails.
set -o errexit  

#to trace what gets executed. Useful for debugging.
set -o xtrace

#to exit when your script tries to use undeclared variables.
set -o nounset


PATH_FROM_COPY="/home/info-harsh/workspace/Training/Web Application - Servlet Html/tuitionManagementSystem"
TOMCAT_PATH="/home/info-harsh/workspace/jars/apache-tomcat-9.0.8"

WAR_NAME="tms.war"
FOLDER_NAME="tms"


cd tuitionManagementSystem/
mvn clean install
rm "$TOMCAT_PATH/webapps/$WAR_NAME"
rm -r "$TOMCAT_PATH/webapps/$FOLDER_NAME"


cp "$PATH_FROM_COPY/target/$WAR_NAME" "$TOMCAT_PATH/webapps/$WAR_NAME"

"$TOMCAT_PATH/bin/startup.sh"

