#!/usr/bin/env groovy

import com.example.Git

def call(String message) {
    return new Git(this).commit(message)
}
