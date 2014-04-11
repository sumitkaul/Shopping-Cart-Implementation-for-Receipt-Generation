
class Product {

	private static final Object Null = null;
	private String productName;
	private double productPrice;
	private int productQuantity;
	private String location;
	
	
	public Product(String productName,double productPrice, int productQuantity,String location)
	{
			this.productName=productName;
			this.productPrice=productPrice;
			this.productQuantity=productQuantity;
			this.location=location;
	}
	
	public String getproductName()
	{
		return this.productName;
	}
	
	public double getproductPrice()
	{
		return this.productPrice;
	}
	
	public int getproductQuantity()
	{
		return this.productQuantity;
	}
	
	public String getlocation()
	{
		return this.location;
	}
	@Override
	 public boolean equals(Object obj) {
		  
		  if(obj==Null)
		  {
			  return false;
		  }
		  

		  if(obj==this)
		  {
			  return true;
		  }
		  

		  if(obj instanceof Product)
		  {
			  Product p=(Product)(obj);			  
			  	if(productName.equals(p.productName)&& productPrice==p.productPrice && productQuantity==p.productQuantity &&location.equals(p.location) )
                     return true;
		  }
		
		  return false;
	  }
	
	@Override
	  public int hashCode() {
		 /* final int prime = 31;
		    int result = 1;
		    result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		    result = prime * result
		            + ((location == null) ? 0 : location.hashCode());
		    result+=productPrice;
		    result+=productQuantity;
		    return result;*/
		  return super.hashCode();
	    }
	
}
