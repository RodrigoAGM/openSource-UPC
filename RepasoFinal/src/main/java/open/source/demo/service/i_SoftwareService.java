package open.source.demo.service;

import open.source.demo.entity.Software;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface i_SoftwareService {
    public List<Software> listado();
    public boolean agregar(Software obj);
    public boolean eliminar(int id);
    public Optional<Software> buscarPorID(int id);
}
