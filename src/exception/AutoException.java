package exception;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AutoException extends Exception {

    private int errorNo;
    private String errorMsg;


    // default constructor
    public AutoException() {
    }

    // constructor with errorMsg argument
    public AutoException(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    // constructor with errorNo argument
    public AutoException(int errorNo) {
        this.errorNo = errorNo;
        fix(errorNo);
    }

    // constructor with all properties as arguments
    public AutoException(int errorNo, String errorMsg) {
        this.errorNo = errorNo;
        this.errorMsg = errorMsg;
    }

    // getters and setters
    public int getErrorNo() {
        return errorNo;
    }

    public void setErrorNo(int errorNo) {
        this.errorNo = errorNo;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    // this method can be redundant
    public void printMyProblem() {
        writeLogFile(errorNo, errorMsg);
    }

    // log timestamps for all exceptions that get caught
    public void writeLogFile(int errorNo, String errorMsg) {

        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        PrintWriter printWriter = null;

            try {
                fileWriter = new FileWriter("LogFile.txt", true);
                bufferedWriter = new BufferedWriter(fileWriter);
                printWriter = new PrintWriter(bufferedWriter);
                SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Calendar cal = Calendar.getInstance();
                String message = date.format(cal.getTime()) + ": FixProblems [errorno=" + errorNo + ", errorMsg=" + errorMsg + "]";
                System.out.println(message);
                printWriter.println(message);
                printWriter.close();
                printWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    printWriter.close();
                    bufferedWriter.close();
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

    }

    // fix method to catch exception
    public void fix (int errorNo)  {
        int num = (int) Math.ceil((double)errorNo/100);

        switch (num) {
            case 1:
                Fix1to100 f1 = new Fix1to100();
                f1.fix(errorNo);
                break;
            case 2:
                Fix101to200 f2 = new Fix101to200();
                f2.fix(errorNo);
                break;
        }
    }


}
