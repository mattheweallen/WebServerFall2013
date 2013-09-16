import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * This class implements UniformResourceLocator, and is a representation of a URL.
 * 
 * @author Matthew Allen
 * @version 1.6 September 16, 2013
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

    /**
     * The method returns the scheme part of url.
     * 
     * @return String representation of a scheme
     */
	@Override
	public String getScheme() {
		return scheme;
	}

	/**
     * The method returns the host part of url.
     * 
     * @return String representation of a host
     */
	@Override
	public String getHost() {
		return host;
	}
	
	/**
     * The method returns the port part of url.
     * 
     * @return Integer signifying port in url
     */
	@Override
	public Integer getPort() {
		return port;
	}

	/**
     * The method returns the path part of url.
     * 
     * @return String representation of a path
     */
	@Override
	public String getPath() {
		return path;
	}

	/**
     * The method returns the set of keys associated with query in url.
     * 
     * @return Set<String> that are the keys in the url's query
     */
	@Override
	public Set<String> getQueryKeys() {
		return query.keySet();
	}

	/**
     * The method returns for a given query key the value associated with it.
     * 
     * @return String based on the query key.
     */
	@Override
	public String getQueryValue(String key) {
		return query.get(key);
	}

	/**
     * The method returns the key, value pairs in the url's query
     * 
     * @return Map<String, String> that contains all the query key, value pairs.
     */
	@Override
	public Map<String, String> getQuery() {
		return query;
	}

	/**
     * The method returns the fragment part of url.
     * 
     * @return String representation of url fragment
     */
	@Override
	public String getFragment() {
		return fragment;
	}

	/**
	 * This method concatenates all the parts of the UniformResourceLocator, and returns it as a String.
	 * 
	 * @return String representation of a UniformResourceLocator 
	 * @throws IllegalStateException
	 */
	public String toString() throws IllegalStateException {
		//if()
		return "blarg";
	}
	
	/**
     * The method takes a url query String as input and returns it with special characters encoded.
     * 
     * @param q String representation of query.
     * @return String with special characters encoded
     */
	public String encodeQuery(String q) {
		for (int i=0; i < queryEncodeMap.size(); i++) {
			String key = (String)queryEncodeMap.keySet().toArray()[i];
			String val = (String)queryEncodeMap.values().toArray()[i];
			q = q.replace(key, val);
		}
		return q;
	}

	/**
	 * This method takes a UniformResourceLocator, and turns it into a java.net.URL
	 * 
	 * @return java.net.url based on the toString method of the UniformResourceLocator
	 * @throws IllegalStateException
	 */
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

	/**
     * The method takes a String as input and returns it as a UniformResourceLocator with scheme set.
     * 
     * @param s String representing scheme
     * @return UniformResourceLocator
     */
	@Override
	public UniformResourceLocator scheme(String s) {
		this.scheme = s;
		return this;
	}

	/**
     * The method takes a String as input and returns it as a UniformResourceLocator with host set.
     * 
     * @param h String representing host
     * @return UniformResourceLocator
     */
	@Override
	public UniformResourceLocator host(String h) {
		this.host = h;
		return this;
	}

	/**
     * The method takes an Integer as input and returns it as a UniformResourceLocator with port set.
     * 
     * @param h String representing port
     * @return UniformResourceLocator
     */
	@Override
	public UniformResourceLocator port(Integer h) {
		this.port = h;
		return this;
	}

	/**
     * The method takes a String as input and returns it as a UniformResourceLocator with path set.
     * 
     * @param h String representing path
     * @return UniformResourceLocator
     */
	@Override
	public UniformResourceLocator path(String h) {
		this.path = h;
		return this;
	}
	
	/**
     * The method takes a String key, value pair as input and returns it as a UniformResourceLocator with key, value added to query.
     * 
     * @param key String 
     * @param value String
     * @return UniformResourceLocator
     */
	@Override
	public UniformResourceLocator queryParameter(String key, String value) {
		query.put(key, value);
		return this;
	}

	/**
     * The method takes a String as input and returns it as a UniformResourceLocator with fragment in url set.
     * 
     * @param h String
     * @return UniformResourceLocator
     */
	@Override
	public UniformResourceLocator fragment(String h) {
		this.fragment = h;
		return this;
	}
}
