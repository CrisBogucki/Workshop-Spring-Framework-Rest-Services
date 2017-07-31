package pl.asseco.workshop.calculationModule.Services;

import java.util.ArrayList;

/**
 * Created by krzysztof.bogucki on 31 lip 2017.
 */
public class Sum {

    private Integer adderSum;
    private ArrayList<Integer> adderItems;

    public Integer getAdderSum() {
        return adderSum;
    }

    public void setAdderSum(Integer adderSum) {
        this.adderSum = adderSum;
    }

    public ArrayList<Integer> getAdderItems() {
        return adderItems;
    }

    public void setAdderItems(ArrayList<Integer> adderItems) {
        this.adderItems = adderItems;
    }
}
