#!/bin/bash

#containerId=`docker ps | grep "mongo-db-test_mongo.1." | sed -e "s/.*mongo-db-test_mongo/mongo-db-test_mongo/"`
containerId=`docker ps | grep "mongo-db-test_mongo.1."| sed -e "s/.*mongo-db-test_mongo/mongo-db-test_mongo/"` 
echo "containerId: $containerId"
docker exec -it "$containerId" mongo
