/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controllers;

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modules.Booking;

/**
 *
 * @author 2021g
 */
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
                booking = new Booking(data[0],Integer.parseInt(data[1]),data[2],data[3],data[4],data[5],Integer.parseInt(data[6]));
                bookings.add(booking);
            }

            file.close();
            filePath.close();
        }catch(IOException error){
            System.out.println("Error while reading bookings.");
        }
        return bookings;
    }
}
