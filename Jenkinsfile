pipeline {
    agent any
     
    environment {
        DOCKER_IMAGE = "gopikrishnadockerpractie/employee-management:latest"
    }
stages{
stage('Docker Push') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub-creds',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {
                    sh '''
                        echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin
                        docker push $DOCKER_IMAGE
                    '''
                }
            }
        }
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

