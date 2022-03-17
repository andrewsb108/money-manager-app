package com.moneymanagerapp.domain.registration;

import com.moneymanagerapp.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ConfirmationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String token;
    @Column(nullable = false)
    private LocalDateTime createdAT;
    @Column(nullable = false)
    private LocalDateTime expiresAT;
    private LocalDateTime confirmedAT;
    @ManyToOne
    @JoinColumn(nullable = false, name = "app_user_id")
    private User user;

    public ConfirmationToken(String token,
                             LocalDateTime createdAT,
                             LocalDateTime expiredAT,
                             User user) {
        this.token = token;
        this.createdAT = createdAT;
        this.expiresAT = expiredAT;
        this.user = user;
    }
}

