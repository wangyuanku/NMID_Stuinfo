package Bean;

import java.util.Date;

public class Student {
    private int id;
    private String stuID;
    private String name;
    private String gender;
    private int age;
    private Date birthday;

    public Student(String stuID, String name, String gender, int age, Date birthday){
        this.stuID = stuID;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.birthday = birthday;
    }

    public int getId(){
        return id;
    }
    public String getStuID(){
        return stuID;
    }
    public String getName(){
        return name;
    }
    public String getGender(){
        return gender;
    }
    public int getAge(){
        return age;
    }
    public Date getBirthday(){
        return birthday;
    }


    public void setId(int id){
        this.id = id;
    }
    public void setStuID(String stuID){
        this.stuID = stuID;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setBirthday(Date birthday){
        this.birthday = birthday;
    }
}
