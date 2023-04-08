package Booking;
import java.util.*;

public class Booking {
    private String yearH;
    private String monthH;
    private String dayH;

    private String room;

    private  int person;

    private String meeting;

    private String Timemeeting;

    private String name;

    private String phone;


    Scanner in = new Scanner(System.in);

    public void checkIn(){
        System.out.println("---------- Check in ----------"); //ใส่วัน เดือน ปี ที่จะเข้าพัก
        System.out.print("Year : ");
        yearH = in.nextLine();

        System.out.print("Month : ");
        monthH = in.nextLine();

        System.out.print("Day : ");
        dayH = in.nextLine();
    }

    public void checkOut(int selectBooking){

        if (selectBooking == 1){
            System.out.println("---------- Data ----------"); // CheckOut ค่อยเขียนตอนแสดงผล
            System.out.println("Please select your preferred room. ");
            System.out.println("     1. Basic Booking.Room (1-3)         3,500 Baht/day");
            System.out.println("     2. Deluxe Booking.Room (4-6)        5,500 Baht/day");
            System.out.println("     3. Super Deluxe Booking.Room (7-8)  8,000 Baht/day");
            room = in.nextLine();
            System.out.println("How many guests will stay ? ");
            person = in.nextInt();
            System.out.println("How long will you be staying ? ");
            dayH += in.nextLine();
        }

        else if (selectBooking == 2) {
            System.out.println("---------- Data ----------"); // CheckOut ค่อยเขียนตอนแสดงผล
            System.out.println("Please select the size of the meeting room you would like. ");
            System.out.println("     1. The Universe (250)      50,000 Baht/day    25,000 Baht/half day ");
            System.out.println("     2. The World (100)         30,000 Baht/day    15,000 Baht/half day ");
            System.out.println("     3. The Mini World (50)     20,000 Baht/day    10,000 Baht/half day ");
            System.out.println("     4. The Town (50)           20,000 Baht/day    10,000 Baht/half day ");
            meeting = in.nextLine();
            System.out.println("Which meeting room will you choose ?");
            System.out.println("1.Morning half day meeting");
            System.out.println("2.Half day evening meeting");
            System.out.println("3.Full day meeting");
            Timemeeting = in.nextLine();

        }

    }

    public void name(){
        System.out.print("name : "); //ใส่ชื่อผู้จอง
        name = in.nextLine();
    }

    public void phone(){

        System.out.print("Phone number : "); //เบอร์โทรติดต่อ
        phone = in.nextLine();
        String phoneLimit = "\\d{10}"; // ต้องใส่เบอร์โทรศัพให้ครบ 10 ตัว
        boolean check = true;
        while (check){
            if (!phone.matches(phoneLimit)){
                System.out.println("* Invalid data!! Please try again *");
                System.out.print("Phone number : ");
                phone = in.nextLine();
                phoneLimit = "\\d{10}";
            }else {
                check = false;
            }
        }

    }





}
