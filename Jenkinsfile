#!/usr/bin/env groovy

pipeline {
    agent any
    tools {
        maven 'maven'
        jdk 'java'
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }

        stage ('Build') {
        steps{
        withSonarQubeEnv('sonar') {
        sh 'mvn clean package sonar:sonar'
        } 
    }
        
        
         //   steps {
        //       sh 'mvn -Dmaven.test.failure.ignore=true install sonar:sonar' 
        //    }
        //    post {
          //      success {
            //        junit 'target/surefire-reports/**/*.xml' 
              //  }
        //    }
        }
        stage("Quality Gate"){
        steps{
        script{
        // sonar plugins 
        // http://192.168.50.4:8080/configure add sonar qube 
        //http://192.168.50.4:9000/settings?category=webhooks add  http://192.168.50.4:8080/sonarqube-webhook/ !!!
  timeout(time: 1, unit: 'MINUTES') { // Just in case something goes wrong, pipeline will be killed after a timeout
     qg = waitForQualityGate() // Reuse taskId previously collected by withSonarQubeEnv
    if (qg.status != 'OK') {
      error "Pipeline aborted due to quality gate failure: ${qg.status}"
    }
  }
}}
}
    }
}
