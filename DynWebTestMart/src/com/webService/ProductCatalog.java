package org.webService;
//Web service with annotation Web service and Web method
//Customize WSDL

import org.businessService.BusinessProductServiceImpl;
import org.model.Product;
import org.webServiceInterface.ProductCatalogInterface;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(
		endpointInterface="org.webServiceInterface.ProductCatalogInterface", 
		portName = "TestProductCatalogPort",
		serviceName = "TestProductCatalogService") 
public class ProductCatalog implements ProductCatalogInterface 
{
	//Implementation class
	BusinessProductServiceImpl bService = new BusinessProductServiceImpl();

	/* (non-Javadoc)
	 * @see org.DynamicWebApplication.ProductCatalogInterface#getProductGroups()
	 */
	@Override
	public List<String> getProductGroups() {
		return bService.getProductGroups();
	}

	/* (non-Javadoc)
	 * @see org.DynamicWebApplication.ProductCatalogInterface#getProducts(java.lang.String)
	 */
	@Override
	public List<String> getProducts(String product){
		return bService.getProducts(product);
	}

	/* (non-Javadoc)
	 * @see org.DynamicWebApplication.ProductCatalogInterface#addProducts(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean addProducts( String group, String product){
		return bService.addProducts(group, product);
	}

	/* (non-Javadoc)
	 * @see org.DynamicWebApplication.ProductCatalogInterface#getProducts2(java.lang.String)
	 */
	@Override
	public List<Product> getProducts2( String product){
		return bService.getProducts2(product);
	}
}
