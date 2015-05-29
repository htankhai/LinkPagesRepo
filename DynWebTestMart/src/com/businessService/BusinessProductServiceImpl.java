package org.businessService;
//Business Service logic//Service implementation
import java.util.ArrayList;
import java.util.List;
import org.model.Product;

public class BusinessProductServiceImpl 
{
	List<String> bookList = new ArrayList<>();
	List<String> dvdList =  new ArrayList<>();
	List<String> musicCd = new ArrayList<>();

	public BusinessProductServiceImpl (){
		bookList.add("Kid Books...");
		bookList.add("School Books...");
		bookList.add("Tech Books...");

		dvdList.add("Action DVD...");
		dvdList.add("Drama DVD...");
		dvdList.add("Scifi Fantacy DVD...");

		musicCd.add("Pop...");
		musicCd.add("Rock...");
		musicCd.add("Country...");

	}

	public List<String> getProductGroups() {
		List<String> group = new ArrayList<>();
		group.add("Books");
		group.add("DVD");
		group.add("MusicCD");

		return group;

	}

	public List<String> getProducts(String group)
	{
		switch(group.toLowerCase()){
		case "books":
			return bookList;
		case "dvd":
			return dvdList;
		case "musicCd":
			return musicCd;
		}
		return null;
	}

	public boolean addProducts(String group, String product) {
		// TODO Auto-generated method stub
		return true;
	}

	public List<Product> getProducts2(String book_product) {
		List<Product> productList = new ArrayList<>();
		productList.add(new Product("Java Books", "xyz234", 999.99));
		productList.add(new Product("Tech books", "xuy2353",  989.99));
		return productList ;
	}

}
