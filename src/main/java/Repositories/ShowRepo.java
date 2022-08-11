package Repositories;


import Entities.Show;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepo extends CrudRepository<Show,String> {
}

