import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Matthew Allen
 *
 */

public class UniformResourceLocatorImpl implements UniformResourceLocator {
	private String scheme;
	private String host;
	private Integer port;
	private String path;
	private Map<String, String> query = new HashMap<String,String>();
	private String fragment;
	private static final Map<String, String> queryEncodeMap;
    static {
        Map<String, String> aMap = new HashMap<String, String>();
        aMap.put("!", "%21");
        aMap.put("#", "%23");
        aMap.put("$", "%24");
        aMap.put("&", "%26");
        aMap.put("'", "%27");
        aMap.put("(", "%28");
        aMap.put(")", "%29");
        aMap.put("*", "%2A");
        aMap.put("+", "%2B");
        aMap.put(",", "%2C");
        aMap.put("/", "%2F");
        aMap.put(":", "%3A");
        aMap.put(";", "%3B");
        aMap.put("=", "%3D");
        aMap.put("?", "%3F");
        aMap.put("@", "%40");
        aMap.put("[", "%5B");
        aMap.put("]", "%5D");
        queryEncodeMap = Collections.unmodifiableMap(aMap);
    }

	@Override
	public String getScheme() {
		return scheme;
	}


	@Override
	public String getHost() {
		return host;
	}

	@Override
	public Integer getPort() {
		return port;
	}

	@Override
	public String getPath() {
		return path;
	}

	@Override
	public Set<String> getQueryKeys() {
		return query.keySet();
	}

	/**
	 * @return the queryValue
	 */
	@Override
	public String getQueryValue(String key) {
		return query.get(key);
	}

	@Override
	public Map<String, String> getQuery() {
		return query;
	}

	@Override
	public String getFragment() {
		return fragment;
	}

	/**
	 * This method concatenates all the parts of the UniformResourceLocator, and returns it as a String.
	 * 
	 * @return a UniformResourceLocator as a String 
	 */
	public String toString() throws IllegalStateException {
		//if()
		return "blarg";
	}
	
	public String encodeQuery(String q) {
		for (int i=0; i < queryEncodeMap.size(); i++) {
			String key = (String)queryEncodeMap.keySet().toArray()[i];
			String val = (String)queryEncodeMap.values().toArray()[i];
			q = q.replace(key, val);
		}
		return q;
	}

	@Override
	public URL toURL() throws IllegalStateException {
		URL url = null;
		try {
			url = new URL(this.toString());
		} catch (MalformedURLException e) {
			throw new IllegalStateException();
		} 
		return url;
	}

	@Override
	public UniformResourceLocator scheme(String s) {
		this.scheme = s;
		return this;
	}

	@Override
	public UniformResourceLocator host(String h) {
		this.host = h;
		return this;
	}

	@Override
	public UniformResourceLocator port(Integer h) {
		this.port = h;
		return this;
	}

	@Override
	public UniformResourceLocator path(String h) {
		this.path = h;
		return this;
	}

	@Override
	public UniformResourceLocator queryParameter(String key, String value) {
		query.put(key, value);
		return this;
	}

	@Override
	public UniformResourceLocator fragment(String h) {
		this.fragment = h;
		return this;
	}
}
