# SimpleJPA samples



Database creation (In-memory H2 database) 
------------------------------------------
 1  Comment out following section on application.properties file. 
```
#spring.datasource.url=jdbc:mysql://localhost:3306/users
#spring.datasource.username=root
#spring.datasource.password=root
#spring.datasource.driver-class-name=com.mysql.jdbc.Driver
#spring.jpa.hibernate.ddl-auto=none
#spring.jpa.generate-ddl=false
#spring.jpa.properties.hibernate.hbm2ddl.auto=none
#spring.jpa.show-sql=true
```
2  Update pom.xml file by removing MySQL connector and intoducing H2 driver. 
```
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>runtime</scope>
        </dependency>
        <!--<dependency>-->
            <!--<groupId>mysql</groupId>-->
            <!--<artifactId>mysql-connector-java</artifactId>-->
        <!--</dependency>--> 
```

3  Copy schema.sql file into spring-boot/src/main/resources directory.  

Database creation (MySQL database) 
------------------------------------------
1. Run db.sql script on db-script directory. 
```
mysql -u user -p  < db.sql
```
2.  Update the values on application.properties file. 
``` 
spring.datasource.url=jdbc:mysql://localhost:3306/users
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.jpa.hibernate.ddl-auto=none
spring.jpa.generate-ddl=false
spring.jpa.properties.hibernate.hbm2ddl.auto=none
spring.jpa.show-sql=true
  ```
 3. Update pom.xml file by removing H2 driver and intoducing  MySQL connector. 
 ```
         <!--<dependency>-->
            <!--<groupId>com.h2database</groupId>-->
            <!--<artifactId>h2</artifactId>-->
            <!--<scope>runtime</scope>-->
        <!--</dependency>-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
 ```
  
How to run the sample  
------------------------------------------
1. Use maven to build the sample 
```
mvn clean package 
```
2. Use following command to run the application 
```
java -jar target/SimpleJPA-Spring-Boot-1.0.0.jar 
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





