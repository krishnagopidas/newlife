pipeline {
    agent any

    stages {

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t employee-management .'
            }
        }

       stage('Deploy to K3s') {
    steps {
        sh 'sudo k3s kubectl apply -f deployment.yaml'
        sh 'sudo k3s kubectl get pods'
    }
}
        }
    }

