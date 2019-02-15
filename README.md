# WebApiAutomation (Component Testing)

This is a project I have created to automate tests for GitHub's API - https://api.github.com/

## Set Up
I've set up a project with Maven and an IDE (IntelliJ).

I imported several dependencies that I need to comfortably run my tests - especially Apache HttpClient.
Without this you can't communicate with the API.

## Tests
### Status code and Content-Type Headers
I have written several simple tests for Status codes and Content-Type Headers.

These headers are so common and so universal that the Apache library provides us with convenience methods to get those out of the response object.

However this isn't the case for all possible headers - there is just too many of them.

Furthermore, API developers can create their own and have a lot of control over what they set in the response, so it's much more practical to just write your own methods that are suitable for all possible headers, which is what I did.

With just this small set of functionality, you could write dozens of tests. That of course depends on how big and complex the API in question is.

But all of this is just the beginning. Up until now, I have been limiting myself to the headers - the metadata of the response object.

Let's not forget it also has a body - the actual data - and that is what I will test next.

__________________________________________


## Installation

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

It may be different on your machine, just be sure it points to your Java directory and in which the /bin directory of
your version of JDK folder resides.

Maven is a very helpful build automation tool, used primarily for Java projects.

It addresses two aspects of building software:

1. It describes how software is built
2. It describes its dependencies.

If you're not using Maven then be sure to know how to manage and configure your own dependencies manually.

It is highly recommended that you build Maven projects with Java as it can turn ugly pretty quickly otherwise.

The amount of time spent on actual development increases significantly with Maven, as it handles all of the mundane stuff
for you, such as managing dependencies as said previously and versions, artifacts, plugins, artifact IDs, the list
goes on...

To find out if you already have Maven installed with Java, in the command line prompt type:
```
mvn -version
```
If you haven't got it installed then you can do so here:

https://maven.apache.org/download.cgi

Download the Binary zip archive file from there.
It's useful to move this elsewhere from your downloads directory, but is not necessary. However, it's good practise to have your
dev tools stored in one single directory.

You're almost there with being able to develop Java projects with Maven.

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
