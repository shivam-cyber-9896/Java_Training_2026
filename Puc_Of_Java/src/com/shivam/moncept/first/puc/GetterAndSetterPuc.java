package com.shivam.moncept.first.puc;
class student{
	private String name;
	private   int id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public student(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public student() {
	
	}
}
public class GetterAndSetterPuc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		student s1=new student();
		student s2=new student("Sid",23);
		s1.setName("Shivam");
		s1.setId(3);
		System.out.println("Enter name  is ="+s1.getName()
		                          +"\n Enter id is ="+s1.getId());
		System.out.println("Enter name  is ="+s2.getName()
        +"\n Enter id is ="+s2.getId());

	}

	

}
