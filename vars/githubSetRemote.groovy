#!/usr/bin/env groovy

import com.example.Github

def call(String credentials, String repoUrl) {
    return new Github(this).setRemote(credentials, repoUrl)
}
