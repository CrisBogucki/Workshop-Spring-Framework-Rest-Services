package pl.asseco.workshop.calculationModule.Services;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by krzysztof.bogucki on 24 lip 2017.
 */
@Service
public class FileAdderProvider implements AdderProvider {

    private Logger logger = Logger.getLogger(getClass().getName());

    private Random generator;
    private Integer maxGen;

    private ArrayList<Integer> listItem;
    private Boolean isManualSuported = false;

    @Override
    public ArrayList<Integer> getItems() {

        //System.out.println("Instancja FileAdderProvider-a " + hashCode());

        //TODO: Implement load Integers from file
        if(isManualSuported == false) {

            this.generator = new Random();
            this.maxGen  = generator.nextInt(10);

            logger.info("Pobrano dane z generatora liczbowego");

            listItem = new ArrayList<Integer>();
            for (int i = 0; i <= this.maxGen; i++) {
                listItem.add(i);
            }
        }

        logger.info("Pobrano dane z pliku tekstowego...");
        return listItem;
    }

    @Override
    public void setListItems(ArrayList<Integer> listItem) {
        this.listItem = listItem;
        isManualSuported = true;
    }


}
