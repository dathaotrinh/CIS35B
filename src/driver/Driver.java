package driver;

import adapter.BuildAuto;
import adapter.CreateAuto;
import adapter.FixAuto;
import adapter.UpdateAuto;
import exception.AutoException;
import model.Automobile;
import util.FileIO;

public class Driver {
    public static void main(String[] args) throws AutoException {
 /*       //Build Automobile Object from a file.
        FileIO file = new FileIO();
        Automobile FordZTW = file.readFile("CarConfiguration.txt");
        //Print attributes before serialization
        System.out.println(FordZTW.print());
//        System.out.println(FordZTW.printOptionSet());
//        System.out.println(FordZTW.printOptionsOfAnOptionSet("Transmission"));


        //Serialize the object
        file.serializeAuto(FordZTW);
        //Deserialize the object and read it into memory.
        Automobile newFordZTW = file.deserializeAuto(FordZTW.getName().replaceAll("\\s+", "") + ".ser"); //Print new attributes.
        System.out.println(newFordZTW.print());

    */

/*        // testing methods from BuildAuto
        CreateAuto a1 = new BuildAuto();
        UpdateAuto a2 = new BuildAuto();
        FixAuto a3 = new BuildAuto();

        a1.BuildAuto("CarConfiguration.txt");
        a1.printAuto();

        a2.updateOptionPrice("Automatic", 12, "Transmission");
        a2.updateOptionSetName("Transmission", "Updated Transmission");
        a1.printAuto();

    //    a3.fix(1);
*/

        // test exception
        CreateAuto a1 = new BuildAuto();
        a1.BuildAuto("EmptyTextFile.txt");

    }
}
