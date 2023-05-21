# CmdAPI
Advanced API for Bukkit/Spigot Commands to integrate in your own plugins. 

# Adding CmdAPI to your Project

## 1. Maven:
Step 1. Add the JitPack repository to your build file:
```xml
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```
Step 2. Add the dependency
```xml
	<dependency>
	    <groupId>com.github.Manered</groupId>
	    <artifactId>CmdAPI</artifactId>
	    <version>Tag</version>
	</dependency>
```

## 2. Gradle:
Step 1. Add it in your root build.gradle at the end of repositories:
```gradle
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Step 2. Add the dependency
```gradle
	dependencies {
	        implementation 'com.github.Manered:CmdAPI:Tag'
	}
```
