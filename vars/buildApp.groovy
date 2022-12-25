#!/usr/bin/env groovy

def call() {
    echo "Building jar..."
    echo "Executing on branch $BRANCH_NAME"
    sh 'mvn clean package'
}
