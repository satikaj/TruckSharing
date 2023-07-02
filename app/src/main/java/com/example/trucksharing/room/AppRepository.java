package com.example.trucksharing.room;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class AppRepository {
    private final UserDao userDao;
    private final OrderDao orderDao;

    public AppRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        userDao = db.userDao();
        orderDao = db.orderDao();
    }

    public void insertUser(User user) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            userDao.insertUser(user);
        });
    }

    public void insertOrder(Order order) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            orderDao.insertOrder(order);
        });
    }

    public LiveData<List<Order>> getAllOrders() {
        return orderDao.getAllOrders();
    }

    public LiveData<List<Order>> getMyOrders(String senderUsername) {
        return orderDao.getMyOrders(senderUsername);
    }
}
