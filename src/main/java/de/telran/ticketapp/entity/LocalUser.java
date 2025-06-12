package de.telran.ticketapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;
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
public class LocalUser {

    @Id // указывает что это поле первичный ключ
    @GeneratedValue(strategy = GenerationType.IDENTITY) // задает автогенерацию значения поля
    @EqualsAndHashCode.Include
    private Long id;

    private String name;

    private String surname;

    private String email;

    private String password;

    private String postAddress;   // post_address  // postAddress
}
