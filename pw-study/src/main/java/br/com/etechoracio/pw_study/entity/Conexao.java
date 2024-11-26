package br.com.etechoracio.pw_study.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.CookieValue;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name = "TBL_CONEXAO")
public class Conexao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CONEXAO")
    private long id;

    @Column(name = "DT_CRIACAO")
    private LocalDateTime dataCriacao;

    @ManyToOne
    @JoinColumn(name = "ID_MONITOR")
    private Monitor monitor;


}
