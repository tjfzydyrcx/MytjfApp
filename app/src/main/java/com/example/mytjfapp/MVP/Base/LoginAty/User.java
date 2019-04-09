package com.example.mytjfapp.MVP.Base.LoginAty;

import com.example.mytjfapp.MVP.Base.BaseBean;
import com.example.mytjfapp.Utils.Utils;

/**
 * Created by Administrator on 2019-01-05 0005.
 */

public class User extends BaseBean implements Comparable{

    private String userName;

    private String phone;

    private char headLetter;

    public User(String userName, String phone) {
        this.userName = userName;
        this.phone = phone;
        headLetter = Utils.getHeadChar(userName);
    }

    public String getUserName() {
        return userName;
    }

    public String getPhone() {
        return phone;
    }

    public char getHeadLetter() {
        return headLetter;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        User that = (User) object;
        return getUserName().equals(that.getUserName()) && getPhone().equals(that.getPhone());
    }

    @Override
    public int compareTo(Object object) {
        if (object instanceof User) {
            User that = (User) object;
            if (getHeadLetter() == ' ') {
                if (that.getHeadLetter() == ' ') {
                    return 0;
                }
                return -1;
            }
            if (that.getHeadLetter() == ' ') {
                return 1;
            } else if (that.getHeadLetter() > getHeadLetter()) {
                return -1;
            } else if (that.getHeadLetter() == getHeadLetter()) {
                return 0;
            }
            return 1;
        } else {
            throw new ClassCastException();
        }
    }
}
