package Controllers;

import Modules.LineFlight;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class FlightController {
    private LineFlight FLIGHT;
    private LinkedList<LineFlight> FLIGHTS;
    
    // Constructor - Load all USERS in the RAM memory
    public FlightController() throws IOException{
        FileReader FILEREADER;
        BufferedReader BUFFEREDREADER;
        String FILECONTENT;
        String[] FILEDATA;

        FILEREADER = new FileReader("test/Flights.txt");
        BUFFEREDREADER = new BufferedReader(FILEREADER);
        FLIGHTS = new LinkedList<LineFlight>();
        while((FILECONTENT = BUFFEREDREADER.readLine()) != null){
            FILEDATA = FILECONTENT.split(",");
            FLIGHT = new LineFlight(FILEDATA[0],FILEDATA[1],FILEDATA[2],FILEDATA[3],
                FILEDATA[4],FILEDATA[5],FILEDATA[6],FILEDATA[7]);
            FLIGHTS.add(FLIGHT);
            System.out.println("Hey: "+FILEDATA[4]);
        }
        FILEREADER.close();
    }
    
    //CRUD - Read FLIGHT to check if it exists
    public LinkedList<LineFlight> getStructure(){
        return FLIGHTS;
    }
}
