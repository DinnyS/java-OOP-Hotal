package Booking;
import java.util.*;


public class HotelRoom extends Room implements InfoRoom , SelectBooking{

    private int numRoom;
    private int numCustomers;

    public int getNumRoom() {
        return numRoom;
    }

    public int getNumCustomers() {
        return numCustomers;
    }

    public int getNumType() {
        return numType;
    }

    private int numType;

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

        for (int i =1; i<= numRoom; i++){

            System.out.print("Enter number of customers/room ( room " + i + " ) : ");
            numCustomers = in.nextInt();
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("You can choose typ of room :");
            suggestRoom(HotelRoom.getHotelRooms(),numCustomers);
            System.out.print("Enter the number : ");
            numType = in.nextInt();
            System.out.println("-----------------------------------------------------------------------------");

        }
    }


}