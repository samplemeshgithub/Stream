package streamExampleAndMethods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductInventoryManagement {

	
	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
 
	
	public ProductInventoryManagement(int productID, String name, String category, double price,int quantity) {
		
		this.productID = productID;
		this.name = name;
		this.category = category;
		this.price = price;
		this.quantity=quantity;
		this.stockbelowthreshold=stockbelowthreshold;
	}
	
	int productID;
	String name;
	String category;
	double price;	
	int quantity;
	boolean stockbelowthreshold;
	
	public boolean isStockbelowthreshold() {
		return stockbelowthreshold;
	}

	public void setStockbelowthreshold(boolean stockbelowthreshold) {
		this.stockbelowthreshold = stockbelowthreshold;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public static void main(String[] args) {
		List<ProductInventoryManagement> productlist= new ArrayList<ProductInventoryManagement>();
		productlist.add(new ProductInventoryManagement(001, "Laptop", "Electronics", 1200,10));
		productlist.add(new ProductInventoryManagement(002, "shirt", "Apparel", 40,4));
		productlist.add(new ProductInventoryManagement(003, "Headphones", "Electronics", 100,15));
		productlist.add(new ProductInventoryManagement(004, "jeans", "Apparel", 60,5));
		
		 // Use a map for easy categorization and retrieval
        Map<String, List<ProductInventoryManagement>> categoryMap = new HashMap<>();

        // Categorize products based on their category
        for (ProductInventoryManagement product : productlist) {
            categoryMap.computeIfAbsent(product.getCategory(), k -> new ArrayList<>())
                    .add(product);
            
            if (product.getQuantity() < 5) {
            	product = new ProductInventoryManagement(
                        product.getProductID(),
                        product.getName(),
                        product.getCategory(),
                        product.getPrice(),
                        product.getQuantity()
                        
                );
        
            }
        }

        // Print the category-wise product listing
        System.out.println("Category-wise Product Listing:");
        categoryMap.forEach((category, products) -> {
            System.out.println("Category: " + category);
            products.forEach(product ->
                    System.out.println("ID: " + product.getProductID() +
                            ", Name: " + product.getName() +
                            ", Price: " + product.getPrice() +
                            ", Quantity: " + product.getQuantity()));
            System.out.println();
        });
		
       
        // Print the inventory status
        System.out.println("Inventory Status:");
        categoryMap.forEach((category, products) -> {
            System.out.println("Category: " + category);
            products.forEach(product ->
                    System.out.println("ID: " + product.productID +
                            ", Name: " + product.getName() +
                            ", Price: " + product.getPrice() +
                            ", Quantity: " + product.getQuantity()));
                           
            System.out.println();
        });
        
        
            
        // Create a map for fast updates (Key: Product ID, Value: Product)
        Map<Integer, ProductInventoryManagement> productMap = new HashMap<>();

        // Populate the map with initial product details
        productMap.put(1, new ProductInventoryManagement( 001, "Laptop", "Electronics", 1200,10));
        productMap.put(2, new ProductInventoryManagement(002, "shirt", "Apparel", 40,4));
        productMap.put(3, new ProductInventoryManagement(003, "Headphones", "Electronics", 100,15));
        productMap.put(4, new ProductInventoryManagement(004, "jeans", "Apparel", 60,5));
        
     // Print the products before the update
        System.out.println("Products before the update:");
        productMap.values().forEach(product ->
                System.out.println("ID: " + product.getProductID() +
                        ", Name: " + product.getName() +
                        ", Price: " + product.getPrice() +
                        ", Quantity: " + product.getQuantity()));
        
        // Update the price of Product 3
        if (productMap.containsKey(3)) {
        	ProductInventoryManagement productToUpdate = productMap.get(3);
            productToUpdate.setPrice(110.0);
            productMap.put(3, productToUpdate);
        }
        
     
        
        System.out.println("\nProducts after the update:");
        productMap.values().forEach(product ->
                System.out.println("ID: " + product.getProductID() +
                        ", Name: " + product.getName() +
                        ", Price: " + product.getPrice() +
                        ", Quantity: " + product.getQuantity()));
    
	}
	
}


    
   
	
       

