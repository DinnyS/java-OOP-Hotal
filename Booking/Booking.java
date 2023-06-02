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

        day += numDay-1;

        if (day > currentDate.getDayOfMonth()){
            if (month == 12){
                month = 1;
                day = numDay;
                year +=1;
            } else if (month == 4 && day > 28 || day > 29 ) {
                day = numDay;
                month += 1;
            } else if (day == 32 || day == 31) {
                day = numDay;
                month += 1;
            }
        }

        checkOutDate = day + "/" + month + "/" + year;
    }

    private String name;

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
    private String phone;
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

                if ((year == currentDate.getYear() && year < 2025 ) && month == currentDate.getMonthValue() && day >= currentDate.getDayOfMonth()) {
                    check = true;
                } else if ((year > currentDate.getYear() && year < 2025 ) || (year == currentDate.getYear() && month > currentDate.getMonthValue())) {
                    check = true;
                } else {
                    if (year <= 2025){
                        System.out.println("* Sorry, the hotel can only be booked until 2024. Please try again *");
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

    private void checkOut(int selectBooking){

        if (selectBooking == 1){
            System.out.println("----------- Check out -----------");
            do{
                System.out.print("How long will you be staying ? : ");
                String strNumDay = in.nextLine().trim();
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

        }

        else {
            System.out.println("Invalid data!");
        }

    }

    private void name(){
        System.out.print("name : ");
        name = in.nextLine();
    }

    private void phone(){

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
        name();
        phone();
        System.out.println(getCheckInDate());
        if (selectBooking == 1){
            System.out.println(getCheckOutDate());
        }
    }

    public void bookingSummary(int selectBooking){
        System.out.println("\n------------------------------ Booking Summary ------------------------------");
        System.out.println("Name : " + name);
        System.out.println("Telephone number : " + phone);
        System.out.println("Check in : " + getCheckInDate());
        if (selectBooking == 1){
            System.out.println("Check out : " + getCheckOutDate());
        }
        Room roomBill = new Room(getNumDay(),selectBooking);
        System.out.println("------------------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        Booking booking = new Booking();
        booking.startBooking(1);
    }







}
