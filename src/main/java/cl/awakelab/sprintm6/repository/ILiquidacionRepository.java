package cl.awakelab.sprintm6.repository;

import cl.awakelab.sprintm6.entity.Liquidacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILiquidacionRepository extends JpaRepository<Liquidacion, Integer> {
}
