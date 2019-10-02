package springxml;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import springxml.beans.Fish_Species;
import springxml.beans.Fishing_Spot;
import springxml.beans.Species_Spots;

public class SpringApp {
    public static void main(String[] args) {
        // load the Spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // retrieve bean from Spring container
        Fish_Species fishSpecies1 = context.getBean("fishSpecies", Fish_Species.class);
        Fishing_Spot fishSpot = context.getBean("fishSpot", Fishing_Spot.class);
        Species_Spots speciesSpot  = context.getBean("speciesSpot", Species_Spots.class);
        // call methods on the bean
        System.out.println(fishSpecies1.getLogInfo());
        System.out.println(fishSpot.getLogInfo());
        System.out.println(speciesSpot.getLogInfo());

        // call getters for literal values
        System.out.println(speciesSpot.getSpot_ID());
        System.out.println(speciesSpot.getSpecies_ID());
        System.out.println(fishSpot.getSpot_ID());
        System.out.println(fishSpot.getSpecies());
        System.out.println(fishSpot.getName());
        System.out.println(fishSpot.getType());
        System.out.println(fishSpot.getSummary());
        System.out.println(fishSpecies1.getSpecies_ID());
        System.out.println(fishSpecies1.getSummary());
        System.out.println(fishSpecies1.getSpeciesName());
        // close the context
        context.close();
    }
}
