package adapter;

import exception.AutoException;
import model.Automobile;
import util.FileIO;

public abstract class proxyAutomobile {
    private static Automobile a1;

    public void BuildAuto(String filename) throws AutoException {
        a1 = new Automobile();
        FileIO fileIO = new FileIO();
        Automobile temp = fileIO.readFile(filename);

        a1.setName(temp.getName());
        a1.setBasePrice(temp.getBasePrice());
        a1.setOptionSet(temp.getOptionSet());

    }

    public void printAuto() {
        System.out.println(a1.print());
    }

    public void updateOptionSetName(String optionSetName, String newName) {
        a1.updateAnOptionSetName(optionSetName, newName);
    }

    public void updateOptionPrice(String name, float price, String optionSetName) {
        a1.updateAnOptionPrice(name, price, optionSetName);
    }

    public void fix(int errorNo) {
        AutoException autoException = new AutoException();
        autoException.fix(errorNo);
    }

}
