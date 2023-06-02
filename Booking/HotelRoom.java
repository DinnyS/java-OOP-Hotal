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
            System.out.format("%-30s %-15d %-15d %-10s%n", hotelRoom.getType(), hotelRoom.getCapacity(), hotelRoom.getPrice(), hotelRoom.getAvailable());
        }
        System.out.println("-----------------------------------------------------------------------------");
    }

    @Override
    public void selectBooking() {
        do{ //input number of room in String ✓✓
            System.out.print("Enter number of room(s) : ");
            String numRoomSTR = in.nextLine().trim();

            if (Pattern.matches("\\d+$",numRoomSTR)){
                numRoom = Integer.parseInt(numRoomSTR);
                setNumRoom(numRoom);
                Bill storeBill = new Bill("for create array",getNumRoom());

                if (getNumRoom() > 40) {
                    setNumRoom(40);
                }

                break;
            }

            else{
                System.out.println("\n !!!Please enter only integer!!! \n");
            }

        }while (true);

        for (int i = 1; i <= getNumRoom(); i++) {

            if (i == 0) {
                i = 1;
                System.out.println("\n!!! Please enter the information again !!!\n");
            }

            do{ // enter amount of customers in String ✓✓
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
                System.out.println("You can choose type of room :");// เลือก choice
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
                    break;
                }
            }while(true);

            System.out.println("-----------------------------------------------------------------------------");

        }
    }
}