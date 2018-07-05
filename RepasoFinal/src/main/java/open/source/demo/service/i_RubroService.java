package open.source.demo.service;

import open.source.demo.entity.Rubro;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface i_RubroService {
    public List<Rubro> listado();
    public boolean agregar(Rubro obj);
    public boolean eliminar(int id);
    public Optional<Rubro> buscarPorID(int id);
}
