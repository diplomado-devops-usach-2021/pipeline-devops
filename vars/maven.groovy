import helpers.*

/*
	forma de invocación de método call:
	def ejecucion = load 'script.groovy'
	ejecucion.call()
*/

def call(String pipelineType){

  figlet 'Maven'

  // stage('Tag to Master'){
  //   STAGE = env.STAGE_NAME
  //   figlet "Stage: ${env.STAGE_NAME}"

  //   def git = new helpers.Git()
  //   git.tag(env.GIT_LOCAL_BRANCH)

  //   println "${env.STAGE_NAME} realizado con exito"
  // }

  figlet 'Integracion Continua'

  stage('Compile') {
    STAGE = env.STAGE_NAME
    sh './mvnw clean compile -e'
  }

  stage('Test') {
    STAGE = env.STAGE_NAME
    sh './mvnw clean test -e'
  }

  stage('Jar') {
    STAGE = env.STAGE_NAME
    sh './mvnw clean package -e'
  }
  
  stage('Run') {
    STAGE = env.STAGE_NAME
    sh 'nohup bash mvnw spring-boot:run &'
    sleep 20
  }
  
  stage('TestApp') {
    STAGE = env.STAGE_NAME
    sh "curl -X GET 'http://localhost:8081/rest/mscovid/test?msg=testing'"
  }

}

return this;