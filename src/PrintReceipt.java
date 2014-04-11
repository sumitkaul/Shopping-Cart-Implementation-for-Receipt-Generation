import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;


public class PrintReceipt implements Receipt {

	List<Product> productList;
	double total;
	double subTotal;
	
	public PrintReceipt( List<Product> productList,double total,double subTotal)
	{
		this.productList=productList;
		this.total=total;
		this.subTotal=subTotal;
	}
	
	@Override
	public void display() {
		
		System.out.println("shopping cart detials");
		
		
		System.out.println("\n Item             price       quantity");
		
		for(Product product: productList){
				
			System.out.println("  "+ product.getproductName()   + "          "+ product.getproductPrice() + "           " + product.getproductQuantity());
		}
		System.out.println(" subtotal:"+"                     "+"$"+ (subTotal));
		System.out.println(" tax:"+"                           "+"$"+roundDouble(total-subTotal));
		
		System.out.println(" total:"+"                         "+"$"+roundDouble(total));
		
	}
	
	private double roundDouble(double a)
	{
		BigDecimal bd = new BigDecimal(a);
		bd = bd.round(new MathContext(3));
		
		return bd.doubleValue();
	}

}
