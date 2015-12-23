#!/bin/bash

PRJ="$(cd `dirname $0` && pwd)"

$JAVA_HOME/bin/java \
    -classpath $PRJ/target/classes:`cat $PRJ/target/classpath` \
    org.springdot.sandbox.asm.AnnotationScanner \
    $PRJ/target/classes/org/springdot/sandbox/asm/Scannee.class
