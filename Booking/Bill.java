package Booking;

public class Bill {
    private static int bookedTime;
    private static int bookedDay;
    private static String bookedMeeting;
    private static String[] bookedHotel;
    private static double meetingPrice;
    private static double[] hotelPrice;
    private static int amountRoom;
    private static int i = 0;
    private double totalPrice;
    public Bill(){}
    public Bill(int bookedDay){
        this.bookedDay = bookedDay;
    }
    public Bill(int time, int price, String type) {
        this.bookedTime = time;
        this.meetingPrice = price;
        this.bookedMeeting = type;
    }

    public Bill(String a, int numRoom){
        this.amountRoom = numRoom;

        this.hotelPrice = new double[numRoom];
        this.bookedHotel = new String[numRoom];
    }
    public Bill(int price, String type){


        while (i < amountRoom){
            this.bookedHotel[i] = type;
            this.hotelPrice[i] = price;
            break;
        }
        i++;
    }
    public double calPriceMeeting(){
        if (bookedTime == 1){
            totalPrice = meetingPrice;
        }
        else {
            totalPrice = meetingPrice/2;
        }
        return totalPrice;
    }
    public double calHotelPrice(int numDay){
        for(int a = 0; a < hotelPrice.length; a++){
            totalPrice += hotelPrice[a];
        }
        return totalPrice*numDay;
    }
    public void showBill(){
        if(bookedDay == 0) {
            System.out.println("Type : " + bookedMeeting);
            System.out.println("Total price : " + calPriceMeeting() + " THB");
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

            System.out.println("Price : " + calHotelPrice(bookedDay) + " THB");

            i = 0;
        }
    }
}
