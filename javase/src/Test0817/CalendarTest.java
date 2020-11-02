package Test0817;

import java.util.Calendar;

public class CalendarTest {
    public static void main(String[] args) {
        //创建Calendar
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR,-23);
        System.out.println(calendar.get(Calendar.YEAR));
        calendar.set(Calendar.YEAR,2020);
        System.out.println(calendar.get(Calendar.YEAR));
        calendar.set(Calendar.MONTH,8);
        System.out.println(calendar.get(Calendar.MONTH));
        calendar.set(Calendar.DAY_OF_MONTH,17);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        calendar.set(2020,8,17);
        System.out.println(calendar.get(Calendar.YEAR) + calendar.get(Calendar.MONTH)+calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.YEAR) + "  "+ calendar.get(Calendar.MONTH) + "  " +calendar.get(Calendar.DAY_OF_MONTH));
    }
}
