package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "driver")
public class Driver implements Serializable {

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private int id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "name")
    private String name;

    @Basic(optional = false)
    @NotNull
    @Column(name = "birth_year")
    private int birth_year;

    @Basic(optional = false)
    @NotNull
    @Column(name = "gender")
    private String gender;

    @OneToMany
    private List<Car> carList = new ArrayList<>();

    public Driver() {
    }

    public Driver(int id, String name, int birth_year, String gender) {
        this.id = id;
        this.name = name;
        this.birth_year = birth_year;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(int birth_year) {
        this.birth_year = birth_year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
