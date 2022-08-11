package Repositories;

import Entities.Ticket;
import Util.TestUtl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@DataJpaTest
@Rollback(false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TicketRepoTest {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private TicketRepo ticketRepo;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private ShowRepo showRepo;

    @Test
    void findTicketById(){
        //if we have
        var show = showRepo.save(TestUtl.createShow("Kong fu Panda"));
        var ticket = ticketRepo.save(TestUtl.createTicket("8978",show));
        //when we try
        var result = ticketRepo.findTicketById(ticket.getTicketID());
        //then
        assertThat(result.orElseGet(Assertions::fail), contains(ticket));
    }
    @Test
    void findTicketByShow(){
        //if we have
        var show = showRepo.save(TestUtl.createShow("Cinderella"));
        //when we try
        var result = ticketRepo.findTicketByShow(show);
        //then
        assertThat(result.orElseGet(Assertions::fail), contains(show.getShowName()));
    }
    @Test
    void deleteTicketById(){
        //if we have
        var show = showRepo.save(TestUtl.createShow("Doctor Strange"));
        var ticket = ticketRepo.save(TestUtl.createTicket("43269834",show));
        //when we try
        var result = ticketRepo.deleteTicketById(Ticket.getId());
        //then
        assertThat(result.orElseGet(Assertions::fail), contains(not(ticket)));
    }
    @Test
    void clearTicketById(){
        //if we have
        var show = showRepo.save(TestUtl.createShow("Matrix"));
        var ticket = ticketRepo.save(TestUtl.createTicket("5673830",show));
        //when we try
        var result = ticketRepo.clearTicketById(Ticket.getId());
        //then
        assertThat(result.orElseGet(Assertions::fail), contains("none"));
    }
}