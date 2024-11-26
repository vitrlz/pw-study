package br.com.etechoracio.pw_study.repository;

import br.com.etechoracio.pw_study.entity.Disciplina;
import br.com.etechoracio.pw_study.entity.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MonitorRepository extends JpaRepository<Monitor,Long> {
    //List<Monitor> findByEmailOrWhatsapp(String email, String whatsapp);
    Optional<Monitor> findByEmail(String email);
    Optional<Monitor> findByWhatsapp(String whatsapp);
    Optional<Monitor> findByEmailOrWhatsapp(String email, String whatsapp);
    Optional<Monitor> findByDisciplina(Disciplina disciplina);
}
