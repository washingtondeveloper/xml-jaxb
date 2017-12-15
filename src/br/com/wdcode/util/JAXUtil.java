package br.com.wdcode.util;

import java.io.IOException;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import br.com.wdcode.model.Pessoa;
import br.com.wdcode.model.repository.PessoaRepository;

public class JAXUtil {
	
	private static JAXUtil instance;
	
	private static JAXBContext context;
	
	public static JAXUtil getInstance() {
		return instance;
	}
	
	static {
		try {
			context = JAXBContext.newInstance(PessoaRepository.class, Pessoa.class);
		}catch (JAXBException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String toXML(Object object) throws IOException {
		try {
			StringWriter writer = new StringWriter();
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(object, writer);
			String xml = writer.toString();
			return xml;
		}catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}
}
