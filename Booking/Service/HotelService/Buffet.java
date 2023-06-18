package Booking.Service.HotelService;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Buffet extends HotelService{
    private static int people;
    private double totalPrice;
    public Buffet(){
    }
    public Buffet(String order, String name, double price, String moreDetail) {
        super(order, name, price, moreDetail);
    }

    public void receiveValue(){
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        do{
            System.out.print("Enter amount of customer : ");
            String peopleSTR = sc.nextLine().trim();
            if (Pattern.matches("\\d+$",peopleSTR)){
                people = Integer.parseInt(peopleSTR);
                if(people < 1){
                    System.out.println("\u001B[31m!!!must be booked at least 1 hour!!!\u001B[0m");
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
        totalPrice = 1200*people;
        return totalPrice;
    }
    public String showDetail(){
        return people+" customer(s)";
    }
}
