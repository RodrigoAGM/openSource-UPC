package open.source.demo.service.imp;

import open.source.demo.entity.Software;
import open.source.demo.repository.i_SoftwareRepository;
import open.source.demo.service.i_SoftwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEmpresa implements i_SoftwareService {

    @Autowired
    i_SoftwareRepository repository;

    @Override
    public List<Software> listado() {
        return repository.findAll();
    }

    @Override
    public boolean agregar(Software obj) {
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        return false;
    }

    @Override
    public Software buscarPorID(int id) {
        return null;
    }
}
