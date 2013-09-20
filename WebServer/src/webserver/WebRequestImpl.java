/**
 * 
 */
package webserver;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * This class implements WebRequest. 
 * 
 * @author Matthew Allen
 */
public class WebRequestImpl implements WebRequest {
	private String method;
	private Map<String, String> headerFields = new HashMap<String,String>();
	private String path;
	private String version;
	private UniformResourceLocator url;
	
	
	/** 
	 * set the method for the request message request line.
	 * 
	 * @param method 
	 */
	@Override
	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * set the path for the resource indicated in the request message request line.
	 * 
	 * @param path
	 */
	@Override
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * set the version for http spec indicated in the request message request line.
	 * 
	 * @param version String
	 */
	@Override
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * get the method for the request message request line.
	 * 
	 * @return method String
	 */
	@Override
	public String getMethod() {
		return method;
	}

	/**
	 * get the path for the resource indicated in the request message request line.
	 * 
	 * @return path String
	 */
	@Override
	public String getPath() {
		return path;
	}

	/**
	 * get the version for http spec indicated in the request message request line.
	 * 
	 * @return version String
	 */
	@Override
	public String getVersion() {
		return version;
	}

	/**
	 * This method puts a header field, which is a name value pair into headerFields.
	 * headerFields will be used in getHeader to generate name value pairs separated by colon, 
	 * and terminated with carriage return and line feed.  
	 * 
	 * @param name String
	 * @param value String
	 */
	@Override
	public void addHeader(String name, String value) {
		headerFields.put(name, value);
	}

	/**
	 * get the header, which will consist of the name value pair request headers from headerFields.
	 * The name value pairs will be separated by a colon, and terminated with the carriage return and line feed \r\n where \r is carriage return \n is line feed.
	 * The end of the header will be indicated by two consecutive carriage return line feed pairs.
	 * 
	 * @param name String
	 * @return 
	 */
	@Override
	public String getHeader(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * return all the names of the fields that are in headerFields 
	 * 
	 * @return headerNames Set<String>
	 */
	@Override
	public Set<String> getHeaderNames() {
		return headerFields.keySet();
	}

	/**
	 * get the url
	 * 
	 * @return url UniformResourceLocator
	 */
	@Override
	public UniformResourceLocator getUrl() {
		return url;
	}

	/**
	 * set the url
	 * 
	 * @param url UniformResourceLocator
	 */
	@Override
	public void setUrl(UniformResourceLocator url) {
		this.url = url;
	}

}
