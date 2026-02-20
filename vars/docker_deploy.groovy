def call(){
  sh """
        docker compose down || true
        docker compose pull
        docker compose up -d --build --force-recreate
     """
}
