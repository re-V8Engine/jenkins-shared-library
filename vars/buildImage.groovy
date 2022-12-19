def call() {
    echo "Building docker image..." 
    withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
        sh "docker build -t v8engine/java-maven-app:1.4.0 ."
        sh "echo ${PASSWORD} | docker login -u ${USERNAME} --password-stdin"
        sh "docker push v8engine/java-maven-app:1.4.0"
    }
}

