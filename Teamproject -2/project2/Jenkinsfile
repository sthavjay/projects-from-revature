pipeline{
    agent any 
    environment{
        registry= 'jorgemongelos/project2'
        dockerHubCreds = 'dockerhub'
        dockerImage =''
    }
    stages{
        stage('Code quality analysis'){
            steps{
                withSonarQubeEnv(credentialsId: 'sonar-token', installationName: 'sonar-scanner'){
                    sh 'mvn verify org.sonarsource.scanner.maven:sonar-maven-plugin:sonar -Dsonar.projectKey=030722-VA-SRE_TeamWW'
                }
            }
        }
        stage("Maven clean package"){
            steps{
                sh 'mvn clean package'            
            }
        }
        stage("Docker build"){
            steps{
                script{
                    dockerImage = docker.build "$registry"
                }
            }
        }
        stage("Sending docker's image to DockerHub"){
            steps{
                script{
                    docker.withRegistry('', dockerHubCreds){
                        dockerImage.push("$currentBuild.number")
                        dockerImage.push("latest")
                    }
                }
            }
        }
        stage("Waiting for approval"){
            steps{
                script{
                    // Prompt, if yes build, if no abort
                    try {
                        timeout(time: 2, unit: 'MINUTES'){
                            approved = input message: 'Deploy to production?', ok: 'Continue',
                                parameters: [choice(name: 'approved', choices: 'Yes\nNo', description: 'Deploy this build to production')]
                            if(approved != 'Yes'){
                                error('Build not approved')
                            }
                        }
                    } catch (error){
                        error('Build not approved in time')
                    }
                }
            }
        }
        stage("Deploy to production"){
            steps{
                script{
                    withAWS(credentials: 'credentials', region: 'us-east-1'){
                        sh 'curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"'
                        sh 'chmod u+x ./kubectl'
                        sh 'aws eks update-kubeconfig --name kevin-sre-1285'
                        sh './kubectl get pods -n teamww'
                        sh "echo $registry:$currentBuild.number"
                        sh "./kubectl set image -n teamww deployment/project2-deployment project2-container=$registry:$currentBuild.number"
                    }
                }
            }
        }
    }
}