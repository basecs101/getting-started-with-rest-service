# gettting-started-with-rest-service
A sample spring boot rest application and demo rest methods
A lot of other concepts covered in readme
1. Networking
2. Logging framework and levels
3. architecture styles
4. rest methods
5. spring boot profiles
6. spring boot annotations

## ----------------- Networking Concepts ---------------
IPv4 -> 4 octets -> 4*8 =32 bits -> 2^32

1.2.3.4
255.240.10.20
------------------------
IPv6
0 -> 0000
1 -> 0001
2 -> 0010
3 -> 0011
4 -> 0100
5 -> 0101
6 -> 0110
7 -> 0111
8 -> 1000
9 -> 1001
A -> 1010
B -> 1011
C -> 1100
D -> 1101
E -> 1110
F -> 1111

AAAA:BBBB:AABB:CCBB:DDAA:BEEB:AAFF:BBAA
16+   16+  16+  16+  16+  16+  16+  16 =128
## ---------------- Protocols ----------------
1. IP protocol -> Machine has an IP on the internet
   Port -> Communication channel for a service 
2. TCP - IP Protocol + port -> Transimission control protocol -> Connection oriented 
3. UDP - User datagram protocol -> Connection oriented 
4. HTTP ->  TCP protocol over 80 port =(IP + Port) + 80 port reserved 
5. FTP -> File transfer protocol -> 20-21 
6. SSH -> Secure Shell -> 22 
7. SFTP -> Secure FTP ->
8. DNS -> Domain name Service -> 53
9.NIC Card -> N/w interface card, Number of NIC cards = Number of IP address

## --------------- What is REST -------------

REST (Representational State Transfer) is an architectural style used in web development for building scalable, performant, and maintainable web services. RESTful API (Application Programming Interface) is an implementation of the REST architecture.

RESTful API is a type of web API that is designed to work with HTTP (Hypertext Transfer Protocol) requests such as GET, POST, PUT, DELETE, etc., to retrieve, create, update or delete resources on the web. RESTful APIs use HTTP methods to define the actions to be performed on resources, and use URLs (Uniform Resource Locators) to identify resources.

RESTful APIs typically return data in JSON (JavaScript Object Notation) or XML (Extensible Markup Language) format, which are both lightweight and easy to parse. They also use hypermedia links to navigate between resources and represent the state of the system.

RESTful APIs are widely used in modern web development for creating web services that are easy to consume, scalable, and platform-agnostic. They are used by many popular web applications and services, such as Twitter, Facebook, and Google Maps.

## ------------- API Architectural designs You Must Know ------------

1. REST 🌐
   Representational State Transfer - REST is like a classic library where you request specific books and receive them as they are. It's simple and widely used for web APIs, like ordering a la carte from a menu 🍽️.

2. GraphQL 🚀
   GraphQL is like a customizable buffet 🍴 where you ask for exactly what you want and get a tailored plate. It allows clients to request only the data they need, reducing over-fetching.

3. SOAP 🧼
   SOAP (Simple Object Access Protocol) is like sending a letter 💌 with detailed instructions, complete with a table of contents. It's more structured but can be heavier than REST or GraphQL.

4. gRPC 🚄:
   gRPC is like a high-speed train 🚄 for communication between services. It uses Protocol Buffers for efficient data exchange and supports streaming and bidirectional communication.

5. WebSockets 🌐💬
   WebSockets are like real-time phone calls ☎️ for the web. They enable two-way communication, perfect for chat apps and live updates.

6. MQTT 📡
   MQTT (Message Queuing Telemetry Transport) is like a radio broadcast 📻, designed for low-bandwidth, high-latency, or unreliable networks. Ideal for IoT devices and sensor data.

![api-architecture-design.gif](src/main/resources/api-architecture-design.gif)

## ----------- Request URL example for REST -------------
> Example of URL :- `http://localhost:8080/greeting?name=Vikram`

* http -> protocol
* localhost -> domain name
* 8080 -> http port
* /greeting -> path or endpoint
* name -> request parameter key
* Vikram -> request parameter value

## -- what is spring framework and how spring boot and spring MVC are different? --------

1. Spring Framework:
   - Spring is a comprehensive Java-based framework used for building enterprise applications.
   - It provides various modules and features for addressing common concerns in application development, such as dependency injection, aspect-oriented programming, transaction management, and more.
   - Spring promotes a modular and flexible approach to application development, making it easier to manage complex applications and improve testability and maintainability.

2. Spring Boot:
   - Spring Boot is a project within the Spring ecosystem that simplifies the setup and development of Spring applications.
   - It provides a set of conventions and pre-configured settings to streamline the development process, reducing the need for extensive configuration.
   - Spring Boot is particularly well-suited for building microservices and standalone applications, and it includes embedded web servers for deploying web applications with minimal effort.

3. Spring MVC:
   - Spring MVC (Model-View-Controller) is a part of the Spring Framework used for developing web applications.
   - It focuses on building web applications with a clear separation of concerns, where the Model represents the application's data, the View handles the presentation, and the Controller manages the flow of requests and responses.
   - Spring Boot can be used in conjunction with Spring MVC to simplify web application development, but Spring MVC is primarily focused on the web layer, while Spring Boot simplifies the overall application setup and configuration.

In summary, Spring is a versatile framework for building enterprise applications, Spring Boot simplifies application setup and development, and Spring MVC is a component of Spring specifically designed for building web applications. They can be used together to create web applications efficiently.

## -------- Spring boot profiles ----------

Spring Boot allows you to define and work with multiple profiles, which is helpful when you want to manage different configurations for your application based on the environment or use case. Profiles are typically used to manage settings like database connection details, logging levels, and other configuration parameters for various deployment environments (e.g., development, testing, production). Here's how you can create and use multiple profiles in Spring Boot:

1. Define Multiple Configuration Files:

Create separate configuration files for each profile. By default, Spring Boot uses application.properties or application.yml. To create a profile-specific configuration, you can create files like application-dev.properties, application-test.properties, and application-prod.properties for development, testing, and production profiles, respectively.

For example, you can create an application-dev.properties file for the "dev" profile:

   ### application-dev.properties
   ```
   spring.datasource.url=jdbc:mysql://localhost:3306/dev_database
   logging.level.root=debug
   ```

2. Activate Profiles:
Profiles can be activated in various ways. 

The most common methods are:
   * Using `application.properties` or `application.yml`:
   You can specify the active profile in your `application.properties` or `application.yml` file using the `spring.profiles.active` property.
   `spring.profiles.active=dev`
  * Using Command Line Arguments:
  You can specify the active profile as a command-line argument when running your Spring Boot application.
  `java -jar my-spring-app.jar --spring.profiles.active=dev`
  * Using Environment Variables:
  You can set the `SPRING_PROFILES_ACTIVE` environment variable to specify the active profile.
  Using the `application-{profile}.properties` or `application-{profile}.yml` Naming Convention:
  Spring Boot will automatically pick up the appropriate profile-specific configuration file based on the active profile.

3. Access Profile-Specific Properties:
Configure a component or bean using @Profile annotation and get the beans when that profile is set.
In your Java code, you can access the profile-specific properties using the @Value annotation or by injecting the Environment object.
```
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class MyComponent {
@Value("${spring.datasource.url}")
private String databaseUrl;

    // ...
}
```
4. Run the Application:
When you run your Spring Boot application, it will load the configuration properties from the specified profile. Make sure you activate the desired profile using one of the methods mentioned above.
By following these steps, you can create and manage multiple profiles in a Spring Boot application, allowing you to configure and customize the application for different environments or use cases.


## --------- Important Spring boot Annotations ----------

### Spring Boot Annotations:
1. `SpringBootApplication` : `@SpringBootApplication` is a convenience annotation that adds all of the following:
   `@SpringBootConfiguration`: Tags the class as a source of bean definitions for the application context.
   `@EnableAutoConfiguration`: Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings. For example, if spring-webmvc is on the classpath, this annotation flags the application as a web application and activates key behaviors, such as setting up a DispatcherServlet.
   `@ComponentScan`: Tells Spring to look for other components, configurations, and services in the com/example package, letting it find the controllers.
2. `SpringBootTest`
3. `RestController` : The Spring boot `@RestController` annotation, which marks the class
   as a controller where every method returns a domain object instead of a view.
   It is shorthand for including both `@Controller` and `@ResponseBody`.
4. `GetMapping` : The @GetMapping annotation ensures that HTTP GET requests to /greeting are mapped to the greeting() method.
5. `PostMapping` : Create resource
6. `PutMapping` : Update resource
7. `PatchMapping` : Partial update of resource
8. `DeleteMapping` : Delete existing resource
9. `RequestParam` : @RequestParam binds the value of the query string parameter name into the name parameter of the greeting() method. If the name parameter is absent in the request, the defaultValue of World is used.
10. `Profile` : It sets the spring managed beans to specifically available due that profile.
11. `Value` : Reads an attribute from application.properties file and stores it into an object field.
Jackson - Json -> Converts java objects to Json objects.
The main() method uses Spring Boot’s SpringApplication.run() method to launch an application. Did you notice that there was not a single line of XML? There is no web.xml file, either. This web application is 100% pure Java and you did not have to deal with configuring any plumbing or infrastructure.

## ------- Logging in Java Application ---------
We can use lombok dependency at compile time to include SLF4J annotation for logging.
Basically it creates a log object for annotated class and can use to log at different levels.
Lombok is a dependency that has many useful annotations.

SLF4J - Simple Logging Facade for Java
This is an interface or facade or API.
SLF4J is not a library for logging but exposes logging to use different logging methods

### SLF4J internally uses many logging libraries ->
1. **jul (java util logging) to slf4j**: The jul-to-slf4j library facilitates the integration of SLF4J by including the SLF4J API, allowing applications using Java Util Logging (JUL) to route their logs through SLF4J.

2. **log4j-to-slf4j**: The log4j-to-slf4j library includes the SLF4J API, enabling applications that use the Log4j logging framework to bridge and utilize SLF4J for logging operations.

3. **logback-classic**: The logback-classic library incorporates the SLF4J API, making it possible for applications using the Logback Classic logging framework to leverage SLF4J for their logging needs.
### Logging Levels:
* `Error` : Use the "error" logging level when a critical issue or unexpected error occurs in your application, and it needs immediate attention. This level should capture failures that prevent the application from functioning correctly, helping you identify and resolve these high-impact problems quickly.
* `Warn` : The "warn" level is suitable for logging messages that highlight potentially problematic situations that don't immediately disrupt the application's functionality. It's often used for warnings or errors that the system can recover from, and it provides a heads-up for potential issues that should be investigated.
* `Info` : The "info" level is for general information that helps you understand the flow of your application. Use it to log significant events and milestones in your code, such as when a user logs in, or an important process starts or completes successfully.
* `Debug` : "Debug" level logging is intended for messages that aid developers in debugging and troubleshooting issues during development or testing. It provides detailed information about the internal workings of your code, helping you identify and fix problems efficiently.
* `Trace` : The "trace" level is the most granular and detailed logging level, typically used to log every step or action within a specific process. It's useful for in-depth debugging and performance profiling, providing insights into the minutiae of application execution.

Choosing the appropriate logging level depends on the context and the purpose of the logs, with lower levels providing more detailed information but generating larger log files.




Note:
There are companion annotations for other HTTP verbs (e.g. @PostMapping for POST). There is also a @RequestMapping annotation that they all derive from, and can serve as a synonym (e.g. @RequestMapping(method=GET)).
### Reference [Tutorial](https://spring.io/guides/gs/rest-service/)