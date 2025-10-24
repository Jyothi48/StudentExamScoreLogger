package task2;

public class MainClass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String filePaths = "scores.csv";
        Scorewriter writer = new Scorewriter(filePaths);

        Thread td1 = new ThreadStudents(new Students("Jyothi", 1, 85), writer);
        Thread td2 = new ThreadStudents(new Students("Deepthi", 2, 90), writer);
        Thread td3 = new ThreadStudents(new Students("deepa", 3, 78), writer);

        td1.start();
        td2.start();
        td3.start();

       
        td1.join();
        td2.join();
       td3.join();

        System.out.println("All threads completed writing");

	}

}
