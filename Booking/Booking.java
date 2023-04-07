package Booking;
import java.util.*;

public class Booking {
    private String yearH;
    private String monthH;
    private String dayH;
    private String hours;

    private String name;

    private String phone;


    Scanner in = new Scanner(System.in);

    public void checkIn(){
        System.out.println("---------- Check in ----------");
        System.out.print("Year : ");
        yearH = in.nextLine();

        System.out.print("Month : ");
        monthH = in.nextLine();

        System.out.print("Day : ");
        dayH = in.nextLine();
    }

    public void checkOut(int selectBooking){

        if (selectBooking == 1){
            System.out.println("---------- Check out ----------");
            System.out.print("How long will you be staying ? : ");
            dayH += in.nextLine();
        }

        else if (selectBooking == 2) {
            System.out.println("---------- Check out ----------");
            System.out.println("How many hours will you be booking ?");
            hours = in.nextLine();
        }

    }

    public void name(){
        System.out.print("name : ");
        name = in.nextLine();
    }

    public void phone(){

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






}
