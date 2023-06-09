package Booking;

public class Bill {
    private static int bookedTime;
    private int bookedDay; //มีแก้ตรงนี้นะ เอา static ออก
    private static String bookedMeeting;
    private static String[] bookedHotel;
    private static double meetingPrice;
    private static double[] hotelPrice;
    private static int amountRoom;
    private static int i = 0;

    //ที่ใช้เป็นตัวแปร static เพื่อให้ค่าที่เก็บไว้แปะอยู่กลับคลาส เวลาดึงค่าไปมาค่าจะได้ไม่เป็น default
    private double totalPrice;
    public Bill(){}
    public Bill(int bookedDay){
        //รับค่ามาจากคลาส Room เพื่อเอามาคิดราคารวมของ hotel room
        this.bookedDay = bookedDay; //เก็บจำนวนวันที่ได้จองไว้
    }
    public Bill(int time, int price, String type) {
        //รับค่ามาจาก MeetingRoom เพื่อเอามาคิดราคารวม
        this.bookedTime = time; // เก็บเวลาที่ได้จองไว้
        this.meetingPrice = price; //เก็ยราคาของ meeting room
        this.bookedMeeting = type; //เก็บ type ของ meeting room
    }

    public Bill(String a, int numRoom){
        //รับค่ามาจาก HotelRoom เพื่อสร้าง Array ไว้เก็บข้อมูลตามจำนวนห้องที่ user ป้อนเข้ามา
        //String a สร้างไว้เฉยๆเพื่อกันการซ้ำกับ constructor ที่เก็บค่าจำนวนวันที่ถูกจอง
        this.amountRoom = numRoom;
        this.hotelPrice = new double[numRoom];  //สร้าง Array เก็บ detail ของห้องที่ user กดจอง
        this.bookedHotel = new String[numRoom]; //สร้าง Array เก็บ ราคา ของห้องที่ user กดจอง
    }
    public Bill(int price, String type){
        // รับค่ามาจาก HotelRoom เพื่อเอามาคิดราคารวม
        while (i < amountRoom){
            this.bookedHotel[i] = type; //เก็บ detail ของห้องที่ user กดจองไว้ใน array
            this.hotelPrice[i] = price;//เก็บราคาของห้องที่ user กดจองไว้ใน array
            break;
        }
        i++;
    }
    public double calPriceMeeting(){
        if (bookedTime == 1){
            //ถ้าเวลาที่จองเป็น 1 (All day) ราคาจะเป็นราคาเต็ม
            totalPrice = meetingPrice;
        }
        else {
            // แต่ถ้าเวลาที่ถูกจองเป็นอย่างอื่นจะเป็น half day
            totalPrice = meetingPrice/2; //ซึ่งราคาของห้องจะเป็นครึ่งนึงของราคาเต็ม
        }
        return totalPrice; //return ราคารวม
    }
    public double calHotelPrice(int numDay){
        //เอาราคาที่เก็บไว้ใน array มารวมกัน ใน totalPrice
        for(int a = 0; a < hotelPrice.length; a++){
            totalPrice += hotelPrice[a];
        }
        return totalPrice*numDay; //เอา totalPrice ที่รวมได้มาคูณกับจำนวนวันที่ user ได้จองไว้เพื่อหาราคารวม
    }
    public void showBill(){
        /*
            ฟังก์ชันที่เอาไว้สรุปรายการที่ user จองไว้
            โดยแยกระหว่าง meeting room กับ hotel room ด้วยการใช้ numDay
            ถ้า numDay == 0 จะเป็นในฝั่งของ meeting room
            แต่ถ้าไม่จะเข้า condition ของ hotel room
         */
        if(bookedDay == 0) {
            System.out.println("Type : " + bookedMeeting);
            //แสดงว่า user ได้จองห้องไหนไปบ้าง

            System.out.println("Total price : " + calPriceMeeting() + " THB");
            //แสดงราคารวมของ bill นี้โดยดึงค่ามาจาก calMeetingPrice()
        }

        else{
            int room1 = 0;
            int room2 = 0;
            int room3 = 0;

            for (int a = 0; a < bookedHotel.length; a++){
                if(bookedHotel[a].equals("1. Basic Room")){
                    room1++;
                }
                else if (bookedHotel[a].equals("2. Deluxe Room")) {
                    room2++;
                }
                else if (bookedHotel[a].equals("3. Super Deluxe Room")) {
                    room3++;
                }
            }

            //เอาไว้นับจำนวนว่าห้อง type ไหน ถูกจองไปกี่ห้อง

            System.out.println("Type :");
            if(room1 != 0){
                System.out.println("   Basic Room [ "+room1+" room(s) ]");
            }
            if(room2 != 0){
                System.out.println("   Deluxe Room [ "+room2+" room(s) ]");
            }
            if(room3 != 0){
                System.out.println("   Super Deluxe Room [ "+room3+" room(s) ]");
            }

            //แสดงว่า user ได้จองห้องไหนไปบ้าง แล้วจองไปกี่ห้อง

            System.out.println("Price : " + calHotelPrice(bookedDay) + " THB");
            //แสดงราคารวมของ bill นี้โดยดึงค่ามาจาก calHotelPrice(int numDay)

            i = 0; //กำหนดให้ i = 0 เพื่อให้รีค่ากลับไปใหม่
        }
    }
}
