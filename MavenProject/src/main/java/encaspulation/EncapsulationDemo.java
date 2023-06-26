package encaspulation;

public class EncapsulationDemo {
    public static void main(String[] args) {
        Employee employee = new Employee("Lydia", 12333);
        System.out.println("employee id:" + employee.getId());
        System.out.println("employee name:" + employee.getName());
        employee.setId(33321);
        employee.setName("Hali");
        System.out.println("----change employee name and id----");
        System.out.println("employee id:" + employee.getId());
        System.out.println("employee name:" + employee.getName());
    }
}

class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
