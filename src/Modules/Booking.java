package Modules;

public class Booking {
    private String DATE;
    private int RESERVATION;
    private String NAME;
    private String ORIGIN;
    private String DEST;
    private int PAX;
    private String[] seats;
    private String flightNumber;

    public Booking(String date, int reservation, String name, String origin, String dest, int pax, String[] seats, String flightNumber) {
        this.DATE = date;
        this.RESERVATION = reservation;
        this.NAME = name;
        this.ORIGIN = origin;
        this.DEST = dest;
        this.PAX = pax;
        this.seats = seats;
        this.flightNumber = flightNumber;
    }

    public String[] getSeats() {
        return seats;
    }

    public void setSeats(String[] seats) {
        this.seats = seats;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDate() {
        return DATE;
    }

    public void setDate(String date) {
        this.DATE = date;
    }

    public int getReservation() {
        return RESERVATION;
    }

    public void setReservation(int reservation) {
        this.RESERVATION = reservation;
    }

    public String getName() {
        return NAME;
    }

    public void setName(String name) {
        this.NAME = name;
    }

    public String getOrigin() {
        return ORIGIN;
    }

    public void setOrigin(String origin) {
        this.ORIGIN = origin;
    }

    public String getDest() {
        return DEST;
    }

    public void setDest(String dest) {
        this.DEST = dest;
    }

    public int getPax() {
        return PAX;
    }

    public void setPax(int pax) {
        this.PAX = pax;
    }

    
    
    
   
}
