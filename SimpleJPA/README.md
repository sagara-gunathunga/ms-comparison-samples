# SimpleJPA samples



Database creation (In-memory H2 database) 
------------------------------------------
 Uncomment following section on src/main/resources/META-INF/persistence.xml file. 
```
 <properties>
            <property name="javax.persistence.jdbc.driver" value="org.h2.Driver" />
            <property name="javax.persistence.jdbc.url" value="jdbc:h2:mem:db1;DB_CLOSE_DELAY=-1;MVCC=TRUE" />
            <property name="javax.persistence.jdbc.user" value="sa" />
            <property name="javax.persistence.jdbc.password" value="" />
            
            <property name="hibernate.show_sql" value="true" />
            <property name="hibernate.hbm2ddl.auto" value="create" />
  </properties>
```


Database creation (In-memory H2 database) 
------------------------------------------
1. Run db.sql script on db-script directory. 
```
mysql -u user -p  < db.sql
```
2.  Uncomment following section on src/main/resources/META-INF/persistence.xml file. 
``` 
  <properties>
            <property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver" />
            <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/users" />
            <property name="javax.persistence.jdbc.user" value="user" />
            <property name="javax.persistence.jdbc.password" value="password" />
            
            <property name="hibernate.show_sql" value="true" />
            <property name="hibernate.connection.autocommit" value="true"/>
  </properties>
  ```
  
  
  
How to run the sample  
------------------------------------------
1. Use maven to build the sample 
```
mvn clean package 
```
2. Use following command to run the application 
```
java -jar target/hibernate-sample-1.0.0-SNAPSHOT.jar 
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





