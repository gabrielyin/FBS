package Modules;

/**
 *
 * @author 2021g
 */
public class Pax {
    protected String DEPART;
    protected String ARRIVAL;
    protected String DEPDATE;
    protected String ARRDATE;
    protected String PAXNUM;
    protected String CLASS;
    
    public Pax(String a,String b,String c,String d,String e,String f){
        this.DEPART = a;
        this.ARRIVAL = b;
        this.DEPDATE = c;
        this.ARRDATE = d;
        this.PAXNUM = e;
        this.CLASS = f;
}
}
