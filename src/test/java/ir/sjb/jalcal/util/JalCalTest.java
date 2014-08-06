/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.sjb.jalcal.util;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.junit.Test;
import static org.fest.assertions.Assertions.*;

/**
 *
 * @author sjb
 */
public class JalCalTest {

    @Test
    public void testJalaliToGregorian() throws DateException {
        Calendar expected1 = Calendar.getInstance(TimeZone.getDefault());
        expected1.set(2014, 7, 5, 10, 2, 4);
        assertThat(JalCal.jalaliToGregorian(1393, 5, 14, 10, 2, 4).toString()).isEqualTo(expected1.getTime().toString());

        Calendar expected2 = Calendar.getInstance(TimeZone.getDefault());
        expected2.set(2014, 7, 5, 12, 1, 1);
        assertThat(JalCal.jalaliToGregorian(1393, 5, 14, 12, 1, 1).toString()).isEqualTo(expected2.getTime().toString());

        Calendar expected3 = Calendar.getInstance(TimeZone.getDefault());
        expected3.set(2014, 7, 5, 23, 1, 1);
        assertThat(JalCal.jalaliToGregorian(1393, 5, 14, 23, 1, 1).toString()).isEqualTo(expected3.getTime().toString());

        Calendar expected4 = Calendar.getInstance(TimeZone.getDefault());
        expected4.set(2014, 7, 5, 1, 23, 1);
        assertThat(JalCal.jalaliToGregorian(1393, 5, 14, 1, 23, 1).toString()).isEqualTo(expected4.getTime().toString());

        Calendar expected5 = Calendar.getInstance(TimeZone.getDefault());
        expected5.set(2014, 7, 5, 0, 0, 0);
        assertThat(JalCal.jalaliToGregorian("1393/5/14").toString()).isEqualTo(expected5.getTime().toString());

        Calendar expected6 = Calendar.getInstance(TimeZone.getDefault());
        expected6.set(2014, 7, 5, 0, 0, 0);
        assertThat(JalCal.jalaliToGregorian("14/5/1393").toString()).isEqualTo(expected5.getTime().toString());
    }

    @Test
    public void testGregorianToJalali() throws DateException {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 5);
        cal.set(Calendar.MONTH, 6);
        cal.set(Calendar.YEAR, 2014);
        cal.set(Calendar.HOUR_OF_DAY, 10);
        cal.set(Calendar.MINUTE, 25);
        cal.set(Calendar.SECOND, 1);
        cal.set(Calendar.MILLISECOND, 0);
        assertThat(JalCal.gregorianToJalali(cal.getTime(), true)).isEqualTo("14/4/1393   10:25:1");
    }

}
