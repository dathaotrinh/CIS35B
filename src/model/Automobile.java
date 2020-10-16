package model;

import java.io.Serializable;

public class Automobile implements Serializable {

    // properties
    private String name;
    private float basePrice;
    private OptionSet[] optionSet;

    // default constructor
    public Automobile() {
    }

    // constructor
    public Automobile(String name, float basePrice, int size) {
        this.name = name;
        this.basePrice = basePrice;
        this.optionSet = new OptionSet[size];

    }

    // ------getters and setters
    // get Name of Automotive
    public String getName() {
        return name;
    }

    // set Name of Automotive
    public void setName(String name) {
        this.name = name;
    }

    // get BasePrice of Automotive
    public float getBasePrice() {
        return basePrice;
    }

    // set BasePrice of Automotive
    public void setBasePrice(float basePrice) {
        this.basePrice = basePrice;
    }

    // get all OptionSets
    public OptionSet[] getOptionSet() {
        return this.optionSet;
    }

    // set all OptionSets
    public void setOptionSet(OptionSet[] optionSet) {
        this.optionSet = optionSet;
    }

    // ----- other methods
    // get an OptionSet by index
    public OptionSet getAnOptionSetByIndex(int index) {
        // if the index is invalid
        if(index < 0 || index >= this.optionSet.length) return null;
        return this.optionSet[index];
    }

    // find Index of An Option Set
    public int findIndexOfOptionSet(String name) {
        // compare the name of each OptionSet with the input
        for(int idx = 0; idx < this.optionSet.length; idx++) {
            // skip the null OptionSet
            if(this.optionSet[idx] == null) continue;
            if(this.optionSet[idx].getName().equals(name)) {
                return idx;
            }
        }
        return -1;
    }

    // find OptionSet with Name
    public OptionSet findOptionSetWithName(String name) {
        // find the index of OptionSet by name
        int index = findIndexOfOptionSet(name);
        // if found, return the OptionSet at that index
        if(index != -1) {
            return this.optionSet[index];
        }
        return null;
    }

    // set Value Of An OptionSet
    public void setValueOfAnOptionSet(int optionSetIndex, OptionSet currentOptionSet) {
        // check if OptionSetIndex is valid
        if(optionSetIndex < 0 || optionSetIndex >= this.optionSet.length) return;
        this.optionSet[optionSetIndex] = currentOptionSet;
    }

    // set Value Of An Option
    public void setValueOfAnOption(String name, float price, int optionSetIndex, int optionIndex) {
        if(optionSetIndex < 0 || optionSetIndex >= this.optionSet.length) return;
        this.optionSet[optionSetIndex].setValueOfAnOption(name, price, optionIndex);
    }


    // find Index of Option with name
    public int findIndexOfOptionWithName(OptionSet currentOptionSet, String optionName) {
        return currentOptionSet.findIndexOfOption(optionName);
    }

    // delete an OptionSet
    public void deleteAnOptionSetByName(String name) {
        int index = findIndexOfOptionSet(name);
        if(index != -1) {
            this.optionSet[index] = null;
        }
    }

    // delete an Option
    public void deleteAnOptionByName(String optionName, String optionSetName) {
        int index = findIndexOfOptionSet(optionSetName);
        if(index != -1) {
            this.optionSet[index].deleteAnOptionByName(optionName);
        }
    }

    // update an OptionSet Name
    public void updateAnOptionSetName(String name, String newName) {
        int index = findIndexOfOptionSet(name);
        if(index != -1) {
            this.optionSet[index].setName(newName);
        }
    }

    // update an Option Price
    public void updateAnOptionPrice(String name, float price, String optionSetName) {
        int index = findIndexOfOptionSet(optionSetName);
        if(index != -1) {
            int optionIndex = findIndexOfOptionWithName(this.optionSet[index], name);
            if(optionIndex != -1) {
                this.optionSet[index].setValueOfAnOption(name, price, optionIndex);
            }
        }
    }

    // print Car Name
    public String printCarName() {
        return this.name;
    }

    // print Base Price
    public double printBasePrice() {
        return this.basePrice;
    }

    // print Name of all OptionSet
    public String printOptionSet() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < optionSet.length; i++) {
            str.append(this.optionSet[i].getName()).append(", ");
        }

        return str.toString().substring(0, str.length()-2);
    }


    // print All Option Name of an OptionSet
    public String printOptionsOfAnOptionSet(String optionSetName) {
        OptionSet optionSet = findOptionSetWithName(optionSetName);
        StringBuilder str = new StringBuilder();

        if(optionSet != null) {
            str.append(optionSetName).append(": ");
            for (OptionSet.Option option: optionSet.getOptions()) {
                str.append(option.getName()).append(", ");
            }
            return str.toString().substring(0, str.length()-2);
        }

        return "Cannot find the target OptionSet";

    }

    // print Automotive
    public String print() {
        StringBuilder str = new StringBuilder();

        str.append(this.name).append("\n");
        str.append(this.basePrice).append("\n");

        for(int idx = 0; idx < this.optionSet.length; idx++) {
            if(this.optionSet[idx] != null) {
                str.append(this.optionSet[idx].print());
            } else {
                str.append("Deleted OptionSet");
            }
            str.append("\n");
        }

        return str.toString().trim();
    }

}
