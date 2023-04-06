
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // ==================================== Main Menu =======================================================

        do {

            System.out.println();
            System.out.println();
            System.out.println(" ----- Welcome to Mackky Hotel 5 Star ----- ");
            System.out.println();

            System.out.println(" == Select == "); // เลือกหัวข้อ
            System.out.println(" 1. Information Hotel Room "); // ข้อมูลของโรงแรม
            System.out.println(" 2. Booking"); // การจอง
            System.out.println();
            System.out.print(" : ");

            String select = scan.nextLine(); // ใช้ select ในการเลือกหัวข้อ (เป็น String)


            // --------------------------- Information Of Hotel ----------------------------------------

            if (select.equals("1")) {
                System.out.println();
                System.out.println();
                System.out.println(" == Information Hotel Room == ");
                System.out.println();
                System.out.println(" - Hotel Room ");
                System.out.println("     1. Basic Room (1-3)         3,500 Baht/day");
                System.out.println("     2. Deluxe Room (4-6)        5,500 Baht/day");
                System.out.println("     3. Super Deluxe Room (7-8)  8,000 Baht/day");
                System.out.println();
                System.out.println(" - Meeting Room ");
                System.out.println("     1. The Universe (250)      50,000 Baht/day");
                System.out.println("     2. The World (100)         30,000 Baht/day");
                System.out.println("     3. The Mini World (50)     20,000 Baht/day");
                System.out.println("     4. The Town (50)           20,000 Baht/day");

                System.out.println(" == Privileges if staying this Hotel == ");
                System.out.println(" - Steam Room");
                System.out.println(" - Massage Room");
                System.out.println(" - Swimming Pool");
                System.out.println(" - Jacuzzi");

                // ปริ้นครบแล้ว จะกลับไปหน้า Welcome
            }


            // -------------------- Booking of Hotel ---------------------------------------------------
            // การจองห้องต่างๆ

            else if (select.equals("2")) {
                do {
                    System.out.println();
                    System.out.println();
                    System.out.println(" ----- Booking -----");
                    System.out.println(" 1. Hotel Room ");
                    System.out.println(" 2. Meeting Room ");
                    System.out.println(" 3. Back to Menu");
                    System.out.println();
                    System.out.println(" == Select == ");
                    System.out.print(" : ");

                    int selectbooking = scan.nextInt(); // จะใช้ตัวแปรเป็น int มีชื่อว่า selectbooking

                    // --------------- Booking Hotel Room ----------------------

                    if (selectbooking == 1) {
                        System.out.println();
                        System.out.println(" ===== Booking Hotel Room ===== ");
                        System.out.println();
                    }


                    // --------------- Booking Meeting Room --------------------

                    else if (selectbooking == 2) {
                        System.out.println();
                        System.out.println(" ===== Booking Meeting Room ===== ");
                        System.out.println();

                    }

                    else if (selectbooking == 3 ) {
                        break;
                    }


                    else {
                        System.out.println("Error!!! please Try Again "); // ถ้าหรอกผิดจะให้หรอกใหม่
                    }

                }while (true);} // Loop ของ Booking







            // ================================ ADMIN ====================================================

            else if (select.equals("Admin123")) { // ------------================== รหัส Admin 123 ================-------------
                do {
                    System.out.println();
                    System.out.println(" -----===== ADMIN =====----- ");
                    System.out.println(" 1. Show All Room Data ");
                    System.out.println(" 2. Change Data");
                    System.out.println(" 3. Back to Menu");

                    System.out.println();
                    System.out.println(" ----- select ----- ");
                    System.out.print(" : ");

                    int adminselect = scan.nextInt();

                    if (adminselect == 1 ){ // แสดงข้อมูลทั้งหมด

                    }

                    else if(adminselect == 2 ){ // แก้ไขข้อมูล

                    }

                    else if (adminselect == 3) { // กลับไปหน้ากมนู
                        break;
                    }

                    else {
                        System.out.println("Error!!! Please Try Again"); // ต้องกรอกข้อมูลหน้านี้ใหม้
                    }
                }while (true);} // Loop ของ Admin



        }while (true); // Loop ของ Main Menu


    }
}
