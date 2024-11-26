package br.com.etechoracio.pw_study.repository;

import br.com.etechoracio.pw_study.entity.Conexao;
import br.com.etechoracio.pw_study.entity.Disciplina;
import br.com.etechoracio.pw_study.entity.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConexaoRepository extends JpaRepository<Conexao, Long>{
}
