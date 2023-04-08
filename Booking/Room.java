package Booking;

public class Room {

    private String type;
    private int capacity;
    private int price;

    private int available;

    //constructor of hotel room
    public Room(String type, int capacity, int price, int available) {
        this.type = type;
        this.capacity = capacity;
        this.price = price;
        this.available = available;
    }

    //constructor of meeting room
    public Room(String type, int price) {
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPrice() {
        return price;
    }

    public int getAvailable(){
        return available;
    }






}
