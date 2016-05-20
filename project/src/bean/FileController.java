package bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class FileController<T> {

	String filePath;
	Class<T> type;

	public FileController(String path, Class<T> type) {
		this.filePath = path;
		this.type = type;
	}

	public T load() {
		T obj = null;
		JAXBContext jc;
		try {
			jc = JAXBContext.newInstance(type);
			Unmarshaller u = jc.createUnmarshaller();
			FileInputStream fin = new FileInputStream(filePath);
			obj = (T) u.unmarshal(fin);
			fin.close();
			return obj;
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public void save(T obj) {
		JAXBContext jc;
		try {
			jc = JAXBContext.newInstance(type);
			Marshaller m = jc.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(obj, new File(filePath));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
