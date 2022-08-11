package Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends User{

    private Integer rights = 1;

    public Integer getRights() {
        return rights;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
