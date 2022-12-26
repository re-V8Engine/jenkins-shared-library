#!/usr/bin/env groovy

import com.example.Git

def call(String branchName) {
    return new Git(this).push(branchName)
}
