package Booking;

import java.util.ArrayList;
import java.util.List;

public class AvailableMeeting extends Bill{

    private static boolean MeetFull = false;

    private static List<String> dateOfAll = new ArrayList<>();  // arraylist ที่เก็บข้อมูล "Day / Month / Year / เช้า / บ่าย / ทั้งวัน / ห้อง" โดยมีค่าอยู่ 7 ตัวในนั้น ต่อ 1 ตัวใน array
                                                                // เช่น 10/11/2023/0/0/1/4 หรือ 10/11/2023/1/1/0/2 เป็นต้น 

    public AvailableMeeting(){}
                            // เวลาของวัน
                            // เช้า/บ่าย/ทั้งวัน     // ประเภทห้อง        // วันที่จอง
    public AvailableMeeting(int timeDay , int typeMeet , String checkInDate){
        //this.timedays = timeDay; // เก็บค่าเวลาของวัน
        //this.typeMeet = typeMeet; // เก็บค่าประเภทห้อง

        String[] parts = checkInDate.split("/"); // ตัว check วัน checkIn
            if (parts.length == 3) {
                int day = Integer.parseInt(parts[0]);
                int month = Integer.parseInt(parts[1]);
                int year = Integer.parseInt(parts[2]);
                System.out.println("");
                System.out.println("Check In : " + day +"/"+ month +"/"+ year);


                int count = 0;
                int roomMeeting = 0; // เก็บค่าของห้องที่ส่งมา
                boolean found = false; // เพิ่มตัวแปรเพื่อตรวจสอบว่าเจอค่าที่ตรงกับเงื่อนไขหรือไม่
                for (String check : dateOfAll) {

                    String checkRoom = dateOfAll.get(count); // Check ตำแหน่งที่ For loop กำลังทำงาน
                    String[] salat = checkRoom.split("/"); // ตัวแบ่งข้อมูลที่เราเก็บ
                    int room = Integer.parseInt(salat[6]); // ตำแหน่งที่ 6 ใน array = ตัวที่ 7 ก็คือห้อง 
        
                    // ---------------- Check ห้อง The Universe (1)
                    if (check.startsWith(checkInDate) && check.endsWith("1") && typeMeet == 1) { // Check ห้อง The Universe (1)
                        roomMeeting = room; // เซ็ทค่าห้องที่ได้ลงในตัวแปลเก็บค่าห้อง
                        if (check.startsWith(checkInDate + "/" + "0" + "/" + "0" + "/" + "1" + "/" + "1") && (timeDay == 1 || timeDay == 2  || timeDay == 3)) { // เช็ค ทั้งวัน 
                            System.out.println("Status : Meeting in This Day Now is Full...!!!");
                            System.out.println("");
                            found = true;
                            MeetFull = true;
                            break;
                        } else if (check.startsWith(checkInDate + "/" + "1" + "/" + "0" + "/" + "0" + "/" + "1") && timeDay == 1) { // เช็ค ทั้งวัน (เช้า + บ่าย)
                            System.out.println("Status : Meeting in Morning Now is Full...!!! So you can't booking all day");
                            System.out.println("");
                            found = true;
                            MeetFull = true;
                            break;
                        }else if (check.startsWith(checkInDate + "/" + "0" + "/" + "1" + "/" + "0" + "/" + "1") && timeDay == 1) { // เช็ค ทั้งวัน (เช้า + บ่าย)
                                System.out.println("Status : Meeting in Afternoon Now is Full...!!! So you can't booking all day");
                                System.out.println("");
                                found = true;
                                MeetFull = true;
                                break;
                        }else if (check.startsWith(checkInDate + "/" + "1" + "/" + "1" + "/" + "0" + "/" + "1") && (timeDay == 1 || timeDay == 2  || timeDay == 3)) { // เช็ค ทั้งวัน (เช้า + บ่าย)
                            System.out.println("Status : Meeting in This Day Now is Full...!!!");
                            System.out.println("");
                            found = true;
                            MeetFull = true;
                            break;
                        } else if (check.startsWith(checkInDate + "/" + "0" + "/" + "1" + "/" + "0" + "/" + "1") && timeDay == 2) { // เช้า = 0  บ่าย = 1
                            dateOfAll.set(count, checkInDate + "/" + "0" + "/" + "0" + "/" + "1" + "/" + "1"); //แก้ค่า ให้ เป็น ทั้งวัน 
                            System.out.println("Status : Add Morning Complete");
                            System.out.println("");
                            found = true;
                            MeetFull = false;
                            break;
                        } else if (check.startsWith(checkInDate + "/" + "1" + "/" + "0" + "/" + "0" + "/" + "1") && timeDay == 3) { // เช้า = 1  บ่าย = 0
                            dateOfAll.set(count, checkInDate + "/" + "0" + "/" + "0" + "/" + "1" + "/" + "1"); //แก้ค่า ให้ เป็น ทั้งวัน 
                            System.out.println("Status : Add Afternoon Complete");
                            System.out.println("");
                            found = true;
                            MeetFull = false;
                            break;
                        }  else{
                            System.out.println("Status : Meeting Now is Full...!!!"); 
                            System.out.println("");
                            found = true;
                            MeetFull = true;
                            // ถ้าเข้าเงื่อนไขของ if มาได้แล้ว แสดงว่ามีข้อมูลอยู่แล้ว ถ้าไม่เข้าเงื่อนไขข้างบนเลยแสดงว่า มัน Error แต่มันไม่มีวันเข้า else ได้
                        }
                    }

                    // ---------------- Check ห้อง The World (2)
                    else if (check.startsWith(checkInDate) && check.endsWith("2") && typeMeet == 2) { // Check ห้อง The World (2)
                        roomMeeting = room; // เซ็ทค่าห้องที่ได้ลงในตัวแปลเก็บค่าห้อง
                        if (check.startsWith(checkInDate + "/" + "0" + "/" + "0" + "/" + "1" + "/" + "2") && (timeDay == 1 || timeDay == 2  || timeDay == 3)) { // เช็ค ทั้งวัน 
                            System.out.println("Status : Meeting in This Day Now is Full...!!!");
                            System.out.println("");
                            MeetFull = true;
                            found = true;
                            break;
                        } else if (check.startsWith(checkInDate + "/" + "1" + "/" + "0" + "/" + "0" + "/" + "2") && timeDay == 1) { // เช็ค ทั้งวัน (เช้า + บ่าย)
                            System.out.println("Status : Meeting in Morning Now is Full...!!! So you can't booking all day");
                            System.out.println("");
                            found = true;
                            MeetFull = true;
                            break;
                        }else if (check.startsWith(checkInDate + "/" + "0" + "/" + "1" + "/" + "0" + "/" + "2") && timeDay == 1) { // เช็ค ทั้งวัน (เช้า + บ่าย)
                                System.out.println("Status : Meeting in Afternoon Now is Full...!!! So you can't booking all day");
                                System.out.println("");
                                found = true;
                                MeetFull = true;
                                break;
                        }else if (check.startsWith(checkInDate + "/" + "1" + "/" + "1" + "/" + "0" + "/" + "2") && (timeDay == 1 || timeDay == 2  || timeDay == 3)) { // เช็ค ทั้งวัน (เช้า + บ่าย)
                            System.out.println("Status : Meeting in This Day Now is Full...!!!");
                            System.out.println("");
                            MeetFull = true;
                            found = true;
                            break;
                        } else if (check.startsWith(checkInDate + "/" + "0" + "/" + "1" + "/" + "0" + "/" + "2") && timeDay == 2) { // เช้า = 0  บ่าย = 1
                            dateOfAll.set(count, checkInDate + "/" + "0" + "/" + "0" + "/" + "1" + "/" + "2"); //แก้ค่า ให้ เป็น ทั้งวัน 
                            System.out.println("Status : Add Morning Complete");
                            System.out.println("");
                            found = true;
                            MeetFull = false;
                            break;
                        } else if (check.startsWith(checkInDate + "/" + "1" + "/" + "0" + "/" + "0" + "/" + "2") && timeDay == 3) { // เช้า = 1  บ่าย = 0
                            dateOfAll.set(count, checkInDate + "/" + "0" + "/" + "0" + "/" + "1" + "/" + "2"); //แก้ค่า ให้ เป็น ทั้งวัน 
                            System.out.println("Status : Add Afternoon Complete");
                            System.out.println("");
                            found = true;
                            MeetFull = false;
                            break;
                        }  else{
                            System.out.println("Status : Meeting Now is Full...!!!"); 
                            System.out.println("");
                            found = true;
                            MeetFull = true;
                            // ถ้าเข้าเงื่อนไขของ if มาได้แล้ว แสดงว่ามีข้อมูลอยู่แล้ว ถ้าไม่เข้าเงื่อนไขข้างบนเลยแสดงว่า มัน Error แต่มันไม่มีวันเข้า else ได้
                        }
                    }

                    // ---------------- Check ห้อง The Mini (3)
                    else if (check.startsWith(checkInDate) && check.endsWith("3") && typeMeet == 3) { // Check ห้อง The Mini (3)
                        roomMeeting = room; // เซ็ทค่าห้องที่ได้ลงในตัวแปลเก็บค่าห้อง
                        if (check.startsWith(checkInDate + "/" + "0" + "/" + "0" + "/" + "1" + "/" + "3") && (timeDay == 1 || timeDay == 2  || timeDay == 3)) { // เช็ค ทั้งวัน 
                            System.out.println("Status : Meeting in This Day Now is Full...!!!");
                            System.out.println("");
                            MeetFull = true;
                            found = true;
                            break;
                        } else if (check.startsWith(checkInDate + "/" + "1" + "/" + "0" + "/" + "0" + "/" + "3") && timeDay == 1) { // เช็ค ทั้งวัน (เช้า + บ่าย)
                            System.out.println("Status : Meeting in Morning Now is Full...!!! So you can't booking all day");
                            System.out.println("");
                            found = true;
                            MeetFull = true;
                            break;
                        }else if (check.startsWith(checkInDate + "/" + "0" + "/" + "1" + "/" + "0" + "/" + "3") && timeDay == 1) { // เช็ค ทั้งวัน (เช้า + บ่าย)
                                System.out.println("Status : Meeting in Afternoon Now is Full...!!! So you can't booking all day");
                                System.out.println("");
                                found = true;
                                MeetFull = true;
                                break;
                        }else if (check.startsWith(checkInDate + "/" + "1" + "/" + "1" + "/" + "0" + "/" + "3") && (timeDay == 1 || timeDay == 2  || timeDay == 3)) { // เช็ค ทั้งวัน (เช้า + บ่าย)
                            System.out.println("Status : Meeting in This Day Now is Full...!!!");
                            System.out.println("");
                            MeetFull = true;
                            found = true;
                            break;
                        } else if (check.startsWith(checkInDate + "/" + "0" + "/" + "1" + "/" + "0" + "/" + "3") && timeDay == 2) { // เช้า = 0  บ่าย = 1
                            dateOfAll.set(count, checkInDate + "/" + "0" + "/" + "0" + "/" + "1" + "/" + "3"); //แก้ค่า ให้ เป็น ทั้งวัน 
                            System.out.println("Status : Add Morning Complete");
                            System.out.println("");
                            found = true;
                            MeetFull = false;
                            break;
                        } else if (check.startsWith(checkInDate + "/" + "1" + "/" + "0" + "/" + "0" + "/" + "3") && timeDay == 3) { // เช้า = 1  บ่าย = 0
                            dateOfAll.set(count, checkInDate + "/" + "0" + "/" + "0" + "/" + "1" + "/" + "3"); //แก้ค่า ให้ เป็น ทั้งวัน 
                            System.out.println("Status : Add Afternoon Complete");
                            System.out.println("");
                            found = true;
                            MeetFull = false;
                            break;
                        }  else{
                            System.out.println("Status : Meeting Now is Full...!!!");
                            System.out.println("");
                            MeetFull = true; 
                            found = true;
                            // ถ้าเข้าเงื่อนไขของ if มาได้แล้ว แสดงว่ามีข้อมูลอยู่แล้ว ถ้าไม่เข้าเงื่อนไขข้างบนเลยแสดงว่า มัน Error แต่มันไม่มีวันเข้า else ได้
                        }
                    }

                    // ---------------- Check ห้อง The Town (4)
                    else if (check.startsWith(checkInDate) && check.endsWith("4") && typeMeet == 4) { // Check ห้อง The Town (4)
                        roomMeeting = room; // เซ็ทค่าห้องที่ได้ลงในตัวแปลเก็บค่าห้อง
                        if (check.startsWith(checkInDate + "/" + "0" + "/" + "0" + "/" + "1" + "/" + "4") && (timeDay == 1 || timeDay == 2  || timeDay == 3)) { // เช็ค ทั้งวัน 
                            System.out.println("Status : Meeting in This DayNow is Full...!!!");
                            System.out.println("");
                            MeetFull = true;
                            found = true;
                            break;
                        } else if (check.startsWith(checkInDate + "/" + "1" + "/" + "0" + "/" + "0" + "/" + "4") && timeDay == 1) { // เช็ค ทั้งวัน (เช้า + บ่าย)
                            System.out.println("Status : Meeting in Morning Now is Full...!!! So you can't booking all day");
                            System.out.println("");
                            found = true;
                            MeetFull = true;
                            break;
                        }else if (check.startsWith(checkInDate + "/" + "0" + "/" + "1" + "/" + "0" + "/" + "4") && timeDay == 1) { // เช็ค ทั้งวัน (เช้า + บ่าย)
                                System.out.println("Status : Meeting in Afternoon Now is Full...!!! So you can't booking all day");
                                System.out.println("");
                                found = true;
                                MeetFull = true;
                                break;
                        }else if (check.startsWith(checkInDate + "/" + "1" + "/" + "1" + "/" + "0" + "/" + "4") && (timeDay == 1 || timeDay == 2  || timeDay == 3)) { // เช็ค ทั้งวัน (เช้า + บ่าย)
                            System.out.println("Status : Meeting in This Day Now is Full...!!!");
                            System.out.println("");
                            MeetFull = true;
                            found = true;
                            break;
                        } else if (check.startsWith(checkInDate + "/" + "0" + "/" + "1" + "/" + "0" + "/" + "4") && timeDay == 2) { // เช้า = 0  บ่าย = 1
                            dateOfAll.set(count, checkInDate + "/" + "0" + "/" + "0" + "/" + "1" + "/" + "4"); //แก้ค่า ให้ เป็น ทั้งวัน 
                            System.out.println("Status : Add Morning Complete");
                            System.out.println("");
                            found = true;
                            MeetFull = false;
                            break;
                        } else if (check.startsWith(checkInDate + "/" + "1" + "/" + "0" + "/" + "0" + "/" + "4") && timeDay == 3) { // เช้า = 1  บ่าย = 0
                            dateOfAll.set(count, checkInDate + "/" + "0" + "/" + "0" + "/" + "1" + "/" + "4"); //แก้ค่า ให้ เป็น ทั้งวัน 
                            System.out.println("Status : Add Afternoon Complete");
                            System.out.println("");
                            found = true;
                            MeetFull = false;
                            break;
                        }  else{
                            System.out.println("Status : Meeting Now is Full...!!!"); 
                            System.out.println("");
                            MeetFull = true;
                            found = true;
                            // ถ้าเข้าเงื่อนไขของ if มาได้แล้ว แสดงว่ามีข้อมูลอยู่แล้ว ถ้าไม่เข้าเงื่อนไขข้างบนเลยแสดงว่า มัน Error แต่มันไม่มีวันเข้า else ได้
                        }
                    }
                    
                    count++;
                } // จุดสิ้นสุด for loop 


                if (found == false && count == dateOfAll.size() && roomMeeting == 0) { // check ว่า ถ้าใน for loop ไม่มีค่าที่ตรงกับวันที่เพิ่มมา ให้ เข้าเงื่อนไขนี้
                    if(typeMeet == 1){
                        if (timeDay == 1) {
                            dateOfAll.add(checkInDate + "/" + "0" + "/" + "0" + "/" + "1" + "/" + "1"); // Add ค่า "ทั้งวัน" เข้าไป
                            System.out.println("Status : Add All Day Complete");
                            System.out.println("");
                        } else if (timeDay == 2) {
                            dateOfAll.add(checkInDate + "/" + "1" + "/" + "0" + "/" + "0" + "/" + "1"); // Add ค่า "เช้า" เข้าไป
                            System.out.println("Status : Add Morning Complete");
                            System.out.println("");
                        } else if (timeDay == 3) {
                            dateOfAll.add(checkInDate + "/" + "0" + "/" + "1" + "/" + "0" + "/" + "1"); // Add ค่า "บ่าย" เข้าไป
                            System.out.println("Status : Add Afternoon Complete");
                            System.out.println("");
                        }
                    }
                    else if(typeMeet == 2){
                        if (timeDay == 1) {
                            dateOfAll.add(checkInDate + "/" + "0" + "/" + "0" + "/" + "1" + "/" + "2"); // Add ค่า "ทั้งวัน" เข้าไป
                            System.out.println("Status : Add All Day Complete");
                            System.out.println("");
                        } else if (timeDay == 2) {
                            dateOfAll.add(checkInDate + "/" + "1" + "/" + "0" + "/" + "0" + "/" + "2"); // Add ค่า "เช้า" เข้าไป
                            System.out.println("Status : Add Morning Complete");
                            System.out.println("");
                        } else if (timeDay == 3) {
                            dateOfAll.add(checkInDate + "/" + "0" + "/" + "1" + "/" + "0" + "/" + "2"); // Add ค่า "บ่าย" เข้าไป
                            System.out.println("Status : Add Afternoon Complete");
                            System.out.println("");
                        }
                    }
                    else if(typeMeet == 3){
                        if (timeDay == 1) {
                            dateOfAll.add(checkInDate + "/" + "0" + "/" + "0" + "/" + "1" + "/" + "3"); // Add ค่า "ทั้งวัน" เข้าไป
                            System.out.println("Status : Add All Day Complete");
                            System.out.println("");
                        } else if (timeDay == 2) {
                            dateOfAll.add(checkInDate + "/" + "1" + "/" + "0" + "/" + "0" + "/" + "3"); // Add ค่า "เช้า" เข้าไป
                            System.out.println("Status : Add Morning Complete");
                            System.out.println("");
                        } else if (timeDay == 3) {
                            dateOfAll.add(checkInDate + "/" + "0" + "/" + "1" + "/" + "0" + "/" + "3"); // Add ค่า "บ่าย" เข้าไป
                            System.out.println("Status : Add Afternoon Complete");
                            System.out.println("");
                        }
                    }
                    else if(typeMeet == 4){
                        if (timeDay == 1) {
                            dateOfAll.add(checkInDate + "/" + "0" + "/" + "0" + "/" + "1" + "/" + "4"); // Add ค่า "ทั้งวัน" เข้าไป
                            System.out.println("Status : Add All Day Complete");
                            System.out.println("");
                        } else if (timeDay == 2) {
                            dateOfAll.add(checkInDate + "/" + "1" + "/" + "0" + "/" + "0" + "/" + "4"); // Add ค่า "เช้า" เข้าไป
                            System.out.println("Status : Add Morning Complete");
                            System.out.println("");
                        } else if (timeDay == 3) {
                            dateOfAll.add(checkInDate + "/" + "0" + "/" + "1" + "/" + "0" + "/" + "4"); // Add ค่า "บ่าย" เข้าไป
                            System.out.println("Status : Add Afternoon Complete");
                            System.out.println("");
                        }
                    }
                    else{
                        if (timeDay == 1) {
                            dateOfAll.add(checkInDate + "/" + "0" + "/" + "0" + "/" + "1" + "/" + typeMeet); // Add ค่า "ทั้งวัน" เข้าไป
                            System.out.println("Status : Add All Day Complete");
                            System.out.println("");
                        } else if (timeDay == 2) {
                            dateOfAll.add(checkInDate + "/" + "1" + "/" + "0" + "/" + "0" + "/" + typeMeet); // Add ค่า "เช้า" เข้าไป
                            System.out.println("Status : Add Morning Complete");
                            System.out.println("");
                        } else if (timeDay == 3) {
                            dateOfAll.add(checkInDate + "/" + "0" + "/" + "1" + "/" + "0" + "/" + typeMeet); // Add ค่า "บ่าย" เข้าไป
                            System.out.println("Status : Add Afternoon Complete");
                            System.out.println("");
                        }
                    }
                }
                    
        
                if (dateOfAll.isEmpty()) { // check ว่า ถ้า ข้อมูลมันว่างให้สร้าง ค่าอันใหม่
                    // ลิสต์ dateOfAll ยังไม่มีข้อมูล
                    // ใส่ข้อมูลเริ่มต้นลงในลิสต์
                    if (timeDay == 1) {
                        dateOfAll.add(checkInDate + "/" + "0" + "/" + "0" + "/" + "1" + "/" + typeMeet); // Add ค่า "ทั้งวัน" เข้าไป
                        System.out.println("Status : Add All Day Complete");
                        System.out.println("");
                    } else if (timeDay == 2) {
                        dateOfAll.add(checkInDate + "/" + "1" + "/" + "0" + "/" + "0" + "/" + typeMeet); // Add ค่า "เช้า" เข้าไป
                        System.out.println("Status : Add Morning Complete");
                        System.out.println("");
                    } else if (timeDay == 3) {
                        dateOfAll.add(checkInDate + "/" + "0" + "/" + "1" + "/" + "0" + "/" + typeMeet); // Add ค่า "บ่าย" เข้าไป
                        System.out.println("Status : Add Afternoon Complete");
                        System.out.println("");
                    }
                } /*else {
                    // ลิสต์ dateOfAll มีข้อมูลอยู่แล้ว
                    // ทำการลูปผ่านลิสต์เพื่อค้นหาและแก้ไขค่า
                    for (int i = 0; i < dateOfAll.size(); i++) {
                        String check = dateOfAll.get(i);
                        // เขียนโค้ดเพื่อตรวจสอบและแก้ไขค่าตามเงื่อนไขที่ต้องการ
                        if (check.startsWith(checkInDate)) {
                            if (check.startsWith(checkInDate + "/" + "0" + "/" + "0" + "/" + "1")) {
                                System.out.println("Meeting Now is Full...!!!");
                                break;
                            } else if (check.startsWith(checkInDate + "/" + "1" + "/" + "1" + "/" + "0")) {
                                System.out.println("Meeting Now is Full...!!!");
                                break;
                            } else if (check.startsWith(checkInDate + "/" + "0" + "/" + "1" + "/" + "0")) {
                                dateOfAll.set(i, checkInDate + "/" + "1" + "/" + "1" + "/" + "0");
                                break;
                            } else if (check.startsWith(checkInDate + "/" + "1" + "/" + "0" + "/" + "0")) {
                                dateOfAll.set(i, checkInDate + "/" + "1" + "/" + "1" + "/" + "0");
                                break;
                            }
                        }
                    }
                }*/
            }
    }

    public List getDateOfAll(){
        return dateOfAll;
    }

    public boolean getMeetCheck(){
        return MeetFull;
    }



}


            
        
                  /*if (!check.startsWith(checkInDate) && timeDay == 1 && !iterator.hasNext()) {
                        dateOfAll.add(checkInDate + "/" + "0" + "/" + "0" + "/" + "1");
                        System.out.println("Add All");
                        break;
                    } else if (!check.startsWith(checkInDate) && timeDay == 2 && !iterator.hasNext()) {
                        dateOfAll.add(checkInDate + "/" + "1" + "/" + "0" + "/" + "0");
                        System.out.println("Add Chao");
                        break;
                    } else if (!check.startsWith(checkInDate) && timeDay == 3 && !iterator.hasNext()) {
                        dateOfAll.add(checkInDate + "/" + "0" + "/" + "1" + "/" + "0");
                        System.out.println("Add Bai");
                        break;
                    }
                }
        
                for (int i = 0; i < dateOfAll.size(); i++) {
                    System.out.println(dateOfAll.get(i));
                }
            }*/





        /*int index = -1; // Set ค่าตัวนับ = -1 เพราะว่า ค่าแรกจะอยู่ที่ 0 และ จะได้เอา index ไว้ใกล้ตัว for loop
        for (String check : dateOfAll) {
            index ++; // เพิ่มค่า +1 เพื่อนับตำแหน่งปัจจุบันที่ for กำลังนับอยู่*/


        /*for (int i = 0; i < dateOfAll.size(); i++) { //เป็นลูป เช็ค dateOfAll ทั้งหมด ตอนแรกใช้เป็น for each ที่อยู่ข้างบนจากบรรทัดนี้ประมาณ 5 บรรทัด
            String check = dateOfAll.get(i); // รับค่าตำแหน่งปัจจุบันใน for

            //---------- dateOFAll จะมีค่า 6 ตัว ----------
            //   คือ : Day / Month / Year / เช้า / บ่าย / ทั้งวัน 

            String[] dateAndBook = check.split("/");

            if (check.startsWith(checkInDate)) {
                if(check.startsWith(checkInDate+"/"+"0"+"/"+"0"+"/"+"1")){ // เช็ค ทั้งวัน
                    System.out.println("Meeting Now is Full...!!!");
                    break;
                }
                else if(check.startsWith(checkInDate+"/"+"1"+"/"+"1"+"/"+"0")){ // เช็ค ทั้งวัน (เช้า + บ่าย)
                    System.out.println("Meeting Now is Full...!!!");
                    break;
                }
                else if(check.startsWith(checkInDate+"/"+"0"+"/"+"1"+"/"+"0")){ // เช้า = 0  บ่าย = 1
                    dateOfAll.set(i , checkInDate+"/"+"1"+"/"+"1"+"/"+"0"); //แก้ค่า ให้ เป็น เช้า = 1  บ่าย = 1
                    break;
                }
                else if(check.startsWith(checkInDate+"/"+"1"+"/"+"0"+"/"+"0")){  // เช้า = 1  บ่าย = 0
                    dateOfAll.set(i , checkInDate+"/"+"1"+"/"+"1"+"/"+"0"); //แก้ค่า ให้ เป็น เช้า = 1  บ่าย = 1
                    break;
                }
                
            }

                //---------- dateOFAll จะมีค่า 6 ตัว ----------
                //   คือ : Day / Month / Year / เช้า / บ่าย / ทั้งวัน 

            else if(!check.startsWith(checkInDate) && timeDay == 1){ 
                dateOfAll.add(checkInDate+"/"+"0"+"/"+"0"+"/"+"1"); // Add ค่า "ทั้งวัน" เข้าไป
                System.out.println("Add All");
                break;
            }
            else if(!check.startsWith(checkInDate) && timeDay == 2){
                dateOfAll.add(checkInDate+"/"+"1"+"/"+"0"+"/"+"0"); // Add ค่า "เช้า" เข้าไป
                System.out.println("Add Chao");
                break;
            }
            else if(!check.startsWith(checkInDate) && timeDay == 3){
                dateOfAll.add(checkInDate+"/"+"0"+"/"+"1"+"/"+"0"); // Add ค่า "บ่าย" เข้าไป
                System.out.println("Add Bai");
                break;
            }
        }

        for (int i = 0; i < dateOfAll.size(); i++) { // ปริ้น check ข้อมูลว่า เข้า arraylist รึปล่าว 
            System.out.println(dateOfAll.get(i));
        }*/


        

        /*String[] parts = checkInDate.split("/"); // ตัว check วัน checkIn
            if (parts.length == 3) {
                int day = Integer.parseInt(parts[0]);
                int month = Integer.parseInt(parts[1]);
                int year = Integer.parseInt(parts[2]);

                bookedDay = day;
                bookedMonth = month;
                bookedYear = year;


            String[] partDay = hasbook.split("/"); // ตัว check วัน checkIn
                if (partDay.length == 3) {
                    int chao = Integer.parseInt(partDay[0]); // เช้า
                    int bai = Integer.parseInt(partDay[1]); // บ่าย
                    int tangwan = Integer.parseInt(partDay[2]); // ทั้งวัน

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
                        this.hasbook = hasbook;
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
                        this.hasbook = hasbook;
                    }


                }
            
        }*/

            