#!/usr/bin/env bash

cd ..

### compile angular
cd angularUI
ng build

### copy angular scripts to static folder
cp dist/ordproc-ui/* ../src/main/resources/static

### make the build
cd ..
./gradlew build