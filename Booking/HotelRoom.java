package Booking;
import java.util.*;
import java.util.regex.Pattern;

public class HotelRoom extends Room implements InfoRoom , SelectBooking{
    private int numRoom;
    private int numCustomers;
    private int numType;
    public void setNumRoom(int numRoom) {
        this.numRoom = numRoom;
    }
    public void setNumCustomers(int numCustomers) {
        this.numCustomers = numCustomers;
    }
    public void setNumType(int numType) {
        this.numType = numType;
    }
    public int getNumRoom() {
        return numRoom;
    }
    public int getNumCustomers() {
        return numCustomers;
    }
    public int getNumType() {
        return numType;
    }
    public HotelRoom(String type, int capacity, int price, int available) {
        super(type, capacity, price, available);
    }
    private static List<HotelRoom> hotelRooms = new ArrayList<>();

    static {
        hotelRooms.add(new HotelRoom("1. Basic Room", 3, 3500, 20));
        hotelRooms.add(new HotelRoom("2. Deluxe Room", 6, 5500, 15));
        hotelRooms.add(new HotelRoom("3. Super Deluxe Room", 8, 8000, 5));
    }
    protected static List<HotelRoom> getHotelRooms() {
        return hotelRooms;
    }

    private static void suggestRoom(List<? extends Room> rooms, int numCustomers) {
        //แสดงห้องที่เหมาะกับำนวนลูกค้าที่เข้าพัก
        for (Room room : rooms) {

            if (room.getCapacity() >= numCustomers && room.getAvailable() > 0) {
                numCustomers++;
                System.out.format("%-2s %-30s%n", "",room.getType());
            }
        }
    }

    @Override
    public void infoRoom() {
        List<HotelRoom> rooms = HotelRoom.getHotelRooms();
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("%-30s %-15s %-15s %-10s%n", "Room Type", "Capacity", "Price (Baht)", "Room available");
        System.out.println("-----------------------------------------------------------------------------");
        for (HotelRoom hotelRoom : rooms) {
            //แสดง detail ต่างๆ ของของให้ user ได้เลือก
            System.out.format("%-30s %-15d %-15d %-10s%n", hotelRoom.getType(), hotelRoom.getCapacity(), hotelRoom.getPrice(), hotelRoom.getAvailable());
        }
        System.out.println("-----------------------------------------------------------------------------");
    }

    @Override
    public void selectBooking() {
        do{
            //input number of room in String ✓✓
            //ถาม user ว่าจะจองกี่ห้อง
            System.out.print("Enter number of room(s) : ");
            String numRoomSTR = in.nextLine().trim();
            int number;
            do {
                if (Pattern.matches("^\\d+$", numRoomSTR)) {
                    number = Integer.parseInt(numRoomSTR);
                    if (number > 40) {
                        System.out.println("Number of room(s) cannot exceed 40. Please enter again.");
                        System.out.print("Enter number of room(s): ");
                        numRoomSTR = in.nextLine().trim();
                    }
                }

            } while (!(Pattern.matches("^\\d+$", numRoomSTR) && Integer.parseInt(numRoomSTR) <= 40));

            number = Integer.parseInt(numRoomSTR);
            numRoomSTR= String.valueOf(number);

             if (Pattern.matches("\\d+$",numRoomSTR)){
                numRoom = Integer.parseInt(numRoomSTR);
                setNumRoom(numRoom);

                Bill storeBill = new Bill("for create array",getNumRoom());
                //ส่งค่าจำนวนห้องที่จองไป constructor ในคลาส Bill เพื่อสร้าง array ไว้เก็บข้อมูล

                if (getNumRoom() > 40) {
                    //ถ้า user กรอกจำนวนห้องมามากกว่า 40 ระบบะเซตให้จำนวนห้องที่ลูกค้าจะจองเป็น 40 ทันที่
                    setNumRoom(40);
                }

                break;
            }

            else{
                System.out.println("\n !!!Please enter only integer!!! \n");
            }

        }while (true);

        //loop ถาม user ตามจำนวนห้องที่จองว่าแต่ละห้องมีผู้พักกี่คน และ จพเลือก type ไหน
        for (int i = 1; i <= getNumRoom(); i++) {

            if (i == 0) {
                i = 1;
                System.out.println("\n!!! Please enter the information again !!!\n");
            }

            do{
                // enter amount of customers in String ✓✓
                // user ระบุคนที่มาพัก/ห้อง
                System.out.print("Enter number of customers/room ( room " + i + " ) : ");
                String numCustomerSTR = in.nextLine().trim();

                if(Pattern.matches("^\\d+$", numCustomerSTR)){
                    numCustomers = Integer.parseInt(numCustomerSTR);
                    if(numCustomers > 8){
                        System.out.println("\n!!!There is no room of the right size for " + numCustomers + " customers.!!!\n");
                    }
                    else {
                        if (i <= 0) {
                            i = 1;
                        }
                        if (numCustomers <= 8) {
                            setNumCustomers(numCustomers);
                            break;
                        }
                    }
                }
                else{
                    System.out.println("\n!!!Please enter only integer!!!\n");
                }
            }while (true);

            System.out.println("-----------------------------------------------------------------------------");

            do{
                //เลือก type ของห้อง ตามที่ระบบแนะนำมาโดยอ้างอิงจากจำนวนผู้เข้าพัก
                System.out.println("You can choose type of room :");// เลือกรูปแบบของห้อง
                suggestRoom(HotelRoom.getHotelRooms(), numCustomers);
                System.out.print("Enter the number : ");
                String numTypeStr = in.nextLine().trim();

                if (!numTypeStr.equals("1") && !numTypeStr.equals("2") && !numTypeStr.equals("3")){
                    System.out.println("\n!!! Please select only the options available here !!!\n");
                }

                else{
                    numType = Integer.parseInt(numTypeStr);
                    setNumType(numType);
                    Bill hotelBill = new Bill(hotelRooms.get(getNumType()-1).getPrice(),hotelRooms.get(getNumType()-1).getType());
                    /*
                        ส่งค่าที่ user เลือก ไป constructor ของคลาส Bill
                        โดย hotelRooms.get(getNumType()-1).getPrice() คือ ราคาของห้องที่ user จองไว้
                        hotelRooms.get(getNumType()-1).getType() ตือ type ของห้องที่ user จอง
                     */
                    break;
                }
            }while(true);

            System.out.println("-----------------------------------------------------------------------------");

        }
    }
}