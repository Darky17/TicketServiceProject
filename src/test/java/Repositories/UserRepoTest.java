package Repositories;

import Util.TestUtl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@DataJpaTest
@Rollback(false)
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
class UserRepoTest {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserRepo userRepo;

    @Test
    void testFindByName(){
        //if we have
        var user = userRepo.save(TestUtl.createUser("Dragos","Popescu"));
        //when we try
        var result = userRepo.findUserByFirstNameAndAndLastName("Dragos","Popescu")
                .orElseGet(() -> fail("No user found with that name"));
        //then
        assertEquals(user, result);
    }
}