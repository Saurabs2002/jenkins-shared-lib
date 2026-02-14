def call(String Project, String Image, String dockeUser){
  withCredentials([usernamePassword(
            credentialsId: 'docker-hub',
            usernameVariable: 'DOCKER_USER',
            passwordVariable: 'DOCKER_PASS'
        )]) {

            sh '''
                echo $DOCKER_PASS | docker login -u ${dockerUser} --password-stdin
                docker tag ${Project}:${Image} ${dockerUser}/${Project}:${Image}
                docker push ${dockerUser}/${Project}:${Image}
            '''
        }
}
