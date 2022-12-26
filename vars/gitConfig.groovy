#!/usr/bin/env groovy

import com.example.Git

def call(String email, String name) {
    return new Git(this).config(email, name)
}
