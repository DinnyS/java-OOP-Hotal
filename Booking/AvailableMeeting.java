package Booking;

public class AvailableMeeting extends Bill{
    private static int numBookedRoom;

    private int bookedDay;
    private int bookedMonth;
    private int bookedYear;

    private int timedays;
    private String typeMeet;

    private int year;

    private String hasbook = "0/0/0";

                            // เวลาของวัน
                            // เช้า/บ่าย/ทั้งวัน     // ประเภทห้อง        // วันที่จอง
    public AvailableMeeting(int timeDay , String typeMeet , String checkInDate){
        this.timedays = timeDay; // เก็บค่าเวลาของวัน
        this.typeMeet = typeMeet; // เก็บค่าประเภทห้อง

        String[] parts = checkInDate.split("/"); // ตัว check วัน checkIn
            if (parts.length == 3) {
                int day = Integer.parseInt(parts[0]);
                int month = Integer.parseInt(parts[1]);
                int year = Integer.parseInt(parts[2]);

                bookedDay = day;
                bookedMonth = month;
                bookedYear = year;


            String[] partDay = hasbook.split("/"); // ตัว check วัน checkIn
                if (partDay.length == 3) {
                    int chao = Integer.parseInt(parts[0]); // เช้า
                    int bai = Integer.parseInt(parts[1]); // บ่าย
                    int tangwan = Integer.parseInt(parts[2]); // ทั้งวัน

                    if(timedays == 1 && checkInDate.equals(bookedDay+"/"+bookedMonth+"/"+bookedYear)){// Check ว่า เวลาที่จอง(ทั้งวัน)ตรงกับวันที่เคยจองก่อนหน้ารึป่าว (ถ้าใช่ Error)
                        System.out.println("Meeting New is Full...!!!");
                    }
                    else if(checkInDate.equals(bookedDay+"/"+bookedMonth+"/"+bookedYear)){ // Check ว่า วันที่จองมีค่าเท่ากับวันที่เคยจอง
                        if(chao == 1 && bai == 0 && timeDay == 3){// Check เวลาช่วงบ่าย 
                            bai = 1;
                            hasbook = chao+"/"+bai+"/"+tangwan;
                        }
                        else if(bai == 1 && chao == 0 && timeDay == 2){ // Check เวลาช่วงเช้า 
                            chao = 1;
                            hasbook = chao+"/"+bai+"/"+tangwan;
                        }
                    }

                    else if(!checkInDate.equals(bookedDay+"/"+bookedMonth+"/"+bookedYear)){// Check ว่า ถ้าไม่เท่ากับวันที่เคยจองเลย
                        hasbook = "0/0/0";
                        if(timeDay == 2){
                            chao = 1;
                            hasbook = chao+"/"+bai+"/"+tangwan; // เช้า + 1
                        }
                        else if(timeDay == 3){
                            bai = 1;
                            hasbook = chao+"/"+bai+"/"+tangwan; // บ่าย + 1
                        }
                        else if(timeDay == 1){
                            tangwan = 1;
                            hasbook = chao+"/"+bai+"/"+tangwan; // ทั้งวัน + 1
                        }
                    }


                }
            
        }

            System.out.println(hasbook + " " + bookedDay + " " + bookedMonth + " " + bookedYear);
    }
}
