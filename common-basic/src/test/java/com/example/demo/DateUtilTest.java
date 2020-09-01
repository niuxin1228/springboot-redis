package com.example.demo;

import com.uih.uplus.common.utils.date.DateUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Timestamp;
import java.util.*;

public class DateUtilTest {
    private Date testDate;
    @BeforeMethod
    public void before() throws Exception {
        testDate = DateUtil.parseStrToDate("2020/08/28", "yyyy/MM/dd");
    }
    @Test
    public void DateUtilnowSuccess() {
        String now = DateUtil.now();
        System.out.println(now);
        Assert.assertNotNull(now);
    }
    @Test
    public void DateUtilnowformatSuccess() {
        String now = DateUtil.now(DateUtil.DATE_FORMAT_YYYY);
        System.out.println(now);
        Assert.assertNotNull(now);
    }
    @Test
    public void getYearTest() {
        int result = DateUtil.getYear(testDate);
        Assert.assertEquals(result, 2020);
    }

    @Test
    public void getMonthTest() {
        int result = DateUtil.getMonth(testDate);
        Assert.assertEquals(result, 8);
    }

    @Test
    public void getDayTest() {
        int result = DateUtil.getDay(testDate);
        Assert.assertEquals(result, 28);
    }

    @Test
    public void parseDateToStrTest() {
        String result = DateUtil.parseDateToStr(testDate, DateUtil.DATE_FORMAT_YYYY_MM_DD);
        Assert.assertEquals(result, "2020-08-28");
    }

    @Test
    public void parseDateToStrTestALL() {
        String result = DateUtil.parseDateToStr(testDate, "wrongFormat", "1979-01-01");
        Assert.assertEquals(result, "1979-01-01");
    }

    @Test
    public void parseDateToStrTestnew() {
        String result = DateUtil.parseDateToStr(testDate, DateUtil.DATE_FORMAT_YYYY_MM_DD, new Date());
        Assert.assertEquals(result, "2020-08-28");
    }

    @Test
    public void parseTimestampToStrTest() {
        Timestamp time = new Timestamp(testDate.getTime());
        String result = DateUtil.parseTimestampToStr(time, DateUtil.DATE_FORMAT_YYYY_MM_DD);
        Assert.assertEquals(result, "2020-08-28");
    }

    @Test
    public void parseStrToDateTest() {
        Date result = DateUtil.parseStrToDate("2020-08-28", DateUtil.DATE_FORMAT_YYYY_MM_DD);
        Assert.assertEquals(result, testDate);
    }

    @Test
    public void parseStrToDateTestallindex() {
        Date date = new Date();
        Date result = DateUtil.parseStrToDate("2020-08-28", "wrongFormat", date);
        Assert.assertEquals(result, date);
    }

    @Test
    public void strToDateTest() {
        Date result1 = DateUtil.strToDate("20200828");
        Assert.assertEquals(result1, testDate);
        Date result2 = DateUtil.strToDate("2020-08-28");
        Assert.assertEquals(result2, testDate);
    }

    @Test
    public void getMonthListOfDateTest() {
        List<String> result = DateUtil.getMonthListOfDate("2020-08-28", "2020-12-31");
        System.out.println(result.size());
        Assert.assertTrue(result.size() == 5);
    }

    @Test
    public void getDayListOfDateTest() {
        List<String> result = DateUtil.getDayListOfDate("2020-08-28", "2020-12-31");
        Assert.assertTrue(result.size() == 126);
    }

    @Test
    public void getYearListOfYearsTest() {
        List<Integer> result = DateUtil.getYearListOfYears(5, 5);
        Assert.assertTrue(result.size() == 10);
    }

    @Test
    public void getWeekthOfYearTest() {
        int result = DateUtil.getWeekthOfYear(testDate);
        Assert.assertEquals(result,34);
    }

    @Test
    public void getWeekTimeOfYearTest() {
        Map result = DateUtil.getWeekTimeOfYear(2020);
        Assert.assertNotNull(result);
    }

    @Test
    public void getWeekCountOfYearTest() {
        int result = DateUtil.getWeekCountOfYear(2020);
        Assert.assertEquals(result,52);
    }

    @Test
    public void getFirstDayOfWeekTest() {
        Date result = DateUtil.getFirstDayOfWeek(testDate);
        Assert.assertEquals(result, DateUtil.parseStrToDate("2020/08/24", "yyyy/MM/dd"));
    }

    @Test
    public void getFirstDayOfWeekTestall() {
        Date result = DateUtil.getFirstDayOfWeek(2019, 52);
        Assert.assertEquals(DateUtil.parseDateToStr(result, "yyyy/MM/dd"),"2019/12/30");
    }

    @Test
    public void getLastDayOfWeekTest() {
        Date result = DateUtil.getLastDayOfWeek(testDate);
        Assert.assertEquals(result, DateUtil.parseStrToDate("2020/08/30", "yyyy/MM/dd"));
    }

    @Test
    public void getLastDayOfWeekTestall() {
        Date result = DateUtil.getLastDayOfWeek(2019, 52);
        Assert.assertEquals(DateUtil.parseDateToStr(result, "yyyy/MM/dd"),"2020/01/05");
    }

    @Test
    public void getFirstDayOfMonthTest() {
        Date result = DateUtil.getFirstDayOfMonth(2019, 12);
        Assert.assertEquals(DateUtil.parseDateToStr(result, "yyyy/MM/dd"),"2019/12/01");
    }

    @Test
    public void getLastDayOfMonthTest() {
        Date result = DateUtil.getLastDayOfMonth(2019, 12);
        Assert.assertEquals(DateUtil.parseDateToStr(result, "yyyy/MM/dd"),"2019/12/31");
    }

    @Test
    public void getDayWeekOfDate1Test() {
        Assert.assertNotNull(DateUtil.getDayWeekOfDate1(testDate));
    }

    @Test
    public void getDayWeekOfDate2Test() {
        int result = DateUtil.getDayWeekOfDate2(testDate);
        Assert.assertEquals(result, 6);
    }

    @Test
    public void validateIsDateTest() {
        boolean result1 = DateUtil.validateIsDate("2019-12-31");
        Assert.assertTrue(result1);
        boolean result2 = DateUtil.validateIsDate("20191-121-s311");
        Assert.assertTrue(!result2);

    }

    @Test
    public void formatHhMmSsOfDateTest() {
        Date result = DateUtil.formatHhMmSsOfDate(testDate);
        Assert.assertEquals(result, testDate);

    }

    @Test
    public void addDateTest() {
        Date result = DateUtil.addDate(testDate,1,1,1,0,0,0,0);
        Assert.assertEquals(DateUtil.parseDateToStr(result, "yyyy/MM/dd"), "2021/09/29");
    }

    @Test
    public void getDistanceTimestampTest() {
        Date date = DateUtil.addDate(testDate,1,0,0,0,0,0,0);
        long result = DateUtil.getDistanceTimestamp(testDate,date);
        Assert.assertEquals(result, 365l);
    }

    @Test
    public void compareIsSameMonthTest() {
        Date date1 = DateUtil.addDate(testDate,0,0,31,0,0,0,0);
        boolean result1 = DateUtil.compareIsSameMonth(testDate,date1);
        Assert.assertTrue(!result1);
        Date date2 = DateUtil.addDate(testDate,0,0,29,0,0,0,0);
        boolean result2 = DateUtil.compareIsSameMonth(testDate,date2);
        Assert.assertTrue(!result2);
    }

    @Test
    public void getDistanceTimeTest() {
        Date date = DateUtil.addDate(testDate,1,0,0,0,0,0,0);
        long[] result = DateUtil.getDistanceTime(testDate,date);
        Assert.assertEquals(result, new long[]{365, 0, 0, 0});
    }

    @Test
    public void getDistanceTimeTestmore() {
        Date date = DateUtil.addDate(testDate,1,0,0,0,0,0,0);
        long[] result = DateUtil.getDistanceTime(DateUtil.parseDateToStr(testDate, DateUtil.DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS),
                DateUtil.parseDateToStr(date, DateUtil.DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS));
        Assert.assertEquals(result, new long[]{365, 0, 0, 0});
    }

    @Test
    public void getDistanceDaysTest() {
        Date date = DateUtil.addDate(testDate,1,0,0,0,0,0,0);
        long result = DateUtil.getDistanceDays(DateUtil.parseDateToStr(testDate, DateUtil.DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS),
                DateUtil.parseDateToStr(date, DateUtil.DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS));
        Assert.assertEquals(result, 365);
    }

    @Test
    public void getDayBeginTimeTest() {
        Date result = DateUtil.getDayBeginTime(testDate);
        Assert.assertEquals(result, testDate);
    }

    @Test
    public void getDayEndTimeTest() {
        Date result = DateUtil.getDayEndTime(testDate);
        Assert.assertEquals(result, DateUtil.addDate(testDate,0,0,0,23,59,59,999));
    }

    @Test
    public void getDateAtomTest() {
        int result = DateUtil.getDateAtom(testDate, Calendar.YEAR);
        Assert.assertEquals(result, 2020);
    }

    @Test
    public void formatToGMTTest() {
        Assert.assertNotNull(DateUtil.formatToGMT(testDate));
    }

    @Test
    public void formatTest() {
        Assert.assertNotNull(DateUtil.format(testDate, "EEE, dd MMM yyyy HH:mm:ss z", "GMT", Locale.ENGLISH));
    }

    @Test
    public void parseToGMTTest() {
        Date result = DateUtil.parseToGMT(DateUtil.formatToGMT(testDate));
        Assert.assertEquals(result, testDate);
    }

    @Test
    public void parseTest() {
        Date result = DateUtil.parse(DateUtil.formatToGMT(testDate), "EEE, dd MMM yyyy HH:mm:ss z", "GMT", Locale.ENGLISH);
        Assert.assertEquals(result, testDate);
    }
}
