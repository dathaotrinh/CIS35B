package adapter;

import exception.AutoException;
import model.Automobile;
import util.FileIO;

public abstract class proxyAutomobile {
    // property
    private static Automobile a1;

    // define BuildAuto method from CreateAuto
    public void BuildAuto(String filename) throws AutoException {
        a1 = new Automobile();
        FileIO fileIO = new FileIO();
        Automobile temp = fileIO.readFile(filename);

        a1.setName(temp.getName());
        a1.setBasePrice(temp.getBasePrice());
        a1.setOptionSet(temp.getOptionSet());

    }

    // define printAuto method from CreateAuto
    public void printAuto() {
        System.out.println(a1.print());
    }

    // define updateOptionSetName from UpdateAuto
    public void updateOptionSetName(String optionSetName, String newName) {
        a1.updateAnOptionSetName(optionSetName, newName);
    }

    // define updateOptionPrice from UpdateAuto
    public void updateOptionPrice(String name, float price, String optionSetName) {
        a1.updateAnOptionPrice(name, price, optionSetName);
    }

    // define fix method from FixAuto
    public void fix(int errorNo) {
        AutoException autoException = new AutoException();
        autoException.fix(errorNo);
    }

}
