#!/usr/bin/env groovy

import com.example.Docker

def call(String imageName, String context) {
    return new Docker(this, imageName).dockerBuild(context)
}
