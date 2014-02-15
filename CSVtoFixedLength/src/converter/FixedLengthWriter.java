package converter;

import java.io.File;
import java.util.List;

import org.beanio.BeanIOConfigurationException;
import org.beanio.BeanIOException;
import org.beanio.BeanWriter;
import org.beanio.BeanWriterException;
import org.beanio.BeanWriterIOException;
import org.beanio.StreamFactory;

public class FixedLengthWriter {

	public void writeOrderHeader(List<OrderHeaderBean> orderHdrList,
			String fileName) {

		BeanWriter out = null;
		try {
			StreamFactory factory = StreamFactory.newInstance();
			factory.load("OrderHeaderMapping.xml");
			out = factory.createWriter("orderHeader", new File(fileName));
			for (OrderHeaderBean orderHdr : orderHdrList) {
				out.write(orderHdr);
			}
		} catch (BeanWriterIOException e) {
			e.printStackTrace();
		} catch (BeanIOConfigurationException e) {
			e.printStackTrace();
		} catch (BeanWriterException e) {
			e.printStackTrace();
		} catch (BeanIOException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}
	}

	public void writeOrderDetails(List<OrderDetailsBean> orderDtlsList,
			String fileName) {

		BeanWriter out = null;
		try {
			StreamFactory factory = StreamFactory.newInstance();
			factory.load("OrderDetailsMapping.xml");
			out = factory.createWriter("orderDetails", new File(fileName));
			for (OrderDetailsBean orderDtls : orderDtlsList) {
				out.write(orderDtls);
			}
		} catch (BeanWriterIOException e) {
			e.printStackTrace();
		} catch (BeanIOConfigurationException e) {
			e.printStackTrace();
		} catch (BeanWriterException e) {
			e.printStackTrace();
		} catch (BeanIOException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}
	}
}