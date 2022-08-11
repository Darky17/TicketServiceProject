package Controller;

import Entities.Show;
import Entities.Ticket;
import Repositories.TicketRepo;
import Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private TicketRepo ticketRepo;

    @PostMapping(path = "/tickets/{id}/{show}")
    public Ticket createTicket(@PathVariable String id, @PathVariable Show show) {
        ticketService.saveTicket(createTicket(id,show));
        if(id.equals(Ticket.getId()))throw new RuntimeException("Ticket exist");
        return null;
    }

    @GetMapping(path = "/tickets/{id}")
    public Optional<List<Ticket>> getTicket(@PathVariable int id) {
        return ticketRepo.findTicketById(String.valueOf(id));
    }

    @PutMapping(path = "/tickets/{id}")
    public void clearTicketById(@PathVariable int id) {
        ticketRepo.clearTicketById(String.valueOf(id));
    }

    @DeleteMapping(path = "/tickets/{id}")
    public void deleteTicket(@PathVariable Integer id) {
        ticketRepo.deleteTicketById(String.valueOf(id));
    }
}

