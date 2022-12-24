#!/usr/bin/env groovy

import com.example.Docker

def call(String credentials) {
    return new Docker(this, '').dockerLogin(credentials)
}
