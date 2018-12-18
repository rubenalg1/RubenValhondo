package es.hubiqus.inventario.controller.profesor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.hubiqus.inventario.model.Asignacion;
import es.hubiqus.inventario.service.AsignacionSvc;

@Controller
public class ModificarAsignacion {

	private static final String ATT_ERROR = "error";

	private static final String SUCCESS = "menuprofesor";
	private static final String ERROR = "error";

	@Autowired
	private AsignacionSvc svc;

	//Metodo con el que el profesor modifica el ejercicio de una asignacion.
	@RequestMapping(value = "/modificarasignacion", method = RequestMethod.POST)
	public String borrar(@ModelAttribute Asignacion asignacion, Model model) {

		// Recuperamos el id que se envia de la jsp de asignaciones, buscamos la
		// asignacion y se modifica el ejercicio. Finalmente, se vuelve a enviar
		// a la pagina con todas las asignaciones de dicho profesor.
		try {
			Asignacion a = svc.buscarPorId(asignacion.getId());
			a.setEjercicio(asignacion.getEjercicio());

			svc.modificarAsignacion(a);
			return SUCCESS;

		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

}
