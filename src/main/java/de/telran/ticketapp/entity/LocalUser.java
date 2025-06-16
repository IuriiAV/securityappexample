package de.telran.ticketapp.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

import java.util.List;

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
@ToString
public class LocalUser {

    @Id // указывает что это поле первичный ключ
    @GeneratedValue(strategy = GenerationType.IDENTITY) // задает автогенерацию значения поля
    @EqualsAndHashCode.Include
    //@ToString.Include
    private Long id;

    private String name;

    private String surname;

    private String email;

    private String password;

    private String postAddress;   // post_address  // postAddress

    @OneToOne(mappedBy = "localUser")
    @JsonManagedReference\
//    @OneToMany
//    @JoinColumn(name = "local_user_id")
    private Ticket ticket;
}
