package com.example.trucksharing.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface OrderDao {
    @Insert
    public void insertOrder(Order order);

    @Query("SELECT * FROM order_table")
    public LiveData<List<Order>> getAllOrders();

    @Query("SELECT * FROM order_table WHERE senderUsername = :senderUsername")
    public LiveData<List<Order>> getMyOrders(String senderUsername);
}
