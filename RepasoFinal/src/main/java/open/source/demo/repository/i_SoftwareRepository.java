package open.source.demo.repository;

import open.source.demo.entity.Software;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface i_SoftwareRepository extends JpaRepository<Software,Integer> {
}
