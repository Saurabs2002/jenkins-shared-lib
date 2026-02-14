def call(String project, String imageTag) {

    withCredentials([usernamePassword(
        credentialsId: 'docker-hub',
        usernameVariable: 'DOCKER_USER',
        passwordVariable: 'DOCKER_PASS'
    )]) {

        sh """
            echo \$DOCKER_PASS | docker login -u \$DOCKER_USER --password-stdin
            docker tag ${project}:${imageTag} \$DOCKER_USER/${project}:${imageTag}
            docker push \$DOCKER_USER/${project}:${imageTag}
        """
    }

    echo "Docker image pushed successfully!"
}
