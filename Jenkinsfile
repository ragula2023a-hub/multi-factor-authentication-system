pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Clone your GitHub repo
                git 'https://github.com/ragula2023a-hub/multi-factor-authentication-system.git'
            }
        }

        stage('Build') {
            steps {
                // Build using Maven
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                // Run JUnit tests
                sh 'mvn test'
            }
        }

        stage('Docker Build') {
            steps {
                // Build Docker image
                sh 'docker build -t mfa-service .'
            }
        }

        stage('Docker Run') {
            steps {
                // Run Docker container
                sh 'docker run -d -p 8080:8080 mfa-service'
            }
        }
    }

    post {
        always {
            echo 'Pipeline finished'
        }
    }
}