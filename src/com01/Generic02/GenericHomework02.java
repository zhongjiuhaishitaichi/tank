package com01.Generic02;

import org.junit.jupiter.api.Test;

import java.util.*;

public class GenericHomework02 {
    public static void main(String[] args) {

    }

    @Test
    public void TestList() {
        DAO<User> userDAO = new DAO<>();
        userDAO.save("001", new User(1, 10, "php"));
        userDAO.save("002", new User(2, 1123, "java"));
        userDAO.save("003", new User(3, 100, "python"));
        List<User> list = userDAO.list();
        System.out.println(list);
        userDAO.update("002", new User(4, 12345, "MySQL"));
        List<User> list2 = userDAO.list();
        System.out.println(list2);
        userDAO.delete("003");
        List<User> list3 = userDAO.list();
        System.out.println(list3);
        System.out.println(userDAO.get("001"));
    }
}

class DAO<T> {
    private Map<String, T> map = new HashMap<>();

    @Test
    public void save(String id, T entity) {
        map.put(id, entity);
    }

    @Test
    public T get(String id) {

        return map.get(id);
    }

    @Test
    public void update(String id, T entity) {
        map.put(id, entity);
    }

    public List<T> list() {
        List<T> list = new ArrayList<>();
        Set<String> strings = map.keySet();
        for (String key : strings) {
            list.add(map.get(key));
        }
        /*  Set<Map.Entry<String, T>> entries = map.entrySet();
        Iterator<Map.Entry<String, T>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, T> next = iterator.next();
            System.out.println((T) (next.getKey() + "--" + next.getValue()));
        }*/
        return list;
    }

    public void delete(String id) {
        map.remove(id);
    }
}

class User {
    private int id;
    private int age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}' + "\n";
    }
}
