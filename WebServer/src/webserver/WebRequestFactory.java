/**
 * 
 */
package webserver;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * The purpose of WebRequestFactory is to create a WebRequest object based on data from a BufferedReader. 
 * 
 * @author Matthew Allen
 * @version September 23, 2013
 *
 */
public class WebRequestFactory {
	
	/**
	 * createRequest builds a WebRequest based on bufferedReader.
	 * 
	 * @param bufferedReader
	 * @return webRequest
	 * @throws IOException 
	 */
	public static WebRequest createRequest(BufferedReader bufferedReader) throws IOException {
		WebRequest webRequest = new WebRequestImpl();
		String sCurrentLine = bufferedReader.readLine();
		String[] requestLine = sCurrentLine.split(" ");

		webRequest.setMethod(requestLine[0].trim());
		webRequest.setPath(requestLine[1].trim());
		System.out.println(webRequest.getPath());
		webRequest.setVersion(requestLine[2].trim());
		
		while(!(sCurrentLine = bufferedReader.readLine()).equals("")) {
			String[] requestHeader = sCurrentLine.split(":");
			webRequest.addHeader(requestHeader[0].trim(), requestHeader[1].trim());
		}
		
		String[] pathArr = webRequest.getPath().split("?");
		UniformResourceLocator url = new UniformResourceLocatorImpl()
										.scheme("http")
										.host("localhost")
										.port(88)
										.path(pathArr[0]);
		
		
		String[] queryArr = pathArr[1].split("&");
		for(int i = 0; i < queryArr.length; i++) {
			url = url.queryParameter(queryArr[i].split("=")[0], queryArr[i].split("=")[1]);
		}
										
		
		return webRequest;
	}
}
