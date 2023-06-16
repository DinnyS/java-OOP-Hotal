package Booking.Service;

import Booking.Bill;
import Booking.SelectBooking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MeetingService extends Service implements InfoService, SelectBooking {
    private static int time;
    private static int people;
    public MeetingService(String order,String name, double price, String moreDetail) {
        super(order,name, price, moreDetail);
    }
    public MeetingService(int time, String type){
        this.time = time;
        if(type.equals("1. The Universe (250 people)")){people = 250;}
        else if (type.equals("2. The World (100 people)")){people = 100;}
        else if (type.equals("3. The Mini World (50 people)")){people = 50;}
        else if (type.equals("4. The Town (50 people)")){people = 50;}
    }
    private static List<MeetingService> meetingServices = new ArrayList<>();

    static {
        meetingServices.add(new MeetingService("A.","2 coffee breaks + 1 lunch",600,"only full day"));
        meetingServices.add(new MeetingService("B.","1 coffee break + 1 lunch",450,"only half day"));
        meetingServices.add(new MeetingService("C.","3 coffee breaks",250,"all package"));
        meetingServices.add(new MeetingService("D.","International buffet with Soft Drink",750,"all package"));
        meetingServices.add(new MeetingService("E.","Seafood buffet with Soft Drink",1000,"all package"));
    }

    protected static List<MeetingService> getMeetingService(){
        return meetingServices;
    }

    @Override
    public void infoService() {
        List<MeetingService> services = MeetingService.getMeetingService();
        System.out.println("\n---------------------------------------------------------------");
        System.out.format("%-40s %-20s\n", "Package", "Price/Person (Baht)");
        System.out.println("---------------------------------------------------------------");

        if(time == 1){
            System.out.format("%-2s %-40s %-10s\n",
                    meetingServices.get(0).getOrder(), meetingServices.get(0).getName(), meetingServices.get(0).getPrice());
            System.out.format("%-2s %-40s %-10s\n",
                    meetingServices.get(2).getOrder(), meetingServices.get(2).getName(), meetingServices.get(2).getPrice());
            System.out.format("%-2s %-40s %-10s\n",
                    meetingServices.get(3).getOrder(), meetingServices.get(3).getName(), meetingServices.get(3).getPrice());
            System.out.format("%-2s %-40s %-10s\n",
                    meetingServices.get(4).getOrder(), meetingServices.get(4).getName(), meetingServices.get(4).getPrice());
        }

        else if (time == 2 || time == 3) {
            System.out.format("%-2s %-40s %-10s\n",
                    meetingServices.get(1).getOrder(), meetingServices.get(1).getName(), meetingServices.get(1).getPrice());
            System.out.format("%-2s %-40s %-10s\n",
                    meetingServices.get(2).getOrder(), meetingServices.get(2).getName(), meetingServices.get(2).getPrice());
            System.out.format("%-2s %-40s %-10s\n",
                    meetingServices.get(3).getOrder(), meetingServices.get(3).getName(), meetingServices.get(3).getPrice());
            System.out.format("%-2s %-40s %-10s\n",
                    meetingServices.get(4).getOrder(), meetingServices.get(4).getName(), meetingServices.get(4).getPrice());
        }

        System.out.println("The number of people is based on the maximum capacity of the room.");
        System.out.println("---------------------------------------------------------------");
    }

    @Override
    public void selectBooking() {

        Scanner scan = new Scanner(System.in);

        do{
            System.out.print("Select type of package [A-E]: ");
            String selectPackage = scan.nextLine().trim().toUpperCase();

            if (selectPackage.equals("A")){
                Bill bill = new Bill(people, meetingServices.get(0).getName(), meetingServices.get(0).getPrice());
                break;
            }
            else if (selectPackage.equals("B")){
                Bill bill = new Bill(people, meetingServices.get(1).getName(), meetingServices.get(1).getPrice());
                break;
            }
            else if (selectPackage.equals("C")){
                Bill bill = new Bill(people, meetingServices.get(2).getName(), meetingServices.get(2).getPrice());
                break;
            }
            else if (selectPackage.equals("D")){
                Bill bill = new Bill(people, meetingServices.get(3).getName(), meetingServices.get(3).getPrice());
                break;
            }
            else if (selectPackage.equals("E")){
                Bill bill = new Bill(people, meetingServices.get(4).getName(), meetingServices.get(4).getPrice());
                break;
            }
            else{
                System.out.println("\n!!! Please select only the options available here !!!\n");
            }
        }while (true);
    }
}