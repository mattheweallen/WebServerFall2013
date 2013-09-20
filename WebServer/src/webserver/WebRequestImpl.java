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

	private Map<String, String> headerMap = new HashMap<String,String>();
	
	/** 
	 * set the method for the request message request line.
	 * 
	 * @param method 
	 */
	@Override
	public void setMethod(String method) {
		// TODO Auto-generated method stub

	}

	/**
	 * set the path for the resource indicated in the request message request line.
	 * 
	 * @param path
	 */
	@Override
	public void setPath(String path) {
		// TODO Auto-generated method stub

	}

	/**
	 * set the version for http spec indicated in the request message request line.
	 * 
	 * @param version String
	 */
	@Override
	public void setVersion(String version) {
		// TODO Auto-generated method stub

	}

	/**
	 * get the method for the request message request line.
	 * 
	 * @return method String
	 */
	@Override
	public String getMethod() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * get the path for the resource indicated in the request message request line.
	 * 
	 * @return path String
	 */
	@Override
	public String getPath() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * get the version for http spec indicated in the request message request line.
	 * 
	 * @return version String
	 */
	@Override
	public String getVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * This method puts a header field, which is a name value pair into headerMap.
	 * headerMap will be used in getHeader to generate name value pairs separated by colon, 
	 * and terminated with carriage return and line feed.  
	 * 
	 * @param name String
	 * @param value String
	 */
	@Override
	public void addHeader(String name, String value) {
		headerMap.put(name, value);
	}

	/**
	 * get the header, which will consist of the name value pair request headers from headerMap.
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
	 * 
	 * @return headerNames Set<String>
	 */
	@Override
	public Set<String> getHeaderNames() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * @return url UniformResourceLocator
	 */
	@Override
	public UniformResourceLocator getUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * @param url UniformResourceLocator
	 */
	@Override
	public void setUrl(UniformResourceLocator url) {
		// TODO Auto-generated method stub
		
	}

}
