package domain;

import java.util.Date;
import java.util.UUID;

public class PersonDomainModel {

	protected  UUID personID;
    protected  String firstName;
    protected  String lastName;
    protected  String street;
    protected  int postalCode;
    protected  String city;
    protected  Date birthday;

    /**
     * Default constructor.
     */
	public PersonDomainModel() {
		this.personID = UUID.randomUUID();
	}

	public PersonDomainModel(String firstName, String lastName, String street, int postalCode, String city, Date dOB) {
		super();
		this.setPersonID(UUID.randomUUID());		
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.postalCode = postalCode;
		this.city = city;
		this.birthday = dOB;		
	}

	public PersonDomainModel(PersonDomainModel per)
	{
		super();
		this.setPersonID(UUID.randomUUID());		
		this.firstName = per.getFirstName();
		this.lastName = per.getLastName();
		this.street = per.getStreet();
		this.postalCode = per.getPostalCode();
		this.city = per.getCity();
		this.birthday = per.getBirthday();
	}
	
	/**
	 * Person - This constructor will retrieve a give Person ID's record.
	 * @param PersonID
	 */
	public PersonDomainModel(UUID PersonID) {
		super();
		this.personID = PersonID;		
	}

	public UUID getPersonID() {
		return personID;
	}
	
	public void setPersonID(UUID PersonID) {
		this.personID = PersonID;
	}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
