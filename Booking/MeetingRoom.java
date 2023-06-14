package Booking;
import Booking.Service.MeetingService;

import java.util.*;

public class MeetingRoom extends Room implements InfoRoom , SelectBooking{
    private int numRoom;
    private int time;
    private static String CheckInDate;
    public void setNumRoom(int numRoom) {
        this.numRoom = numRoom;
    }
    public void setTime(int time) {
        this.time = time;
    }
    public int getNumRoom() {
        return numRoom;
    }

    public int getTime() {
        return time;
    }
    protected MeetingRoom(String type, int price, String available , String CheckInDate) {
        super(type, price, available);
        this.CheckInDate = CheckInDate;
    }

    private static List<MeetingRoom> meetingRooms = new ArrayList<>();

    static {
        
        meetingRooms.add(new MeetingRoom("1. The Universe (250 people)", 50000, "Empty Allday",CheckInDate));

        meetingRooms.add(new MeetingRoom("2. The World (100 people)",30000,"Empty Allday",CheckInDate));

        meetingRooms.add(new MeetingRoom("3. The Mini World (50 people)", 20000,"Empty Allday",CheckInDate));

        meetingRooms.add(new MeetingRoom("4. The Town (50 people)",20000,"Empty Allday",CheckInDate));

    }

    protected static List<MeetingRoom> getMeetingRooms(){
        return meetingRooms;
    }
    
    @Override
    public void infoRoom() {

        AvailableMeeting availM = new AvailableMeeting();
        List<String> dateOfAll = availM.getDateOfAll();

        String meetRoom1 = "Allday";
        String meetRoom2 = "Allday";
        String meetRoom3 = "Allday";
        String meetRoom4 = "Allday";

        int countDateOfAll = 0;
        int roomMeeting = 0;
        boolean foundDateOfAll = false;

        for (String check : dateOfAll){
            if (check.startsWith(CheckInDate) && check.endsWith("1")){
                if(check.startsWith(CheckInDate + "/" + "0" + "/" + "0" + "/" + "1" + "/" + "1") && check.endsWith("1")){
                    meetRoom1 = "Full";
                }
                else if(check.startsWith(CheckInDate + "/" + "1" + "/" + "1" + "/" + "0" + "/" + "1") && check.endsWith("1")){
                    meetRoom1 = "Full";
                }
                else if(check.startsWith(CheckInDate + "/" + "0" + "/" + "1" + "/" + "0" + "/" + "1") && check.endsWith("1")){
                    meetRoom1 = "Morning";
                }
                else if(check.startsWith(CheckInDate + "/" + "1" + "/" + "0" + "/" + "0" + "/" + "1") && check.endsWith("1")){
                    meetRoom1 = "Afternoon";
                }
            }
            if (check.startsWith(CheckInDate) && check.endsWith("2")){
                if(check.startsWith(CheckInDate + "/" + "0" + "/" + "0" + "/" + "1" + "/" + "2") && check.endsWith("2")){
                    meetRoom2 = "Full";
                }
                else if(check.startsWith(CheckInDate + "/" + "1" + "/" + "1" + "/" + "0" + "/" + "2") && check.endsWith("2")){
                    meetRoom2 = "Full";
                }
                else if(check.startsWith(CheckInDate + "/" + "0" + "/" + "1" + "/" + "0" + "/" + "2") && check.endsWith("2")){
                    meetRoom2 = "Morning";
                }
                else if(check.startsWith(CheckInDate + "/" + "1" + "/" + "0" + "/" + "0" + "/" + "2") && check.endsWith("2")){
                    meetRoom2 = "Afternoon";
                }
            }
            if (check.startsWith(CheckInDate) && check.endsWith("3")){
                if(check.startsWith(CheckInDate + "/" + "0" + "/" + "0" + "/" + "1" + "/" + "3") && check.endsWith("3")){
                    meetRoom3 = "Full";
                }
                else if(check.startsWith(CheckInDate + "/" + "1" + "/" + "1" + "/" + "0" + "/" + "3") && check.endsWith("3")){
                    meetRoom3 = "Full";
                }
                else if(check.startsWith(CheckInDate + "/" + "0" + "/" + "1" + "/" + "0" + "/" + "3") && check.endsWith("3")){
                    meetRoom3 = "Morning";
                }
                else if(check.startsWith(CheckInDate + "/" + "1" + "/" + "0" + "/" + "0" + "/" + "3") && check.endsWith("3")){
                    meetRoom3 = "Afternoon";
                }
            }
            if (check.startsWith(CheckInDate) && check.endsWith("4")){
                if(check.startsWith(CheckInDate + "/" + "0" + "/" + "0" + "/" + "1" + "/" + "4") && check.endsWith("4")){
                    meetRoom4 = "Full";
                }
                else if(check.startsWith(CheckInDate + "/" + "1" + "/" + "1" + "/" + "0" + "/" + "4") && check.endsWith("4")){
                    meetRoom4 = "Full";
                }
                else if(check.startsWith(CheckInDate + "/" + "0" + "/" + "1" + "/" + "0" + "/" + "4") && check.endsWith("4")){
                    meetRoom4 = "Morning";
                }
                else if(check.startsWith(CheckInDate + "/" + "1" + "/" + "0" + "/" + "0" + "/" + "4") && check.endsWith("4")){
                    meetRoom4 = "Afternoon";
                }
            }
            countDateOfAll++;
        }

        List<MeetingRoom> rooms = MeetingRoom.getMeetingRooms();
        System.out.println("------------------------------------------------------------------------------");
        System.out.format("%-40s %-20s %-10s%n", "Room Type", "Price/Day (Baht)", "Room available");
        System.out.println("------------------------------------------------------------------------------");
        int countRoomMeet = 1;
        for (MeetingRoom meetingRoom : rooms) {
            if(countRoomMeet==1){
                System.out.format("%-40s %-20d %-10s%n", meetingRoom.getType(), meetingRoom.getPrice(), meetRoom1);
            }
            else if(countRoomMeet==2){
                System.out.format("%-40s %-20d %-10s%n", meetingRoom.getType(), meetingRoom.getPrice(), meetRoom2);
            }
            else if(countRoomMeet==3){
                System.out.format("%-40s %-20d %-10s%n", meetingRoom.getType(), meetingRoom.getPrice(), meetRoom3);
            }
            else if(countRoomMeet==4){
                System.out.format("%-40s %-20d %-10s%n", meetingRoom.getType(), meetingRoom.getPrice(), meetRoom4);
            }
            countRoomMeet++; 
        }
        System.out.println("------------------------------------------------------------------------------");
    }
    
    @Override
    public void selectBooking() {
        //เลือก type และ เวลา ที่จะจองห้องประชุม
        do{
            //เลือก type ของห้อง
            System.out.print("Enter the number type : ");
            String strNumRoom = in.nextLine().trim();

            if (!strNumRoom.equals("1") && !strNumRoom.equals("2") && !strNumRoom.equals("3") && !strNumRoom.equals("4")){
                System.out.println("\n!!! Please select only the options available here !!!\n");
            }

            else {
                numRoom = Integer.parseInt(strNumRoom);
                setNumRoom(numRoom);
                break;
            }

        }while (true);

        do{
            //เลือกเวลาที่จะจองห้องประชุม
            System.out.println("\n ====== Select time ====== ");
            System.out.println("*** The half day price will be half the full day price ***");
            System.out.format("%-2s %-2s%n","","1. All day");
            System.out.format("%-2s %-2s%n","","2. Half day (Morning)");
            System.out.format("%-2s %-2s%n","","3. Half day (Afternoon)");
            System.out.println(" ========================= ");
            System.out.print(" Enter : ");
            String strTime = in.nextLine().trim();

            if(!strTime.equals("1") && !strTime.equals("2") && !strTime.equals("3")){
                System.out.println("\n!!! Please select only the options available here !!!\n");
            }


            else {
                time = Integer.parseInt(strTime);
                setTime(time);
                break;
            }

        }while (true);

        Bill meetingBill = new Bill(getTime(),meetingRooms.get(getNumRoom()-1).getPrice(),meetingRooms.get(getNumRoom()-1).getType(),CheckInDate , getNumRoom());
        /*
            ส่งค่าที่ user เลือก ไป constructor ของคลาส Bill
            โดย getTime() คือ เวลาที่เลือกจอง (int)
            meetingRooms.get(getNumRoom()-1).getPrice() คือ ราคาของห้องที่ได้จองไว้ (int)
            meetingRooms.get(getNumRoom()-1).getType() คือ type ของห้องที่ได้จองไว้ (String)
         */

        MeetingService meetingService = new MeetingService(getTime(),meetingRooms.get(getNumRoom()-1).getType());

        //ส่งค่าไปเพื่อช่วยในการเลือก package ของ service


        System.out.println("------------------------------------------------------------------------------");
    }
}
