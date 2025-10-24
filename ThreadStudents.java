package task2;

public class ThreadStudents extends Thread {
	Students student;
	Scorewriter writer;
	
	public ThreadStudents(Students student, Scorewriter writer) {
		this.student=student;
		this.writer=writer;
	}
	@Override
	public void run() {
		writer.writeToFile(student);
	}

}
