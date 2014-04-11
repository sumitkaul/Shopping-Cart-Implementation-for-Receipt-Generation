//this is the class which contain the main method and create the interface ref and class object 
import java.util.ArrayList;
import java.util.List;


public class ShoppingCartImplementation implements ShoppingCart {
	
	private List<Product> productList = new ArrayList<Product>();
	
	public ShoppingCartImplementation (List<Product> productList)
	{
		this.productList=productList;
	}
	
	
	//decoupling display with the business logic here 
	public Receipt getReceipt(ReceiptType type) {
		
		//Receipt r=new ReceiptImplementation(productList, getTotal(), subTotal());
		Receipt r=ReceiptFactory.create(type, productList, getTotal(), subTotal());
		return r;
		
	}

	@Override
	public void addProduct(Product product) {
		productList.add(product);	
	}

	//routine for calculating the total of the items added in the cart.
	@Override
	public double getTotal() {
		double totalPrice =0.0;
		for(Product product:productList)
		{
			totalPrice+=product.getproductPrice()*product.getproductQuantity();
			Configuration config = Configuration.getInstance();
			if(!config.isExempt(product, product.getlocation()))
			{
				//add tax
				double tax = config.getTax(product.getlocation());
				double productTax = tax *product.getproductPrice()*product.getproductQuantity();
				totalPrice+=productTax;
			}
		}		
		
		return totalPrice;
	}

	//routibe for calculating the subtotal
	@Override
	public double  subTotal() {
		double subTotalPrice =0.0;
		for(Product product:productList)
		{
			subTotalPrice+=product.getproductPrice()*product.getproductQuantity();
		}		
		return subTotalPrice;
		
	}

	//remove product one by one
	@Override
	public void removeProduct(Product product) {	
		
		productList.remove(product);	
		
	}

    //remove all the product which in terms will empty the cart in one go 
	@Override
	public void removeAllProducts() {
		productList.clear();
		
	}
	
	
	public static void main(String[] args){
		
		List<Product> productList=new ArrayList<Product>();
			
		Product p1=new Product("Book",12.99,1,"NJ");
		Product p2=new Product("music cd",9.99,3,"NJ");
		productList.add(p1);
		productList.add(p2);
		
		//interface ref and class object
		ShoppingCart sci=new ShoppingCartImplementation(productList);
		//this is from the receipt factory which is mainly extensible to the Web and pdf as well
		Receipt r=sci.getReceipt(ReceiptType.Print);   
		r.display();
		
	}
	

}
