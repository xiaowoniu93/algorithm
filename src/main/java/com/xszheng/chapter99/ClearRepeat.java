package com.xszheng.chapter99;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClearRepeat {

    public static void main(String[] args) {
        String[] data = {"aaa", "aaa", "bbb", "ccc", "123", "aaa"};
        String[] desData = clearRepeat(data);
        System.out.println(Arrays.asList(desData));
    }


    private static String[] clearRepeat(String[] originData) {
        List<String> desDataList = new ArrayList<>();
        for (int i=0; i<originData.length; i++) {
            String ele = originData[i];
            if (!desDataList.contains(ele)) {
                desDataList.add(ele);
            }
        }
        return desDataList.toArray(new String[]{});
    }
}
