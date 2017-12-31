# Unycom Order Tracker

This project basically lets you see customers and their order details.


### Prerequisites

What things you need to install the software and how to install them

```
Apache Maven 3.2.3 or later

Apache Tomcat 8.0.48 or later
```

### Build

```
mvn clean install
```

### Deployment

Copy .war file

```
/unycom-order-tracker-j8-master/target/unycom-order-tracker-j8-1.0.war
```

to the directory:

```
/apache-tomcat-8.0.48/webapps/
```

And start the Tomcat Server. After that you will be able to see the customer list with any browser on 

```
http://localhost:8080/unycom-order-tracker-j8-1.0/
```
You can navigate to orders of the customers by clicking desired customer row. That link will take you to the Orders page of the customer. If you want to see details of the any order you can click any order.

You can navigate back to Orders of the Customer and from there to the Customer List

### H2 Database console

Database console will be reachable 

```
http://localhost:8082
```
You can access using credentials as

```
Driver Class: org.h2.Driver

JDBC URL: jdbc:h2:mem:unycom_order_tracker

User Name: sa

Password: <leave it blank>
```
### Test

You can run tests using 

```
mvn clean test
```



