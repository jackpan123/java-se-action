package com.jackpan.lambda;

import com.jackpan.dataentity.DepartureDelays;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



/**
 * PredicateExamplesTest操作类
 *
 * @author JackPan
 * @date 2022/05/30 16:20
 **/
public class PredicateExamplesTest {

    private static List<DepartureDelays> originList;

    private PredicateExamples predicateExamples = new PredicateExamples();

    /**
     * Load test data from data/departuredelays.csv
     * @throws Exception
     */
    @BeforeAll
    public static void loadData() throws Exception {
        System.out.println("Loading data");
        originList = new ArrayList<>();
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
        System.out.println();
    }

    /**
     * Suppose you provide a method that caller can make his condition flexible.
     * @throws Exception
     */
    @Test
    public void singleFilterTest() throws Exception {
        // Find delay greater than 0.
        List<DepartureDelays> delays = predicateExamples.singleFilter(originList, data -> data.getDelay() > 0);
        assertEquals(delays.size(), 1129);
        // Find origin airport is ABE.
        List<DepartureDelays> originABE = predicateExamples.singleFilter(originList, data -> "ABE".equals(data.getOrigin()));
        assertEquals(originABE.size(), 135);

        // And you can do else something.
    }

    /**
     * Suppose you want to add two condition with and expression.
     */
    @Test
    public void doubleAndFilterTest() {
        // You can find delay greater than 0 and origin airport is ABE.
        List<DepartureDelays> dataList = predicateExamples.doubleAndFilter(originList,
                data -> data.getDelay() > 0,
                data -> "ABE".equals(data.getOrigin()));

        assertEquals(dataList.size(), 39);
    }

    /**
     * Suppose you want to add two condition with or expression.
     */
    @Test
    public void doubleOrFilterTest() {
        // You can find delay greater than 0 or origin airport is ABE.
        List<DepartureDelays> dataList = predicateExamples.doubleOrFilter(originList,
                data -> data.getDelay() > 0,
                data -> "ABE".equals(data.getOrigin()));

        assertEquals(dataList.size(), 1225);
    }

}
