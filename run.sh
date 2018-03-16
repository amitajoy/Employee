#!/usr/bin/env bash
#mvn spring-boot:run -Drun.jvmArguments='-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005' -Dtc.log.dir=logs -Dlc.investorprofile=local
mvn spring-boot:run -Drun.jvmArguments='-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005'
