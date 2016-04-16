import java.io.*;
import java.util.*;

public class Processor implements Runnable {
	
	private int freq;
	private Reader reader;
	private Parser parser;
	private StatManager sm;
	private Notifier notifier;
	public Processor () {
		init();
	}

	private void init () {
		try {
			InputStream in = getClass().getClassLoader().getResourceAsStream("config.properties");
			Properties prop = new Properties();
			
			prop.load(in);
			in.close();
			
			reader = new Reader(prop.getProperty("logFilePath"));
			parser = new SampleParser();
			sm = new StatManager(Integer.valueOf(prop.getProperty("userQPMWarning")),
									Integer.valueOf(prop.getProperty("userQPMCritical")),
									Integer.valueOf(prop.getProperty("endpointQPMWarning")),
									Integer.valueOf(prop.getProperty("userQPMCritical")));
			ArrayList<String> emails = new ArrayList(Arrays.asList(prop.getProperty("emails").split(" ")));
			notifier = new Notifier(emails);
			freq = Integer.valueOf(prop.getProperty("updateFrequency"));
		}
		catch (Exception e) {
			System.err.println("Failed to initialize. Exiting.");
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void run () {
		while (true) {
			String s = null;
	        while ((s = reader.getNew()) != null) {
	        	String entry = s;
	        	if (entry.length() == 0) continue;
	        	ArrayList<Object> record = parser.parse(entry);
	        	int status = sm.update(record);
	        	if (status > 0) {
		        	notifier.notify(status, record);
		        }
	        }
        	try {
				Thread.sleep(freq);
			}
			catch (Exception e) {
				System.err.println("Error: " + e.getMessage());
			}
		}
	}
}
