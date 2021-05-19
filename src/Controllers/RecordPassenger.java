package Controllers;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

public class RecordPassenger {
    RandomAccessFile WRITER2;
    PrintWriter PRINTPASSENGER;

    public RecordPassenger(){
        
    }
    
    public void RecordPassenger(String DATA,long position) throws IOException{
        WRITER2 = new RandomAccessFile("test/passengerrecord.txt", "rw");
        WRITER2.write(DATA.getBytes("HELLO"),CountPassenger("test/passengerrecord.txt")-2,5);
        System.out.println("Passenger recorded");
        WRITER2.close();
    }
    
    public int CountPassenger(String TextFile) throws FileNotFoundException, IOException{
        return 0;
    }
    
    public void NewPassenger(String DATE,String RESERVATION,String NAME,String SURNAME,String ORIGIN,String DEST,int PAX) throws IOException{
        PRINTPASSENGER = new PrintWriter(new FileWriter("test/passengerrecord.txt",true));
        PRINTPASSENGER.write(DATE+","+RESERVATION+","+NAME+","+SURNAME+","+ORIGIN+","+DEST+","+PAX+"\n");
        PRINTPASSENGER.close();
    }
}
