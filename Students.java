package task2;

public class Students {
	String name;
	int rollno;
	int marks;
	public Students(String name, int rollno, int marks) {
        this.name = name;
        this.rollno = rollno;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return name + "," + rollno + "," + marks;
    }

}
