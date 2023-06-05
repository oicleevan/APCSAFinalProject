#!/bin/bash

if [ ! -d "dist/" ]
then
    compile
fi

if [ "$1" = "--compile" ] 
then
    compile
fi

cd dist/
java -jar APCSAFinalProject.jar
cd ..

compile () {
    ant package
}