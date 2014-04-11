//interface which is implemented by ShoppingCartImplementation 
public interface ShoppingCart {
	
	
	public Receipt getReceipt(ReceiptType type);
	public void addProduct(Product product); 	
	public double getTotal();	
	public double subTotal();
	public void removeProduct(Product product);
	public void removeAllProducts();
}
