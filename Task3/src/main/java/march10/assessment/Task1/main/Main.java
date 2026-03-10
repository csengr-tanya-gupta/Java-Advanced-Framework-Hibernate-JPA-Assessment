package march10.assessment.Task1.main;

public class Main {
	
	public static void main(String[] args) {

        JavaApp app = new JavaApp();

        app.addEmployee();

        app.searchEmployee(101);

        app.updateSalary(101,60000);

        app.updateAddress(101,"456 Park Ave","New York","10002");

        app.deleteEmployee(101);
    }

}
