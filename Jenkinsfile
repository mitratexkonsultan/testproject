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
              withSonarQubeEnv(credentialsId: 'squ_861eda3b9648f22ea628cd558f685fbf86f936b6', installationName: 'SonarQube') {
                sh "${scannerHome}/bin/sonar-scanner"
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
