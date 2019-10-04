pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        sh '$M2_HOME/bin/mvn spring-boot:run'
      }
    }
  }
}