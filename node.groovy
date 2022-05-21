pipeline { 
    agent nodejs 
    }
    stages {
        stage('git-pull') { 
            steps { 
                git 'https://github.com/sushantkamble-sys/mirotalk.git'
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