import java.util.Scanner;

public class Driver 
{
	private Scanner input;
	Library library;


	public Driver(){
		input = new Scanner(System.in);
		library = new Library ();
	}


	public static void main(String args[]){
		Driver app = new Driver();
		app.run();
	}

	private int mainMenu(){
		System.out.println("My DVD Library");
		System.out.println("  1) Add a DVD");
		System.out.println("  2) List all DVDs");
		System.out.println("  3) Update a DVD");
		System.out.println("  4) Delete a DVD");
        System.out.println(" ---------");
        System.out.println("  5) Save Products to dvd.xml");
        System.out.println("  6) Load Products from dvd.xml");
        System.out.println("---------");
		System.out.println("  0) Exit");
		System.out.print("==>>");
		int option = input.nextInt();
		return option;
	}
	
	private void run(){
		int option = mainMenu();
		while (option != 0)
		{
			switch (option)
			{
			case 1:
				addDVD();
				break;
			case 2:
				System.out.println(library.listDVDs());
				break;
			case 3:
				updateDVD();
				break;
			case 4:
				deleteDVD();
				break;
			case 5: 
				try{
  	   			library.save();
                 }
     			  catch (Exception e){
     				  System.out.println("Error writing to file: " + e);
     			  }
     			  break;
			case 6:
				try{
  	   			library.load();
                 }
     			  catch (Exception e){
     				  System.out.println("Error reading to file: " + e);
     			  }
     			  break;
			default:
				System.out.println("Invalid option selected.");
				break;
			}

			System.out.println("");
			option = mainMenu();
		}
		System.out.println("Exiting... bye");
	}

	private void addDVD(){
		System.out.print("DVD title: ");
		String dvdTitle = input.nextLine();
		dvdTitle = input.nextLine();
		library.add(new DVD(dvdTitle));
	}

    public void updateDVD(){
		System.out.println(library.listDVDs());

		if (library.getDVDs().size() != 0){	
			System.out.print("Index of dvd to edit ==>");
			int index = input.nextInt();

			if (index < library.getDVDs().size()){	
				System.out.print("   Enter a new dvd title: ");
				String desc = input.nextLine();
				desc = input.nextLine();

				DVD dvd = library.getDVDs().get(index);
				dvd.setTitle(desc);
			}
			else
			{
				System.out.println("There is no DVD for this index number");
			}
		}
	} 

	public void deleteDVD()
	{
		System.out.println(library.listDVDs());

		if (library.getDVDs().size() != 0){	
			System.out.print("Index of DVD to delete ==>");
			int index = input.nextInt();

			if (index < library.getDVDs().size()){	
				library.getDVDs().remove(index);
				System.out.println("DVD deleted.");
			}
			else{
				System.out.println("There is no DVD for this index number");
			}
		}
	} 	
}
