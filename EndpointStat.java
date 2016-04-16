import java.util.*;
public class EndpointStat {
	ArrayList<Date> requests; //over the last one minute

	public EndpointStat () {
		requests = new ArrayList<Date>();
	}
	public int update (Date req) {
		Date now = new Date();
		long currentTime = now.getTime();
                long oldestTime =  (requests.size() == 0)?0:requests.get(requests.size() - 1).getTime();
		requests.add(req);
		while (requests.size() > 0 && (now.getTime() - requests.get(0).getTime()) >= 60000 ) {
			requests.remove(0);
		}
		return requests.size();
	}
}
