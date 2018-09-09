package com.example.ldv.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TimeUtil {

    private static final LocalTime LUNCH_TIME = LocalTime.of(11, 0);

    public static boolean isVoteCanBeChanged(){
        if(LocalTime.now().isBefore(LUNCH_TIME) || LocalTime.now().equals(LUNCH_TIME)){
            return true;
        } else {
            return false;
        }
    }

    public static LocalTime currentTime(){
        return LocalTime.now();
    }

    public static LocalDate currentDate(){
        return LocalDate.now();
    }

    public static LocalDateTime currentDateTime(){
        return LocalDateTime.now();
    }

}
