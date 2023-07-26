package cl.awakelab.sprintm6.repository;

import cl.awakelab.sprintm6.entity.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPerfilRepository extends JpaRepository<Perfil, Integer> {
}
