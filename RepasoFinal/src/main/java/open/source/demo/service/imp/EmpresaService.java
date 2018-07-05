package open.source.demo.service.imp;


import open.source.demo.entity.Empresa;
import open.source.demo.repository.i_EmpresaRepository;
import open.source.demo.service.i_EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService implements i_EmpresaService {

    @Autowired
    i_EmpresaRepository repository;

    @Override
    public List<Empresa> listado() {
        return repository.findAll();
    }

    @Override
    public boolean agregar(Empresa obj) {
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        return false;
    }

    @Override
    public Empresa buscarPorID(int id) {
        return null;
    }
}
