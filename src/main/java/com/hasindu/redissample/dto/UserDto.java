package com.hasindu.redissample.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.index.Indexed;

/**
 * @author hasindu_d
 */
public class UserDto {


    private String id;

    private String name;

    private long salary;

    public UserDto() {
    }

    public UserDto(String id, String name, long salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}
