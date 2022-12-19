package com.example

class Docker implements Serializable {

    def script

    Docker(script) {
        this.script = script
    }

    def buildDockerImage(String imageName) {
        script.echo "Building docker image..." 
        script.withCredentials([script.usernamePassword(credentialsId: 'dockerhub-credentials', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
            script.sh "docker build -t $imageName ."
            script.sh "echo $script.PASSWORD | docker login -u $script.USERNAME --password-stdin"
            script.sh "docker push $imageName"
        }
    }
}