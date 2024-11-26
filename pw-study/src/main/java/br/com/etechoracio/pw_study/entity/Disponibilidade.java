package br.com.etechoracio.pw_study.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "TBL_DISPONIBILIDADE")
public class Disponibilidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DISPONIBILIDADE")
    private long disponibilidade;

    @Column(name = "TX_DIA_SEMANA")
    private String diaSemana;

    @Column(name = "DT_DAS")
    private LocalDateTime dtDas;

    @Column(name = "DT_ATE")
    private LocalDateTime dtAte;


}
