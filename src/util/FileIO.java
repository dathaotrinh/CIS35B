package util;

import exception.AutoException;
import model.*;

import java.io.*;

public class FileIO {

    public FileIO() {

    }

    public Automobile readFile(String fileName) throws AutoException {
        return buildAutoObject(fileName);
    }

    public Automobile buildAutoObject(String filename) throws AutoException {
        Automobile automobile = new Automobile();

        try {
            FileReader file = new FileReader(filename);
            BufferedReader buff = new BufferedReader(file);
            boolean eof = false;

            // model of the car
            String model = "";

            // store the base price of the car
            float basePrice = 0;

            // number of OptionSet
            int optionSetSize = 0;

            // what line we are currently at
            // start at 1
            int counter = 1;

            // start at line 4
            // information for OptionSet
            int newOptionSetLine = 4;

            int optionSetIndex = 0;

            while(!eof) {
                String line = buff.readLine();
                if(line == null) {
                    eof = true;
                    if(counter == 1) {
                        throw new AutoException(102);
                    }
                } else {
                    // line 1 includes
                    // the model of a car
                    if(counter == 1) {
                        model = line;
                        if(line.equals("")) {
                            throw new AutoException(5);
                        }
                        // line 2 includes
                        // the base price of a car
                    } else if(counter == 2) {
                        if(line.equals("")) {
                            throw new AutoException(1);
                        }
                        basePrice = Float.valueOf(line);

                        // line 3 includes
                        // the OptionSet's size
                    } else if(counter == 3) {
                        optionSetSize = Integer.valueOf(line);

                    } else {
                        if(line.equals("")) {
                            throw new AutoException(3);
                        }

                        String[] tokens = line.split(",");

                        // create an instance of Automotive
                        // after knowing its model, base price and optionSet's size
                        if(counter == 4) {
                            automobile = new Automobile(model, basePrice, optionSetSize);
                        }


                        if(counter == 4 || counter == newOptionSetLine) {
                            int optionSize = Integer.valueOf(tokens[1]);
                            String optionSetName = tokens[0];

                            // create an instance of OptionSet
                            OptionSet optionSetTemp = new OptionSet(optionSetName, optionSize);

                            // set a OptionSet in OptionSet list of Automotive
                            automobile.setValueOfAnOptionSet(optionSetIndex, optionSetTemp);

                            // find the next OptionSet line
                            newOptionSetLine = counter + optionSize + 1;
                            counter++;
                        }

                        int optionIndex = 0;

                        // while the counter is not at the line of new OptionSet line
                        // and not the end of the file
                        while (counter != newOptionSetLine && !eof) {
                            line = buff.readLine();
                            if (line == null) {
                                eof = true;
                            } else {
                                tokens = line.split(",");
                                Float optionPrice = Float.valueOf(tokens[1]);
                                String optionName = tokens[0];

                                // set value of an option
                                automobile.setValueOfAnOption(optionName, optionPrice, optionSetIndex, optionIndex);

                                // update optionIndex and counter
                                optionIndex++;
                                counter++;
                            }
                        }

                        // decrease counter by 1
                        // since we will increase counter by 1 later on
                        // if not, we over count it
                        if(counter == newOptionSetLine) {
                            counter--;
                        }
                        optionSetIndex++;

                    }
                    counter++;
                }
            }

            if(counter == 3) {
                throw new AutoException(2);
            }

            buff.close();
        } catch (IOException e) {
//            System.out.println("Error -- " + e.toString());
            throw new AutoException(101);
        }
        return automobile;

    }


    public void serializeAuto(Automobile automobile) {
        try {

            // writing streams of raw bytes
            FileOutputStream binaryFile = new FileOutputStream( automobile.getName().replaceAll("\\s+", "") + ".ser");
            ObjectOutputStream out = new ObjectOutputStream(binaryFile);
            out.writeObject(automobile);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Automobile deserializeAuto(String fileName) {
        try {
            // obtains input bytes from a file in a file system
            FileInputStream file = new FileInputStream(fileName);

            // deserializes primitive data and objects previously written using the ObjectOutputStream
            ObjectInputStream in = new ObjectInputStream(file);

            Automobile automobile = (Automobile) in.readObject();
            return automobile;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
