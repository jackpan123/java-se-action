package com.jackpan.stream;

import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;


/**
 * StreamExamples操作类
 *
 * @author JackPan
 * @date 2022/05/22 15:28
 **/
public class StreamExamples {


    public void useJava7() {
        List<MnmInfo> list = new ArrayList<>();

        List<MnmInfo> lowerCountList = new ArrayList<>();
        for (MnmInfo mnmInfo : list) {
            if (mnmInfo.getCount() < 20) {
                lowerCountList.add(mnmInfo);
            }
        }

        Collections.sort(lowerCountList, new Comparator<MnmInfo>() {
            @Override
            public int compare(MnmInfo o1, MnmInfo o2) {
                return Integer.compare(o1.getCount(), o2.getCount());
            }
        });

        // 排序完成之后，获取每种颜色的出现的次数
        Map<String, List<MnmInfo>> map = new HashMap<String, List<MnmInfo>>();
        for (MnmInfo mnmInfo : lowerCountList) {
            List<MnmInfo> mnmInfos = map.get(mnmInfo.getColor());
            if (mnmInfos == null) {
                mnmInfos = new ArrayList<MnmInfo>();
            }
            mnmInfos.add(mnmInfo);
        }

    }

    public void useJava8() {
        List<MnmInfo> list = new ArrayList<>();
        Map<String, List<MnmInfo>> aggList = list.stream()
                .filter(m -> m.getCount() < 20)
                .sorted(comparing(MnmInfo::getCount))
                .collect(groupingBy(MnmInfo::getColor));
    }

    private List<MnmInfo> dataList = new ArrayList<>();

    public void dataFilter() {
        dataList.stream().filter(d -> d.getCount() > 20);
    }

    public void dataLimit() {
        dataList.stream().sorted(comparing(MnmInfo::getCount)).limit(10);
    }

    public void dataSkip() {
        dataList.stream().sorted(comparing(MnmInfo::getCount)).skip(10).limit(10);
    }

    public void dataMap() {
        List<String> collect = dataList.stream().limit(10).map(MnmInfo::getCa).collect(toList());
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "World");
        List<String> distinctLetters = Arrays.asList("Hello", "World").stream().map(word -> word.split("")).flatMap(Arrays::stream).distinct().collect(toList());
        System.out.println();
    }
}
