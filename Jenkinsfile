#!groovy

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
  //Una sección que define las herramientas para “autoinstalar” y poner en la PATH
  tools {
    jdk 'JDK11_Centos' //Preinstalada en la Configuración del Master
    gradle 'Gradle5.0_Centos' //Preinstalada en la Configuración del Master
  }
  //Aquí comienzan los “items” del Pipeline
  stages {
    stage('Checkout') {
      steps {
        echo "------------>Checkout<------------"
        checkout([
          $class: 'GitSCM',
          branches: [[name: '*/master']],
          doGenerateSubmoduleConfigurations: false,
          extensions: [],
          gitTool: 'Git_Centos',
          submoduleCfg: [],
          userRemoteConfigs: [[
            credentialsId: 'GitHub_Mateolegi',
            url:'https://github.com/Mateolegi/ADN-Ceiba'
          ]]
        ])
      }
    }
    stage('Build') {
      steps {
        echo "------------>Build<------------"
        dir("server") {
          //Construir sin tarea test que se ejecutó previamente
          sh 'gradle build -x test'
        }
      }
    }
    stage('Tests') {
      steps {
        echo "------------>Unit Tests<------------"
        dir("server") {
          sh 'gradle test'
        }
      }
    }
    stage('Static Code Analysis') {
      steps {
        echo '------------>Análisis de código estático<------------'
        withSonarQubeEnv('Sonar') {
          // sh "${tool name: 'SonarScanner',type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner"
          sh 'gradle sonarqube'
        }
      }
    }
  }
  post {
    always {
      echo 'This will always run'
    }
    success {
      echo 'This will run only if successful'
      junit 'server/**/build/test-results/test/*.xml'
    }
    failure {
      echo 'This will run only if failed'
      mail (to: 'mateo.leal@ceiba.com.co', subject: "Failed Pipeline:${currentBuild.fullDisplayName}",
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
