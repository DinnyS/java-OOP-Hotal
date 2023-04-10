package Booking;
import java.util.*;
import java.time.LocalDate;

public class Booking {
    private String year;
    private String month;
    private String day;
    private int hours;

    private String name;

    private String phone;



    Scanner in = new Scanner(System.in);

    public void checkIn(){
        LocalDate currentDate = LocalDate.now();
        boolean check = false;
        String date = null;

        while (!check) {
            System.out.println("***** Please enter the number as a Gregorian data *****");
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

    public void Information(int selectBooking){

        if (selectBooking == 1){
            System.out.println("---------- Information ----------");
            System.out.print("How long will you be staying ? : ");
            day += in.nextLine();
        }

        else if (selectBooking == 2) {
            boolean check = true;
            System.out.println("---------- Information ----------");
            System.out.println("Which package do you need?");
            System.out.println("*** The half day price will be half the full day price ***");
            System.out.println(" == Select == ");
            System.out.println(" 1. All day");
            System.out.println(" 2. Half day (Morning)");
            System.out.println(" 3. Half day (Afternoon)");
            System.out.println();
            System.out.print(" : ");
            hours = in.nextInt();
            while (check) {
                if (hours<1||hours>3){
                    System.out.println("!!! Please select only the options available here !!!");
                    System.out.println("Which package do you need?");
                    System.out.println("*** The half day price will be half the full day price ***");
                    System.out.println(" == Select == ");
                    System.out.println(" 1. All day");
                    System.out.println(" 2. Half day (Morning)");
                    System.out.println(" 3. Half day (Afternoon)");
                    System.out.println();
                    System.out.print(" : ");
                    hours = in.nextInt();
                }
                else {
                    check = false;
                }

            }

        }

    }

    public void name(){
        System.out.print("name ");
        System.out.println();
        System.out.print(" : ");
        name = in.nextLine();
        System.out.println();
    }

    public void phone(){

        System.out.print("Phone number ");
        System.out.println();
        System.out.print(" : ");
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
        Information(selectBooking);
        Room bookRoom = new Room(selectBooking);
        name();
        phone();
    }


}
