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

Suppose you want to filter something that the condition is define by  caller. You can define method throw  Predicate functional class as a variable. And you can define filter method like below:

```java
// You can find delay greater than 0.
List<DepartureDelays> delays = predicateExamples.singleFilter(originList, data -> data.getDelay() > 0);
assertEquals(delays.size(), 1129);
//  You can find origin airport is ABE.
List<DepartureDelays> originABE = predicateExamples.singleFilter(originList, data -> "ABE".equals(data.getOrigin()));
assertEquals(originABE.size(), 135);
```



Suppose  You  want find delay greater than 0 and origin airport is ABE. You should define doubleAndFilter method and accept two conditon variables.

```java
// You can find delay greater than 0 and origin airport is ABE.
List<DepartureDelays> dataList = predicateExamples.doubleAndFilter(originList,
                                                                   data -> data.getDelay() > 0,
                                                                   data -> "ABE".equals(data.getOrigin()));
assertEquals(dataList.size(), 39);
```

Suppose  You  want find delay greater than 0 or origin airport is ABE. You should define doubleOrFilter method and accept two conditon variables.

```java
// You can find delay greater than 0 and origin airport is ABE.
List<DepartureDelays> dataList = predicateExamples.doubleOrFilter(originList,
                                                                   data -> data.getDelay() > 0,
                                                                   data -> "ABE".equals(data.getOrigin()));
assertEquals(dataList.size(), 1225);
```

