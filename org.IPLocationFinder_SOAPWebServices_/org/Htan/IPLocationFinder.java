package org.Htan;
import src.org.IPAddressSourceFiles.GeoIP;
import src.org.IPAddressSourceFiles.GeoIPService;
import src.org.IPAddressSourceFiles.GeoIPServiceSoap;
public class IPLocationFinder 
{
	public static void main(String[] args)
	{
		if(args.length != 1){
			System.out.println("Enter one ipaddress");
		}
		else {
			String ipAddress = args[0];

			GeoIPService ipService = new GeoIPService();
			GeoIPServiceSoap ipServiceSoap = ipService.getGeoIPServiceSoap();
			GeoIP geoIP = ipServiceSoap.getGeoIP(ipAddress);
			System.out.println(geoIP.getCountryName());
			//stub.getCountryname(IPaddress);

		}

	}
}

// C:\Program Files\Java\jdk1.8.0_31\bin >wsimport -d http://localhost:9999/IPLocationFinder_SOAPWebServices_?wsdl
//wsimport -d generated http://localhost:9999/IPLocationFinder_SOAPWebServices_?wsdl
//Create dir SEI at command prompt under C:\Users\htan\EclipseIdeWorkspace\org.IPLocationFinder_SOAPWebServices_
//
//C:\Users\htan\EclipseWorkspace\IPLocationFinder_SOAPWebServices_ > mkdir sei
//C:\Users\htan\EclipseWorkspace\IPLocationFinder_SOAPWebServices_\sei > wsimport WSDL_URI
//WSDL_URI is http://www.webservicex.net/geoipservice.asmx?WSDL at WSDL Schema Location

//net  folder has classes list of content //sei> ls 

//create src folder under sei folder add source classes //sei > wsimport -keep -s src WSDL_URI

//Get service name and port name from WSDL 
//<wsdl:service name="GeoIPService">
//wsdl:port name="GeoIPServiceSoap"


//<wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
//GeoIPService - GetGeoIP enables you to easily look up countries by IP addresses

//C:/> ping yahoo.com
//206.190.36.45

