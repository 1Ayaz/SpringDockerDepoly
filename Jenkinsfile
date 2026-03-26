pipeline{
    agent any

    environment{
        IMAGE_NAME="1ayaz/springboot123new"
        IMAGE_TAG="latest"
        EC2_HOST="ec2-52-23-209-81.compute-1.amazonaws.com"
        EC2_USER="ubuntu"
        SONARQUBE_ENV='sonarcse'
    }

    stages{

        stage('clone code'){
            steps{
                git branch: 'main', url: "https://github.com/1Ayaz/SpringDockerDepoly.git"
            }
        }
        stage('Unit Testing'){
            steps{
                bat 'mvn test'
            }
            post{
                always{
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
        stage('SonarQube Analysis'){
            steps{
                withSonarQubeEnv("${SONARQUBE_ENV}"){
                    bat 'mvn clean verify sonar:sonar'
                }
            }
        }

        stage('build jar'){
            steps{
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('build docker image'){
            steps{
                bat "docker build -t %IMAGE_NAME%:%IMAGE_TAG% ."
            }
        }

        stage('Push Image to Docker Hub'){
            steps{
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhubcred',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]){

                    bat '''
                        echo %DOCKER_PASS% | docker login -u %DOCKER_USER% --password-stdin
                        docker push %IMAGE_NAME%:%IMAGE_TAG%
                    '''
                }
            }
        }

        stage('Deploy to EC2'){
            steps{
                sshagent(['cse-server-2']){
                    bat '''
                        ssh -o StrictHostKeyChecking=no %EC2_USER%@%EC2_HOST% "sudo docker stop springboot-container1 || true && sudo docker rm springboot-container1 || true && sudo docker pull 1ayaz/springboot123new:latest && sudo docker run -d -p 8095:8095 --name springboot-container1 1ayaz/springboot123new:latest"
                    '''
                }
            }
        }

    }
}
