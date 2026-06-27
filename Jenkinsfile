pipeline {
    agent any
     
    environment {
        DOCKER_IMAGE = "gopikrishnadockerpractie/employee-management:latest"
    }
stage('Docker Push') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub-creds',
                    usernameVariable: 'gopikrishnadockerpractie',
                    passwordVariable: 'Gopikrishna'
                )]) {
                    sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'
                    sh 'docker push $DOCKER_IMAGE'
                }
            }
        }
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
        sh 'kubectl apply -f deployment.yaml'
        sh 'kubectl get pods'
    }
}
        }
    }

