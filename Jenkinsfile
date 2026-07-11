pipeline {
    agent any

    tools {
        jdk 'JDK21'
        maven 'Maven'
    }

    stages {

        stage('Build') {
            steps {
                dir('empbackend') {
                    bat 'mvn clean compile'
                }
            }
        }

        stage('Test') {
            steps {
                dir('empbackend') {
                    bat 'mvn test'
                }
            }
        }

        stage('Package') {
            steps {
                dir('empbackend') {
                    bat 'mvn clean package -DskipTests'
                }
            }
        }

        stage('Deploy') {
            steps {
                bat '''
                if not exist C:\\deploy mkdir C:\\deploy
                copy /Y empbackend\\target\\empbackend-0.0.1-SNAPSHOT.jar C:\\deploy\\employee-service.jar
                '''
            }
        }

        stage('Start Application') {
            steps {
                bat '''
                start "" java -jar C:\\deploy\\employee-service.jar --server.port=8081
                '''
            }
        }
    }

    post {
        success {
            archiveArtifacts artifacts: 'empbackend/target/*.jar', fingerprint: true
        }
    }
}
