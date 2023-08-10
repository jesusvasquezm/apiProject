package med.voll.api.medico;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> { //Padrão Repository em vez do padrão DAO
}
