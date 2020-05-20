package com.ccit;

public enum ICGWeekValues {

    Mon(1l, "Monday"),

    Tue(2l, "Tuesday"),

    Wed(3l, "Wednesday"),

    Thur(4l, "Thursday"),

    Fir(5l, "Friday"),

    Sat(6l, "Saturday"),

    Sunday(7l, "Sunday");

    private Long value;

    private String message;

    ICGWeekValues(Long value, String message) {
        this.value = value;
        this.message = message;
    }
}
