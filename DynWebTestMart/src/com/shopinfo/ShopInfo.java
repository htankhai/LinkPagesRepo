package org.shopinfo;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.WebResult;
import javax.jws.WebParam;
import javax.jws.soap.SOAPBinding;

@WebService
//@SOAPBinding(style= Style.RPC)
public class ShopInfo {
	@WebMethod
	@WebResult(partName = "LookupOutput")
	public String getShopInfo(@WebParam (partName= "LookupInput") String property){
		String response = "Invalid property";
		if("shopName".equals(property)){
			response ="Test Mart";
		}
		else if ("since".equals(property))
		{
			response="since 2013";

		}
		return response;
	}
}

//Get wsdl
/*<types>
<xsd:schema>
<xsd:import namespace="http://Shopinfo.org/" schemaLocation="http://hkkhai:8080/TestMarket_WebApplication/ShopInfoService?xsd=1"/>
</xsd:schema>
</types>
*/

//Launch on the browser, http://hkkhai:8080/TestMarket_WebApplication/ShopInfoService?xsd=1
/*<xs:schema xmlns:tns="http://Shopinfo.org/" xmlns:xs="http://www.w3.org/2001/XMLSchema" version="1.0" targetNamespace="http://Shopinfo.org/">
<xs:element name="getShopInfo" type="tns:getShopInfo"/>
<xs:element name="getShopInfoResponse" type="tns:getShopInfoResponse"/>
<xs:complexType name="getShopInfo">
<xs:sequence>
<xs:element name="arg0" type="xs:string" minOccurs="0"/>
</xs:sequence>
</xs:complexType>
<xs:complexType name="getShopInfoResponse">
<xs:sequence>
<xs:element name="return" type="xs:string" minOccurs="0"/>
</xs:sequence>
</xs:complexType>
</xs:schema>
*/
