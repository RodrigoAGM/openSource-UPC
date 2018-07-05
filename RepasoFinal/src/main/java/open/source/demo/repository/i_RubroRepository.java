package open.source.demo.repository;

import open.source.demo.entity.Rubro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface i_RubroRepository extends JpaRepository<Rubro, Integer> {
}
