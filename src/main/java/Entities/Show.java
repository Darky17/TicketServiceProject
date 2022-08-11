package Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Show {
    String showName;
    String date;

    Integer nrTickets;
    private String id;

    @OneToMany(mappedBy="show")
    private ArrayList<Ticket> ticketSet = new ArrayList<>();



    public Integer getNrTickets() {
        return nrTickets;
    }

    public void setNrTickets(Integer nrTickets) {
        this.nrTickets = nrTickets;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public static void setId(String id) {
        UtilFunc generateShowID = null;
        generateShowID.generate(id);
    }

    @Id
    public String getId() {
        return id;
    }

}

