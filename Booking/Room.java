package Booking;

import java.util.Scanner;

public class Room {
    private String type;
    private int capacity;
    private int price;
    private int available;


    public Room(String type, int price, int available) {
        this.type = type;
        this.price = price;
        this.available = available;
    }

    public Room(String type, int capacity, int price, int available) {
        this.type = type;
        this.capacity = capacity;
        this.price = price;
        this.available = available;
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

    Scanner in = new Scanner(System.in);

    Room(int selectBooking){

        if (selectBooking == 1){
            HotelRoom hotelRoom = new HotelRoom(getType(),getCapacity(),getPrice(),getAvailable());
            hotelRoom.infoRoom();
            hotelRoom.selectBooking();

        } else if (selectBooking == 2) {
            MeetingRoom meetingRoom = new MeetingRoom(getType(),getPrice(),getCapacity());
            meetingRoom.infoRoom();
            meetingRoom.selectBooking();
        }
    }

    public Room(int numDay, int  selectBooking){
        if(selectBooking == 1){
            Bill hotelBill = new Bill(numDay);
            System.out.println("( "+ (numDay+1) + " Day(s) , " + numDay + " Night(s) )");
            hotelBill.showBill();
        }
        else if(selectBooking == 2){
            Bill meetingBill = new Bill();
            meetingBill.showBill();
        }
    }
}
