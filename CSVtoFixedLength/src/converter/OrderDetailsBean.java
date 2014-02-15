package converter;

public class OrderDetailsBean {
	private int invoiceNo;
	private String productCode;
	private int sumOfQtyCases;
	private int sumOfQtyPacks;
	private int sumOfQtyPieces;
	public int getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(int invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public int getSumOfQtyCases() {
		return sumOfQtyCases;
	}
	public void setSumOfQtyCases(int sumOfQtyCases) {
		this.sumOfQtyCases = sumOfQtyCases;
	}
	public int getSumOfQtyPacks() {
		return sumOfQtyPacks;
	}
	public void setSumOfQtyPacks(int sumOfQtyPacks) {
		this.sumOfQtyPacks = sumOfQtyPacks;
	}
	public int getSumOfQtyPieces() {
		return sumOfQtyPieces;
	}
	public void setSumOfQtyPieces(int sumOfQtyPieces) {
		this.sumOfQtyPieces = sumOfQtyPieces;
	}
	
	
}
