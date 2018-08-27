pipeline {
    //Donde se va a ejecutar el Pipeline
    agent {
        label 'Slave_Induccion'
    }
    //Opciones específicas de Pipeline dentro del Pipeline
    options {
        //Mantener artefactos y salida de consola para el # específico de ejecuciones recientes del Pipeline.
        buildDiscarder(logRotator(numToKeepStr: '3'))
        //No permitir ejecuciones concurrentes de Pipeline
        disableConcurrentBuilds()
    }
    //Una sección que define las herramientas para autoinstalar y poner en la PATH
    tools {
        jdk 'JDK8_Centos' //Preinstalada en la Configuración del Master
        gradle 'Gradle4.5_Centos' //Preinstalada en la Configuración del Master
    }
    //Aquí comienzan los items del Pipeline
    stages {
        stage('Checkout') {
            steps {
                echo "------------>Checkout<------------"
                checkout([$class                           : 'GitSCM',
                          branches                         : [[name: '*/master']],
                          doGenerateSubmoduleConfigurations: false,
                          extensions                       : [],
                          gitTool                          : 'Git_Centos',
                          submoduleCfg                     : [],
                          userRemoteConfigs                : [[credentialsId: 'GitHub_01dalkon',
                                                               url          : 'https://github.com/01dalkon/ProyectCB']]])
            }
        }
        
        stage('Unit Tests') {
            steps {
                echo "------------>Unit Tests<------------"
                sh 'gradle --b ./build.gradle cleanTest test'
                sh 'gradle --b ./build.gradle test'
                junit '**/build/test-results/*.xml'
                jacoco classPattern:'**/build/classes/java', execPattern:'**/build/jacoco/jacocoTest.exec', sourcePattern:'**/src/main/java'
            }
        }

        stage('Integration Tests') {
            steps {
                echo "------------>Integration Tests<------------"
            }
        }
        stage('Static Code Analysis') {
            steps {
                echo '------------>Analisis de c�digo estatico<------------'
                withSonarQubeEnv('Sonar') {
                    sh "${tool name: 'SonarScanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner "
                }
            }
        }
        stage('Build') {
			steps {
		 		echo "------------>Build<------------"
		 		sh 'gradle --b ./build.gradle build -x test'
		 	}
		}
	}
    
    post {
        always {
            echo 'This will always run'
        }
        success {
            echo 'This will run only if successful'
        }
        failure {
            echo 'This will run only if failed'
            mail(to: 'jonathan.munoz@ceiba.com.co',
                    subject: "Failed Pipeline:${currentBuild.fullDisplayName}",
                    body: "Something is wrong with ${env.BUILD_URL}")
        }

        unstable {
            echo 'This will run only if the run was marked as unstable'
        }
        changed {
            echo 'This will run only if the state of the Pipeline has changed'
            echo 'For example, if the Pipeline was previously failing but is now successful'
        }
    }
}