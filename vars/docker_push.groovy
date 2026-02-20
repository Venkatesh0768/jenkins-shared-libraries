def call(String credsId, String image1, String image2) {

    withCredentials([usernamePassword(
        credentialsId: credsId,
        usernameVariable: 'DOCKER_USER',
        passwordVariable: 'DOCKER_PASS'
    )]) {

        sh """
            set -e

            echo "\$DOCKER_PASS" | docker login -u "\$DOCKER_USER" --password-stdin

            docker push "\$DOCKER_USER/${image1}:latest"
            docker push "\$DOCKER_USER/${image2}:latest"

            docker logout
        """
    }
}
