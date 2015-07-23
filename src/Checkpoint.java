
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Checkpoint {

    /**
     * @param targetStr String to search
     * @param searchType 0 - for Number and 1 - for Time
     * @return
     */
    public static String searchCheckpoint(String targetStr, int searchType) {
        BufferedReader br = null;
        try {
            String line;
            String text = "";
            br = new BufferedReader(new FileReader("Log.txt")); //read log.txt file to search 
            while ((line = br.readLine()) != null) {            //loop to process all matching lines
                String[] tokens = line.split(";");              //tokenize each line as number, timestamp and status 
                if (tokens[searchType].equals(targetStr)) {     //search by timestamp(1) or number(0)
                    text = text + line + "\n";                  //append line if matched
                }
            }
            return text;
        } catch (Exception ex) {
            System.out.println("File read error, Check Log.txt File location and try again");
            System.exit(1);
        } finally {
            try {
                if (br != null) {
                    br.close();     //close any open readers in anycase of try or catch
                }
            } catch (IOException ex) {
            }
        }
        return null;
    }

    /**
    * Adds a new checkpoint based on number, timestamp and app state
    */
    public static void addCheckpoint(int number, long time, String state) {
        String toOut = number + ";" + time + ";" + state;       //format line to print to file
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("Log.txt", true));   //open file to write
            bw.append(toOut);
            bw.append(System.lineSeparator());  //new line after each append

        } catch (Exception ex) {
            System.out.println("File write error, try again");
            System.exit(1);
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException ex) {
            }
        }
    }

    /**
     * @param number - Number of the line to be modified
     * @param newCheckpoint New details which will be used to replace old
     * details
     * return true if file was modified, false if not
     */
    private static boolean modifyFile(int number, String newCheckpoint) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        boolean isModified = false;
        try {
            String line;
            String text = "";
            br = new BufferedReader(new FileReader("Log.txt")); //open log file to read existing content
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(";");
                if (tokens[0].equals("" + number)) {
                    line = newCheckpoint;   //replace matching lines with new checkpoint information
                    isModified=true;
                }
                line = ("".equals(line)) ? line : line + System.lineSeparator();    //add a new line if not an empty string
                text = text + line;         // append line by line to create the modified text content
            }
            if(!isModified){
                return false;
            }
            bw = new BufferedWriter(new FileWriter("Log.txt", false));  //open log file to write modified content
            bw.append(text);
            return true;
        } catch (Exception ex) {
            System.out.println("File read error, Check Log.txt File location and try again");
            System.exit(1);
        } finally {
            try {
                if (br != null) {
                    br.close();     //close any open readers in anycase of try or catch
                }
                if (bw != null) {
                    bw.close();     //close any open readers in anycase of try or catch
                }
            } catch (IOException ex) {
            }
        }
        return false;
    }

    /**
     * @return last number(index) of the log file
     */
    public static int getLastIndex() {
        BufferedReader br = null;
        try {
            String line;
            String last = "";
            br = new BufferedReader(new FileReader("Log.txt"));
            while ((line = br.readLine()) != null) {
                last = line;
            }
            return Integer.parseInt(last.split(";")[0]) + 1;
        } catch (IOException | NumberFormatException ex) {
        } finally {
            try {
                if (br != null) {
                    br.close();     //close any open readers in anycase of try or catch
                }
            } catch (IOException ex) {
            }
        }
        return 0;
    }

    /**
     * @param number - Number of the line to be modified
     * @param time - New timestamp to replace old timestamp(if applicable)
     * @param state - New state to replace old state(if applicable)
     * @return true if modified, false if not
     */
    public static boolean modifyCheckpoint(int number, Long time, String state) {
        String line = number + ";" + time + ";" + state;
        return modifyFile(number, line);
    }

    /**
     * @param number Number of the checkpoint to be deleted
     */
    public static boolean deleteCheckpoint(int number) {
        return modifyFile(number, "");
    }

    /**
     * @return the complete content of the log file as a string
     */
    public static String getAllDetails() {
        StringBuilder details = new StringBuilder();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("Log.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(";");
                details.append("Number: ").append(tokens[0]).append(System.lineSeparator());
                details.append("TimeStamp: ").append(tokens[1]).append(System.lineSeparator());
                details.append("State: ").append(tokens[2]).append(System.lineSeparator());
                details.append(System.lineSeparator());
            }
        } catch (Exception e) {
            if (br != null) {
                try {
                    br.close();     //close any open readers in anycase of try or catch
                } catch (IOException ex) {
                }
            }
        }
        return details.toString();
    }

    /**
     * @param number - Number of the checkpoint whose details are requested
     * @return details of target checkpoint as a String
     */
    public static String getDetail(int number) {
        try {
            StringBuilder details = new StringBuilder();
            String line = searchCheckpoint(number + "", 0);
            String[] tokens = line.split(";");
            details.append("Number: ").append(tokens[0]).append(System.lineSeparator());
            details.append("TimeStamp: ").append(tokens[1]).append(System.lineSeparator());
            details.append("State: ").append(tokens[2]).append(System.lineSeparator());
            details.append(System.lineSeparator());
            return details.toString();
        } catch (Exception e) {
            return "";
        }
    }
}
