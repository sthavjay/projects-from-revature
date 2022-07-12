TEAMWW for Project-2

Project 2 will be a group project focusing on the deployment and monitoring of an application. Each group will be comprised of 3-4 team members. Each group will select one of the team members p1 to build off of.

The goal is to introduce working in a group and researching SRE principles.

Descpritions:
	
	In our project-2, we have used the item-shop Api. We have created this APi in a RESTful to allow the http request and response with the item's and user's (name and price) endpoints. we have used a docker to create container image and pushed into dockerhub.
For this project, we have use Jenkins to deploy the application to the (AWS)EKS cluster using CI/CD(continous Delivery) where we have to provide authorization at the end of the deployment process. Also, We have used a Grafana for the metrics and logs visualization which will be collected from Prometheus and loki. Also, we have used sonarcloud to catch Bugs and Security Vulnerabilities in your Pull Requests.
 
Technologies Used:
* Spring Boot/Spring MVC
* Maven,Ec2( with java 11), Eks,Jenkins.
* Prostgres using AWS postgresQL database
* Promtail, Loki, Prometheus and Grafana
* Docker and Restful API
* Hibernate and logback-spring
* Exceptions

Features:
* abled to use Jenkins pipeline for deployment to Eks cluster.
* abled to use containerized applications using docker and kubernetes.
* abled to use https verbs like get, post and pull for http request and respone.
* abled to record the log and metrics in seperate application.log using logback spring configuration.
* abled to display the log and metrics charts and table in Grafana using promtail, loki and prometheus.
* abled to use different types dependencies using Maven tools.
* abled to use containerized applications using docker and kubernetes.
* abled to use postgreSQL database using data.sql file.

useable Commands
* basic add, commit and push to push into github. 
* kubectl apply -f ./kubernetes  -> (all our deployment files are inside kubernetes folder)
* kubectl get all -n teamww -> ( able to see all the pods and containers in our namespace "teamww")
* dockerImage = docker.build "$registry" -> ( command inside the Jenkinsfile build for dockerimage )
* dockerImage.push("$currentBuild.number")  -> ( for pushing image into dockerhub)



Team Names:
Jay
Bijaya
Mahipal
Juan