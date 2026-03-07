pipeline {
    agent any

    stages {

        stage('Checkout Code') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t calculator-app .'
            }
        }

        stage('Push Docker Image') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub-creds',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {

                    sh '''
                    echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin
                    docker tag calculator-app $DOCKER_USER/calculator:latest
                    docker push $DOCKER_USER/calculator:latest
                    '''
                }
            }
        }

        stage('Deploy using Ansible') {
            steps {
                sh 'ansible-playbook -i inventory deploy.yml'
            }
        }
    }

    post {

        failure {
            emailext(
                to: 'visheshtamrakar1@gmail.com',
                from: 'visheshtamrakar1@gmail.com',
                subject: "BUILD FAILED: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
Build FAILED

Job: ${env.JOB_NAME}
Build Number: ${env.BUILD_NUMBER}

Check console output:
${env.BUILD_URL}
""",
                mimeType: 'text/plain'
            )
        }

        changed {
            emailext(
                to: 'visheshtamrakar1@gmail.com',
                from: 'visheshtamrakar1@gmail.com',
                subject: "BUILD FIXED: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
Good news!

The build has been FIXED.

Job: ${env.JOB_NAME}
Build Number: ${env.BUILD_NUMBER}

Details:
${env.BUILD_URL}
""",
                mimeType: 'text/plain'
            )
        }

    }
}