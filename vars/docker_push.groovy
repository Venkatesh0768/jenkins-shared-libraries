def call(String credsId , String image1 , String image2){
 
                withCredentials([usernamePassword(
                    credentialsId: "${credsId}",
                    usernameVariable: "dockerHubUser",
                    passwordVariable: "dockerHubPass"
                )]) {

                    sh """
                        echo "${env.dockerHubPass}" | docker login -u "${env.dockerHubUser}" --password-stdin
                        docker push ${env.dockerHubUser}/${image1}:latest
                        docker push ${env.dockerHubUser}/${image2}:latest
                        docker logout
                    """
                }
            }
        }

}
