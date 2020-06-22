package core;

/**
 * This class is used to create a customer object made up of an name, address, 
 * city, state, zip code, and age.
 */
public class Customer {
	private String name,streetAddress,city,state,zip;
	private int age;
	
	/**
	 * Constructor that uses passed values for all fields except age.  Age is 
	 * 
	 * @param name				String passed to store in customer name
	 * @param streetAddress		String passed to store in customer street address
	 * @param city				String passed to store in customer city
	 * @param state				String passed to store in customer state
	 * @param zip				String passed to store in customer zip code
	 */
	public Customer(String name, String streetAddress, String city, String state, String zip) {
		this.name = name;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.age = 0;
	}

	/**
	 * Returns the name for this object.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name for this object.
	 * 
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the street address for this object.
	 * 
	 * @return the streetAddress
	 */
	public String getStreetAddress() {
		return streetAddress;
	}

	/**
	 * Sets the street address for this object.
	 * 
	 * @param streetAddress the streetAddress to set
	 */
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	/**
	 * Returns the city for this object.
	 * 
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city for this object.
	 * 
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Returns the state for this object.
	 * 
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Sets the state for this object.
	 * 
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Returns the zip code for this object.
	 * 
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * Sets the zip code for this object.
	 * 
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * Returns the age for this object.
	 * 
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets the age for this object. 
	 * 
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * Return a formated string made up of the street address, city, state and zip code.
	 * 
	 * @return String created from address elements
	 */
	public String displayAddress() {
		String outputAddress = streetAddress + "\n" + city + ", " + state + " " + zip;

		return outputAddress;
	}
	
	/**
	 * Return a formated string made up of the name, street address, city, state and zip code.
	 * 
	 * @return String created from name and address elements
	 */
	public String displayAddressLabel() {
		String outputAddress = name + "\n" + streetAddress + "\n" + city + ", " + state + " " + zip;
	
		return outputAddress;
	}
}
