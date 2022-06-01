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
     * @param condition condition filter
     * @return filter data list.
     */
    public List<DepartureDelays> singleFilter(List<DepartureDelays> originList,
                                              Predicate<DepartureDelays> condition) {
        List<DepartureDelays> newList = new ArrayList<>();
        for (DepartureDelays departureDelays : originList) {
            if (condition.test(departureDelays)) {
                newList.add(departureDelays);
            }
        }
        return newList;
    }


    /**
     * Double And condition filter
     *
     * @param originList origin data list
     * @param firstCondition first condition
     * @param secondCondition second condition
     * @return filter data list.
     */
    public List<DepartureDelays> doubleAndFilter(List<DepartureDelays> originList,
                                              Predicate<DepartureDelays> firstCondition,
                                              Predicate<DepartureDelays> secondCondition) {

        List<DepartureDelays> newList = new ArrayList<>();
        for (DepartureDelays departureDelays : originList) {
            if (firstCondition.and(secondCondition).test(departureDelays)) {
                newList.add(departureDelays);
            }
        }
        return newList;
    }

    /**
     * Double Or condition filter
     *
     * @param originList origin data list
     * @param firstCondition first condition
     * @param secondCondition second condition
     * @return filter data list.
     */
    public List<DepartureDelays> doubleOrFilter(List<DepartureDelays> originList,
                                                 Predicate<DepartureDelays> firstCondition,
                                                 Predicate<DepartureDelays> secondCondition) {

        List<DepartureDelays> newList = new ArrayList<>();
        for (DepartureDelays departureDelays : originList) {
            if (firstCondition.or(secondCondition).test(departureDelays)) {
                newList.add(departureDelays);
            }
        }
        return newList;
    }


    /**
     * Single condition filter
     *
     * @param originList origin data list
     * @param excludeCondition exclude condition filter
     * @return filter data list.
     */
    public List<DepartureDelays> excludeFilter(List<DepartureDelays> originList,
                                              Predicate<DepartureDelays> excludeCondition) {
        List<DepartureDelays> newList = new ArrayList<>();
        for (DepartureDelays departureDelays : originList) {
            if (excludeCondition.negate().test(departureDelays)) {
                newList.add(departureDelays);
            }
        }
        return newList;
    }


}
