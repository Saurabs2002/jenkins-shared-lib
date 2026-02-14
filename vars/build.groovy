def call(String ProjectName, String Image, String DockerUser){
  sh "docker build -t ${DockerUser}/${ProjectName}:${Image} ."
}
