/**
 * 
 */
package webserver;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * The purpose of WebRequestHandler class is to generate a valid HTTP response.
 * 
 * @author Matthew Allen
 * @version September 23, 2013
 */
public class WebRequestHandler {
	private static final Set<String> htmlcssColorSet; 
	static {
		Set<String> aSet = new HashSet<String>();
		aSet.add("aliceblue");
		aSet.add("antiquewhite");
		aSet.add("aqua");
		aSet.add("aquamarine");
		aSet.add("azure");
		aSet.add("beige");
		aSet.add("bisque");
		aSet.add("black");
		aSet.add("blanchedalmond");
		aSet.add("blue");
		aSet.add("blueviolet");
		aSet.add("brown");
		aSet.add("burlywood");
		aSet.add("cadetblue");
		aSet.add("chartreuse");
		aSet.add("chocolate");
		aSet.add("coral");
		aSet.add("cornflowerblue");
		aSet.add("cornsilk");
		aSet.add("crimson");
		aSet.add("cyan");
		aSet.add("darkblue");
		aSet.add("darkcyan");
		aSet.add("darkgoldenrod");
		aSet.add("darkgray");
		aSet.add("darkgreen");
		aSet.add("darkkhaki");
		aSet.add("darkmagenta");
		aSet.add("darkolivegreen");
		aSet.add("darkorange");
		aSet.add("darkorchid");
		aSet.add("darkred");
		aSet.add("darksalmon");
		aSet.add("darkseagreen");
		aSet.add("darkslateblue");
		aSet.add("darkslategray");
		aSet.add("darkturquoise");
		aSet.add("darkviolet");
		aSet.add("deeppink");
		aSet.add("deepskyblue");
		aSet.add("dimgray");
		aSet.add("dodgerblue");
		aSet.add("firebrick");
		aSet.add("floralwhite");
		aSet.add("forestgreen");
		aSet.add("fuchsia");
		aSet.add("gainsboro");
		aSet.add("ghostwhite");
		aSet.add("gold");
		aSet.add("goldenrod");
		aSet.add("gray");
		aSet.add("green");
		aSet.add("greenyellow");
		aSet.add("honeydew");
		aSet.add("hotpink");
		aSet.add("indianred");
		aSet.add("indigo");
		aSet.add("ivory");
		aSet.add("khaki");
		aSet.add("lavender");
		aSet.add("lavenderblush");
		aSet.add("lawngreen");
		aSet.add("lemonchiffon");
		aSet.add("lightblue");
		aSet.add("lightcoral");
		aSet.add("lightcyan");
		aSet.add("lightgoldenrodyellow");
		aSet.add("lightgray");
		aSet.add("lightgreen");
		aSet.add("lightpink");
		aSet.add("lightsalmon");
		aSet.add("lightseagreen");
		aSet.add("lightskyblue");
		aSet.add("lightslategray");
		aSet.add("lightsteelblue");
		aSet.add("lightyellow");
		aSet.add("lime");
		aSet.add("limegreen");
		aSet.add("linen");
		aSet.add("magenta");
		aSet.add("maroon");
		aSet.add("mediumaquamarine");
		aSet.add("mediumblue");
		aSet.add("mediumorchid");
		aSet.add("mediumpurple");
		aSet.add("mediumseagreen");
		aSet.add("mediumslateblue");
		aSet.add("mediumspringgreen");
		aSet.add("mediumturquoise");
		aSet.add("mediumvioletred");
		aSet.add("midnightblue");
		aSet.add("mintcream");
		aSet.add("mistyrose");
		aSet.add("moccasin");
		aSet.add("navajowhite");
		aSet.add("navy");
		aSet.add("oldlace");
		aSet.add("olive");
		aSet.add("olivedrab");
		aSet.add("orange");
		aSet.add("orangered");
		aSet.add("orchid");
		aSet.add("palegoldenrod");
		aSet.add("palegreen");
		aSet.add("paleturquoise");
		aSet.add("palevioletred");
		aSet.add("papayawhip");
		aSet.add("peachpuff");
		aSet.add("peru");
		aSet.add("pink");
		aSet.add("plum");
		aSet.add("powderblue");
		aSet.add("purple");
		aSet.add("red");
		aSet.add("rosybrown");
		aSet.add("royalblue");
		aSet.add("saddlebrown");
		aSet.add("salmon");
		aSet.add("sandybrown");
		aSet.add("seagreen");
		aSet.add("seashell");
		aSet.add("sienna");
		aSet.add("silver");
		aSet.add("skyblue");
		aSet.add("slateblue");
		aSet.add("slategray");
		aSet.add("snow");
		aSet.add("springgreen");
		aSet.add("steelblue");
		aSet.add("tan");
		aSet.add("teal");
		aSet.add("thistle");
		aSet.add("tomato");
		aSet.add("turquoise");
		aSet.add("violet");
		aSet.add("wheat");
		aSet.add("white");
		aSet.add("whitesmoke");
		aSet.add("yellow");
		aSet.add("yellowgreen");
		htmlcssColorSet = Collections.unmodifiableSet(aSet);
	}
	
	/**
	 * The method handleRequest writes a valid HTTP response based on webRequest to dataOutputStream.
	 * The only valid method is GET. The HTTP response will consist of valid HTTP header and HTTP body.
	 * 
	 * @param webRequest
	 * @param dataOutputStream
	 * @throws IOException 
	 */
	public void handleRequest(WebRequest webRequest, DataOutputStream dataOutputStream) throws IOException {
		Integer x = 0;
		Integer y = 0;
		String color = "gray";
		boolean error = false;
		
		System.out.println("y = " + webRequest.getUrl().getQueryValue("y"));
		System.out.println("x = " + webRequest.getUrl().getQueryValue("x"));
		
		if(webRequest.getUrl().getQueryValue("x") != null) {
			if(isInteger(webRequest.getUrl().getQueryValue("x"))) {
				x = Integer.parseInt(webRequest.getUrl().getQueryValue("x"));
			} else {
				error = true;
			}
		}
		
		if(webRequest.getUrl().getQueryValue("y") != null) {
			if(isInteger(webRequest.getUrl().getQueryValue("y"))) {
				y = Integer.parseInt(webRequest.getUrl().getQueryValue("y"));
			} else {
				error = true;
			}
		}
		
		if(webRequest.getUrl().getQueryValue("color") != null) {
			if(isValidColor(webRequest.getUrl().getQueryValue("color"))) {
				color = webRequest.getUrl().getQueryValue("color").trim().toLowerCase();
			} else {
				error = true;
			}
		}
		
		if(!error) {
			Integer sum = 0;
			dataOutputStream.writeBytes(webRequest.getVersion().trim()  + " 200 OK" + "\n");
			dataOutputStream.writeBytes("Content-Type: text/html\n");
			dataOutputStream.writeBytes("\n");
			
			System.out.println("Path = " + webRequest.getUrl().getPath());
			
			if(webRequest.getUrl().getPath().equals("/math/add")) {
				sum = x + y;
			} else if (webRequest.getUrl().getPath().equals("/math/sub")) {
				sum = x - y;
			}
			
			
			
			dataOutputStream.writeBytes("<html><head><title>My Super Awesome Math Page</title>");
			dataOutputStream.writeBytes("<style>");
			dataOutputStream.writeBytes("table {background-color:" + color + "; text-align:left;} table, th, td { border: 1px solid black;} h1 {color:" + color + "; text-align:left;}");
			dataOutputStream.writeBytes("</style></head><body>");
			dataOutputStream.writeBytes("<table><tr><th>NAME</th><th>VALUE</th></tr>");   
			dataOutputStream.writeBytes("<tr>" + "<td>" + "method" + "</td>" +"<td>" + webRequest.getMethod() + "</td>" +"</tr>");
			dataOutputStream.writeBytes("<tr>" + "<td>" + "path" + "</td>" +"<td>" + webRequest.getPath() + "</td>" +"</tr>");
			dataOutputStream.writeBytes("<tr>" + "<td>" + "version" + "</td>" +"<td>" + webRequest.getVersion() + "</td>" +"</tr>");
			
			for(String s : webRequest.getHeaderNames()) {
				dataOutputStream.writeBytes("<tr>" + "<td>" + s + "</td>" +"<td>" + webRequest.getHeader(s) + "</td>" +"</tr>");
			}
			
			dataOutputStream.writeBytes("</table>");
			dataOutputStream.writeBytes("<h1>");
			dataOutputStream.writeBytes("VALUE = " + sum.toString());
			dataOutputStream.writeBytes("</h1>");
			
			dataOutputStream.writeBytes("</body></html>");
		}
	}
	
	public boolean isInteger( String input )  
	{  
	   try  
	   {  
	      Integer.parseInt( input );  
	      return true;  
	   }  
	   catch( Exception e)  
	   {  
	      return false;  
	   }  
	} 
	
	public boolean isValidColor(String input) {
		return htmlcssColorSet.contains(input.trim().toLowerCase());
	}
	
//	
//	* headerFields will be used in getHeader to generate name value pairs separated by colon, 
//	 * and terminated with carriage return and line feed. 
//			 
//			 * get the header, which will consist of the name value pair request headers from headerFields.
//			 * TODO update these comments this may be implemented else where this is just to return header value?
//			 * The name value pairs will be separated by a colon, and terminated with the carriage return and line feed \r\n where \r is carriage return \n is line feed.
//			 * The end of the header will be indicated by two consecutive carriage return line feed pairs.
}
