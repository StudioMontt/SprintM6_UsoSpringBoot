package cl.awakelab.sprintm6.repository;

import cl.awakelab.sprintm6.entity.InstSalud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInstSaludRepository extends JpaRepository<InstSalud, Integer> {
}
