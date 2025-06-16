package de.telran.ticketapp.repository;

import de.telran.ticketapp.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//JPA - standard -> (set of interfaces) ->Hibernate(JDBC)
//ORM - java class to table database and from database to java class

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    //find - select,  by - where
    Ticket findByTitle(String title);

    List<Ticket> findAllByTitle(String title);

    @Query (value = "SELECT t FROM Ticket t LEFT JOIN LocalUser u ON u.id = t.id" )
    List<Ticket> getAllWithUsers();

    @Query (value = "SELECT t.* FROM tickets AS t " , nativeQuery = true )
    List<Ticket> getAllWithAllUsers();
}
