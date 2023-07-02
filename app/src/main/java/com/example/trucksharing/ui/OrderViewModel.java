package com.example.trucksharing.ui;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.trucksharing.room.AppRepository;
import com.example.trucksharing.room.Order;

import java.util.List;

public class OrderViewModel extends AndroidViewModel {

    private final AppRepository repository;

    public OrderViewModel(Application application) {
        super(application);
        repository = new AppRepository(application);
    }

    public void insertOrder(Order order) {
        repository.insertOrder(order);
    }

    public LiveData<List<Order>> getAllOrders() {
        return repository.getAllOrders();
    }

    public LiveData<List<Order>> getMyOrders(String senderUsername) {
        return repository.getMyOrders(senderUsername);
    }
}
