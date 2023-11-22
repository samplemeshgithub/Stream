package streamExampleAndMethods;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionData {

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}


public double getAmount() {
	return amount;
}


public void setAmount(double amount) {
	this.amount = amount;
}


public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public TransactionData(int id, double amount, String timestamp, String status) {
	
	this.id = id;
	this.amount = amount;
	this.timestamp = timestamp;
	this.status = status;
}

int id;
double amount;
String timestamp;
public String getTimestamp() {
	return timestamp;
}


public void setTimestamp(String timestamp) {
	this.timestamp = timestamp;
}

String status;

	
	
	public static void main(String[] args) {
		List<TransactionData> trnxdata = new ArrayList<TransactionData>();
		trnxdata.add(new TransactionData(1, 200,"2023-11-01T12:00:00","completed"));
		trnxdata.add(new TransactionData(2, 150,"2023-11-01T13:00:00","pending"));
		trnxdata.add(new TransactionData(3, 300,"2023-11-01T14:00:00","completed"));
		
		// Specify the amount threshold and status for the query
      

       
        List<TransactionData> filteredTransactions = trnxdata.stream()
                .filter(transaction ->
                        transaction.getAmount() > 150 && transaction.getStatus().equals("completed"))
                .collect(Collectors.toList());

        // Print the filtered transactions
        System.out.println("Transactions with amount greater than " + 150 +
                " and status '" + "completed" + "':");
        filteredTransactions.forEach(transaction ->
                System.out.println("ID: " + transaction.getId() +
                        ", Amount: $" + transaction.getAmount() 
                       ));
        
        System.out.println();
        
     // Use streams and lambda expressions to sort transactions in descending order based on the amount
        List<TransactionData> sortedTransactions = trnxdata.stream()
                .sorted(Comparator.comparingDouble(TransactionData::getAmount).reversed())
                .collect(Collectors.toList());

        // Print the sorted transactions
        System.out.println("Transactions sorted in descending order based on the amount:");
        sortedTransactions.forEach(transaction ->
                System.out.println("ID: " + transaction.getId() +
                        ", Amount: $" + transaction.getAmount() 
                       ));
        System.out.println();
        
     // Use streams and lambda expressions to calculate the total amount of all transactions
        double totalAmount = trnxdata.stream()
                .mapToDouble(TransactionData::getAmount)
                .sum();

        // Print the total amount
        System.out.println("Total amount of all transactions: " + totalAmount);
        
        
     // Use streams and lambda expressions to group transactions by their status and calculate the total amount for each group
        Map<String, Double> totalAmountByStatus = trnxdata.stream()
                .collect(Collectors.groupingBy(TransactionData::getStatus, Collectors.summingDouble(TransactionData::getAmount)));

        // Print the total amount for each group
        System.out.println();
        System.out.println("Total amount for each status group:");
        totalAmountByStatus.forEach((status, totalAmounts) ->
                System.out.println("Status: " + status + ", Total Amount: " + totalAmounts));
	}

}
