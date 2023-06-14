package Booking;

import java.util.Scanner;

public class Room {
    private String type;
    private int capacity;
    private int price;
    private int available;
    private static String availableMeet;

    public Room(String type, int price, String availableMeet) {
        //ใช้ใน Meeting room
        this.type = type;
        this.price = price;
        this.availableMeet = availableMeet;
    }

    public Room(String type, int capacity, int price, int available) {
        //ใช้ใน Hotel room
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

    public String getAvailableMeet(){
        return availableMeet;
    }

    Scanner in = new Scanner(System.in);

    Room(int selectBooking , String CheckInDate){

        if (selectBooking == 1){
            HotelRoom hotelRoom = new HotelRoom(getType(),getCapacity(),getPrice(),getAvailable());
            hotelRoom.infoRoom();
            hotelRoom.selectBooking();

        } else if (selectBooking == 2) {
            MeetingRoom meetingRoom = new MeetingRoom(getType(),getPrice(),availableMeet,CheckInDate);
            meetingRoom.infoRoom();
            meetingRoom.selectBooking();
        }
    }

    public Room(int numDay, int  selectBooking){
        //เป็น constructor ที่สร้างมาจาก bookingSummary จากคลาส Booking
        if(selectBooking == 1){
            Bill hotelBill = new Bill(numDay); //ส่งค่า numDay ไปเอาไว้ใช้ตอนคิดเงินของ hotel room
            System.out.println("( "+ (numDay+1) + " Day(s) , " + numDay + " Night(s) )"); //print ให้เห็นว่าพักกี่วันกี่คืน
            hotelBill.showBill(); //เรียกฟังก์ชัน showBill() เพื่อแสดงผลที่จองไป
        }
        else if(selectBooking == 2){
            Bill meetingBill = new Bill();
            meetingBill.showBill(); //เรียกฟังก์ชัน showBill() เพื่อแดงผลที่จองไป
        }
    }
}
