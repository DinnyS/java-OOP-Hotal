package Booking;
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
    protected MeetingRoom(String type, int price, int available , String CheckInDate) {
        super(type, price, available);
        this.CheckInDate = CheckInDate;
    }

    private static List<MeetingRoom> meetingRooms = new ArrayList<>();

    static {
        meetingRooms.add(new MeetingRoom("1. The Universe (250 people)", 50000, 1,CheckInDate));
        meetingRooms.add(new MeetingRoom("2. The World (100 people)",30000,1,CheckInDate));
        meetingRooms.add(new MeetingRoom("3. The Mini World (50 people)", 20000,1,CheckInDate));
        meetingRooms.add(new MeetingRoom("4. The Town (50 people)",20000,1,CheckInDate));
    }
    protected static List<MeetingRoom> getMeetingRooms(){
        return meetingRooms;
    }
    @Override
    public void infoRoom() {
        List<MeetingRoom> rooms = MeetingRoom.getMeetingRooms();
        System.out.println("------------------------------------------------------------------------------");
        System.out.format("%-40s %-20s %-10s%n", "Room Type", "Price/Day (Baht)", "Room available");
        System.out.println("------------------------------------------------------------------------------");
        for (MeetingRoom meetingRoom : rooms) {
            System.out.format("%-40s %-20d %-10s%n", meetingRoom.getType(), meetingRoom.getPrice(), meetingRoom.getAvailable());
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

        Bill meetingBill = new Bill(getTime(),meetingRooms.get(getNumRoom()-1).getPrice(),meetingRooms.get(getNumRoom()-1).getType(),CheckInDate);
        /*
            ส่งค่าที่ user เลือก ไป constructor ของคลาส Bill
            โดย getTime() คือ เวลาที่เลือกจอง (int)
            meetingRooms.get(getNumRoom()-1).getPrice() คือ ราคาของห้องที่ได้จองไว้ (int)
            meetingRooms.get(getNumRoom()-1).getType() คือ type ของห้องที่ได้จองไว้ (String)
         */

        System.out.println("------------------------------------------------------------------------------");
    }
}
