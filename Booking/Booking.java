package Booking;
import java.util.*;
import java.time.LocalDate;
import java.util.regex.Pattern;

public class Booking {
    private int year;
    private int month;
    private int day;
    private int numDay;
    private String checkInDate;
    private String checkOutDate;
    private String name;
    private String phone;

    LocalDate currentDate = LocalDate.now();
    public int getNumDay() {
        return numDay;
    }
    public void setNumDay(int numDay) {
        this.numDay = numDay;
    }
    public void setCheckInDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;

        checkInDate = day + "/" + month + "/" + year;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(int numDay){
        day = getDay();
        month = getMonth();
        year = getYear();

        day += numDay; // วัน checkin รวมกับจำนวนวันที่นอน

        if (day > currentDate.getDayOfMonth()){
            if (month == 12 && day > 31 ){ // ขึ้นปีใหม่
                month = 1;
                day = day - 31;
                year +=1;
            } 
            
            else if (month == 2 && year %4 == 0 && day > 29) { // เดือน 2 ที่มี 29 วัน
                day = day - 29;
                month += 1;
            }

            else if (month == 2 && day > 28) { // เดือน 2 ที่มี 28 วัน
                    day = day - 28;
                    month += 1;
            } 

            else if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day > 31){ // เดือนที่มี 31 วัน (คม)
                day = day - 31;
                month += 1;
            }

            else if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30){ // เดือนที่มี 30 วัน (ยน)
                day = day - 30;
                month += 1;
            }
        }

        checkOutDate = day + "/" + month + "/" + year;
    }
    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    Scanner in = new Scanner(System.in);

    private void checkIn(){

        boolean check = false;
        String date;

        while (!check) {
            System.out.print("Enter a date (dd/mm/yyyy) : ");
            date = in.nextLine();
            String[] parts = date.split("/");

            if (parts.length == 3) {
                day = Integer.parseInt(parts[0]);
                month = Integer.parseInt(parts[1]);
                year = Integer.parseInt(parts[2]);

                if((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day > 31){ // เช็ควัน ห้ามเกิน 31 วัน
                    System.out.println("Please input correct date 1");
                }
                else if((month == 4 || month == 6 || month == 9 || month == 11) && day > 30){ // เช็ควัน ห้ามเกิน 30 วัน
                    System.out.println("Please input correct date 2");
                }

                else if (month == 2 && year %4 == 0 && day > 29) { // เดือน 2 ห้ามเกิน 29 วัน
                    System.out.println("Please input correct date 3");
                }
                else if (month == 2 && day > 28) { // เดือน 2 ห้ามเกิน 28 วัน
                    System.out.println("Please input correct date 4");
                }

                else if ((year == currentDate.getYear() && year < 2026 ) && month == currentDate.getMonthValue() && day >= currentDate.getDayOfMonth()) {
                    check = true;
                } 

                else if ((year > currentDate.getYear() && year < 2026 ) || (year == currentDate.getYear() && month > currentDate.getMonthValue())) {
                    check = true;
                } 
                else {
                    if (year >= 2026){
                        System.out.println("* Sorry, the hotel can only be booked until 2025. Please try again *");
                    }else {
                        System.out.println("Invalid date!");
                    }

                }

                setCheckInDate(day,month,year);

            }
            else {
                System.out.println("Invalid date format!");
            }
        }
    }

    private void checkOut(int selectBooking){ //รับค่ามาเชตว่าจองห้องโรงแรมหรือห้องประชุม

        if (selectBooking == 1){ //Hotel room
            System.out.println("----------- Check out -----------");
            do{ //ใช้ loop เพื่อเชคค่า input ที่เข้ามาว่าถูกต้องไหม ถ้าไม่ถูกให้วนถามใหม่
                System.out.print("How long will you be staying ? (Night): ");
                String strNumDay = in.nextLine().trim(); //ถามจำนวนวันที่จะเข้าพัก
                if (Pattern.matches("\\d+$",strNumDay)){ //input amount of day in String ✓✓
                    numDay = Integer.parseInt(strNumDay);
                    setCheckOutDate(numDay);
                    setNumDay(numDay);
                    break;
                }
                else{
                    System.out.println("\n !!!Please enter only integer!!! \n");
                }
            }while (true);

        }

        else if (selectBooking == 2) {
            //ในส่วนของ meeting room จะไม่ได้มีการถามอะไรเพิ่มเติม
        }

        else {
            System.out.println("Invalid data!");
        }

    }

    private void name(){
        //method ถามชื่อ
        System.out.print("name : ");
        name = in.nextLine();
    }

    private void phone(){
        //method ถามเบอร์โทร
        System.out.print("Phone number : ");
        phone = in.nextLine();

        String phoneLimit = "\\d{10}";

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

    public void startBooking(int selectBooking){
        checkIn();
        checkOut(selectBooking);
        Room room = new Room(selectBooking);
        /*เริ่มการจองแบบจริงๆ โดยใช้ constructor
        ส่งตัวเลือกการจอง ว่าจะเลือกจองห้องแบบไหน
            1 == จองห้องพักโรงแรม
            2 == จองห้องประชุม
         */
        name();
        phone();
    }

    public void bookingSummary(int selectBooking){
        //method แสดงรายละเอียดการจองทั้งหมด (ในแต่ละ Bill จะจองได้แค่อย่างใดอย่างหนึ่ง ไม่ห้องพักก็ห้องประชุม)
        System.out.println("\n------------------------------ Booking Summary ------------------------------");
        System.out.println("Name : " + name);
        System.out.println("Telephone number : " + phone);
        System.out.println("Check in : " + getCheckInDate());
        if (selectBooking == 1){
            //ถ้าเป็นการของโรงแรม จะมีการโชว์วัน check out
            System.out.println("Check out : " + getCheckOutDate());
        }
        Room roomBill = new Room(getNumDay(),selectBooking); //ส่งต่า numDay และ selectBooking ไปใช้ใน class Room
        System.out.println("------------------------------------------------------------------------------");
    }







}
