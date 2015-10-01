# Helloworld sample


How to run the sample  
------------------------------------------
1. Use maven to build the sample 
```
mvn clean package 
```
2. Use following command to run the application 
```
java -jar target/Helloworld-WSO2-Mss-1.0.0-SNAPSHOT.jar
```
How to test the sample  
------------------------------------------

Use following cURL.  
```
curl -v http://10.100.1.207:8080/hello/user 
```
