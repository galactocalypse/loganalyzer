# Log Analyzer - monitors QPM based on server logs


## Default log format
	<IP> <timestamp> <endpoint> <response code>

## Usage
### Generator
	node generate.js > sample.log
### Analyzer
	javac Main.java
	java Main

## Configuration
  Specified in config.properties


## Todo
	Abstract Reader, UserStat, EndpointStat and StatManager
	Specify QPM value in notifications

## Contact
  galactocalypse@gmail.com
