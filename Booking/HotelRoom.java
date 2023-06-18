package Booking;
import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Pattern;

public class HotelRoom extends Room implements InfoRoom , SelectBooking{
    private int numRoom;
    private int numCustomers;
    private int numType;
    private static String CheckInDate;
    private static int[] selectHRoom = new int[31];
    private static int countRoomH = 0;
    private static String[] availableOfHotelR = new String[3];

    public int getCountRoomH(){ // ส่งค่า countRoomH ออก
        return countRoomH;
    }

    public void setSelectHRoom(int numType , int countOfR){ // set ค่าของ array โดยที่ แทนค่าด้วย numType ตำแหน่ง countOfR
        this.selectHRoom[countOfR] = numType;
    }

    public int[] getSelectHRoom(){ // ส่ง selectHRoom ออก
        return selectHRoom;
    }

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
    public HotelRoom(){}
    public HotelRoom(String type, int capacity, int price, int available,String CheckInDate) {
        super(type, capacity, price, available);
        this.CheckInDate = CheckInDate;
    }
    protected static List<HotelRoom> hotelRooms = new ArrayList<>();

    static {
        hotelRooms.add(new HotelRoom("1. Basic Room", 3, 3500, 20 , CheckInDate));
        hotelRooms.add(new HotelRoom("2. Deluxe Room", 6, 5500, 15 , CheckInDate));
        hotelRooms.add(new HotelRoom("3. Super Deluxe Room", 8, 8000, 5 , CheckInDate));
    }


    protected static List<HotelRoom> getHotelRooms() {
        return hotelRooms;
    }

    private static void suggestRoom(List<? extends Room> rooms, int numCustomers) {

        availableOfHotelR[0] = "20";
        availableOfHotelR[1] = "15";
        availableOfHotelR[2] = "5";

        int nubRoom = 1;
        AvailableHotel avHotel = new AvailableHotel();
        List<String> allOfHotel= avHotel.getAllOfHotel();
        int countNaja = 0;

        for (String check : allOfHotel){ //check ข้อมูลที่มีใน list

            String checkRoom = allOfHotel.get(countNaja); //รับค่าข้อมูลตัวที่กำลัง check
            String[] salat = checkRoom.split("/"); // ตัวแบ่ง part ของข้อมูล
            int activeRoom = Integer.parseInt(salat[3]); // check จำนวนห้องที่ว่าง


            
            if(check.startsWith(CheckInDate) && check.endsWith("1")){ // Check ห้องแรก
                if(activeRoom > 0){ // ถ้าห้องยังว่างอยู่
                    availableOfHotelR[0] = Integer.toString(activeRoom); // แปลงค่าจาก int เป็น String
                }
                else{ // ถ้าไม่ว่าง
                    availableOfHotelR[0] = "Full"; // set ห้องเป็นเต็ม
                }
            }
            else if(check.startsWith(CheckInDate) && check.endsWith("2")){ // Check ห้อง 2
                if(activeRoom > 0){ // ถ้าห้องยังว่างอยู่
                    availableOfHotelR[1] = Integer.toString(activeRoom);
                }
                else{ // ถ้าไม่ว่าง
                    availableOfHotelR[1] = "Full"; // set ห้องเป็นเต็ม
                }
            }
            else if(check.startsWith(CheckInDate) && check.endsWith("3")){ // Check ห้อง 3
                if(activeRoom > 0){ // ถ้าห้องยังว่างอยู่
                    availableOfHotelR[2] = Integer.toString(activeRoom);
                }
                else{ // ถ้าไม่ว่าง
                    availableOfHotelR[2] = "Full"; // set ห้องเป็นเต็ม
                }
            }
            countNaja++;
        }
        //แสดงห้องที่เหมาะกับำนวนลูกค้าที่เข้าพัก
        int count = 0;
        System.out.print("\u001B[32m");
        for (Room room : rooms) { // 3 ห้อง 
            if(room.getCapacity() >= numCustomers && availableOfHotelR[count].equals("Full") && count == 0){

            }

            else if (room.getCapacity() >= numCustomers && !availableOfHotelR[count].equals("Full") && count == 0) { // ห้อง แรก
                numCustomers++;
                System.out.format("%-2s %-30s%n", "",room.getType());
            }
            else if (room.getCapacity() >= numCustomers && !availableOfHotelR[count].equals("Full") && count == 1) { // ห้อง 2
                numCustomers++;
                System.out.format("%-2s %-30s%n", "",room.getType());
            }
            else if (room.getCapacity() >= numCustomers && !availableOfHotelR[count].equals("Full") && count == 2) { // ห้อง 3
                numCustomers++;
                System.out.format("%-2s %-30s%n", "",room.getType());
            }
            count++;
        }
        System.out.print("\u001B[31m");
        System.out.println("   4. Exit the booking...  ");
        System.out.print("\u001B[0m");
    }

    @Override
    public void infoRoom() {

        availableOfHotelR[0] = "20";
        availableOfHotelR[1] = "15";
        availableOfHotelR[2] = "5";
        /*String availableOfHotelR1 = "20";
        String availableOfHotelR2 = "15";
        String availableOfHotelR3 = "5";*/

        int nubRoom = 1;
        AvailableHotel avHotel = new AvailableHotel();
        List<String> allOfHotel= avHotel.getAllOfHotel();
        int countNaja = 0;

        for (String check : allOfHotel){ //check ข้อมูลที่มีใน list

            String checkRoom = allOfHotel.get(countNaja); //รับค่าข้อมูลตัวที่กำลัง check
            String[] salat = checkRoom.split("/"); // ตัวแบ่ง part ของข้อมูล
            int activeRoom = Integer.parseInt(salat[3]); // check จำนวนห้องที่ว่าง


            
            if(check.startsWith(CheckInDate) && check.endsWith("1")){ // Check ห้องแรก
                if(activeRoom > 0){ // ถ้าห้องยังว่างอยู่
                    availableOfHotelR[0] = Integer.toString(activeRoom); // แปลงค่าจาก int เป็น String
                }
                else{ // ถ้าไม่ว่าง
                    availableOfHotelR[0] = "Full"; // set ห้องเป็นเต็ม
                }
            }
            else if(check.startsWith(CheckInDate) && check.endsWith("2")){ // Check ห้อง 2
                if(activeRoom > 0){ // ถ้าห้องยังว่างอยู่
                    availableOfHotelR[1] = Integer.toString(activeRoom);
                }
                else{ // ถ้าไม่ว่าง
                    availableOfHotelR[1] = "Full"; // set ห้องเป็นเต็ม
                }
            }
            else if(check.startsWith(CheckInDate) && check.endsWith("3")){ // Check ห้อง 3
                if(activeRoom > 0){ // ถ้าห้องยังว่างอยู่
                    availableOfHotelR[2] = Integer.toString(activeRoom);
                }
                else{ // ถ้าไม่ว่าง
                    availableOfHotelR[2] = "Full"; // set ห้องเป็นเต็ม
                }
            }
            countNaja++;
        }

        int count = 0;
        List<HotelRoom> rooms = HotelRoom.getHotelRooms();
        System.out.println("\u001B[33m-----------------------------------------------------------------------------");
        System.out.format("%-30s %-15s %-15s %-10s%n", "Room Type", "Capacity", "Price (Baht)", "Room available");
        System.out.println("-----------------------------------------------------------------------------");
        for (HotelRoom hotelRoom : rooms) {
            //แสดง detail ต่างๆ ของของให้ user ได้เลือก
            System.out.format("%-30s %-15d %-15d %-10s%n", hotelRoom.getType(), hotelRoom.getCapacity(), hotelRoom.getPrice(), availableOfHotelR[count]);
                /*if(nubRoom == 1){
                    System.out.format("%-30s %-15d %-15d %-10s%n", hotelRoom.getType(), hotelRoom.getCapacity(), hotelRoom.getPrice(), availableOfHotelR1);
                }
                else if(nubRoom == 2){
                    System.out.format("%-30s %-15d %-15d %-10s%n", hotelRoom.getType(), hotelRoom.getCapacity(), hotelRoom.getPrice(), availableOfHotelR2);
                }
                else if(nubRoom == 3){
                    System.out.format("%-30s %-15d %-15d %-10s%n", hotelRoom.getType(), hotelRoom.getCapacity(), hotelRoom.getPrice(), availableOfHotelR3);
                }*/
            //nubRoom++;
            count++;
        }
        System.out.println("-----------------------------------------------------------------------------\u001B[0m");
    }

    @Override
    public void selectBooking() {
        int countOfR = 0;
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
                    else if(number <= 0){
                        System.out.println("Number of room(s) cannot exceed lower than 1. Please enter again.");
                        System.out.print("Enter number of room(s): ");
                        numRoomSTR = in.nextLine().trim();
                    }
                    else{}
                }

            } while (!(Pattern.matches("^\\d+$", numRoomSTR) && Integer.parseInt(numRoomSTR) <= 40  && Integer.parseInt(numRoomSTR) > 0));

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

            if (i <= 0) {
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

                if (!numTypeStr.equals("1") && !numTypeStr.equals("2") && !numTypeStr.equals("3") && !numTypeStr.equals("4")){
                    System.out.println("\n!!! Please select only the options available here !!!\n");
                }
                else if ((numCustomers >= 4 && numCustomers < 9) && numTypeStr.equals("1")) {
                    System.out.println("\n!!! Sorry, Room type 1 is available for 1-3 customers.\n");
                }
                else if ((numCustomers >= 7 && numCustomers <= 8) && numTypeStr.equals("2")) {
                    System.out.println("\n!!! Sorry, Room type 2 is available for 4-6 customers.\n");
                }


                else{
                    
                    numType = Integer.parseInt(numTypeStr);
                    if(numType == 4){
                        break;
                    }
                  
                    setNumType(numType);
                    setSelectHRoom(numType , countOfR);
                    countRoomH++;
                    countOfR++;
                    Bill hotelBill = new Bill(hotelRooms.get(getNumType()-1).getPrice(),hotelRooms.get(getNumType()-1).getType(),numType);
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