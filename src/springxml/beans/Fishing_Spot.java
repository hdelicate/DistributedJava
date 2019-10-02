package springxml.beans;

import springxml.services.iLog;
import springxml.services.logClass;

public class Fishing_Spot implements iLog {
    private int Spot_ID;
    private String Species;
    private String Name;
    public String Type;
    public String Summary;
    private iLog log;

    public Fishing_Spot(iLog log){

    }
    public int getSpot_ID(){
        return Spot_ID;
    }
    public void setSpot_ID(int Spot_ID){
        this.Spot_ID = Spot_ID;
    }
    public String getSpecies(){
        return Species;
    }
    public void setSpecies(String Species){
        this.Species = Species;
    }
    public String getName(){
        return Name;
    }
    public void setName(String Name){
        this.Name = Name;
    }
    public String getType(){
        return Type;
    }
    public void setType(String Type){
        this.Type = Type;
    }
    public String getSummary(){
        return Summary;
    }
    public void setSummary(String Summary){
        this.Summary = Summary;
    }
    public void setLog(logClass log) {
        // diagnostic message
        System.out.println("Log has been accessed");
        this.log = log;
    }
    @Override
    public String getLogInfo() {
        return "Fishing Spot has been accessed";
    }
}
