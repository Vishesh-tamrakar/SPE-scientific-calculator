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
                    docker login -u $DOCKER_USER -p $DOCKER_PASS
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

        always {
            echo "Pipeline finished"
        }

        success {
            emailext(
                to: 'visheshtamrakar1@gmail.com',
                subject: "SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
Build succeeded.

Job: ${env.JOB_NAME}
Build Number: ${env.BUILD_NUMBER}

Pipeline completed successfully.

Console Output:
${env.BUILD_URL}
""",
                recipientProviders: [developers(), requestor()]
            )
        }

        failure {
            emailext(
                to: 'visheshtamrakar1@gmail.com',
                subject: "FAILED: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
Build failed.

Job: ${env.JOB_NAME}
Build Number: ${env.BUILD_NUMBER}

Check Jenkins console logs:
${env.BUILD_URL}
""",
                recipientProviders: [developers(), requestor()]
            )
        }

    }
}