package Repositories;

import Entities.Show;
import Entities.Ticket;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepo extends CrudRepository<Ticket,String> {
    @Query("select t from Ticket t where t.id=:ticketID")
    Optional<List<Ticket>> findTicketById(String ticketID);

    @Query("select t from Ticket t where t.show =:show")
    Optional<List<Ticket>> findTicketByShow(Show show);

    @Modifying
    @Query("delete from Ticket t where t.id=:id")
    Optional<List<Ticket>> deleteTicketById(String id);

    @Modifying
    @Query("update Ticket t set t.userID = 'none' where t.id=:id")
    Optional<List<Ticket>> clearTicketById(String id);

}
