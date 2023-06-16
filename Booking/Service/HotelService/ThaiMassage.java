package Booking.Service.HotelService;

import Booking.Service.HotelService.HotelService;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ThaiMassage extends HotelService {
    private static int hour;
    private double totalPrice;
    public ThaiMassage(){
    }
    public ThaiMassage(String order, String name, double price, String moreDetail) {
        super(order, name, price, moreDetail);
    }
    public void receiveValue(){
        Scanner sc = new Scanner(System.in);
        do{
            System.out.print("How long a hour : ");
            String hourSTR = sc.nextLine().trim();
            if (Pattern.matches("\\d+$",hourSTR)){
                hour = Integer.parseInt(hourSTR);
                break;
            }
            else{
                System.out.println("\n !!!Please enter only integer!!! \n");
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
