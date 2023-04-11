package Booking;
import java.util.*;


public class HotelRoom extends Room implements InfoRoom , SelectBooking{

    private int numRoom;
    private int numCustomers;

    public void setNumRoom(int numRoom) {
        this.numRoom = numRoom;
    }

    public void setNumCustomers(int numCustomers) {
        this.numCustomers = numCustomers;
    }

    public void setNumType(int numType) {
        this.numType = numType;
    }

    private int numType;

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
        System.out.print("Enter number of room(s) : ");
        numRoom = in.nextInt();
        setNumRoom(numRoom);


        if (numRoom > 40) {
            numRoom = 40;
        }

        for (int i = 1; i <= numRoom; i++) {

            if (i == 0) {
                i = 1;
                System.out.println("!!! Please enter the information again !!!");
            }

            System.out.print("Enter number of customers/room ( room " + i + " ) : ");
            numCustomers = in.nextInt();

            while (numCustomers > 8) {
                System.out.println("!!!There is no room of the right size for " + numCustomers + " customers.!!!");
                System.out.print("Enter number of customers/room ( room " + i + " ) : ");
                numCustomers = in.nextInt();
                i = -1;
                if (i <= 0) {
                    i = 1;
                }
                if (numCustomers <= 8) {
                    setNumCustomers(numCustomers);
                    break;
                }
            }

            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("You can choose typ of room :");// เลือก choice
            suggestRoom(HotelRoom.getHotelRooms(), numCustomers);
            System.out.print("Enter the number : ");
            numType = in.nextInt();

            boolean check = true;
            while (check) {
                if (numType < 1 || numType > 3) {
                    System.out.println("!!! Please select only the options available here !!!");
                    System.out.println("You can choose typ of room :");// เลือก choice
                    suggestRoom(HotelRoom.getHotelRooms(), numCustomers);
                    System.out.print("Enter the number : ");
                    numType = in.nextInt();

                } else {
                    setNumType(numType);
                    check = false;
                }

            }
            System.out.println("-----------------------------------------------------------------------------");

        }
    }
}