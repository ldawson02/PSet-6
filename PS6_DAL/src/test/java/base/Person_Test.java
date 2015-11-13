package base;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;

public class Person_Test {

	private static PersonDomainModel per1;
	
	@BeforeClass
	public static void setUp() throws Exception {
		
		Date bday = null;
		try {
			bday = new SimpleDateFormat("yyyy-MM-dd").parse("1996-09-28");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		per1 = new PersonDomainModel("Lia", "Dawson", "129 St Jean Ct", 94526, "Danville", bday);
		
	}
	@Test
	public void addTest() {
		PersonDomainModel test;		
		test = PersonDAL.getPerson(per1.getPersonID());		
		assertNull(test);
		
		test = PersonDAL.addPerson(per1);
		assertEquals("Lia", test.getFirstName());
		assertEquals("Dawson", test.getLastName());
		assertEquals("129 St Jean Ct", test.getStreet());
		assertEquals(94526, test.getPostalCode());
		assertEquals("Danville", test.getCity());
		assertNotNull("Person was added to DataBase", test);
	
	}
	
	@Test
	public void deleteTest() {
		//Add a person and assert that you have added them
		PersonDAL.addPerson(per1);
		assertNotNull(PersonDAL.getPerson(per1.getPersonID()));
		
		//Delete a person and assert that they are no longer in the system
		PersonDAL.deletePerson(per1.getPersonID());
		assertNull(PersonDAL.getPerson(per1.getPersonID()));
	}
	
	@Test
	public void updateTest() {
		
		//add person and assert that they've been added
		PersonDAL.addPerson(per1);
		assertNotNull(PersonDAL.getPerson(per1.getPersonID()));
		
		//Change the Last name of the person, update
		per1.setLastName("Cook");
		PersonDAL.updatePerson(per1);
		assertEquals("Cook", PersonDAL.getPerson(per1.getPersonID()).getLastName());
	}

}