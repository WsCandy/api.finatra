#!/bin/bash

pid=`ps aux | grep api.finatra | awk '{print $2}'`
sudo kill -9 $pid