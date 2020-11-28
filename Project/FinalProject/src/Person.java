import java.util.ArrayList;
import java.util.HashMap;

public class Person {
	
	private String id;
	private String firstName;
	private String lastName;
	private String programAndPlan;
	private String academicLevel;
	private String asuRite;
	private HashMap<String, Integer> time;
	
	public Person(String id, String firstName, String lastName, String programAndPlan, String academicLevel, String asuRite) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.programAndPlan = programAndPlan;
		this.academicLevel = academicLevel;
		this.asuRite = asuRite;
		this.time = new HashMap<String, Integer>();
	}
	
	public void addTime(String date, int time) {
		if (this.time.containsKey(date)) {
			int oldTime = this.time.get(date);
			oldTime += time;
			this.time.put(date, oldTime);
		} else {
			this.time.put(date, time);
		}
	}
	
	public int getTime(String date) {
		return time.get(date);
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getProgramAndPlan() {
		return programAndPlan;
	}
	public void setProgramAndPlan(String programAndPlan) {
		this.programAndPlan = programAndPlan;
	}
	public String getAcademicLevel() {
		return academicLevel;
	}
	public void setAcademicLevel(String academicLevel) {
		this.academicLevel = academicLevel;
	}
	public String getAsuRite() {
		return asuRite;
	}
	public void setAsuRite(String asuRite) {
		this.asuRite = asuRite;
	}
	
	public String[] getHeader() {
		String[] data = new String[6 + time.size()];
		data[0] = ("ID");
		data[1] = ("First Name");
		data[2] = ("Last Name");
		data[3] = ("Program");
		data[4] = ("Level");
		data[5] = ("ASURITE");
		for (int i = 0; i < time.keySet().size(); i++) {
			data[6 + i] = (String) time.keySet().toArray()[i];
		}
		
		return data;
	}
	
	public String[] getPersonArray() {
		String[] data = new String[6 + time.size()];
		data[0] = id;
		data[1] = firstName;
		data[2] = lastName;
		data[3] = programAndPlan;
		data[4] = academicLevel;
		data[5] = asuRite;
		for (int i = 0; i < time.size(); i++) {
			String foundTime = Integer.toString(time.get(time.keySet().toArray()[i]));
			data[6 + i] = foundTime;
		}
		//String[] array = {id, firstName, lastName, programAndPlan, academicLevel, asuRite};
		return data;
	}
	
	

}
