public class Employee {
    private String name;
    private double grossSalary;
    private double tax;

    public Employee(String name,double grossSalary){
        this.name = name;
        this.grossSalary = grossSalary;
        tax = 1000;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }
    //metodos
    public double netSalary(){
       setGrossSalary(getGrossSalary() - getTax());
       return getGrossSalary();
    }
    public void increseSalary(double percentage){
        double increaseAmount = (getGrossSalary() * percentage) / 100;
        setGrossSalary(getGrossSalary() + increaseAmount);
        System.out.println("updated: "+getGrossSalary());
    }

    @Override
    public String toString() {
        return "Employee: " + getName()+" Gross salary: " +getGrossSalary()+ " Tax: "+ getTax();
    }
}
