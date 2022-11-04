package PersonalMedicalHistory.Model;

/**
 * Pojo class for Person
 * @author Abhishek
 *
 */
public class Person {
	private String P_email;
	private String P_name;
	private String P_birthDate;
	private String P_gender;
	private  String Password;
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getP_email() {
		return P_email;
	}
	public void setP_email(String p_email) {
		P_email = p_email;
	}
	public String getP_name() {
		return P_name;
	}
	public void setP_name(String p_name) {
		P_name = p_name;
	}
	public String getP_birthDate() {
		return P_birthDate;
	}
	public void setP_birthDate(String p_birthDate) {
		P_birthDate = p_birthDate;
	}
	public String getP_gender() {
		return P_gender;
	}
	public void setP_gender(String p_gender) {
		P_gender = p_gender;
	}
	
	

}
