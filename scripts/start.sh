#!/bin/bash
java -jar /home/ubuntu/finatra/target/scala-2.12/api-finatra-assembly-1.0.0.jar -http.port=":80" > /dev/null 2>&1 &