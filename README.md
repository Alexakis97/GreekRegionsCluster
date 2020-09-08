# GreekRegionsCluster
[![Maven Central](https://img.shields.io/maven-central/v/com.github.alexakis97/clustering.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22com.github.alexakis97%22%20AND%20a:%22clustering%22)
[![GitHub last commit](https://img.shields.io/github/last-commit/google/skia.svg?style=flat)]()
[![MIT License](https://img.shields.io/apm/l/atomic-design-ui.svg?)](https://github.com/tterb/atomic-design-ui/blob/master/LICENSEs)
<script type='text/javascript' src='https://ko-fi.com/widgets/widget_2.js'></script><script type='text/javascript'>kofiwidget2.init('Support Me', '#857ea6', 'E1E61NOU4');kofiwidget2.draw();</script> 
![alt text](https://www.map-of-greece.org/greece-map-800.jpg)


## Prerequisites
<!--
   ### Include the JSON dependancy
    <dependency>
	   <groupId>org.json</groupId>
	   <artifactId>json</artifactId>
	   <version>20200518</version>
    </dependency>
    
 -->
   ### Include the dependancy
   
   ## Maven
   
    <dependency>
      <groupId>com.github.alexakis97</groupId>
      <artifactId>clustering</artifactId>
      <version>1.1.4</version>
    </dependency>
    
   ## Gradle Groovy
   
    implementation 'com.github.alexakis97:clustering:1.1.4'
    
   For more types of dependancies please refer [here](https://search.maven.org/artifact/com.github.alexakis97/clustering/1.1.4/jar)
  
## Usage

   ### Define a new Point object
   > **Warning:** Don't import **Point** from java.awt!
   
    Point point = new Point(38.021332, 23.798630);
      
   ### Get the instance & load the cluser
 
    Cluster cluster = Cluster.getInstance();
    cluster.loadCluster();
    
  
      
   ### Get the feature
    System.out.println(temp.getClusterFeature(point,"en"));
    
  The feature is returned as a String, with the extra param you can define the language, currently only "gr" and "en" are supported

