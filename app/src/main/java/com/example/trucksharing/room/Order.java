package com.example.trucksharing.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "order_table")
public class Order {
    @PrimaryKey(autoGenerate = true)
    public int orderId;
    public String senderUsername, receiverUsername, pickUpLocation, pickUpDate, pickUpTime, dropOffTime, goodType, vehicleType,
            weight, width, length, height, quantity;

    public Order(String senderUsername, String receiverUsername, String pickUpLocation, String pickUpDate, String pickUpTime,
                 String dropOffTime, String goodType, String vehicleType, String weight, String width, String length,
                 String height, String quantity) {
        this.senderUsername = senderUsername;
        this.receiverUsername = receiverUsername;
        this.pickUpLocation = pickUpLocation;
        this.pickUpDate = pickUpDate;
        this.pickUpTime = pickUpTime;
        this.dropOffTime = dropOffTime;
        this.goodType = goodType;
        this.vehicleType = vehicleType;
        this.weight = weight;
        this.width = width;
        this.length = length;
        this.height = height;
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getSenderUsername() {
        return senderUsername;
    }

    public String getReceiverUsername() {
        return receiverUsername;
    }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public String getPickUpDate() {
        return pickUpDate;
    }

    public String getPickUpTime() {
        return pickUpTime;
    }

    public String getDropOffTime() {
        return dropOffTime;
    }

    public String getGoodType() {
        return goodType;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getWeight() {
        return weight;
    }

    public String getWidth() {
        return width;
    }

    public String getLength() {
        return length;
    }

    public String getHeight() {
        return height;
    }

    public String getQuantity() {
        return quantity;
    }
}
