package Booking;
import java.util.*;


public class HotelRoom extends Room{

    private int numCustomers;

    public void setNumCustomers(int numCustomers) {
        this.numCustomers = numCustomers;
    }


    public HotelRoom(String type, int capacity, int price, int available) {
        super(type, capacity, price, available);
    }

    private static List<HotelRoom> hotelRooms = new ArrayList<>();

    static {
        hotelRooms.add(new HotelRoom("1. Basic Room", 3, 3500, 20));
        hotelRooms.add(new HotelRoom("2. Deluxe Room", 6, 5500, 15));
        hotelRooms.add(new HotelRoom("3. Super Deluxe Room", 8, 8000, 5));
    }

    protected static List<HotelRoom> getHotelRooms() {
        return hotelRooms;
    }

}