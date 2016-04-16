import java.io.*;
import java.util.*;

class Reader {

    private BufferedReader br;
    private String line, nextLine;
    private FileReader fr;
    public Reader (String file) {
        try {

            fr = new FileReader(file);
            br = new BufferedReader(fr);
        }
        catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    public String getNew () {
        try {
            nextLine  = br.readLine();
        }
        catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            nextLine = null;
        }
        finally {
            return nextLine;
        }
    }
}
