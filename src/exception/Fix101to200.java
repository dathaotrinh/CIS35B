package exception;

import adapter.BuildAuto;
import adapter.CreateAuto;
import adapter.UpdateAuto;
import model.Automobile;

import java.util.Scanner;

public class Fix101to200 {
    public Fix101to200() {
    }

    public void fix(int errorNo) {

        String message = "";
        AutoException autoException = new AutoException();
        switch (errorNo) {
            case 101:
                message = "Cannot find the text file.";
                autoException.writeLogFile(101, message);
                System.exit(0);
                break;
            case 102:
                message = "Text file is found but empty.";
                autoException.writeLogFile(102, message);
                System.out.print("Enter a new file name: ");
                Scanner scanner = new Scanner(System.in);
                String filename = scanner.nextLine();
                CreateAuto a1 = new BuildAuto();

                try {
                    System.out.println(filename.trim());
                    a1.BuildAuto(filename.trim());
                    a1.printAuto();
                    System.exit(0);

                } catch (AutoException e) {
                    e.printStackTrace();

                }
                break;
        }
    }
}
