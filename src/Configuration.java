import java.util.HashMap;
import java.util.Map;

//This Config info should be in config file like XML but for the time being we are keeping it in this Class
public class Configuration {
	
	HashMap<String,String> productCategoryMap=new HashMap<String,String>();
	private static Configuration config =null;
	
	private Configuration(){
		
		productCategoryMap.put("Book", "Eduction");
		productCategoryMap.put("chips", "Food");
		productCategoryMap.put("music cd", "Electronics");
		productCategoryMap.put("sweater", "Clothing");
		
	}
	
	static Configuration getInstance()
	{
		if(config == null)
		{
			config = new Configuration();
		}	
	  return config;
	}
	
	public double getTax(String location) {
		double taxRate=0;
		
		if(location.equals("CA"))
		{
			 taxRate=0.0975;
		}
		
		else if(location.equals("NJ"))
		{
			 taxRate=0.07;
			
		}
		return taxRate;
		
	}
	
	public String getProductCategory(Product product){
		
		
		for (Map.Entry<String, String> entry : productCategoryMap.entrySet())
		{
			if(entry.getKey().equals(product.getproductName()))
				return productCategoryMap.get(product.getproductName());				
				
		}
		
		return "default";
		
		
	}	
	
	public boolean isExempt(Product product,String location){
	
		 String productCategory= getProductCategory(product);

			if(location.equals("CA"))
			{
				if (productCategory.equals("Food"))
				{
					return true;
				}
			}
			
			else if(location.equals("NJ"))
			{
				if (productCategory.equals("Food")|| productCategory.equals("Clothing"))
				{
					return true;
				}
				
			}
			return false;
		 
	}
	

}
