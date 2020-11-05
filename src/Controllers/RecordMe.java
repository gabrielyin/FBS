package Controllers;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

public class RecordMe {
    RandomAccessFile WRITER;
    PrintWriter PRINTME;
    String DATAREAD;
 
    public RecordMe(){
        
    }
    
    public void RecordMe(String DATA, long position) throws IOException{
        WRITER = new RandomAccessFile("test/users2.txt", "rw");
        WRITER.write(DATA.getBytes("HELLO"),CountMe("test/users2.txt")-2,5);
        System.out.println("New Login Details Saved");
        WRITER.close();
    }
    
    public int CountMe(String TEXTFILE) throws FileNotFoundException, IOException{
        return 0;
    }
    
    public void NewMe(String AN, String PS, String EMAIL) throws IOException{
        PRINTME = new PrintWriter(new FileWriter("test/users.txt",true));
        PRINTME.write(AN+","+PS+","+EMAIL+"\n");
        PRINTME.close();
    }

}
