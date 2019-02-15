# WebApiAutomation (Component Testing)

Make sure you have the latest version of Java Installed.

To find out if you already have Java installed on your environement, in the command line prompt type:
```
java -version
```

If you haven't got it installed then you can do so here:

https://www.java.com/en/

If you're using Mac be sure that the file path to Java points to:

/Library/Java

You will also need to install the latest JDK (java development kit) version, you can do so here:

https://www.oracle.com/technetwork/java/javase/downloads/index.html

If you're using Mac make sure the file path to the latest version of JDK that you're using points to:

/Library/Java/JavaVirtualMachines/jdk-11.0.1.jdk/Contents/Home

It may be different on your machine, just be sure it points to your Java directory and in which the /bin of your version of JDK folder resides.

Maven is a very helpful build automation tool used primarily for Java projects.
Maven addresses two aspects of building software: first, it describes how software is built, and second, it describes its dependencies.

If you're not using Maven then be sure to know how to manage and configure your own dependencies.

It is highly recommended that you build Java projects with Maven as it increases the amount of time spent on actual development significantly.
It manages all the miscellaneous config for you too.

To find out if you already have Maven installed with Java, in the command line prompt type:
```
mvn -version
```
If you haven't got it installed then you can do so here:

https://maven.apache.org/download.cgi

Downlaod the Binary zip archive file from there.
It's useful to move this elsewhere from your downlaods directory, but is not necessary. It's good practise to have your dev tools stored in one single directory.

You're almost there with being able to Develop Java projects with Maven.

We need to check first if the file path to your Java and JDK directory have been stored globally to the $JAVA_HOME variable.

In the command line prompt type:
```
echo $JAVA_HOME
```

If this returns empty, then type the next command to assign the file path to it:
```
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-11.0.1.jdk/Contents/Home
```

It may be different on your machine, just be sure it points to your Java directory and to where the /bin of your version of JDK folder resides.

Now type:
```
echo $JAVA_HOME
```

It should return the file path

Now type the next command to append the file path to Maven's /bin directory to the $PATH variable:
```
export PATH=/Users/{user}/{file/path/to/apache/maven}/apache-maven-3.6.0/bin:$PATH
```

If you return the versions when you type:
```
java -version
mvn -version
```

You know you are set up and ready to go!
