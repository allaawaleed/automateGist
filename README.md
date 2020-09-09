
**Description**
-----
 * Project consists of 4 packages as the following:
   * Data: This contains all data driven needed -> Still need to efforts to implement JSON data driven
   * steps: This contains all test cases in the separate classes.
   * execution: This contains test classes [TODO]
   * utility: This contains the logging class and Basic.


**How to run?**
----
 * You need to write a valid email and password in the 'gistData.properties' file.
 * Run the 'regerssion.xml' as 'TestNG' suite. 
 * If compiler display error 'Failed to execute goal' or 'Failed to execute classpath' please remove all files in .m2/repository , restart Eclipse, update Maven with selecting force, Ran as clean Maven, Run as Maven Install, Clean project then Run project.

The solution includes:
* Logging using log4j;
* Report will be in the test-output folder after running the test;

**Libraries/Plugins used**
-------------------
* Selenium: To initiate the driver and deal with the web elements.
* Log4j: Used for logging.
* Testing: Used for test annotations, asserting on the results and parallel execution. 
* Maven-surefire-plugin: used for configuring the suite XML and parametrised variables through the command line.
* Maven-compiler-plugin: used to compile the project to version 1.7 because it will not work for 1.5 because of multiple catch exceptions.
