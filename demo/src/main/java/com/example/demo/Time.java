package com.example.demo;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Time {

    public class CarTime {
        DateTimeFormatter timing = DateTimeFormatter.ofPattern("ss");
        LocalDateTime org = LocalDateTime.now();
        LocalDateTime now = org.with(LocalTime.MIDNIGHT);
        ;
        public CarTime(){

        }
        public String carTime(){
            return timing.format(now);
        }
    }

        private int second;

        public Time(int second) {
            this.second = second;
        }

        public String getCarTime(){
            return String.valueOf(second);
        }

        public void oneSecondPassed(){
            second++;
        }

}
