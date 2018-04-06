#!/usr/bin/env bash
#mvn spring-boot:run -Drun.jvmArguments='-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005' -Dtc.log.dir=logs -Dlc.investorprofile=local
#mvn spring-boot:run -Drun.jvmArguments='-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005'

export MAVEN_OPTS="-Xmx1g -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=4000,server=y,suspend=n"
mvn spring-boot:run  -Dserver.port=8090





