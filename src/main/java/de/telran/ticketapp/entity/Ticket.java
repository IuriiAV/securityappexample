package de.telran.ticketapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tickets")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Ticket {

    @Id // указывает что это поле первичный ключ
    @GeneratedValue(strategy = GenerationType.IDENTITY) // задает автогенерацию значения поля
    @EqualsAndHashCode.Include
    private Long id;

    private String title;

    private double price;
}
