package Booking.Service;

import Booking.Service.HotelService.HotelService;

public class Service {
    private String order;
    private String name;
    private double price;
    private String moreDetail;

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

    public String getMoreDetail() {
        return moreDetail;
    }

    public void setMoreDetail(String limit) {
        this.moreDetail = limit;
    }

    public Service(){}

    public Service(String order, String name, double price, String moreDetail){
        //constructor for meeting room
        this.order = order;
        this.name = name;
        this.price = price;
        this.moreDetail = moreDetail;
    }

     public Service(int selectBooking){
        if (selectBooking == 1){
            HotelService hotelService = new HotelService(getOrder(),getName(),getPrice(),getMoreDetail());
            hotelService.infoService();
            hotelService.selectBooking();
        }

        else if (selectBooking == 2) {
            MeetingService meetingService = new MeetingService(getOrder(),getName(),getPrice(),getMoreDetail());
            meetingService.infoService();
            meetingService.selectBooking();
        }
    }


}
