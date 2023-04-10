package Booking;

import java.util.List;
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

    public void infoHotel(){
        List<HotelRoom> rooms = HotelRoom.getHotelRooms();
        System.out.println("--------------------------------------------------------------------");
        System.out.format("%-20s %-15s %-15s %-10s%n", "Room Type", "Capacity", "Price (Baht)", "Room available");
        System.out.println("--------------------------------------------------------------------");
        for (HotelRoom hotelRoom : rooms) {
            System.out.format("%-20s %-15d %-15d %-10s%n", hotelRoom.getType(), hotelRoom.getCapacity(), hotelRoom.getPrice(), hotelRoom.getAvailable());
        }
        System.out.println("--------------------------------------------------------------------");
    }

    public void infoMeeting(){
        List<MeetingRoom> rooms = MeetingRoom.getMeetingRooms();
        System.out.println("--------------------------------------------------------------");
        System.out.format("%-30s %-15s %-10s%n", "Room Type", "Price (Baht)", "Room available");
        System.out.println("--------------------------------------------------------------");
        for (MeetingRoom meetingRoom : rooms) {
            System.out.format("%-30s %-15d %-10s%n", meetingRoom.getType(), meetingRoom.getPrice(), meetingRoom.getAvailable());
        }
        System.out.println("--------------------------------------------------------------");
    }

    public static Room suggestRoom(List<? extends Room> rooms, int numCustomers) {
        for (Room room : rooms) {
            if (room.getCapacity() >= numCustomers && room.getAvailable() > 0) {
                return room;
            }
        }
        return null; // no available room found
    }

    Scanner in = new Scanner(System.in);

    Room(int selectBooking){
        if (selectBooking == 1){
            infoHotel();
            System.out.println("Enter number of room(s) : ");
            int numRoom = in.nextInt();

            for (int i =1; i<= numRoom; i++){

                System.out.print("Enter number of customers ( " + i + " ) : ");
                int numCustomers = in.nextInt();
                Room room = Room.suggestRoom(HotelRoom.getHotelRooms(), numCustomers);

                if (room != null) {
                    System.out.println("Suggested room : " + room.getType());

                } else {
                    System.out.println("No available rooms for " + numCustomers + " customers.");
                }
            }


        } else if (selectBooking == 2) {
            infoMeeting();
        }
    }

    private void setAvailable(int available) {
        this.available=available;
    }


}
