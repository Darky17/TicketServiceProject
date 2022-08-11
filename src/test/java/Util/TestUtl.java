package Util;

import Entities.Show;
import Entities.Ticket;
import Entities.User;
public class TestUtl {


    public static User createUser(String firstName, String lastName) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return user;
    }
    public static Show createShow(String name) {
        Show show = new Show();
        show.setShowName(name);
        return show;
    }
    public static Ticket createTicket(String id, Show show) {
        Ticket ticket = new Ticket();
        ticket.setTicketID(id);
        ticket.setShow(show);
        return ticket;
    }

}

