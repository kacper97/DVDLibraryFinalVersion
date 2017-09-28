import java.beans.XMLEncoder;
import java.beans.XMLDecoder;
import java.io.*;
import java.util.ArrayList;

public class HandleXML {

	public static void write(ArrayList<DVD> dvds, String filename) throws Exception{
		XMLEncoder encoder = 
				new XMLEncoder(
						new BufferedOutputStream(
							new FileOutputStream(filename)));
		encoder.writeObject(dvds);
		encoder.close();						
	}
	
	public static ArrayList<DVD> read(String filename) throws Exception{
		XMLDecoder decoder =
				new XMLDecoder(new BufferedInputStream(
						new FileInputStream(filename)));
		ArrayList<DVD> products = (ArrayList<DVD>) decoder.readObject();
		decoder.close();
		return products;
	}
}
