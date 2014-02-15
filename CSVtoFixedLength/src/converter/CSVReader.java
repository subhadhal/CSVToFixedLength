package converter;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseDate;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

public class CSVReader {

	public List<OrderHeaderBean> readOrderHeader(String file, String[] header)
			throws Exception {

		ICsvBeanReader beanReader = null;
		List<OrderHeaderBean> orderHdrList = new ArrayList<OrderHeaderBean>();
		try {
			beanReader = new CsvBeanReader(new FileReader(file),
					CsvPreference.STANDARD_PREFERENCE);
			final CellProcessor[] processors = getOrderHeaderProcessors();

			OrderHeaderBean orderHdr;
			while ((orderHdr = beanReader.read(OrderHeaderBean.class, header,
					processors)) != null) {
				orderHdrList.add(orderHdr);
			}
			return orderHdrList;
		} finally {
			if (beanReader != null) {
				beanReader.close();
			}
		}
	}

	public List<OrderDetailsBean> readOrderDetails(String file, String[] header)
			throws Exception {

		ICsvBeanReader beanReader = null;
		List<OrderDetailsBean> orderDtlsList = new ArrayList<OrderDetailsBean>();
		try {
			beanReader = new CsvBeanReader(new FileReader(file),
					CsvPreference.STANDARD_PREFERENCE);
			final CellProcessor[] processors = getOrderDetailsProcessors();

			OrderDetailsBean orderDtls;
			while ((orderDtls = beanReader.read(OrderDetailsBean.class, header,
					processors)) != null) {
				orderDtlsList.add(orderDtls);
			}
			return orderDtlsList;
		} finally {
			if (beanReader != null) {
				beanReader.close();
			}
		}
	}
	
	private static CellProcessor[] getOrderHeaderProcessors() {
		final CellProcessor[] processors = new CellProcessor[] {
				new NotNull(new ParseInt()), // invoice number
				new NotNull(), // salesman code
				new NotNull(), // customer number
				new ParseDate("dd/MM/yyyy"), // order date
				new NotNull(new ParseInt()), // order number
				new Optional(), // vehicle number
				new Optional(), // payment type
				new Optional(new ParseInt()), // discount 
				};
		return processors;
	}
	
	private static CellProcessor[] getOrderDetailsProcessors() {
		final CellProcessor[] processors = new CellProcessor[] {
				new NotNull(new ParseInt()), // invoice number
				new NotNull(), // product code
				new Optional(new ParseInt()), // sum of quantity cases
				new Optional(new ParseInt()), // sum of quantity packs
				new Optional(new ParseInt()), // sum of quantity pieces
				};
		return processors;
	}
}
