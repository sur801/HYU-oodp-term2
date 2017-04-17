package com.addresbook;

/**
 * Created by USER on 2017-04-15.
 */


public class Sms {
    Sms (String time, String number, String text, String status) {
        this.time_ = time;
        this.number_ = number;
        this.text_ = text;
        this.status_ = status;
    }


    public String getTime_() {
        return time_;
    }

    public String getNumber_() {
        return number_;
    }

    public String getText_() {
        return text_;
    }

    public String getStatus_() { return status_; }

    private String time_;
    private String number_;
    private String text_;
    private String status_;
}
