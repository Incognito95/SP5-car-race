package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "driver")
public class Driver implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driver_id")
    private int driver_id;

    @Column(name = "driver_name")
    private String driver_name;

    @Column(name = "birth_year")
    private int birth_year;

    @Column(name = "gender")
    private String gender;

    @OneToMany
    private List<Car> carList = new ArrayList<>();

    public Driver() {
    }

    public Driver(int driver_id, String driver_name, int birth_year, String gender) {
        this.driver_id = driver_id;
        this.driver_name = driver_name;
        this.birth_year = birth_year;
        this.gender = gender;
        this.carList = carList;
    }

    public int getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(int driver_id) {
        this.driver_id = driver_id;
    }

    public String getDriver_name() {
        return driver_name;
    }

    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
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

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }
}
