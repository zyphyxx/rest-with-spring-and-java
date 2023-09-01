public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Joao",6000);


        System.out.println(employee.getName());
        System.out.println("$ " + employee.netSalary());
        employee.increseSalary(10.0);







    }
}
