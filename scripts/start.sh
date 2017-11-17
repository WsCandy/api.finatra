#!/bin/bash
sudo nohup java -Dname="api.finatra" -jar finatra/target/scala-2.12/api-finatra-assembly-1.0.0.jar -http.port=":80" &