  
pipeline {

    agent any
 tools {
        maven 'Maven_3.6.3' 
    }
    stages {

        stage('Build stage') {
            steps {
                bat 'mvn clean package' 
        }
        
    }

        stage ('Deploy') {
            steps {

                withCredentials([[$class          : 'UsernamePasswordMultiBinding',
                                  credentialsId   : 'PCF_LOGIN',
                                  usernameVariable: 'USERNAME',
                                  passwordVariable: 'PASSWORD']]) {
                                  echo usernameVariable
                                  echo 'hello'
                                  echo $USERNAME
                    bat 'cf login -a https://api.run.pivotal.io -u $USERNAME -p $PASSWORD'
                }
            }

        }

    }

}


 cf login -a https://api.example.com -u username@example.com -o example-org -s development