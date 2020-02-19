#!/bin/sh

pathfromcopy="/home/info-harsh/workspace/Training Project/Web Application/tuitionManagementSystem"
tomcatpath="/home/info-harsh/workspace/jars/apache-tomcat-9.0.8"

warname="tms.war"
foldername="tms"
rm "$tomcatpath/webapps/$warname"
rm -r "$tomcatpath/webapps/$foldername"


cp "$pathfromcopy/target/$warname" "$tomcatpath/webapps/$warname"

"$tomcatpath/bin/startup.sh"

