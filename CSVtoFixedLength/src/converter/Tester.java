package converter;

import java.util.List;

public class Tester {
	public static void main(String[] args) {
		CSVReader csvReader = new CSVReader();
		FixedLengthWriter fixedLengthWriter = new FixedLengthWriter();
		try {
			// Process order header files
			List<OrderHeaderBean> orderHdrList;
			String []header = {"invoiceNo","salesmanCode","customerNo","orderDate","orderNo","vehicleNo","paymentType","discount"};
			orderHdrList = csvReader.readOrderHeader("OrderHeader.csv", header);
			fixedLengthWriter.writeOrderHeader(orderHdrList, "OrderHeaderOutput.txt");
			
			// Process order details files
			List<OrderDetailsBean> orderDtlsList;
			String []ordDtlsHeader = {"invoiceNo","productCode","sumOfQtyCases","sumOfQtyPacks","sumOfQtyPieces"};
			orderDtlsList = csvReader.readOrderDetails("OrderDetails.csv", ordDtlsHeader);
			fixedLengthWriter.writeOrderDetails(orderDtlsList, "OrderDetailsOutput.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
