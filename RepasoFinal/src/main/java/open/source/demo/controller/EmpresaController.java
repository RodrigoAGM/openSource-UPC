package open.source.demo.controller;

import open.source.demo.entity.Empresa;
import open.source.demo.service.i_EmpresaService;
import open.source.demo.service.i_RubroService;
import open.source.demo.service.i_SoftwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class EmpresaController {

    @Autowired
    i_EmpresaService service;
    @Autowired
    i_RubroService serviceR;
    @Autowired
    i_SoftwareService serviceS;

    @RequestMapping(value="/admin/empresa/listar", method=RequestMethod.GET)
    public String Listado(Model model) {
        model.addAttribute("empresas", service.listado());

        return "admin/empresa/empresa_listar";
    }

    @RequestMapping(value="/admin/empresa/agregar", method=RequestMethod.GET)
    public String agregar(Model model) {
        Empresa objEmpresa = new Empresa();
        model.addAttribute("empresa", objEmpresa);
        model.addAttribute("softwares", serviceS.listado());
        model.addAttribute("rubros", serviceR.listado());

        return "admin/empresa/empresa_agregar";
    }

    @RequestMapping(value="/admin/empresa/guardar", method=RequestMethod.POST)
    public String guardar(@ModelAttribute Empresa objEmpresa, Model model, RedirectAttributes redirAtt) {
        boolean flag;
        flag = service.agregar(objEmpresa);
        if(flag) {
            redirAtt.addFlashAttribute("mensaje", "Empresa Agregada!");
        }else {
            redirAtt.addFlashAttribute("error", "Empresa no agregada");
        }

        return "redirect:/admin/empresa/listar";
    }

    @RequestMapping(value="/admin/empresa/eliminar/{id}", method=RequestMethod.GET)
    public String eliminar(@PathVariable int id, RedirectAttributes redirAtt) {
        boolean flag = service.eliminar(id);
        if(flag) {
            redirAtt.addFlashAttribute("mensaje", "Empresa eliminada");
        }else {
            redirAtt.addFlashAttribute("error", "Ocurrió un error");
        }
        return "redirect:/admin/empresa/listar";
    }

    @RequestMapping(value="/admin/empresa/editar/{id}", method=RequestMethod.GET)
    public String editar(@PathVariable int id, Model model, RedirectAttributes redirAtt) {
        Optional<Empresa> obj = service.buscarPorID(id);

        if(!obj.isPresent()) {
            redirAtt.addFlashAttribute("error", "Empresa no existe");
            return "redirect:/admin/empresa/listar";
        }else {
            model.addAttribute("estudiante", obj);
            model.addAttribute("softwares", serviceS.listado());
            model.addAttribute("rubros", serviceR.listado());
            return "admin/empresa/empresa_editar";
        }
    }
}
