package com.qing.study.utils.date;


import java.util.ArrayList;
import java.util.List;

public class DateUtilTest {

    // test
    public static void main(String[] args) throws Exception {
        /*List<String> aa = getDateRangeHourList("2019-10-10 10:00:00", "2019-10-13 14:10:11", FORMATE_SECOND_2);
        for (String d : aa) {
            System.out.println(d);
        }*/

//        System.out.println(isBetween("2019-10-10", "2019-10-13", "2019-10-13", FORMATE_DAY_1, true, true));

        List<String> res = new ArrayList<>();
        res.add("2019-10-12");
        res.add("2019-10-13");
        res.add("2019-10-11");
        res.add("2019-10-14");

        res = DateUtil.sortDates(res, DateUtil.FORMATE_DAY_1, true);

        for (String s : res) {
            System.out.println(s);
        }

    }
}
