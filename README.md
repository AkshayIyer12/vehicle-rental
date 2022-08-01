```
akshay@akshay-ThinkPad-T470:~/Practice/vehicle-rental$ mvn clean install -T 1C 
[INFO] Scanning for projects...
[INFO] 
[INFO] Using the MultiThreadedBuilder implementation with a thread count of 8
[INFO] 
[INFO] -----------------< org.springframework:vehicle-rental >-----------------
[INFO] Building vehicle-rental 0.1.0
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ vehicle-rental ---
[INFO] Deleting /home/akshay/Practice/vehicle-rental/target
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ vehicle-rental ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 1 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ vehicle-rental ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 22 source files to /home/akshay/Practice/vehicle-rental/target/classes
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ vehicle-rental ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /home/akshay/Practice/vehicle-rental/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ vehicle-rental ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ vehicle-rental ---
[INFO] No tests to run.
[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ vehicle-rental ---
[INFO] Building jar: /home/akshay/Practice/vehicle-rental/target/vehicle-rental-0.1.0.jar
[INFO] 
[INFO] --- maven-shade-plugin:3.2.4:shade (default) @ vehicle-rental ---
[INFO] Replacing original artifact with shaded artifact.
[INFO] Replacing /home/akshay/Practice/vehicle-rental/target/vehicle-rental-0.1.0.jar with /home/akshay/Practice/vehicle-rental/target/vehicle-rental-0.1.0-shaded.jar
[INFO] 
[INFO] --- maven-install-plugin:2.4:install (default-install) @ vehicle-rental ---
[INFO] Installing /home/akshay/Practice/vehicle-rental/target/vehicle-rental-0.1.0.jar to /home/akshay/.m2/repository/org/springframework/vehicle-rental/0.1.0/vehicle-rental-0.1.0.jar
[INFO] Installing /home/akshay/Practice/vehicle-rental/pom.xml to /home/akshay/.m2/repository/org/springframework/vehicle-rental/0.1.0/vehicle-rental-0.1.0.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.257 s (Wall Clock)
[INFO] Finished at: 2022-08-01T10:45:12+05:30
[INFO] ------------------------------------------------------------------------
```

```
akshay@akshay-ThinkPad-T470:~/Practice/vehicle-rental$ java -jar target/vehicle-rental-0.1.0.jar /home/akshay/Practice/vehicle-rental/vehicle-rental-data.txt
TRUE
TRUE
TRUE
TRUE
TRUE
FALSE
-1
1000
250
900
V2
```
