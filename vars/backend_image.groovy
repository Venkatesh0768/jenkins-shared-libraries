def call(String username, String imageName, String filePath) {
    sh "docker build -t ${username}/${imageName}:latest -f ${filePath} ."
}
