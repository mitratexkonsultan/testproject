pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                withSonarQubeEnv('SonarQube') {
                    sh "/var/jenkins_home/sonar-scanner/sonar-scanner-6.2.1.4610-linux-x64/bin/sonar-scanner"
                }
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
