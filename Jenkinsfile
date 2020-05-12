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
                    bat 'cf login -a https://api.run.pivotal.io --skip-ssl-validation -u %USERNAME% -p %PASSWORD%'
                    bat 'cf push'
                }
            }

        }

    }
}






 