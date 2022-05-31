package com.jackpan.lambda;

import com.jackpan.dataentity.DepartureDelays;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * PredicateExamples is deal with data/departuredelays.csv, and the entity is DepartureDelays
 * departuredelays.csv data is about air flight delay.
 *
 * @author JackPan
 * @date 2022/05/30 15:05
 **/
public class PredicateExamples {


    /**
     * Single condition filter
     *
     * @param originList origin data list
     * @param predicate condition filter
     * @return filter data list.
     */
    public List<DepartureDelays> singleFilter(List<DepartureDelays> originList, Predicate<DepartureDelays> predicate) {
        List<DepartureDelays> newList = new ArrayList<>();
        for (DepartureDelays departureDelays : originList) {
            if (predicate.test(departureDelays)) {
                newList.add(departureDelays);
            }
        }
        return newList;
    }


}
