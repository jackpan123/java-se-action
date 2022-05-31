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

