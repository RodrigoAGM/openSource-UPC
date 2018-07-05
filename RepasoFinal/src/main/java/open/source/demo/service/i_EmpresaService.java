package open.source.demo.service;

import open.source.demo.entity.Empresa;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface i_EmpresaService {
    public List<Empresa> listado();
    public boolean agregar(Empresa obj);
    public boolean eliminar(int id);
    public Optional<Empresa> buscarPorID(int id);
}
