package Booking;

import java.util.ArrayList;
import java.util.List;

public class AvailableHotel extends Bill {

    private static List<String> allOfHotel = new ArrayList<>(); // arraylist 1 ตัวมี 5 ค่า "วัน / เดือน / ปี / จำนวนห้อง / ชนิดห้อง"

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
            boolean found = false;

            for (String check : allOfHotel) {
                String checkRoom = allOfHotel.get(count);
                String[] salat = checkRoom.split("/");
                int room = Integer.parseInt(salat[4]);

            }



            if (allOfHotel.isEmpty()){
                allOfHotel.add(checkInDate + "/" + "available" + "/" + type);
            }

    }
}
