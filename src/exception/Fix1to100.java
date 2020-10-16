package exception;

// Exception when some parts are missing in the text file
public class Fix1to100 {

    public Fix1to100() {
    }

    public void fix(int errorNo) {
        String message = "";
        AutoException autoException = new AutoException();
        switch (errorNo) {
            case 1:
                message = "Missing price for Automobile.";
                autoException.writeLogFile(1, message);
                System.exit(0);
                break;
            case 2:
                message = "Missing OptionSet data.";
                autoException.writeLogFile(2, message);
                System.exit(0);
                break;
            case 3:
                message = "Missing part of OptionSet data.";
                autoException.writeLogFile(3, message);
                System.exit(0);
                break;
            case 4:
                message = "Missing Option data.";
                autoException.writeLogFile(4, message);
                System.exit(0);
                break;
            case 5:
                message = "Missing name for Automobile.";
                autoException.writeLogFile(5, message);
                System.exit(0);
                break;
        }
    }
}
