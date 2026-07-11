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
    }
}
