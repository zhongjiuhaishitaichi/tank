package com01.Generic01;

import java.util.*;

public class GenericHomework {
    public static void main(String[] args) {
        HashSet<Student> students = new HashSet<>();//只能添加学生类
        students.add(new Student("john",12));
        students.add(new Student("mark",23));
        students.add(new Student("jack",45));
        for (Student student :students) {
            System.out.println(student);
        }
        HashMap<String, Student> stringStudentHashMap = new HashMap<>();
        stringStudentHashMap.put("jack",new Student("lucy",34));
        stringStudentHashMap.put("tom",new Student("tom",23));
        stringStudentHashMap.put("ai",new Student("mary",100));
        Set<Map.Entry<String, Student>> entries = stringStudentHashMap.entrySet();
        Iterator<Map.Entry<String, Student>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Student> next =  iterator.next();
            System.out.println(next+"========================");
            System.out.println(next.getKey()+"--"+next.getValue());
        }
    }
}
class Student{
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}