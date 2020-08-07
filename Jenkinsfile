pipeline {
    agent {
        docker {
            image 'maven:3.6.3-openjdk-11-slim'
            args '-v $HOME/.m2:/root/.m2'
        }
    }
    stages {
        stage('Example Stage') {
            steps {
                echo "Running ${env.BUILD_ID} on ${env.JENKINS_URL}"
            }
        }
        stage('Test') {
            steps {
                echo 'Testing...'
                sh 'mvn --version'
                sh 'unset MAVEN_CONFIG && ./mvnw test'
            }
        }
        stage('Build') {
            steps {
                echo 'Building...'
                sh 'mvn --version'
                sh 'unset MAVEN_CONFIG && ./mvnw clean package'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Not really deploying!'
                echo 'Archive the build artifacts for manual deployment'
                archiveArtifacts artifacts: 'target/*.jar'
                archiveArtifacts artifacts: 'Dockerfile'
                echo ''
                echo 'To run directly on your computer:'
                echo 'Run the command>>> java -jar <atrifact-file-name>.jar'
                echo ''
                echo 'Use with Docker:'
                echo 'Run the command>>> docker build -t equipment-rental-service .'
                echo 'Run the command>>> docker run -d -p 8081:8081 --name equipment-rental-service equipment-rental-service'
            }
            
        }
    }
}
