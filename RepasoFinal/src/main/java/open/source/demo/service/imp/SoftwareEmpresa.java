package open.source.demo.service.imp;

import open.source.demo.entity.Software;
import open.source.demo.repository.i_SoftwareRepository;
import open.source.demo.service.i_SoftwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

        Software software = repository.save(obj);

        if(software == null){
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
    public Optional<Software> buscarPorID(int id) {

        Optional<Software> objRubro = null;
        try {
            objRubro = repository.findById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return objRubro;
    }
}
