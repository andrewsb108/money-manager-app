package com.moneymanagerapp.domain;

import com.moneymanagerapp.domain.enums.TransactionsType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, length = 50)
    private String comment;
    private long numberAccountFrom;
    private long numberAccountTo;
    private long amount;
    @Enumerated(EnumType.STRING)
    private TransactionsType transactionsType;
    private LocalDateTime localDateTime;
    @OneToOne
    private Category category;
}
