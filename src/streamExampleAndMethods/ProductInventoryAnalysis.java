package streamExampleAndMethods;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductInventoryAnalysis {

	public ProductInventoryAnalysis(int id, String name, String category, double price, int quantity) {
		
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
	}



	int id;
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
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



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	String name;
	String category;
	double price;
	int quantity;
	
	 public double getPriceToQuantityRatio() {
	        return price / quantity;
	    }
	
	public static void main(String[] args) {
		
		List<ProductInventoryAnalysis> productlist = new ArrayList<ProductInventoryAnalysis>();
		productlist.add(new ProductInventoryAnalysis(1,"Laptop","Electronics",1000,5));
		productlist.add(new ProductInventoryAnalysis(2,"Headphones","Electronics",150,10));
		productlist.add(new ProductInventoryAnalysis(3,"Desk","furniture",200,3));
		
		
		// Specify the category and quantity threshold 
      

        
        List<ProductInventoryAnalysis> filteredProductsbasedoncategoryandthreshold = productlist.stream()
                .filter(product -> product.getCategory().equals("Electronics") && product.getQuantity() < 10)
                .collect(Collectors.toList());

        // Print the filtered products
        System.out.println("Products in the category '" + "Electronics" + "' with quantity below " + 10 + ":");
        filteredProductsbasedoncategoryandthreshold.forEach(product ->
                System.out.println("ID: " + product.getId() +
                        ", Name: " + product.getName() +
                        ", Price: " + product.getPrice() +
                        ", Quantity: " + product.getQuantity()));
        
        
     // Use streams and lambda expressions to compute summary statistics for products in each category
        Map<String, DoubleSummaryStatistics> categoryPriceStatistics = productlist.stream()
                .collect(Collectors.groupingBy(
                		ProductInventoryAnalysis::getCategory,
                        Collectors.summarizingDouble(ProductInventoryAnalysis::getPrice)));

        Map<String, IntSummaryStatistics> categoryQuantityStatistics = productlist.stream()
                .collect(Collectors.groupingBy(
                		ProductInventoryAnalysis::getCategory,
                        Collectors.summarizingInt(ProductInventoryAnalysis::getQuantity)));
        
        System.out.println();

        
        System.out.println("Category-wise :");
        System.out.println();
        
        categoryPriceStatistics.forEach((category, priceStats) ->
                System.out.println("Category: " + category +
                        ", Average Price: " + priceStats.getAverage() +
                        ", Total Quantity: " + categoryQuantityStatistics.get(category).getSum()));
        
        
    
        // Use streams and lambda expressions to convert the list of products to a map
        Map<Integer, String> productMap = productlist.stream()
                .collect(Collectors.toMap(ProductInventoryAnalysis::getId, ProductInventoryAnalysis::getName));
   
        
        System.out.println("Product ID to Name Mapping:");
        productMap.forEach((id, name) ->
                System.out.println("ID: " + id + ", Name: " + name));
        
        
        // Use streams and lambda expressions to sort products based on the price-to-quantity ratio
        productlist.sort(Comparator.comparingDouble(ProductInventoryAnalysis::getPriceToQuantityRatio));

        // Print the sorted products
        System.out.println("Products sorted by Price-to-Quantity Ratio:");
        productlist.forEach(product ->
                System.out.println("ID: " + product.getId() +
                        ", Name: " + product.getName() +
                        ", Price-to-Quantity Ratio: " + product.getPriceToQuantityRatio()));
        
	}

}
