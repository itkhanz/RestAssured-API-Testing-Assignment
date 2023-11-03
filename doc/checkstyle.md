# Guide to checkstyle

* Checkstyle is a development tool to help programmers write Java code that adheres to a coding standard. It automates
  the process of checking Java code to spare humans of this boring (but important) task. This makes it ideal for
  projects that want to enforce a coding standard.

## Setup
* Add maven checkstyle plugin to POM.xml
* Setup custom checks in checkstyle.xml and suppressions.xml
* [IntelliJ config](https://stackoverflow.com/a/35273850/7673215)
* Right-click on the src folder, and select `Reformat Code`
* In the right side, choose Maven -> Plugins -> checksyle -> checkstyle:check to run the checkstyle validation
* Alternatively you can run the command in terminal `mvn checkstyle:check` or `mvn validate`
* [checkstyle.yml GitHub action](./../.github/workflows/checkstyle.yml) workflow is setup to trigger validate on each pull request

## Resources

* [checkstyle website](https://checkstyle.sourceforge.io/index.html)
* [checkstyle Badelung](https://www.baeldung.com/checkstyle-java)
* [checkstyle maven](https://central.sonatype.com/artifact/org.apache.maven.plugins/maven-checkstyle-plugin)
* [TMB - Checkstyle Formatting and Coding Standards | Build check | Checkstyle Maven Plugin](https://www.youtube.com/watch?v=mvI9d8rH4IY)
* [The Ultimate Guide to Checkstyle: Unleashing the Power of Code Quality](https://medium.com/@rahul.gite11/checkstyle-all-you-need-to-know-5b6e7a37072a)
* [Introduction to Checkstyle for checking Java code quality - Tutorial](https://www.vogella.com/tutorials/Checkstyle/article.html#checkstyle-maven-plugin)
* [Apache Maven Checkstyle Plugin](https://maven.apache.org/plugins/maven-checkstyle-plugin/index.html)
* [IntelliJ IDEA code format from checkstyle configuration](https://stackoverflow.com/questions/14539313/intellij-idea-code-format-from-checkstyle-configuration?rq=4)
* 