pipeline { 
    agent nodejs 
    }
    stages {
        stage('git-pull') { 
            steps { 
                git branch: 'main', credentialsId: '08bf9e1a-a236-48ad-9fe3-254ea8ff0bcf', url: 'https://github.com/miroslavpejic85/mirotalk.git'
            }
        }
        stage('Deploy') {
            steps {
                sh '''
                cd mirotalk
                cp .env.template .env
                npm install
                npm start
                '''
            }
        }
    }
}
