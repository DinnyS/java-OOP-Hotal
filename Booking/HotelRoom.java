package Booking;

import java.util.*;

public class HotelRoom extends Room{

    private ArrayList<HotelRoom> rooms;

    public HotelRoom(String type, int capacity, int price, int available) {
        super(type, capacity, price, available);
        rooms = new ArrayList<>();

    }

}

