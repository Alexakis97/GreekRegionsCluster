# GreekRegionsCluster
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.alexakis97/clustering/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.alexakis97/clustering)
[![GitHub last commit](https://img.shields.io/github/last-commit/google/skia.svg?style=flat)]()
[![MIT License](https://img.shields.io/apm/l/atomic-design-ui.svg?)](https://github.com/tterb/atomic-design-ui/blob/master/LICENSEs)

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
   ### Include the Cluster dependancy
    <dependency>
      <groupId>com.github.alexakis97</groupId>
      <artifactId>clustering</artifactId>
      <version>1.1.4</version>
    </dependency>
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

