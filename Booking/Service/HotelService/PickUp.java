package Booking.Service.HotelService;

import java.util.Scanner;
import java.util.regex.Pattern;

public class PickUp extends HotelService{
    private int round;
    private static String detail;
    private double totalPrice;
    public PickUp(){}
    public PickUp(String order, String name, double price, String moreDetail) {
        super(order, name, price, moreDetail);
    }
    public void receiveValue(){
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("1. Pick up customers from the airport to the hotel");
            System.out.println("2. Pick up customers from the hotel to the airport");
            System.out.println("3. Pick up and drop off customers between the airport and the hotel");
            System.out.println(" == Select == ");
            System.out.print("  : ");
            String roundSTR = sc.nextLine().trim();
            if (Pattern.matches("\\d+$",roundSTR)){
                round = Integer.parseInt(roundSTR);
                if(round < 1 || round > 3){
                    System.out.println("\u001B[31m!!!must be booked at least 1 day!!!\u001B[0m");
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
        if(round != 3){
            totalPrice = 350;
        }
        else{
            totalPrice = 700;
        }
        return totalPrice;
    }
    public String showDetail(){
        if(round == 1){
            detail = "Pick up customers from the airport to the hotel";
        }
        else if(round == 2){
            detail = "Pick up customers from the hotel to the airport";
        }
        else{
            detail = "Pick up and drop off customers between the airport and the hotel";
        }
        return detail;
    }
}
