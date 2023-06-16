package Booking;

import java.util.ArrayList;
import java.util.List;

public class AvailableHotel extends Bill {

    private static List<String> allOfHotel = new ArrayList<>(); // arraylist วัน / เดือน / ปี / จำนวนห้องหลักสิบ / จำนวนห้องหลักหน่วย / ชนิดห้อง

    public AvailableHotel(){}

    public AvailableHotel(String checkInDate, int available, int type){
        
        String[] partsCheckIn = checkInDate.split("/");
            if (partsCheckIn.length == 3) {
                int day = Integer.parseInt(partsCheckIn[0]);
                int month = Integer.parseInt(partsCheckIn[1]);
                int year = Integer.parseInt(partsCheckIn[2]);

                System.out.println("");
                System.out.println("Check In : " + day +"/"+ month +"/"+ year + "/" + type);
            }

            int count = 0;
            int roomHotel = 0;

            for (String check : allOfHotel) {}







    }
}
