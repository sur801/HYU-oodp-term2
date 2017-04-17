package com.addresbook;

public class Call {

    Call (String time, String number, String duration, String status) {
        this.time_ = time;
        this.number_ = number;
        this.duration_ = duration;
        this.status_ = status;
    }

    public String getTime_() {
        return time_;
    }

    public String getNumber_() {
        return number_;
    }

    public String getDuration_() {
        return duration_;
    }

    public String getStatus_() {
        return status_;
    }

    private String time_;
    private String number_;
    private String duration_;
    private String status_;

}