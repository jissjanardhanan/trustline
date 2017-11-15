#!/bin/bash

PROFILE=$1

java -jar -Dspring.profiles.active=$PROFILE target/trustline-0.0.1-SNAPSHOT.jar