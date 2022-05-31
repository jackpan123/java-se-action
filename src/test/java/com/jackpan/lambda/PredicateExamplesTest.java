package com.jackpan.lambda;

import com.jackpan.dataentity.DepartureDelays;
import com.opencsv.CSVReader;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * PredicateExamplesTest操作类
 *
 * @author JackPan
 * @date 2022/05/30 16:20
 **/
public class PredicateExamplesTest {

    private static List<DepartureDelays> originList;

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

    @Test
    public void csvReaderTest() throws Exception {

        System.out.println();
    }

}
