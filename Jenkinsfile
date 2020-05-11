pipeline {

    agent any

tools {
        maven 'MAVEN'
        jdk 'jdk13'
    }
    stages {

        stage ('Build') {
            steps {
                 sh 'mvn -Dmaven.test.failure.ignore=true install' 
            }
        }

        stage ('Deploy') {
            steps {

                withCredentials([[$class          : 'UsernamePasswordMultiBinding',
                                  credentialsId   : 'PCF_LOGIN',
                                  usernameVariable: 'USERNAME',
                                  passwordVariable: 'PASSWORD']]) {

                    sh '/usr/local/bin/cf login -a http://api.run.pivotal.io -u $USERNAME -p $PASSWORD'
                    sh '/usr/local/bin/cf push'
                }
            }

        }

    }

}