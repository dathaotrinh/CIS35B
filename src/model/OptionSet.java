package model;

import java.io.Serializable;

public class OptionSet implements Serializable {
    private String name;
    private Option[] options;

    // constructors
    public OptionSet() {
    }

    public OptionSet(String name, int size) {
        this.name = name;
        this.options = new Option[size];
        for(int idx = 0; idx < size; idx++) {
            this.options[idx] = new Option();
        }
    }

    // -------getters and setters
    // get Name of OptionSet
    protected String getName() {
        return name;
    }

    // set Name of OptionSet
    protected void setName(String name) {
        this.name = name;
    }

    // get All Options
    protected Option[] getOptions() {
        return options;
    }

    // set All Options
    protected void setOptions(Option[] options) {
        this.options = options;
    }

    // --------- other methods
    // find Index of An Option
    protected int findIndexOfOption(String name) {
        for(int idx = 0; idx < this.options.length; idx++) {
            if(this.options[idx] == null) continue;
            if(this.options[idx].getName().equals(name)) {
                return idx;
            }
        }
        return -1;
    }

    // find Option with Name
    protected Option findOptionWithName(String name) {
        if(findIndexOfOption(name) != -1) {
            int index = findIndexOfOption(name);
            return this.options[index];
        }
        return null;
    }

    // set Value of An Option
    protected void setValueOfAnOption(String name, float price, int optionIndex) {
        Option temp = new Option(name, price);
        this.options[optionIndex] = temp;
    }

    // delete an Option by Index
    protected void deleteAnOptionByIndex(int index) {
        if(index < 0 || index >= this.options.length) return;
        this.options[index] = null;
    }

    // delete an Option by Name
    protected void deleteAnOptionByName(String name) {
        int index = findIndexOfOption(name);
        if (index != -1) {
            this.options[index] = null;
        }
    }

    // update an Option
    protected void updateAnOption(String name, float newPrice) {
        if(findOptionWithName(name) == null) {
            return;
        }

        Option foundOption = findOptionWithName(name);
        foundOption.setPrice(newPrice);
    }

    // print method
    protected String print() {
        StringBuilder str = new StringBuilder();
        str.append(this.name).append(": ");
        str.append("[");

        for(int idx = 0; idx < this.options.length; idx++) {
            str.append(" ");
            if(this.options[idx] != null) {
                str.append(this.options[idx].print());
            } else {
                str.append("Deleted Option");
            }

            str.append(",");
        }
        str.deleteCharAt(str.length()-1);
        str.append(" ]");
        return str.toString();
    }


    class Option implements Serializable {
        private String name;
        private float price;

        public Option() {
        }

        public Option(String name, float price) {
            this.name = name;
            this.price = price;
        }

        protected String getName() {
            return name;
        }

        protected void setName(String name) {
            this.name = name;
        }

        protected float getPrice() {
            return price;
        }

        protected void setPrice(float price) {
            this.price = price;
        }

        // print method
        protected String print() {
            StringBuilder str = new StringBuilder();
            str.append(this.name);
            str.append(": ");
            str.append(this.price);
            return str.toString();
        }
    }


}
