package de.telran.ticketapp.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import de.telran.ticketapp.enums.ROLE;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 */

@Entity
@Table(name = "local_users")
@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
//@ToString
public class LocalUser {

    @Id // указывает что это поле первичный ключ
    @GeneratedValue(strategy = GenerationType.IDENTITY) // задает автогенерацию значения поля
    @EqualsAndHashCode.Include
    //@ToString.Include
    private Long id;

    private String name;

    private String surname;

    //use as user login
    private String email;

    private String password;

    private String postAddress;   // post_address  // postAddress

    @Enumerated(EnumType.STRING)   // хранит енам как строку, если ее не будет
    // то енам будет храниться числом 0, 1 etc
    private ROLE role = ROLE.ROLE_USER;

    //    @OneToOne(mappedBy = "localUser")
    //    @JsonManagedReference
    //    EAGER - грузим все связанное сразу
    //    LAZY - грузим все связанное в момент обращения к этому(когда понадобится)
    //    orphanRemoval = true   -- вспомнить при очистке корзины!!!!
    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "local_user_id")
    private Set<Ticket> tickets = new HashSet<>();

    /*
    Alex  -> ticketOne
          -> ticketTwo
          -> ticketThree

     */

    public LocalUser(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }
}
