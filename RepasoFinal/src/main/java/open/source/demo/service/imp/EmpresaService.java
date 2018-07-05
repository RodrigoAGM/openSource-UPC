package open.source.demo.service.imp;


import open.source.demo.entity.Empresa;
import open.source.demo.repository.i_EmpresaRepository;
import open.source.demo.service.i_EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

        Empresa empresa = repository.save(obj);

        if(empresa == null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public boolean eliminar(int id) {
        boolean flag = false;

        try {
            repository.deleteById(id);
            flag = true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return flag;
    }

    @Override
    public Optional<Empresa> buscarPorID(int id) {

        Optional<Empresa> objRubro = null;
        try {
            objRubro = repository.findById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return objRubro;
    }
}
