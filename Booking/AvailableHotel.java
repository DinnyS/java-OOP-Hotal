package Booking;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class AvailableHotel extends Bill {

    int availableRoom = 40;

    private static List<String> allOfHotel = new ArrayList<>(); // arraylist 1 ตัวมี 5 ค่า "วัน / เดือน / ปี / จำนวนห้อง / ชนิดห้อง"

    public AvailableHotel(){}

                            // วัน/เดือน/ปี   /  จำนวนวันที่นอน / ชนิดห้อง
    public AvailableHotel(String checkInDate, int numDayS, int type , int countDay){
        
        String[] partsCheckIn = checkInDate.split("/");
            if (partsCheckIn.length == 3) {
                int day = Integer.parseInt(partsCheckIn[0]);
                int month = Integer.parseInt(partsCheckIn[1]);
                int year = Integer.parseInt(partsCheckIn[2]);

                day += countDay;

                if (month == 12 && day > 31 ){ // ขึ้นปีใหม่
                    month = 1;
                    day = day - 31;
                    year +=1;
                }
                // เดือน 2 ที่มี 29 วัน
                else if (month == 2 && year %4 == 0 && day > 29) {
                    day = day - 29;
                    month += 1;
                }
                // เดือน 2 ที่มี 28 วัน
                else if (month == 2 && day > 28) {
                        day = day - 28;
                        month += 1;
                }
                // เดือนที่มี 31 วัน (คม)
                else if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day > 31){
                    day = day - 31;
                    month += 1;
                }
                else if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30){ // เดือนที่มี 30 วัน (ยน)
                    day = day - 30;
                    month += 1;
                }
                

                System.out.println("");
                System.out.println("Check In : " + day +"/"+ month +"/"+ year + "/" + type);
            

            int count = 0;
            int roomHotel = 0;
            boolean found = false;

            for (String check : allOfHotel) {
                String checkRoom = allOfHotel.get(count);
                String[] salat = checkRoom.split("/");
                int room = Integer.parseInt(salat[4]);

                 if (check.startsWith(day+"/"+month+"/"+year) && check.endsWith("1")){
                    found = true;
                 }
                 else if (check.startsWith(day+"/"+month+"/"+year) && check.endsWith("2")){
                    found = true;
                 }
                 else if (check.startsWith(day+"/"+month+"/"+year) && check.endsWith("3")){
                    found = true;
                 }

            }


            if(found == false && numDayS > 0 ){ // ถ้าไม่มีค่าใน List แต่ List ไม่ได้ว่าง
                if(type == 1){
                    allOfHotel.add((day+"/"+month+"/"+year) + "/" + (40-1) + "/" + "1");
                }
                else if(type == 2){
                    allOfHotel.add((day+"/"+month+"/"+year) + "/" + (40-1) + "/" + "2");
                }
                else if(type == 3){
                    allOfHotel.add((day+"/"+month+"/"+year) + "/" + (40-1) + "/" + "3");
                }
                else{
                    allOfHotel.add((day+"/"+month+"/"+year) + "/" + (40-1) + "/" + type);
                }
            }


            if (allOfHotel.isEmpty()){ // ถ้า List ไม่มีค่าอะไรด้านในเลย
                if(type == 1){
                    allOfHotel.add((day+"/"+month+"/"+year) + "/" + (40-1) + "/" + "1");
                }
                else if(type == 2){
                    allOfHotel.add((day+"/"+month+"/"+year) + "/" + (40-1) + "/" + "2");
                }
                else if(type == 3){
                    allOfHotel.add((day+"/"+month+"/"+year) + "/" + (40-1) + "/" + "3");
                }
                else{
                    allOfHotel.add((day+"/"+month+"/"+year) + "/" + (40-1) + "/" + type);
                }
            }
        }

    }




    public List getAllOfHotel(){
        return allOfHotel;
    }
}
