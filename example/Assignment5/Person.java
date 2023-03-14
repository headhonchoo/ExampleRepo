//Sidney Mcclendon (smcclendon1@csudh.edu)
public class Person {
	//Fields
	private String firstName;
    private String lastName;
    private String emailAddress;
    private String SSN;

  //Constructors
    public Person(String firstName, String lastName, String emailAddress, String SSN) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.SSN = SSN;
        
    }

    //Methods
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getSSN() {
        return SSN;
    }


    @Override
    public String toString() {
        return firstName+" : "+lastName+" : "+SSN;
    }

}