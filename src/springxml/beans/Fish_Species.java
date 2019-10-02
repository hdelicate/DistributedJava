package springxml.beans;

import springxml.services.iLog;
import springxml.services.logClass;

public class Fish_Species implements iLog {
    private String speciesName;
    private int Species_ID;
    private String Summary;
    private iLog log;

    public Fish_Species(iLog log){


    }
    public String getSpeciesName(){
        return speciesName;
    }
    public void setSpeciesName(String speciesName){
    this.speciesName = speciesName;
    }
    public int getSpecies_ID(){
        return Species_ID;
    }
    public void setSpecies_ID(int Species_ID){
        this.Species_ID = Species_ID;
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
        return "Species has been accessed";
    }
}
