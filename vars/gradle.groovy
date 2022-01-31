import helpers.*

/*
	forma de invocación de método call:
	def ejecucion = load 'script.groovy'
	ejecucion.call()
*/

def call(String pipelineType){

	figlet 'Gradle'

	if (pipelineType == 'CI'){
		figlet 'Integracion Continua'

		stage('Build & Unit Test'){
			STAGE = env.STAGE_NAME
			figlet "Stage: ${env.STAGE_NAME}"
		}

		stage('Sonar'){
			STAGE = env.STAGE_NAME
			figlet "Stage: ${env.STAGE_NAME}"
		}

		stage('Run'){
			STAGE = env.STAGE_NAME
			figlet "Stage: ${env.STAGE_NAME}"
		}

		stage('Test'){
			STAGE = env.STAGE_NAME
			figlet "Stage: ${env.STAGE_NAME}"
		}

		stage('UploadSnapshotJar'){
			STAGE = env.STAGE_NAME
			figlet "Stage: ${env.STAGE_NAME}"
		}
	} else {
		figlet 'Delivery Continuo'

		stage('DownloadSnapshotJar'){
			STAGE = env.STAGE_NAME
			figlet "Stage: ${env.STAGE_NAME}"
		}
		stage('RunSnapshotJar'){
			STAGE = env.STAGE_NAME
			figlet "Stage: ${env.STAGE_NAME}"
		}
		stage('TestSnapshotJar'){
			STAGE = env.STAGE_NAME
			figlet "Stage: ${env.STAGE_NAME}"
		}
		stage('UploadReleaseJar'){
			STAGE = env.STAGE_NAME
			figlet "Stage: ${env.STAGE_NAME}"
		}
		stage('Deploy QA'){
			STAGE = env.STAGE_NAME
			figlet "Stage: ${env.STAGE_NAME}"

			println "${env.STAGE_NAME} realizado con exito"
		}
		stage('Test QA'){
			STAGE = env.STAGE_NAME
			figlet "Stage: ${env.STAGE_NAME}"

			println "${env.STAGE_NAME} realizado con exito"
		}

		input 'Aprobacion para despliegue en Produccion'

		stage('Deploy PROD'){
			STAGE = env.STAGE_NAME
			figlet "Stage: ${env.STAGE_NAME}"

			println "${env.STAGE_NAME} realizado con exito"
		}
		stage('Test PROD'){
			STAGE = env.STAGE_NAME
			figlet "Stage: ${env.STAGE_NAME}"

			println "${env.STAGE_NAME} realizado con exito"
		}
		stage('Merge to Master'){
			STAGE = env.STAGE_NAME
			figlet "Stage: ${env.STAGE_NAME}"

			def git = new helpers.Git()
			git.merge("${env.GIT_BRANCH}",'main')

			println "${env.STAGE_NAME} realizado con exito"
		}
		stage('Merge to Develop'){
			STAGE = env.STAGE_NAME
			figlet "Stage: ${env.STAGE_NAME}"

			def git = new helpers.Git()
			git.merge("${env.GIT_BRANCH}",'develop')

			println "${env.STAGE_NAME} realizado con exito"
		}
		stage('Tag to Master'){
			STAGE = env.STAGE_NAME
			figlet "Stage: ${env.STAGE_NAME}"

			def git = new helpers.Git()
			git.tag(env.GIT_BRANCH)

			println "${env.STAGE_NAME} realizado con exito"
		}

	}
}

return this;