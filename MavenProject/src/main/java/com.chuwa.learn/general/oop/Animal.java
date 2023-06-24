public class Animal {

    private String name;

    private Integer age;

    public Animal() {
        name = null;
        age = 0;
    }

    public void eat() {
        System.out.println("animal is eating");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}