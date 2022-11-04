package PersonalMedicalHistory.Model;

/**
 * This is a pojo class having attributes for medicalvisit. 
 * @author Abhishek
 *
 */
public class MedicalVisit {
	private String Hospital_name;
	private String Doctor_name;
	private String Date_of_Visit;
	private String Next_appointment;
	private String P_email;
	private String Photo;
	private Integer New_medical_visit_id;
	public Integer getNew_medical_visit_id() {
		return New_medical_visit_id;
	}
	public void setNew_medical_visit_id(Integer new_medical_visit_id) {
		New_medical_visit_id = new_medical_visit_id;
	}
	public String getPhoto() {
		return Photo;
	}
	public void setPhoto(String photo) {
		Photo = photo;
	}
	public String getHospital_name() {
		return Hospital_name;
	}
	public void setHospital_name(String hospital_name) {
		Hospital_name = hospital_name;
	}
	public String getDoctor_name() {
		return Doctor_name;
	}
	public void setDoctor_name(String doctor_name) {
		Doctor_name = doctor_name;
	}
	public String getDate_of_Visit() {
		return Date_of_Visit;
	}
	public void setDate_of_Visit(String date_of_Visit) {
		Date_of_Visit = date_of_Visit;
	}
	public String getNext_appointment() {
		return Next_appointment;
	}
	public void setNext_appointment(String next_appointment) {
		Next_appointment = next_appointment;
	}
	public String getP_email() {
		return P_email;
	}
	public void setP_email(String p_email) {
		P_email = p_email;
	}
	
}
