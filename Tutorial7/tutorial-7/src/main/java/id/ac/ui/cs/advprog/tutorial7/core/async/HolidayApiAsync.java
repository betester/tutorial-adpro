package id.ac.ui.cs.advprog.tutorial7.core.async;

import id.ac.ui.cs.advprog.tutorial7.core.miscapi.HolidayApi;

import java.util.function.Supplier;

public class HolidayApiAsync implements Supplier<Boolean> {

    private final HolidayApi holidayApi;
    private final String day;

    public HolidayApiAsync(HolidayApi holidayApi, String day ) {
        this.holidayApi = holidayApi;
        this.day = day;
    }

    @Override
    public Boolean get() {
        return holidayApi.isHoliday(day);
    }
}
