#!/usr/bin/env bash

pwd

cd ..

pwd

### compile angular
cd angularUI
ng build

### copy angular scripts to static folder
cp dist/ordproc-ui/* ../src/main/resources/static

pwd

### make the build
cd ..
./gradlew build