package main;

public class ForeignStudent extends Student {
	private String lang;

	public ForeignStudent(String firstName, String lastName, int age, String lang) {
		super(firstName, lastName, age);
		setLang(lang);
	}

	public ForeignStudent() {
		super();
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getLang() {
		return lang;
	}
	
	@Override
	public String getFullName() {
		return getFirstName()+" "+ getLastName();
	}

}
