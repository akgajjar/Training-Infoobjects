#!/usr/bin/env bash


#make your script exit when a command fails.
set -o errexit  

#to trace what gets executed. Useful for debugging.
set -o xtrace

#to exit when your script tries to use undeclared variables.
set -o nounset


TOMCAT_PATH="/home/info-harsh/workspace/jars/apache-tomcat-9.0.8"


"$TOMCAT_PATH/bin/shutdown.sh"
