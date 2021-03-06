pipeline {
    //Donde se va a ejecutar el Pipeline
    agent {
        label 'Slave_Induccion'
    }

    //Opciones específicas de Pipeline dentro del Pipeline
    options {
        buildDiscarder(logRotator(numToKeepStr: '3'))
        disableConcurrentBuilds()
        timeout(time: 15, unit: 'MINUTES')
    }

    //Una sección que define las herramientas “preinstaladas” en Jenkins
    tools {
        jdk 'JDK8_Centos' //Preinstalada en la Configuración del Master
        gradle 'Gradle4.5_Centos' //Preinstalada en la Configuración del Master
    }

    //Aquí comienzan los “items” del Pipeline
    stages{
        stage('Checkout') {
            steps{
                echo "------------>Checkout<------------"
                checkout([
                    $class: 'GitSCM', 
                    branches: [[name: '*/master']], 
                    doGenerateSubmoduleConfigurations: false, 
                    extensions: [], 
                    gitTool: 'Default', 
                    submoduleCfg: [], 
                    userRemoteConfigs: [[
                        credentialsId: 'GitHub_cesarcanasceiba', 
                        url:'https://github.com/cesarcanasceiba/copipet-app.git'
                    ]]
                ])

            }
        }
        
        stage('Compile & Unit Tests') {
            steps{
                echo "------------>Unit Tests<------------"
                sh 'chmod +x ./petshop_ms/gradlew'
                sh './petshop_ms/gradlew --b ./petshop_ms/build.gradle clean compileJava'
                sh './petshop_ms/gradlew --b ./petshop_ms/build.gradle test'

            }
        }

        stage('Static Code Analysis') {
            steps{
                echo '------------>Análisis de código estático<------------'
                withSonarQubeEnv('Sonar') {
                    sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner"
                }
            }
        }

        stage('Build') {
            steps {
                echo "------------>Build<------------"
                sh './petshop_ms/gradlew --b ./petshop_ms/build.gradle build -x test'
            }
        }
    }

    post {
        always {
            echo 'This will always run'
        }
        success {
            echo 'This will run only if successful'
            junit 'petshop_ms/dominio/build/test-results/test/*.xml'
        }
        failure {
            echo 'This will run only if failed'
            mail (to: 'cesar.canas@ceiba.com.co',subject: "Failed Pipeline:${currentBuild.fullDisplayName}",body: "Something is wrong with ${env.BUILD_URL}")

        }
        unstable {
            echo 'This will run only if the run was marked as unstable'
        }
        changed {
            echo 'This will run only if the state of the Pipeline has changed'
            echo 'For example, if the Pipeline was previously failing but is now successful'
        }
    }
}
