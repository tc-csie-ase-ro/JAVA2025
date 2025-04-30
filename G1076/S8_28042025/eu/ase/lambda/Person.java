package eu.ase.lambda;

public class Person {

    private String name;
    private Sex sex;
    private int age;
    private String email;

    public Person(String name, Sex sex, int age, String email) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void printPerson() {
        System.out.printf("Name: %s, Sex: %s, Age: %d, Email: %s\n", getName(), getSex(), getAge(), getEmail());
    }
}
