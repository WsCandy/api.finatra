#!/bin/bash

pid=`ps aux | grep api.finatra | awk '{print $2}'`
kill -9 $pid