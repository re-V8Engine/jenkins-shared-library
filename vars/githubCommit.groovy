#!/usr/bin/env groovy

import com.example.Github

def call(String message) {
    return new Github(this).commit(message)
}
