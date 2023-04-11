package Booking;
import java.util.*;
import java.time.LocalDate;

public class Booking {
    private String year;
    private String month;
    private String day;

    private String name;

    public String getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public String getDay() {
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
        LocalDate currentDate = LocalDate.now();
        boolean check = false;
        String date;

        while (!check) {
            System.out.print("Enter a date (dd/mm/yyyy) : ");
            date = in.nextLine();
            String[] parts = date.split("/");

            if (parts.length == 3) {
                int day = Integer.parseInt(parts[0]);
                int month = Integer.parseInt(parts[1]);
                int year = Integer.parseInt(parts[2]);

                if (year == currentDate.getYear() && month == currentDate.getMonthValue() && day >= currentDate.getDayOfMonth()) {
                    check = true;
                } else if (year > currentDate.getYear() || (year == currentDate.getYear() && month > currentDate.getMonthValue())) {
                    check = true;
                } else {
                    System.out.println("Invalid date!");
                }
            } else {
                System.out.println("Invalid date format!");
            }
        }
    }

    private void checkOut(int selectBooking){

        if (selectBooking == 1){
            System.out.println("---------- Check out ----------");
            System.out.print("How long will you be staying ? : ");
            day += in.nextLine();
        }

        else if (selectBooking == 2) {
            System.out.print("");
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
    }







}
