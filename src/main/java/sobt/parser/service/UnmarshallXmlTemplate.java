package sobt.parser.service;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class UnmarshallXmlTemplate<T> {
	public T ReturnObjectTemplate(String xml,T t){
		T result = null;
		try {
			StringReader sr = new StringReader(xml);
			JAXBContext context = JAXBContext.newInstance(t.getClass());
			Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();
			result = (T) jaxbUnmarshaller.unmarshal(sr);
			

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
}
