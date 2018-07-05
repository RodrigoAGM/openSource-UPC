package open.source.demo.repository;

import open.source.demo.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface i_EmpresaRepository extends JpaRepository<Empresa, Integer> {

}
