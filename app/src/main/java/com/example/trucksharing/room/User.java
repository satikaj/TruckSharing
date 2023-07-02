package com.example.trucksharing.room;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_table")
public class User {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "username")
    public String username;
    @NonNull
    @ColumnInfo(name = "password")
    public String password;
    @ColumnInfo(name = "fullname")
    public String fullname;
    @ColumnInfo(name = "phone")
    public String phone;

    public User(String username, String password, String fullname, String phone) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.phone = phone;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public String getFullname() {
        return fullname;
    }

    public String getPhone() {
        return phone;
    }
}
