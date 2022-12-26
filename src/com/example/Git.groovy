#!/usr/bin/env groovy

package com.example

class Git implements Serializable {

    def script

    Git(script) {
        this.script = script
    }

    def setRemote(String credentials, String repoUrl) {
        script.withCredentials([script.string(credentialsId: credentials, variable: 'TOKEN')]) {
            script.sh "git remote set-url origin https://$script.TOKEN@$repoUrl"
        }
    }

    def addAll() {
        script.sh 'git add .'
    }

    def commit(String message) {
        script.sh "git commit -m '$message'"
    }

    def push(String branchName) {
        script.sh "git push origin HEAD:$branchName"
    }
}