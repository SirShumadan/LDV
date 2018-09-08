package com.example.ldv.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TimeUtil {

    private static LocalTime lunchTime = LocalTime.of(11, 0);

    public static boolean isVoteCanBeChanged(){
        if(LocalTime.now().isBefore(lunchTime) || LocalTime.now().equals(lunchTime)){
            return true;
        } else {
            return false;
        }
    }

    public static LocalTime currentTime(){
        return LocalTime.now();
    }

    public static LocalDate curreentDate(){
        return LocalDate.now();
    }

    public static LocalDateTime currentDateTime(){
        return LocalDateTime.now();
    }

}
