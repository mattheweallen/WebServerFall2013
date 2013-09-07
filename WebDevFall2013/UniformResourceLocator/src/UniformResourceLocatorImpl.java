import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 
 */

/**
 * @author matthew
 *
 */

public class UniformResourceLocatorImpl implements UniformResourceLocator {
	private String scheme;
	private String host;
	private Integer port;
	private String path;
	private Map<String, String> query = new HashMap<String,String>();
	private String fragment;

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
		// TODO Auto-generated method stub
		return fragment;
	}

	@Override
	public URL toURL() throws IllegalStateException {
		// TODO Auto-generated method stub
		return null;
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
