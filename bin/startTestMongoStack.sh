#!/bin/bash

scriptPos=${0%/*}

pushd $scriptPos/.. > /dev/null

docker stack deploy -c docker/test_mongo.yml mongo-db-test

popd > /dev/null
