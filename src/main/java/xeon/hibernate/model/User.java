package xeon.hibernate.model;

import javax.persistence.*;

/**
 * User: xeon
 * Date: 2/26/13
 * Time: 10:03 PM
 */
@Entity
@Table(name = "USER")
public class User {
    private Long id;
    private String name;
    private int age;
    private Address address;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Embedded
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
