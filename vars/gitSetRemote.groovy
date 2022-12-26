#!/usr/bin/env groovy

import com.example.Git

def call(String credentials, String repoUrl) {
    return new Git(this).setRemote(credentials, repoUrl)
}
