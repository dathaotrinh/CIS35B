package adapter;

import exception.AutoException;

public interface CreateAuto {


    //Given a text file name a method called BuildAuto can be written to build an instance of
    //Automobile. This method does not have to return the Auto instance.
    public void BuildAuto(String filename) throws AutoException;

    //This function searches and prints the properties of a given Automodel.
    public void printAuto() throws AutoException;
}
