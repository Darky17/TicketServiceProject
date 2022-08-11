package Service;

import Entities.Ticket;
import Repositories.TicketRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TicketService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TicketService.class);

    @Autowired
    private TicketRepo ticketRepo;

    public void saveTicket(final Ticket ticket) {
        LOGGER.info("Creating ticket: " + ticket);
        ticketRepo.save(ticket);
    }

}
