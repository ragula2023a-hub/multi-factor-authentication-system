pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/ragula2023a-hub/multi-factor-authentication-system.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t mfa-service .'
            }
        }

        stage('Docker Run') {
            steps {
                bat 'docker run -d -p 8080:8080 mfa-service'
            }
        }
    }

    post {
        always {
            echo 'Pipeline finished'
        }
    }
}