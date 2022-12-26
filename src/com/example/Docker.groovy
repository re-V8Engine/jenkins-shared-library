#!/usr/bin/env groovy

package com.example

class Docker implements Serializable {

    def script
    def imageName
    Docker(script, String imageName) {
        this.script = script
        this.imageName = imageName
    }

    def dockerLogin(String credentials) {
        script.echo "Docker login..."
        script.withCredentials([script.usernamePassword(credentialsId: credentials, passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
            script.sh "echo $script.PASSWORD | docker login -u $script.USERNAME --password-stdin"

        }
    }

    def dockerBuild(String context) {
        script.echo "Building image..."
        script.sh "docker build -t $imageName $context"
    }

    def dockerPush() {
        script.echo "Pushing image to remote repo..."
        script.sh "docker push $imageName"
    }
}