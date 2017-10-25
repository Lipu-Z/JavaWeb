package entity;

public class Student {
    private Integer age;
    private String name;
    private Integer id;
    public Student(String name, int age, int id){
        this.name = name;
        this.age = age;
        this.id = id;
    }
    public Student(){
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}