package Controllers;

import Modules.Booking;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookingController {
    private Booking booking;
    private LinkedList<Booking> bookings;
    
    public BookingController(){
        read();
    }
    
    public LinkedList<Booking> read(){
        try{
            FileReader filePath = new FileReader("test/Booking.txt");
            Scanner file = new Scanner(filePath);
            bookings = new LinkedList<Booking>();

            while(file.hasNext()){
                String[] data = file.nextLine().split(",");

                String[] seats = new String[data[6].split("x").length];
                for (int i = 0; i < data[6].split("x").length; i++) {
                    seats[i] = data[6].split("x")[i];
                }

                booking = new Booking(data[0],Integer.parseInt(data[1]),data[2],data[3],data[4],Integer.parseInt(data[5]),seats, data[7]);
                bookings.add(booking);
            }

            file.close();
            filePath.close();
        }catch(IOException error){
            System.out.println("Error while reading bookings.");
        }
        return bookings;
    }
    
    public LinkedList<Booking> readme(String TFIELD, Integer CHECK){
        try{
            FileReader filePath = new FileReader("test/Booking.txt");
            Scanner file = new Scanner(filePath);
            bookings = new LinkedList<Booking>();

            while(file.hasNext()){
                String[] data = file.nextLine().split(",");
                if(data[CHECK].equals(TFIELD)){

                    String[] seats = new String[data[6].split("x").length];
                    for (int i = 0; i < data[6].split("x").length; i++) {
                        seats[i] = data[6].split("x")[i];
                    }

                    booking = new Booking(data[0],Integer.parseInt(data[1]),data[2],data[3],data[4],Integer.parseInt(data[5]),seats, data[7]);
                    bookings.add(booking);
                }
            }

            file.close();
            filePath.close();
            
        }catch(IOException error){
            System.out.println("Error while reading bookings.");
        }
        return bookings;
    }    
    
    public void create(String DATE, int RESERVATION, String NAME, String ORIGIN, String DEST, int PAX, String seatsStream, String flightNumber){
        try {
            System.out.println("HELLO");
            FileWriter fileWriter = new FileWriter("test/Booking.txt", true);
            fileWriter.write(DATE + "," + RESERVATION + "," + NAME + "," + ORIGIN + "," + DEST + "," + PAX + "," + seatsStream + "," + flightNumber);
            fileWriter.write(System.lineSeparator());

            String[] seats = new String[seatsStream.split("x").length];
            for (int i = 0; i < seatsStream.split("x").length; i++) {
                seats[i] = seatsStream.split("x")[i];
            }

            booking = new Booking(DATE, RESERVATION, NAME, ORIGIN, DEST, PAX, seats, flightNumber);
            bookings.add(booking);
            
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(BookingController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void delete(Integer INDEX) throws IOException{
        FileWriter file = new FileWriter("./test/Booking.txt", false);
        //file.flush();
        for (int i = 0; i < bookings.size(); i++) {

            if (bookings.get(i).getReservation()==INDEX) {
                bookings.set(i, null);
            }else{
                file.write(bookings.get(i).getDate() + "," 
                        + bookings.get(i).getReservation() + "," 
                        + bookings.get(i).getName() + ","                         
                        + bookings.get(i).getOrigin() + "," 
                        + bookings.get(i).getDest()+ "," 
                        + bookings.get(i).getPax());
                file.write(System.lineSeparator());
            }
        }
        file.close();
    }
}
