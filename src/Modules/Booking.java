/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modules;

/**
 *
 * @author 2021g
 */
public class Booking {
    private String DATE;
    private int RESERVATION;
    private String NAME;
    private String SURNAME;
    private String ORIGIN;
    private String DEST;
    private int PAX;

    public Booking(String date, int reservation, String name, String surname, String origin, String dest, int pax) {
        this.DATE = date;
        this.RESERVATION = reservation;
        this.NAME = name;
        this.SURNAME = surname;
        this.ORIGIN = origin;
        this.DEST = dest;
        this.PAX = pax;
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

    public String getSurname() {
        return SURNAME;
    }

    public void setSurname(String surname) {
        this.SURNAME = surname;
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
