# Java-se-action

## Lombok Example

First, you should add Lombok maven dependency to your pom.xml, and dependency as shown below:

```xml
<dependency>
  <groupId>org.projectlombok</groupId>
  <artifactId>lombok</artifactId>
  <version>1.18.24</version>
</dependency>
```

And you should add build to your pom.xml, like below:

```xml
<build>
  <plugins>
    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-compiler-plugin</artifactId>
      <version>3.8.1</version>
      <configuration>
        <source>1.8</source> <!-- depending on your project -->
        <target>1.8</target> <!-- depending on your project -->
        <annotationProcessorPaths>
          <path>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.24</version>
          </path>
        </annotationProcessorPaths>
      </configuration>
    </plugin>
  </plugins>
</build>
```

Enjoy you Lombok! 

## CSV Example

Suppose you want to read data from CSV. You can use opencsv lib and add maven dependency like below:

```xml
<dependency>
  <groupId>com.opencsv</groupId>
  <artifactId>opencsv</artifactId>
  <version>5.6</version>
</dependency>
```



### CSV Reader

This example shows how to read data from a CSV file from your local disk. The code like below:

```java
List<DepartureDelays> originList = new ArrayList<>();
FileReader filereader = new FileReader("/Volumes/JackApp/jackproject/java-se-action/data/departuredelays-sample.csv");
CSVReader csvReader = new CSVReader(filereader);
List<String[]> list = csvReader.readAll();
// Skip csv header
for (int i = 1; i < list.size(); i++) {
  String[] singleRecord = list.get(i);
  DepartureDelays departureDelays = new DepartureDelays();
  departureDelays.setDate(singleRecord[0]);
  departureDelays.setDelay(Integer.parseInt(singleRecord[1]));
  departureDelays.setDistance(Integer.parseInt(singleRecord[2]));
  departureDelays.setOrigin(singleRecord[3]);
  departureDelays.setDestination(singleRecord[4]);
  originList.add(departureDelays);
}
```



## Core Functional Examples

### Predicate Examples

#### singleFilter

Suppose you want to filter something that the condition is defined by caller. You can define the method throw  Predicate functional class, as a variable. And you can define the filter method like below:

```java
// You can find delay greater than 0.
List<DepartureDelays> delays = predicateExamples.singleFilter(originList, data -> data.getDelay() > 0);
assertEquals(delays.size(), 1129);
//  You can find origin airport is ABE.
List<DepartureDelays> originABE = predicateExamples.singleFilter(originList, data -> "ABE".equals(data.getOrigin()));
```



#### doubleAndFilter

Suppose You want to find delay greater than 0 and the origin airport is ABE. You should define the doubleAndFilter method and accept two condition variables.

```java
// You can find delay greater than 0 and origin airport is ABE.
List<DepartureDelays> dataList = predicateExamples.doubleAndFilter(originList,
                                                                   data -> data.getDelay() > 0,
                                                                   data -> "ABE".equals(data.getOrigin()));
```



#### doubleOrFilter

Suppose You want to find delay greater than 0 or the origin airport is ABE. You should define the doubleAndFilter method and accept two condition variables.

```java
// You can find delay greater than 0 and origin airport is ABE.
List<DepartureDelays> dataList = predicateExamples.doubleOrFilter(originList,
                                                                   data -> data.getDelay() > 0,
                                                                   data -> "ABE".equals(data.getOrigin()));
```



#### excludeFilter

Suppose You want to find the origin airport is not ABI. 

```java
// Find origin airport is not ABI.
List<DepartureDelays> originABE = predicateExamples.excludeFilter(originList, data -> "ABI".equals(data.getOrigin()));

```

