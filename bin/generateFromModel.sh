#!/bin/bash

scriptPos=${0%/*}

if [ -z "$JSONCODEGEN_HOME" ]; then
    echo "JSONCODEGEN_HOME not set"
    exit 1
fi

if ! [ -f "$JSONCODEGEN_HOME/jsonCodeGen.sh" ]; then
    echo "JSONCODEGEN_HOME doesn't contain start script jsonCodeGen.sh"
    echo "JSONCODEGEN_HOME: $JSONCODEGEN_HOME"
    exit 1
fi

$JSONCODEGEN_HOME/jsonCodeGen.sh -g plantuml -o docs -m model/example.json \
  -gp removeEmptyLines=true


# generate all beans that are saved in own mongodb collections
$JSONCODEGEN_HOME/jsonCodeGen.sh -g java_generic_derived_beans -o src/main/java -m model/example.json \
    -gp packageName=de.oth.mongodbtest.model.beans \
    -gp genericClass=de.oth.mongodbtest.mongodb.MongoDbConnection \
    -gp containsAttrib=gid

# generate all beans that are pure pojos
$JSONCODEGEN_HOME/jsonCodeGen.sh -g java_beans -o src/main/java -m model/example.json \
    -gp packageName=de.oth.mongodbtest.model.beans \
    -gp missingAttrib=gid
