package Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Ticket {
    @Id
    String ticketID;
    String userID = "none";
    String showID = "none";

    @ManyToOne
    @JoinColumn(name ="showID",nullable = false)
    private Show show;


    public void setTicketID(String ticketID) {
        UtilFunc generateIDs = null;
        generateIDs.generate(ticketID);
    }


    private static String id;



    public String getTicketID() {
        return ticketID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getShowID() {
        return showID;
    }

    public void setShowID(String showID) {
        this.showID = showID;
    }

    public void setId(String id) {
        UtilFunc generateRandomID = null;
        generateRandomID.generate(id);
    }

    @Id
    public static String getId() {
        return id;
    }

}
