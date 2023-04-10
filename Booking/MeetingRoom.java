package Booking;
import java.util.*;

public class MeetingRoom extends Room {

    public MeetingRoom(String type, int price, int available) {
        super(type, price, available);
    }

    private static List<MeetingRoom> meetingRooms = new ArrayList<>();

    static {
        meetingRooms.add(new MeetingRoom("1. The Universe (250 people)", 50000, 1));
        meetingRooms.add(new MeetingRoom("2. The World (100 people)",30000,1));
        meetingRooms.add(new MeetingRoom("3. The Mini World (50 people)", 20000,1));
        meetingRooms.add(new MeetingRoom("4. The Town (50 people)",20000,1));
    }

    protected static List<MeetingRoom> getMeetingRooms(){
        return meetingRooms;
    }




}
