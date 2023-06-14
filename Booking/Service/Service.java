package Booking.Service;

public class Service {
    private String order;
    private String name;
    private double price;
    private String limit;

    public String getOrder(){
        return order;
    }

    public void setOrder(String order){
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public Service(){}
    public Service(String order, String name, double price, String limit){
        //ใช้กับ meeting room
        this.order = order;
        this.name = name;
        this.price = price;
        this.limit = limit;
    }

    public Service(String order, String name, double price){
        //ใช้กับ hotel Room
        this.order = order;
        this.name = name;
        this.price = price;
    }

    public Service(int selectBooking){
        if (selectBooking == 1){

        }

        else if (selectBooking == 2) {
            MeetingService meetingService = new MeetingService(getOrder(),getName(),getPrice(),getLimit());
            meetingService.infoService();
            meetingService.selectBooking();
        }
    }
}
