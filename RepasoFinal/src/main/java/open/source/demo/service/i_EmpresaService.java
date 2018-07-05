package open.source.demo.service;

import open.source.demo.entity.Empresa;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface i_EmpresaService {
    public List<Empresa> listado();
    public boolean agregar(Empresa obj);
    public boolean eliminar(int id);
    public Empresa buscarPorID(int id);
}
