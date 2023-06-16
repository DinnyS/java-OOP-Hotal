package Booking;

import java.util.List;

public class Bill {
    private static int bookedTime;
    private static int numRoom;
    private static String showTime;
    private int bookedDay;
    private static String bookedMeeting;
    private static String[] bookedHotel;
    private static double meetingPrice;
    private static double[] hotelPrice;
    private static int amountRoom;
    private static int i = 0;
    private static int people;
    private static String nameMeetingService;
    private static double priceMeetingService;
    private static String[][] detailHotelService;
    private static double[] priceHotelService;
    private String checkInDate;

    private List dateOfAll;

    //ที่ใช้เป็นตัวแปร static เพื่อให้ค่าที่เก็บไว้แปะอยู่กลับคลาส เวลาดึงค่าไปมาค่าจะได้ไม่เป็น default
    private double totalPrice = 0;
    private static String checkService;
    public Bill(){}
    public Bill(int bookedDay){
        //รับค่ามาจากคลาส Room เพื่อเอามาคิดราคารวมของ hotel room
        this.bookedDay = bookedDay; //เก็บจำนวนวันที่ได้จองไว้
    }
    public Bill(int time, int price, String type , String checkInDate , int getNumRoom) {
        //รับค่ามาจาก MeetingRoom เพื่อเอามาคิดราคารวม
        this.bookedTime = time; // เก็บเวลาที่ได้จองไว้
        this.meetingPrice = price; //เก็ยราคาของ meeting room
        this.bookedMeeting = type; //เก็บ type ของ meeting room
        this.checkInDate = checkInDate;
        this.numRoom = getNumRoom;

        if(bookedTime == 1){
            showTime = "All day";
        }
        else if(bookedTime == 2){
            showTime = "Half day (Morning)";
        }
        else if(bookedTime == 3){
            showTime = "Half day (Afternoon)";
        }
    }
    public Bill(String a, int numRoom){
        //รับค่ามาจาก HotelRoom เพื่อสร้าง Array ไว้เก็บข้อมูลตามจำนวนห้องที่ user ป้อนเข้ามา
        //String a สร้างไว้เฉยๆเพื่อกันการซ้ำกับ constructor ที่เก็บค่าจำนวนวันที่ถูกจอง
        this.amountRoom = numRoom;
        this.hotelPrice = new double[numRoom];  //สร้าง Array เก็บ detail ของห้องที่ user กดจอง
        this.bookedHotel = new String[numRoom]; //สร้าง Array เก็บ ราคา ของห้องที่ user กดจอง
    }
    public Bill(int price, String type){
        // รับค่ามาจาก HotelRoom เพื่อเอามาคิดราคารวม
        while (i < amountRoom){
            this.bookedHotel[i] = type; //เก็บ detail ของห้องที่ user กดจองไว้ใน array
            this.hotelPrice[i] = price;//เก็บราคาของห้องที่ user กดจองไว้ใน array
            break;
        }
        i++;
    }
    public Bill(String checkService){
        this.checkService = checkService;
    }
    public Bill(int people, String name, double price){
        this.people = people;
        this.nameMeetingService = name;
        this.priceMeetingService = price;
    }
    public Bill(String[][] detail, double[] price){
        //รับค่ามาจาก hotel service
        this.detailHotelService = detail;
        this.priceHotelService = price;
    }
    public double calPriceMeeting(){
        if (bookedTime == 1){
            //ถ้าเวลาที่จองเป็น 1 (All day) ราคาจะเป็นราคาเต็ม
            totalPrice = meetingPrice;
        }
        else {
            // แต่ถ้าเวลาที่ถูกจองเป็นอย่างอื่นจะเป็น half day
            totalPrice = meetingPrice/2; //ซึ่งราคาของห้องจะเป็นครึ่งนึงของราคาเต็ม
        }
        return totalPrice; //return ราคารวม
    }
    public double calHotelPrice(int numDay){
        //เอาราคาที่เก็บไว้ใน array มารวมกัน ใน totalPrice
        int totalPrice = 0;
        for(int a = 0; a < hotelPrice.length; a++){
            totalPrice += hotelPrice[a];
        }
        return totalPrice*numDay; //เอา totalPrice ที่รวมได้มาคูณกับจำนวนวันที่ user ได้จองไว้เพื่อหาราคารวม
    }
    public double calMeetingService(int people){
        return priceMeetingService*people;
    }

    public double calHotelService(){
        int totalPrice = 0;
        for(int b = 0; b < priceHotelService.length; b++){
            if(priceHotelService[b] == 0){
                break;
            }
            else {
                totalPrice += priceHotelService[b];
            }
        }
        return totalPrice;
    }
    public void showBill(){
        /*
            ฟังก์ชันที่เอาไว้สรุปรายการที่ user จองไว้
            โดยแยกระหว่าง meeting room กับ hotel room ด้วยการใช้ numDay
            ถ้า numDay == 0 จะเป็นในฝั่งของ meeting room
            แต่ถ้าไม่จะเข้า condition ของ hotel room
         */
        if(bookedDay == 0) {
            System.out.println("Type : " + bookedMeeting);
            //แสดงว่า user ได้จองห้องไหนไปบ้าง

            System.out.println("Time : " + showTime);
            //แสดงว่า user ได้จองห้องในเวลาไหน

            if(checkService.equals("Y")){
                System.out.println("Other Service : " + nameMeetingService);
                //แสดงว่า user ได้เลือก service package ไหน
            }

            System.out.println("-----------------------------------------------------------------------------");

            System.out.println("Meeting room price : " + calPriceMeeting());

            if(checkService.equals("Y")){
                System.out.println("Other service price " + calMeetingService(people));
            }

            System.out.println("Total price : " + (calPriceMeeting()+calMeetingService(people)) + " THB");
            //แสดงราคารวมของ bill นี้โดยดึงค่ามาจาก calMeetingPrice()
        }

        else{
            int room1 = 0;
            int room2 = 0;
            int room3 = 0;

            for (int a = 0; a < bookedHotel.length; a++){
                if(bookedHotel[a].equals("1. Basic Room")){
                    room1++;
                }
                else if (bookedHotel[a].equals("2. Deluxe Room")) {
                    room2++;
                }
                else if (bookedHotel[a].equals("3. Super Deluxe Room")) {
                    room3++;
                }
            }

            //เอาไว้นับจำนวนว่าห้อง type ไหน ถูกจองไปกี่ห้อง

            System.out.println("Type :");
            if(room1 != 0){
                System.out.println("   Basic Room [ "+room1+" room(s) ]");
            }
            if(room2 != 0){
                System.out.println("   Deluxe Room [ "+room2+" room(s) ]");
            }
            if(room3 != 0){
                System.out.println("   Super Deluxe Room [ "+room3+" room(s) ]");
            }

            //แสดงว่า user ได้จองห้องไหนไปบ้าง แล้วจองไปกี่ห้อง
            if(checkService.equals("Y")){
                 System.out.println("Other service :");

                for (int a = 0; a < 10; a++){
                    if(priceHotelService[a] == 0){break;}
                    else {System.out.println("   "+detailHotelService[a][0]+"  "+detailHotelService[a][1]);}
                }
            }

            System.out.println("-----------------------------------------------------------------------------");

            System.out.println("Hotel room price : " + calHotelPrice(bookedDay) + " THB");
            //แสดงราคารวมของ bill นี้โดยดึงค่ามาจาก calHotelPrice(int numDay)

            if(checkService.equals("Y")) {
                System.out.println("Other service price : " + calHotelService());
                System.out.println("Total price : " + (calHotelPrice(bookedDay)+calHotelService()) + " THB");
            }
            else {
                System.out.println("Total price : " + (calHotelPrice(bookedDay)) + " THB");
            }

            i = 0; //กำหนดให้ i = 0 เพื่อให้รีค่ากลับไปใหม่
        }
    }

    public int getBookedTime(){
        return bookedTime;
    }
    public int getNumOfRoom(){
        return numRoom;
    }
}
