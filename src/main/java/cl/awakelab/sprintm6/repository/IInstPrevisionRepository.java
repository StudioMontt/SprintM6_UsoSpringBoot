package cl.awakelab.sprintm6.repository;

import cl.awakelab.sprintm6.entity.InstPrevision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInstPrevisionRepository extends JpaRepository<InstPrevision, Integer> {
}
