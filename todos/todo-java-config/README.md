Simple command line application to add Todos. Todos added are not persisted; when the application is terminated, added todos are lost.

This application just highlights some of the capabilities of Spring core module. It uses Spring's Java configuration.

SETUP
=====

Just import the project into eclipse.

	--> Right click in Eclipse Project / Package Explorer and select Import -> Existing Maven project

BUILDING
========

	--> Right click on the project and select "Maven build..."
	--> In the goals field, enter "clean install"
	--> Hit "Apply" and "Run"

RUNNING
=======

Right click on TodoApplication.java and choose Run as --> Java application

Once the application starts, it prompts the user to enter a Todo title to add.

Understanding
=============

Execution starts with TodoApplication.java. The main method creates an instance of AnnotationConfigApplicationContext to read
Spring configuration from TodoConfig.java.
