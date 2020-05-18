  pipeline {

    agent any
 			tools {
        maven 'Maven_3.6.3' 
   			}
   	 stages {
 		stage('Build') {
            steps {
                 bat 'mvn clean package ' 
       			 }
        
  			  }

       		 stage('Sonarqube Analysis') {
            steps {
            	withSonarQubeEnv('sonar'){
                 bat 'mvn clean package sonar:sonar' 
       				 }
        		}
   		 }

	  stage('Quality Gate Status Check') {
            steps {
                timeout(time: 1, unit: 'HOURS') {
                    waitForQualityGate abortPipeline: true
                }
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
    
    post {
    		always {
      			 mail to: 'nareshrangam99@gmail.com',
          		subject: "Status of pipeline: ${currentBuild.fullDisplayName}",
          body: "${env.BUILD_URL} has result ${currentBuild.result}"
    }
  }
}






 