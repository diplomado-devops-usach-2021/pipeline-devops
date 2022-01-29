/*
	forma de invocación de método call:
	def ejecucion = load 'script.groovy'
	ejecucion.call()
*/

def call(String pipelineType){

  figlet pipelineType

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