package springxml.beans;

import springxml.services.iLog;
import springxml.services.logClass;

public class Species_Spots implements iLog {
    private int Species_ID;
    private int Spot_ID;
    private iLog log;

    public Species_Spots(iLog log){

    }
    public int getSpecies_ID(){
        return Species_ID;
    }
    public void setSpecies_ID(int Species_ID){
        this.Species_ID = Species_ID;
    }
    public int getSpot_ID(){
        return Spot_ID;
    }
    public void setSpot_ID(int Spot_ID){
        this.Spot_ID = Spot_ID;
    }
    public void setLog(logClass log) {
        // diagnostic message
        System.out.println("Log has been accessed");
        this.log = log;
    }
    @Override
    public String getLogInfo() {
        return "Species_Spots has been accessed";
    }
}
