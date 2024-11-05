package PetBoarding;

public class Monkey extends RescueAnimal {

    // Instance variable
    private String tailLength;
    private String height;
    private String bodyLength;
    private String species;
    // Constructor
    public Monkey(String name, String gender, String age,
    String weight, String acquisitionDate, String acquisitionCountry,
	String trainingStatus, boolean reserved, String inServiceCountry,
	String tailLength, String height, String bodyLength, String species) {
        setName(name);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
        setTailLength(tailLength);
        setHeight(height);
        setBodyLength(bodyLength);
        setSpecies(species);

    }

    // Accessor Method
    public String getSpecies() {
        return species;
    }

    // Mutator Method
    public void setSpecies(String monkeySpecies) {
        species = monkeySpecies;
    }
    // Accessor Method
    public String getTailLength() {
        return tailLength;
    }

    // Mutator Method
    public void setTailLength(String monkeyTailLength) {
        tailLength = monkeyTailLength;
    }
    
    // Accessor Method
    public String getHeight() {
        return height;
    }

    // Mutator Method
    public void setHeight(String monkeyHeight) {
        height = monkeyHeight;
    }
    // Accessor Method
    public String getBodyLength() {
        return bodyLength;
    }

    // Mutator Method
    public void setBodyLength(String monkeyBodyLength) {
    	bodyLength = monkeyBodyLength;
    }
}