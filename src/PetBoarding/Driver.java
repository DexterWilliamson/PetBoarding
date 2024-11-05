package PetBoarding;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();
    Scanner scnr = new Scanner(System.in);
    
    // Instance variables (if needed)

    public static void main(String[] args) {
    	Scanner scnr = new Scanner(System.in);
    	
        initializeDogList();
        initializeMonkeyList();
        String input = "" ;
        //do while loop acts as the runtime machine.
        //inputing q will end the program
        do { 
        	displayMenu();
        	try {
        		input = inputCheck(scnr, input, false);
        		switch(input) {
        		case ("1"):
        			intakeNewDog(scnr);
        			break;
        		
 
	    		case ("2"):
	    			intakeNewMonkey(scnr);
	    			break;
	    		
    		
				case ("3"):
					reserveAnimal(scnr);
					break;
		
		
				case ("4"):
					printAnimals("dog");
					break;
				
	
				case ("5"):
					printAnimals("monkey");
					break;
					
				case ("6"):
					printAnimals("available");
					break;
        		
        		default:
        			System.out.println("Please enter a valid key!");
        		}
        		}
        	catch(InputMismatchException excpt) {
        		System.out.println(excpt);
        	}
        	catch(Exception excpt) {
        		System.out.println(excpt.getMessage());
        		
        	}
        		
        		
        }while(input != "q");

    }

    
    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }


    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "in service", false, "United States");
        Dog dog4 = new Dog("TRex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
        dogList.add(dog4);
    }


    // Adds monkeys to a list for testing
    //Optional for testing
    public static void initializeMonkeyList() {
    	 Monkey monkey1 = new Monkey("Rex", "male", "3", "35.2",  "02-03-2020",
    			 "United States", "in service", false, "United States",
         		"12", "45.2", "23", "Gorilla");
    	 
    	 Monkey monkey2 = new Monkey("TRex", "male", "3", "35.2",  "02-03-2020",
    			 "Mexico", "in service", true, "Japan",
          		"12", "45.2", "23", "Gorilla");
    	 
    	 Monkey monkey3 = new Monkey("BRex", "male", "3", "35.2",  "02-03-2020",
    			 "United Kingdom", "in service", false, "EU",
          		"12", "45.2", "23", "Gorilla");
    	 
    	 Monkey monkey4 = new Monkey("FRex", "male", "3", "35.2",  "02-03-2020",
    			 "France", "in service", true, "France",
          		"12", "45.2", "23", "Gorilla");

         monkeyList.add(monkey1);
         monkeyList.add(monkey2);
         monkeyList.add(monkey3);
         monkeyList.add(monkey4);
    }
    
    // Added in this extra method so I could check userInput for q
    // Attempting to keep all the extra validation in one place
    // including making sure user input isn't blank.
    public static String inputCheck(Scanner scanner, String var, boolean boolStringCheck) throws Exception{
    	do {
    		var = scanner.nextLine();
    		// check if user wishes to cancel the entry.
    		// this returns the user to the main menu.
    		if ("q".equalsIgnoreCase(var)) {
    			
    			throw new Exception("Exiting");
    		}
    		// Tell user they didn't enter anything.
    		if ("".equalsIgnoreCase(var)) {
    			System.out.println("Input was blank.\nTry agian.");
    		}
    		// if boolStringCheck is true then see if
    		// var input is a valid boolean indicator
    		// return a string that can be converted to boolean later.
	    	if (boolStringCheck) {

	    		if ("f".equalsIgnoreCase(var)|| "false".equalsIgnoreCase(var)){
		    		     
			        var = "false";
			      
		        	}
	    		else if ("t".equalsIgnoreCase(var)|| "true".equalsIgnoreCase(var)){
		        	
		        	var = "true";
		
		        	}
	    		else {
	    			// if input wasn't recognized, then var is back to ""
	    			var = "";
	    		}
		    		
		    }
		    	
    	}while ("".equalsIgnoreCase(var));
    	return var;
    }
    // Complete the intakeNewDog method
    // The input validation to check that the dog is not already in the list
    // is done for you
    
    public static void intakeNewDog(Scanner scanner) {
    	// start with some default values for
    	// inputCheck to reference in it's do while loop
    	String name = "";
    	String breed= "";
    	String gender= "";
    	String age= "";
    	String weight= "";
    	String acquisitionDate= "";
    	String acquisitionCountry= "";
    	String trainingStatus= "";
    	String temp= "";
    	String inServiceCountry = "";
        boolean reserved = false;
        // using a try catch block to receive exceptions
        // from inputCheck
	    try {
	        System.out.println("What is the dog's name?");
			name = inputCheck(scanner, name, false);
			
			for(Dog dog: dogList) {
		       if(dog.getName().equalsIgnoreCase(name)) {
		            name = "";
		            throw new Exception("\n\nThis dog is already in our system\n\n");
		            }  
		       }
			
			System.out.println("What is the dog's breed?");
	        breed = inputCheck(scanner, breed, false);
	        System.out.println("What is the dog's gender?");
	        gender = inputCheck(scanner, gender, false);
	        System.out.println("What is the dog's age?");
	        age = inputCheck(scanner, age, false);
	        System.out.println("What is the dog's weight?");
	        weight = inputCheck(scanner, weight, false);
	        System.out.println("What is the dog's acquisition date?");
	        acquisitionDate = inputCheck(scanner, acquisitionDate, false);
	        System.out.println("What is the dog's acquisition country?");
	        acquisitionCountry = inputCheck(scanner, acquisitionCountry, false);
	        System.out.println("What is the dog's training status?");
	        trainingStatus = inputCheck(scanner, trainingStatus, false);
	        System.out.println("Is the dog reserved(f / t)?");
	        
	        temp = inputCheck(scanner, temp, true);
	        reserved = Boolean.valueOf(temp);
	        
	        System.out.println("What is the dog's in service country");
	        inServiceCountry = inputCheck(scanner, inServiceCountry, false);
	        
	        Dog newDog = new Dog(name, breed, gender, age, weight, acquisitionDate,
	        		acquisitionCountry, trainingStatus, reserved, inServiceCountry);
	        
	        dogList.add(newDog);
        
				
		} catch (Exception excpt) {
					
			System.out.println(excpt.getMessage());
				
		}
	        
   }

        // Add the code to instantiate a new dog and add it to the appropriate list
    


        // Complete intakeNewMonkey
	//Instantiate and add the new monkey to the appropriate list
        // For the project submission you must also  validate the input
	// to make sure the monkey doesn't already exist and the species type is allowed
    public static void intakeNewMonkey(Scanner scanner) {
    	//same as intakeNewDog except for a few variables
    	
	    	String name = "";
	    	String species= "";
	    	String gender= "";
	    	String age= "";
	    	String weight= "";
	    	String acquisitionDate= "";
	    	String acquisitionCountry= "";
	    	String trainingStatus= "";
	    	String temp= "";
	    	String inServiceCountry = "";
            String tailLength = "";
            String height = "";
            String bodyLength = "";
            
             
	        boolean reserved = false;
	        
	        try {
		        System.out.println("What is the monkey's name?");
				name = inputCheck(scanner, name, false);
				
				for(Monkey monkey: monkeyList) {
			       if(monkey.getName().equalsIgnoreCase(name)) {
			            name = "";
			            throw new Exception("\n\nThis monkey is already in our system\n\n");
			            }  
			       }
				System.out.println("What is the monkey's species?");
				species = inputCheck(scanner, species, false);
		        System.out.println("What is the monkey's gender?");
		        gender = inputCheck(scanner, gender, false);
		        System.out.println("What is the monkey's age?");
		        age = inputCheck(scanner, age, false);
		        System.out.println("What is the monkey's weight?");
		        weight = inputCheck(scanner, weight, false);
		        System.out.println("What is the monkey's acquisition date?");
		        acquisitionDate = inputCheck(scanner, acquisitionDate, false);
		        System.out.println("What is the monkey's acquisition country?");
		        acquisitionCountry = inputCheck(scanner, acquisitionCountry, false);
		        System.out.println("What is the monkey's training status?");
		        trainingStatus = inputCheck(scanner, trainingStatus, false);
		        System.out.println("Is the monkey reserved(f / t)?");
		        
		        temp = inputCheck(scanner, temp, true);
		        reserved = Boolean.valueOf(temp);
		        
		        System.out.println("What is the monkey's in service country");
		        inServiceCountry = inputCheck(scanner, inServiceCountry, false);
		        System.out.println("What is the monkey's tail length?");
	            tailLength = inputCheck(scanner, tailLength, false);
	            System.out.println("What is the monkey's height?");
	            height = inputCheck(scanner, height, false);
	            System.out.println("What is the monkey's body length?");
	            bodyLength =inputCheck(scanner, bodyLength, false);
	            
		        Monkey newMonkey = new Monkey(name, gender, age, weight, acquisitionDate,
	            		acquisitionCountry, trainingStatus, reserved, inServiceCountry,
	            		tailLength, height, bodyLength, species);
	            
	            monkeyList.add(newMonkey);
	        
					
			} catch (Exception excpt) {
						
				System.out.println(excpt.getMessage());
					
			}

            
        
        }
        // Complete reserveAnimal
        // You will need to find the animal by animal type and in service country
    	
    // In my approach I made it so the user could pick which
    // available animal they wanted from the list.
    
    public static void reserveAnimal(Scanner scanner) {
    		//Type will be used to determine if the user
    		//is looking for a Dog or Monkey
            String type= "";
            
            //run will be true until the user selects an animal
            //this will end the loop
            //alternatively if the user input q it will also end the loop
            boolean run = true;
            //selection will be used for which animal the user wants to reserve
            int selection = -1; 
            
           
            // if monkeyOrDog is true, then the user will select from the monkeyList
            // else user will select from the dogList
            boolean monkeyOrDog = true;
            
            //availableAnimals just counts if there are animals available
            //used to prompt user if it's still 0
            int availableAniamls = 0;
            
            do {	
            	
            	try {
            		System.out.println("Enter animal type(Monkey / Dog): ");
            		type = scanner.nextLine();
            		//If the user didn't input a Monkey or Dog it will throw an exception
            		if ((!"monkey".equalsIgnoreCase(type)) && (!"dog".equalsIgnoreCase(type))) {
            			throw new Exception("Please enter Monkey or Dog.");
            		}
            			System.out.println("Enter the " + type + "'s service country: ");
            			String country = scanner.nextLine();
            			System.out.println("Searching for " + type + "'s in " + country);
            			//Loop through Monkey and Dog lists to find animals that are in service, from the country selected
            			//and are not already reserved
            			//Print and then increment availableAnimals.
            			if ("monkey".equalsIgnoreCase(type)) {
	                    	for (Monkey monkey : monkeyList ) {
	                            
	                            if(monkey.getInServiceLocation().equalsIgnoreCase(country) && monkey.getReserved() == false && "in service".equalsIgnoreCase(monkey.getTrainingStatus())) {
	          							System.out.println("[" + monkeyList.indexOf(monkey) + "] " + "Name: " + monkey.getName());
	          							availableAniamls += 1;
	                            		 }
	                            	 }		
	                       }
	            		 
            			else if ("dog".equalsIgnoreCase(type)){
	            			for (Dog dog : dogList) {
	                            
	                            if(dog.getInServiceLocation().equalsIgnoreCase(country) && dog.getReserved() == false && "in service".equalsIgnoreCase(dog.getTrainingStatus())) {
	          							System.out.println("[" + dogList.indexOf(dog) + "] " + "Name: " + dog.getName());
	          							monkeyOrDog = false;
	          							availableAniamls += 1;
	                            		 }
	                            	 }
            				}
            	 // Throw exception if no animals are present
            	  if (availableAniamls == 0) {
            		  throw new Exception("No available animals in this country.");
            		  
            	  }
            	  
            	  //Get user input to select an animal. 
                  System.out.println("\n");
                  System.out.println("Please select an animal by #: ");
                  String temp = "";
                  //This will run until completed or the user enters q.
                  
                      do{
                          try {
                        	temp = scanner.nextLine();
                          	selection = Integer.parseInt(temp);
                          	if ("q".equalsIgnoreCase(temp)) {
                          		throw new Exception("Exiting");
                          	}else {
	                          	if (monkeyOrDog) {
	                          		if (monkeyList.get(selection).getReserved() == true) {
	                          				selection = -1;
	                          				throw new Exception("Please select from avaliable animals listed.");
	                          				}
	                          		monkeyList.get(selection).setReserved(true);
	                          			 }
	                   		
	                            else {
	                           	 dogList.get(selection).setReserved(true);
	                            }
	                            run = false;
	                          		 }
                          }
                          catch (Exception excpt) {
                          			 System.out.println(excpt.getMessage());
                          		 }
                          		 
                  	
                      
                      }while(selection < 0 && (!("q".equalsIgnoreCase(temp))));
                      
            	}catch (Exception excpt) {
                  	System.out.println(excpt.getMessage());
                  }
            	
            }while (run == true && ("q".equalsIgnoreCase(type)));
           
            
        }

        // Complete printAnimals
        // Include the animal name, status, acquisition country and if the animal is reserved.

        // The printAnimals() method has three different outputs
        // based on the listType parameter
        // dog - prints the list of dogs
        // monkey - prints the list of monkeys
        // available - prints a combined list of all animals that are
        // fully trained ("in service") but not reserved 

        public static void printAnimals(String selection) {
        	switch(selection) {
        	//This case will iterate over dogList and show what's available
        	case ("dog"):
        		System.out.println("--Dog List--");
	            for (Dog dog : dogList ) {
	                if(dog.getReserved() == false && "in service".equalsIgnoreCase(dog.getTrainingStatus())) {
	  					System.out.println("[" + dogList.indexOf(dog) + "] " + "Name: " + dog.getName() + " || Country: " + dog.getInServiceLocation() + 
	  							" || Training Status: " + dog.getTrainingStatus()  + " || Reservation Status: " + dog.getReserved());
	                    	}
	                    }		
	               
        		break;
        		//This case will iterate over monkeyList and show what's available
        	case ("monkey"):
        		System.out.println("--Monkey List--");
                for (Monkey monkey : monkeyList ) {
                      if(monkey.getReserved() == false && "in service".equalsIgnoreCase(monkey.getTrainingStatus())) {
                    	  System.out.println("[" + monkeyList.indexOf(monkey) + "] " + "Name: " + monkey.getName() + " || Country: " + monkey.getInServiceLocation() + 
  	  							" || Training Status: " + monkey.getTrainingStatus()  + " || Reservation Status: " + monkey.getReserved());
                        		 }
                        	 }		
                   
        		break;
           //This case will iterate over both Lists and show what's available
        	case ("available"):
        		System.out.println("--Dog List--");
	        	for (Dog dog : dogList ) {
	          		
	                if(dog.getReserved() == false && "in service".equalsIgnoreCase(dog.getTrainingStatus())) {
	                	System.out.println("[" + dogList.indexOf(dog) + "] " + "Name: " + dog.getName() + " || Country: " + dog.getInServiceLocation() + 
	  							" || Training Status: " + dog.getTrainingStatus()  + " || Reservation Status: " + dog.getReserved());
	                		 }
	                	 }		
	        	System.out.println("\n");
	        	System.out.println("--Monkey List--");
	        	for (Monkey monkey : monkeyList ) {
	          		
	                if(monkey.getReserved() == false && "in service".equalsIgnoreCase(monkey.getTrainingStatus())) {
	                	System.out.println("[" + monkeyList.indexOf(monkey) + "] " + "Name: " + monkey.getName() + " || Country: " + monkey.getInServiceLocation() + 
	  							" || Training Status: " + monkey.getTrainingStatus()  + " || Reservation Status: " + monkey.getReserved());
	                		 }
	                	 }		
	           
        		break;
        	
        	default:
        		System.out.println("Unknown selection");
        		break;
        		
        	}
        	

        }
}

