#!/bin/bash

shopt -s expand_aliases

export JAVA_HOME=/Users/dweiss/Library/Java/JavaVirtualMachines/corretto-21.0.4/Contents/Hom

javac --add-modules jdk.incubator.vector --release 21 VectorMultiplication.java
java  --add-modules jdk.incubator.vector -cp . VectorMultiplication

export JAVA_HOME=/opt/homebrew/Cellar/openjdk/23.0.1/libexec/openjdk.jdk/Contents/Home

javac --add-modules jdk.incubator.vector VectorMultiplication.java
java  --add-modules jdk.incubator.vector -cp . VectorMultiplication

# class not found.
java  -cp . VectorMultiplication


# bypassing --enable-preview by exporting java.lang.foreign to all unnamed through java.lang.foreign, then
# patching java.base with java.lang.foreign API equivalents that are stripped of the preview flag annotation.
# 
# javac --add-modules jdk.incubator.vector --add-exports java.base/java.lang.foreign=ALL-UNNAMED 
#       --patch-module java.base=/Users/dweiss/work/apache/lucene/lucene/core/src/generated/jdk/jdk21.apijar  VectorMultiplication.java 
# java --add-modules jdk.incubator.vector -cp . VectorMultiplication


# javac --add-exports java.base/jdk.incubator.vector=ALL-UNNAMED --add-exports java.base/java.lang.foreign=ALL-UNNAMED
#       --patch-module java.base=/Users/dweiss/work/apache/lucene/lucene/core/src/generated/jdk/jdk21.apijar   VectorMultiplication.java 
# java  --add-modules jdk.incubator.vector -cp . VectorMultiplication


# project structure:

core
core.services.jdk21 # contains jdk.incubator.vector dependent code. requires --add-modules jdk.incubator.vector but should load even without it (?)
