package Booking.Service.HotelService;

import java.util.Scanner;
import java.util.regex.Pattern;

public class PickUp extends HotelService{
    private static int day;
    private double totalPrice;
    public PickUp(){
    }
    public PickUp(String order, String name, double price, String moreDetail) {
        super(order, name, price, moreDetail);
    }
    public void receiveValue(){
        Scanner sc = new Scanner(System.in);
        do{
            System.out.print("Enter amount of day : ");
            String daySTR = sc.nextLine().trim();
            if (Pattern.matches("\\d+$",daySTR)){
                day = Integer.parseInt(daySTR);
                break;
            }
            else{
                System.out.println("\n !!!Please enter only integer!!! \n");
            }
        }while (true);

        calPrice();
    }
    public double calPrice(){
        totalPrice = 600*day;
        return totalPrice;
    }
    public String showDetail(){
        return day+" day(s)";
    }
}
