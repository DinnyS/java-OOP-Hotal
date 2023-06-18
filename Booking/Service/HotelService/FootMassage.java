package Booking.Service.HotelService;

import java.util.Scanner;
import java.util.regex.Pattern;

public class FootMassage extends HotelService{
    private static int hour;
    private double totalPrice;
    public FootMassage(){
    }
    public FootMassage(String order, String name, double price, String moreDetail) {
        super(order, name, price, moreDetail);
    }

    public void receiveValue(){
        Scanner sc = new Scanner(System.in);
        System.out.println("This package can be booked up to 5 hours.");
        do{
            System.out.print("Enter the number of hours you want : ");
            String hourSTR = sc.nextLine().trim();
            if (Pattern.matches("\\d+$",hourSTR)){
                hour = Integer.parseInt(hourSTR);
                if(hour < 1){
                    System.out.println("\u001B[31m!!!must be booked at least 1 hour!!!\u001B[0m");
                }
                else if(hour > 5){
                    System.out.println("\u001B[31m!!!This package can be booked up to 5 hours.!!!\u001B[0m");
                }
                else{
                    break;
                }
            }
            else{
                System.out.println("\u001B[31m!!!Please enter only integer!!!\u001B[0m");
            }
        }while (true);

        calPrice();
    }
    public double calPrice(){
        totalPrice = 400*hour;
        return totalPrice;
    }
    public String showDetail(){
        return hour+" hour";
    }
}
