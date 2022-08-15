package com01.Generic01;

import java.util.ArrayList;
import java.util.Comparator;

@SuppressWarnings({"all"})
public class genericHomework002 {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("马里奥no.1", 1000, new MyDate(12, 2, 1904)));
        employees.add(new Employee("小蓝大笨比", 23000, new MyDate(4, 3, 2014)));
        employees.add(new Employee("天选路易", 4000, new MyDate(5, 23, 2015)));
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (!(o1 instanceof Employee && o2 instanceof Employee)) {
                    System.out.println("类型不正确..");
                    return 0;
                }
                int compare = o1.getName().compareTo(o2.getName());
                if (compare != 0) {
                    return compare;
                }
                return o1.getBirthday().compareTo(o2.getBirthday());
            }
        });
        for (Employee employee : employees) {
            System.out.println(employee);
        }

    }
}

class Employee {
    private String name;
    private double salary;
    private MyDate birthday;

    public Employee(String name, double salary, MyDate birthday) {
        this.name = name;
        this.salary = salary;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", birthday=" + birthday +
                '}';
    }
}

class MyDate implements Comparable<MyDate> {
    private int month;
    private int day;
    private int year;

    public MyDate(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "month=" + month +
                ", day=" + day +
                ", year=" + year +
                '}';
    }

    //把比较 封装起来
    @Override
    public int compareTo(MyDate o) { //把对year-month-day比较放在这里

        int yearMinus = this.year - o.getYear();
        if (yearMinus != 0) {
            return yearMinus;
        }
        //如果year相同，就比较month
        int monthMinus = month - o.getMonth();
        if (monthMinus != 0) {
            return monthMinus;
        }
        //如果year 和 month
        return day - o.getDay();
    }

}
