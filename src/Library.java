
import java.util.ArrayList;

public class Library {

	private ArrayList<DVD> dvds;
	
    public Library(){
    	dvds = new ArrayList<DVD>();
    }
	
	public void add(DVD dvd){
		dvds.add(dvd);
	}

	public ArrayList<DVD> getDVDs(){
		return dvds;
	}

	public String listDVDs(){
		if (dvds.size() == 0){
		  return "No DVDs.";
		}
		else
		{
			String listDVDs = "";
			for (int i = 0; i < dvds.size(); i++){
				listDVDs = listDVDs + (i + ":" + dvds.get(i)) + "\n";
			}
			return listDVDs;
		}	
	}
    
	public void load() throws Exception{
    	dvds= HandleXML.read("dvds.xml");
    }
    
    public void save() throws Exception{
    	HandleXML.write(dvds, "dvds.xml");
    }
    
}

