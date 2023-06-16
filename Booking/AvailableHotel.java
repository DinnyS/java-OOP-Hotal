package Booking;

import java.util.ArrayList;
import java.util.List;

public class AvailableHotel extends Bill {

    private static List<String> allOfHotel = new ArrayList<>(); // arraylist วัน / เดือน / ปี / จำนวนห้องหลักสิบ / จำนวนห้องหลักหน่วย / ชนิดห้อง

    public AvailableHotel(){}

    public AvailableHotel(int day, int month, int year, int available, int type, String checkInDate){
        
        String[] parts = checkInDate.split("/");
            if (parts.length == 4) {
                day = Integer.parseInt(parts[0]);
                month = Integer.parseInt(parts[1]);
                year = Integer.parseInt(parts[2]);
                type = Integer.parseInt(parts[3]);
                System.out.println("");
                System.out.println("Check In : " + day +"/"+ month +"/"+ year + "/" + type);
            }

            int count = 0;
            int roomHotel = 0;
    }
}
