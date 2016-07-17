
import java.time.LocalDate;
/**
 * Information about a user
 * @author ildarworld
 *
 */
public class Person {
	private String firstName;
	private String serName;
	private String passportNumber;
	private LocalDate birthDay;
	private String email;
	private String phoneNumber;
	private String creditCardNumber;
	
	public Person(String firstName, String serName, String passportNumber, LocalDate birthDay, String email, String phoneNumber, String creditCardNumber){
		
		this.firstName = firstName;
		this.serName = serName;
		this.passportNumber = passportNumber;
		this.birthDay = birthDay;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.creditCardNumber = creditCardNumber;
		
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSerName() {
		return serName;
	}
	public void setSerName(String serName) {
		this.serName = serName;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public LocalDate getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	
	
	
	
	
}
