package Booking;
import Booking.Service.Service;

import java.util.*;
import java.time.LocalDate;
import java.util.regex.Pattern;

import javax.sound.sampled.AudioFileFormat.Type;

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

        day += numDay; // วัน check in รวมกับจำนวนวันที่นอน

        if (day > currentDate.getDayOfMonth()){

            if (month == 12 && day > 31 ){ // ขึ้นปีใหม่
                month = 1;
                day = day - 31;
                year +=1;
            }

            // เดือน 2 ที่มี 29 วัน
            else if (month == 2 && year %4 == 0 && day > 29) {
                day = day - 29;
                month += 1;
            }

            // เดือน 2 ที่มี 28 วัน
            else if (month == 2 && day > 28) {
                    day = day - 28;
                    month += 1;
            }

            // เดือนที่มี 31 วัน (คม)
            else if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day > 31){
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
                    System.out.println("Please input correct date !!");
                }
                else if((month == 4 || month == 6 || month == 9 || month == 11) && day > 30){ // เช็ควัน ห้ามเกิน 30 วัน
                    System.out.println("Please input correct date !!");
                }

                else if (month == 2 && year %4 == 0 && day > 29) { // เดือน 2 ห้ามเกิน 29 วัน
                    System.out.println("Please input correct date !!");
                }
                else if (month == 2 && day > 28) { // เดือน 2 ห้ามเกิน 28 วัน
                    System.out.println("Please input correct date !!");
                }
                else if (month < 1 || month > 12) { // ห้ามเกินเดือน12 และห้ามต่ำกว่า1
                    System.out.println("Please input correct date !!");
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
            System.out.println("");
            System.out.println("----------- Check out -------------------------------------------------------");
            do{ //ใช้ loop เพื่อเชคค่า input ที่เข้ามาว่าถูกต้องไหม ถ้าไม่ถูกให้วนถามใหม่
                System.out.print("\u001B[31m");
                System.out.println("- The hotel will not allow customers to book our rooms online for more than 30 nights.");
                System.out.println("- If you wish to stay more than 30 nights, please contact the hotel reception directly.");
                System.out.print("\u001B[0m");
                System.out.println("-----------------------------------------------------------------------------");
                System.out.print("How long will you be staying? (Night): ");
                String strNumDay = in.nextLine().trim();
                int numDay;

                do {
                    if (Pattern.matches("^\\d+$", strNumDay)) {
                        numDay = Integer.parseInt(strNumDay);
                        if (numDay > 30) {
                            System.out.println("Number of nights cannot exceed 30! Please enter again.");
                            System.out.print("How long will you be staying? (Night): ");
                            strNumDay = in.nextLine().trim();
                        }
                    }
                } while (!(Pattern.matches("^\\d+$", strNumDay) && (Integer.parseInt(strNumDay) <= 30)));

                numDay = Integer.parseInt(strNumDay);
                strNumDay = String.valueOf(numDay);


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

    // -------------------- Hotel --------------------------------

    public void startBookingHotel(int selectBooking){ 
        checkIn();

        HotelRoom hRoom = new HotelRoom();
        hRoom.infoRoom();

        checkOut(selectBooking);
        Room room = new Room(selectBooking , getCheckInDate());
        Bill bils = new Bill();
        int amountRoom = bils.getamountRoom();

        AvailableHotel avaHotel = new AvailableHotel();
        List<String> allOfHotel = avaHotel.getAllOfHotel();

        int countDay = 0;
        for(int i = 0; i<=getNumDay()-1;i++){ // นับวันที่นอน
            int countRder = 0;
            for(int countR = 0; countR<hRoom.getCountRoomH(); countR++){ // นับห้อง

                if(avaHotel.getHotelFull() == false){
                    new AvailableHotel(checkInDate,getNumDay(),/*bils.getHotelType()*/hRoom.getSelectHRoom()[countRder],countDay);
                    countRder++;
                }

                if(avaHotel.getHotelFull() == true){
                    System.out.println("Sorry This Room is Full on " + avaHotel.getDateFullHotel());
                    System.out.println("------------------------------------------------------------------------------");
                    break;
                }
            }
            if(avaHotel.getHotelFull() == true){
                break;
            }

            if(i == (getNumDay()-1)){
                service(selectBooking);
                name();
                phone();
                bookingSummary(selectBooking);
                System.out.println("Thank you For Booking :)");
                System.out.println("------------------------------------------------------------------------------");
                break;
            }

            countDay++;
        }
        
    
    }

 // -------------------- Meeting --------------------------------

    public void startBooking(int selectBooking){
        checkIn();
        checkOut(selectBooking);
        Room room = new Room(selectBooking , getCheckInDate());
        /*เริ่มการจองแบบจริงๆ โดยใช้ constructor
        ส่งตัวเลือกการจอง ว่าจะเลือกจองห้องแบบไหน
            1 == จองห้องพักโรงแรม
            2 == จองห้องประชุม
         */
        AvailableMeeting availableM = new AvailableMeeting();
        List<String> dateOfAll = availableM.getDateOfAll();

        Bill billy = new Bill();
        int bookedTime = billy.getBookedTime();
        int numRoom = billy.getNumOfRoom();

        int countDateOfAll = 0;
        int roomMeeting = 0;
        boolean foundDateOfAll = false;
        for (String check : dateOfAll){
            // เขียนโค้ดเพื่อตรวจสอบและแก้ไขค่าตามเงื่อนไขที่ต้องการ
            if (check.startsWith(checkInDate) && check.endsWith("1") && numRoom == 1) {
                AvailableMeeting availableMeeting  = new AvailableMeeting(bookedTime , numRoom , checkInDate);//บอกรายละเอียดช่วงเวลาที่ได้จองห้อง meeting
                foundDateOfAll = true;
                if(availableM.getMeetCheck() == false){
                    service(selectBooking);
                    name();
                    phone();
                    bookingSummary(selectBooking);
                    
                    System.out.println(" -- Thank you For Booking -- ");
                    System.out.println("------------------------------------------------------------------------------");
                    break;
                }
                else{
                    System.out.println("------------------------------------------------------------------------------");
                    System.out.println(" -- Please Enter all data again ;( -- ");
                    System.out.println("------------------------------------------------------------------------------");
                    break;
                }
                
            }  
            else if (check.startsWith(checkInDate) && check.endsWith("2") && numRoom == 2) {
                AvailableMeeting availableMeeting  = new AvailableMeeting(bookedTime , numRoom , checkInDate);
                foundDateOfAll = true;
                if(availableM.getMeetCheck() == false){
                    service(selectBooking);
                    name();
                    phone();
                    bookingSummary(selectBooking);
                    
                    System.out.println(" -- Thank you For Booking -- ");
                    System.out.println("------------------------------------------------------------------------------");
                    break;
                }
                else{
                    System.out.println("------------------------------------------------------------------------------");
                    System.out.println(" -- Please Enter all data again ;( -- ");
                    System.out.println("------------------------------------------------------------------------------");
                    break;
                }
            }  
            else if (check.startsWith(checkInDate) && check.endsWith("3") && numRoom == 3) {
                AvailableMeeting availableMeeting  = new AvailableMeeting(bookedTime , numRoom , checkInDate);
                foundDateOfAll = true;
                if(availableM.getMeetCheck() == false){
                    service(selectBooking);
                    name();
                    phone();
                    bookingSummary(selectBooking);
                    
                    System.out.println(" -- Thank you For Booking -- ");
                    System.out.println("------------------------------------------------------------------------------");
                    break;
                }
                else{
                    System.out.println("------------------------------------------------------------------------------");
                    System.out.println(" -- Please Enter all data again ;( -- ");
                    System.out.println("------------------------------------------------------------------------------");
                    break;
                }
            }  
            else if (check.startsWith(checkInDate) && check.endsWith("4") && numRoom == 4) {
                AvailableMeeting availableMeeting  = new AvailableMeeting(bookedTime , numRoom , checkInDate);
                foundDateOfAll = true;
                if(availableM.getMeetCheck() == false){
                    service(selectBooking);
                    name();
                    phone();
                    bookingSummary(selectBooking);
                    
                    System.out.println(" -- Thank you For Booking -- ");
                    System.out.println("------------------------------------------------------------------------------");
                    break;
                }
                else{
                    System.out.println("------------------------------------------------------------------------------");
                    System.out.println(" -- Please Enter all data again ;( -- ");
                    System.out.println("------------------------------------------------------------------------------");
                    break;
                }
            }
            countDateOfAll++;  
        }

        if (foundDateOfAll == false && countDateOfAll == dateOfAll.size() && roomMeeting == 0){
            AvailableMeeting availableMeeting  = new AvailableMeeting(bookedTime , numRoom , checkInDate);
            service(selectBooking);
            name();
            phone();
            bookingSummary(selectBooking);
            
            System.out.println(" -- Thank you For Booking -- ");
            System.out.println("------------------------------------------------------------------------------");
        }

        if(dateOfAll.isEmpty()){
            AvailableMeeting availableMeeting  = new AvailableMeeting(bookedTime , numRoom , checkInDate);
            service(selectBooking);
            name();
            phone();
            bookingSummary(selectBooking);
            
            System.out.println(" -- Thank you For Booking -- ");
            System.out.println("------------------------------------------------------------------------------");
        }

    }

    public void service(int selectBooking){
        System.out.println(" ===== Other Service =====");
        System.out.println("   Press 'Y' for booking more service");
        System.out.println("   Press other for summarize order");
        System.out.println(" == Select == ");
        System.out.print("  : ");
        String selectService = in.nextLine().trim().toUpperCase();

        Bill checkService = new Bill(selectService);

        if(selectService.equals("Y")){
            Service service = new Service(selectBooking);
        }
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
