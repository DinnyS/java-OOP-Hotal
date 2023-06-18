package Booking.Service.HotelService;

import Booking.Booking;

import java.util.Scanner;
import java.util.regex.Pattern;

public class PickUp extends HotelService{
    private static int day;
    private double totalPrice;
    public PickUp(){}
    public PickUp(String order, String name, double price, String moreDetail) {
        super(order, name, price, moreDetail);
    }
    public void receiveValue(){
        Scanner sc = new Scanner(System.in);
        do{
            Booking booking = new Booking();
            System.out.print("Enter amount of day : ");
            String daySTR = sc.nextLine().trim();
            if (Pattern.matches("\\d+$",daySTR)){
                day = Integer.parseInt(daySTR);
                if(day < 1){
                    System.out.println("\u001B[31m!!!must be booked at least 1 hour!!!\u001B[0m");
                }
                else if(day > (booking.getNumDay()+1)){
                    System.out.println("\u001B[31m!!!You cannot book more than the number of days you stay!!!\u001B[0m");
                }
                else {
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
        totalPrice = 600*day;
        return totalPrice;
    }
    public String showDetail(){
        return day+" day(s)";
    }
}
