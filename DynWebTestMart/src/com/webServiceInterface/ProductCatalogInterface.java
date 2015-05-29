package org.webServiceInterface;
//Interface
import org.model.Product;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(name = "TestProductCatalog",  
			targetNamespace = "http://www.WebService.com")

public interface ProductCatalogInterface {
	@WebMethod(action = "fetch_groups", operationName= "FetchGroups")
	public abstract List<String> getProductGroups();

	@WebMethod
	public abstract List<String> getProducts(String product);

	@WebMethod
	public abstract boolean addProducts(String group, String product);

	@WebMethod
	@WebResult(name="Product")
	public abstract List<Product> getProducts2(String product);

}
//port type
//port name
//service
//target name space