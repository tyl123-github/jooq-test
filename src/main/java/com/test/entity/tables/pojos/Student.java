/*
 * This file is generated by jOOQ.
 */
package com.test.entity.tables.pojos;


import java.io.Serializable;

import javax.annotation.processing.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Student implements Serializable {

    private static final long serialVersionUID = 1153698265;

    private Integer id;
    private String  name;
    private Integer age;

    public Student() {}

    public Student(Student value) {
        this.id = value.id;
        this.name = value.name;
        this.age = value.age;
    }

    public Student(
        Integer id,
        String  name,
        Integer age
    ) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Student (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(age);

        sb.append(")");
        return sb.toString();
    }
}
