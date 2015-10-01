# SimpleJPA samples



Database creation (In-memory H2 database) 
------------------------------------------
1. Uncomment following section on config.yml file. 
```
database:
  driverClass: org.h2.Driver
  user: sa
  password: sa
  url: jdbc:h2:./example
```
2. Use maven to build the sample 
```
mvn clean package 
```

3. Use Dropwizard migrate command to create database.
```
java -jar target/SimpleJPA-Dropwizard-1.0.0.jar db migrate config.yml
```

Database creation (MySQL database) 
------------------------------------------
1. Run db.sql script on db-script directory. 
```
mysql -u user -p  < db.sql
```
2.  Uncomment following section on config.yml file. 
``` 
database:
    driverClass: com.mysql.jdbc.Driver
    user: user
    password: password
    url: jdbc:mysql://localhost:3306/users
  ```
  
  
  
How to run the sample  
------------------------------------------
1. Use maven to build the sample 
```
mvn clean package 
```
2. Use following command to run the application 
```
java -jar target/SimpleJPA-Dropwizard-1.0.0.jar server config.yml
```
How to test the sample  
------------------------------------------

Add few users using cURL.  
```
curl -v -X POST http://<host-ip>:8080/users/fname/jhon/lname/snow

curl -v -X POST http://<host-ip>:8080/users/fname/peter/lname/crow 
```

Access above entires from database.

```
curl -v -X GET http://<host-ip>:8080/users/1

curl -v -X GET http://<host-ip>:8080/users/2

curl -v -X GET http://<host-ip>:8080/users
```





