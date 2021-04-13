package Modules;

public class LineFlight {
    String FLIGHTN1;
    String FLIGHTN2; 
    String FLIGHTITSELF;
    String DEPART;
    String ARRIVAL; 
    String STOPOVER;
    String LINK1;
    String LINK2;
    String INDEX;
    
    public LineFlight() {
    
    }
    
    public LineFlight(String FLIGHTN1,String FLIGHTN2,String FLIGHTITSELF,
                String DEPART, String ARRIVAL, String STOPOVER, String LINK1,String LINK2,String INDEX){
        this.FLIGHTN1 = FLIGHTN1;
        this.FLIGHTN2 = FLIGHTN2;
        this.FLIGHTITSELF = FLIGHTITSELF;   
        this.DEPART = DEPART;
        this.ARRIVAL = ARRIVAL; 
        this.STOPOVER = STOPOVER;
        this.LINK1 = LINK1;
        this.LINK2 = LINK2;
        this.INDEX = INDEX;
    }
    
    public String getFlightN1(){
        return FLIGHTN1;
    }
    
    public void setFlightN1(String FLIGHTN1){
        this.FLIGHTN1 = FLIGHTN1;
    }
    public String getFlightN2(){
        return FLIGHTN2;
    }
    
    public void setFlightN2(String FLIGHTN2){
        this.FLIGHTN2 = FLIGHTN2;
    }
    public String getFlightItself(){
        return FLIGHTITSELF;
    }
    public void setFlightItself(String FLIGHTITSELF){
        this.FLIGHTITSELF = FLIGHTITSELF;
    }
    public String getDepart(){
        return DEPART;
    }
    public void setDepart(String DEPART){
        this.DEPART = DEPART;
    }
    public String getArrival(){
        return ARRIVAL;
    }
    public void setArrival(String ARRIVAL){
        this.ARRIVAL = ARRIVAL;
    }
    public String getStopOver(){
        return STOPOVER;
    }
    public void setStopOver(String STOPOVER){
        this.STOPOVER = STOPOVER;
    }    
    public String getLink1(){
        return LINK1;
    }
    public void setLink1(String LINK1){
        this.LINK1 = LINK1;
    }
    public String getLink2(){
        return LINK2;
    }
    public void setLink2(String LINK2){
        this.LINK2 = LINK2;
    }
    public String getIndex(){
        return INDEX;
    }
    public void setIndex(String INDEX){
        this.INDEX = INDEX;
    }
}
 