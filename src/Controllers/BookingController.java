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
                booking = new Booking(data[0],Integer.parseInt(data[1]),data[2],data[3],data[4],Integer.parseInt(data[5]));
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
                    booking = new Booking(data[0],Integer.parseInt(data[1]),data[2],data[3],data[4],Integer.parseInt(data[5]));
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
    
    public void create(String DATE, int RESERVATION, String NAME, String ORIGIN, String DEST, int PAX){
        try {
            System.out.println("HELLO");
            FileWriter fileWriter = new FileWriter("test/Booking.txt", true);
            fileWriter.write(DATE + "," + RESERVATION + "," + NAME + "," + ORIGIN + "," + DEST + "," + PAX);
            fileWriter.write(System.lineSeparator());
            booking = new Booking(DATE, RESERVATION, NAME, ORIGIN, DEST, PAX);
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
