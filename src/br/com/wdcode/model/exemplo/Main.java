package br.com.wdcode.model.exemplo;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {

		// List<Pessoa> lista = new ArrayList<>();
		// Pessoa p1 = new Pessoa();
		// p1.setNome("Fernando");
		// p1.setEmail("fernando@fernando.com");
		// p1.setIdade(19);
		// p1.setProfissao("Pedreiro");
		//
		// Pessoa p2 = new Pessoa();
		// p2.setNome("Maria");
		// p2.setEmail("maria@maria.com");
		// p2.setIdade(29);
		// p2.setProfissao("Aeromosa");
		//
		// Pessoa p3 = new Pessoa();
		// p3.setNome("Bruna");
		// p3.setEmail("bruna@bruna.com");
		// p3.setIdade(33);
		// p3.setProfissao("Estagiaria");
		//
		// lista.add(p1);
		// lista.add(p2);
		// lista.add(p3);
		//
		// PessoaRepository repository = new PessoaRepository();
		// repository.setPessoas(lista);
		//
		// String xml = JAXUtil.toXML(repository);
		//
		// System.out.println(xml);

//		Pessoa p1 = new Pessoa();
//		p1.setNome("Fernando");
//		p1.setEmail("fernando@fernando.com");
//		p1.setIdade(19);
//		p1.setProfissao("Pedreiro");
//
//		StringWriter stringWriter = new StringWriter();
//		
//		JAXBContext context = JAXBContext.newInstance(Pessoa.class);
//		Marshaller marshaller = context.createMarshaller();
//		
//		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//		marshaller.marshal(p1, stringWriter);
//		String xml = stringWriter.toString();
//		
//		System.out.println(xml);
		
//		JAXBContext context = JAXBContext.newInstance(Pessoa.class);
//		Unmarshaller unmarshaller = context.createUnmarshaller();
//		Pessoa p = (Pessoa) unmarshaller.unmarshal(new FileInputStream("pessoa.xml"));
//		System.out.println(p);
		Path path = Paths.get("pessoa_nova.xml");
		
		List<String> lines = Files.readAllLines(Paths.get("pessoa.xml"));
		
		try(BufferedWriter writer = Files.newBufferedWriter(path)){
			for(String line : lines) {
				writer.write(line);
				writer.newLine();
			}
		}
		
		

	}

}
