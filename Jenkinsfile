pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "mfa-service"
        APP_PORT = "8080"
    }

    stages {
        // Stage 1: Checkout code from GitHub
        stage('Checkout SCM') {
            steps {
                git branch: 'main', url: 'https://github.com/ragula2023a-hub/multi-factor-authentication-system.git'
            }
        }

        // Stage 2: Build Maven project (creates JAR)
        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        // Stage 3: Run unit tests (optional, Maven already runs tests)
        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        // Stage 4: Build Docker image
        stage('Docker Build') {
            steps {
                bat "docker build -t %DOCKER_IMAGE% ."
            }
        }

        // Stage 5: Run Docker container
        stage('Docker Run') {
            steps {
                // Stop any existing container first (optional)
                bat "docker stop %DOCKER_IMAGE% || exit 0"
                bat "docker rm %DOCKER_IMAGE% || exit 0"
                
                // Run new container
                bat "docker run -d -p %APP_PORT%:8080 --name %DOCKER_IMAGE% %DOCKER_IMAGE%"
            }
        }
    }

    post {
        always {
            echo 'Pipeline finished'
        }
    }
}