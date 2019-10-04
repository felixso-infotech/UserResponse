pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        sh '$M2_HOME/mvn spring-boot:run'
      }
    }
  }
}