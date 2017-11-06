package entity;

public class Student {
    private Integer idunique;
    private Integer age;
    private String name;
    private Integer id;
    public Student(String name, int age, int id){
        this.name = name;
        this.age = age;
        this.id = id;
    }
    public Student(int idunique,String name, int age, int id){
        this.name = name;
        this.idunique = idunique;
        this.age = age;
        this.id = id;
    }
    public Student(){
    }

    public void setIdunique(int idunique){this.idunique = idunique;}

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

    public int getIdunique(){return this.idunique;}

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}