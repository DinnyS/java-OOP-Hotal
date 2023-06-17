package Booking;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class AvailableHotel extends Bill {

    int availableRoom = 40;
    private static boolean hotelFull = false;

    private static List<String> allOfHotel = new ArrayList<>(); // arraylist 1 ตัวมี 5 ค่า "วัน / เดือน / ปี / จำนวนห้อง / ชนิดห้อง"

    public AvailableHotel(){}

                            // วัน/เดือน/ปี   /  จำนวนวันที่นอน / ชนิดห้อง / นับวันที่อยู่
    public AvailableHotel(String checkInDate, int numDayS, int type , int countDay){ // จะเป็นการ add or set ทีละวัน
        
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
                else if (month == 2 && day > 28 && year %4 != 0) {
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
            

            int count = 0; // ตัวนับว่าตอนนี้ถึงตัวไหนของ List
            boolean found = false;

            for (String check : allOfHotel) { // เช็คค่าทุกตัวที่มีใน allOfHotel ทั้งหมด

                String checkRoom = allOfHotel.get(count); //รับค่าข้อมูลตัวที่กำลัง check
                String[] salat = checkRoom.split("/"); // ตัวแบ่ง part ของข้อมูล
                int activeRoom = Integer.parseInt(salat[3]); // check จำนวนห้องที่ว่าง

                 if (check.startsWith(day+"/"+month+"/"+year) && check.endsWith("1") && type == 1){
                    if(activeRoom > 0){
                        allOfHotel.set(count,(day+"/"+month+"/"+year) + "/" + (activeRoom-1) + "/" + "1");
                        found = true;
                        break;
                    }
                    else{
                        System.out.println(day+"/"+month+"/"+year + " : now is Full");
                        found = true;
                        hotelFull = true;
                        break;
                    }
                 }
                 else if (check.startsWith(day+"/"+month+"/"+year) && check.endsWith("2") && type == 2){
                    if(activeRoom > 0){
                        allOfHotel.set(count,(day+"/"+month+"/"+year) + "/" + (activeRoom-1) + "/" + "2");
                        found = true;
                        break;
                    }
                    else{
                        System.out.println(day+"/"+month+"/"+year + " : now is Full");
                        found = true;
                        hotelFull = true;
                        break;
                    }
                 }
                 else if (check.startsWith(day+"/"+month+"/"+year) && check.endsWith("3") && type == 3){
                    if(activeRoom > 0){
                        allOfHotel.set(count,(day+"/"+month+"/"+year) + "/" + (activeRoom-1) + "/" + "3");
                        found = true;
                        break;
                    }
                    else{
                        System.out.println(day+"/"+month+"/"+year + " : now is Full");
                        found = true;
                        hotelFull = true;
                        break;
                    }
                 }
                

                 count++;
            }


            if(found == false  /* && numDayS > 0/* */ && count == allOfHotel.size()){ // ถ้าไม่มีค่าใน List แต่ List ไม่ได้ว่าง
                if(type == 1){
                    allOfHotel.add((day+"/"+month+"/"+year) + "/" + (20-1) + "/" + "1"); // ห้อง 1
                }
                else if(type == 2){
                    allOfHotel.add((day+"/"+month+"/"+year) + "/" + (15-1) + "/" + "2"); // ห้อง 2
                }
                else if(type == 3){
                    allOfHotel.add((day+"/"+month+"/"+year) + "/" + (5-1) + "/" + "3"); // ห้อง 3
                }
                /*else{
                    allOfHotel.add((day+"/"+month+"/"+year) + "/" + (40-1) + "/" + type);
                }*/
            }


            if (allOfHotel.isEmpty()){ // ถ้า List ไม่มีค่าอะไรด้านในเลย
                if(type == 1){
                    allOfHotel.add((day+"/"+month+"/"+year) + "/" + (20-1) + "/" + "1"); // ห้อง 1
                }
                else if(type == 2){
                    allOfHotel.add((day+"/"+month+"/"+year) + "/" + (15-1) + "/" + "2"); // ห้อง 2
                }
                else if(type == 3){
                    allOfHotel.add((day+"/"+month+"/"+year) + "/" + (5-1) + "/" + "3"); // ห้อง 3
                }
                /*else{
                    allOfHotel.add((day+"/"+month+"/"+year) + "/" + (40-1) + "/" + type);
                }*/
            }
        }

        /*for(int i = 0; i<allOfHotel.size(); i++){
            System.out.println(allOfHotel);
        }*/
        System.out.println(allOfHotel);
    }



    public List getAllOfHotel(){
        return allOfHotel;
    }

    public boolean getHotelFull(){
        return hotelFull;
    }
}
