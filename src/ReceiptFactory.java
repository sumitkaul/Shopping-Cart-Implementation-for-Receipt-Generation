

import java.util.List;


public class ReceiptFactory {
	
	static public PrintReceipt create(ReceiptType type,List<Product> productList, double total, double subTotal){
		
		if(type==ReceiptType.Print)
		{	
			return new PrintReceipt(productList, total, subTotal);
		}
		
		return null;
		
    //currently we have just one format for printing which can be extended in the future in terms of web and pdf.
		
	}

}
