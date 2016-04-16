import java.util.*;

public class StatManager {
	static int USER_QPM_C; //1000
	static int EP_QPM_C;   //0010
	static int USER_QPM_W; //0100
	static int EP_QPM_W;   //0001
	private HashMap <String, EndpointStat> endpoints;
	private HashMap <String, UserStat> users;

	public StatManager (int quw, int quc, int qew, int qec) {
		USER_QPM_W = quw;
		USER_QPM_C = quc;
		EP_QPM_W = qew;
		EP_QPM_C = qec;
		users = new HashMap<String, UserStat> ();
		endpoints = new HashMap<String, EndpointStat> ();

	}

	public int update (ArrayList<Object> record) {
		if (users.get((String)record.get(0)) == null) {
			users.put((String)record.get(0), new UserStat());
		}
		if (endpoints.get((String)record.get(2)) == null) {
			endpoints.put((String)record.get(2), new EndpointStat());
		}
		int qpm_u = users.get(record.get(0)).update((Date)record.get(1));
		int qpm_ep = endpoints.get(record.get(2)).update((Date)record.get(1));
		int status = 0;
		if (qpm_u >= USER_QPM_C) status |= 8;
		else if (qpm_u >= USER_QPM_W) status |= 4;
		if (qpm_ep >= EP_QPM_C) status |= 2;
		else if (qpm_ep >= EP_QPM_C) status |= 1;
		return status;
	}
}
