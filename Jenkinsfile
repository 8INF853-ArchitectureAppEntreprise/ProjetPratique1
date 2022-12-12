#!groovy
pipeline {
    agent any
    stages {
        stage ('Compile Stage') {

            steps {
                withMaven(maven : 'maven_3_8_6') {
                    bat 'mvn clean compile'
                }
            }
        }

        stage ('Testing Stage') {

            steps {
                withMaven(maven : 'maven_3_8_6') {
                    bat 'mvn test'
                }
            }
        }


        stage ('Intalling Stage') {
            steps {
                withMaven(maven : 'maven_3_8_6') {
                    bat 'mvn install'
                }
            }
        }
    }
}