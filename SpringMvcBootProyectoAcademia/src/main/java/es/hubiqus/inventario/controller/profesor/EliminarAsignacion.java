package es.hubiqus.inventario.controller.profesor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.hubiqus.inventario.model.Asignacion;
import es.hubiqus.inventario.service.AsignacionSvc;

@Controller
public class EliminarAsignacion {

	private static final String ATT_ERROR = "error";

	private static final String SUCCESS = "forward:/profesorasignaciones";
	private static final String ERROR = "error";

	@Autowired
	private AsignacionSvc svc;

	//Metodo que borra una asignacion que seleccione el profesor.
	@RequestMapping(value = "/borrarasignacion", method = RequestMethod.GET)
	public String borrar(@RequestParam int id, Model model) {

		// Recuperamos el id que se envia de la jsp de asignaciones y se elimina
		// la asignacion con ese id. Finalmente, se lleva a la pagina con todas
		// las asignaciones de dicho profesor.
		try {
			Asignacion a = new Asignacion();
			a.setId(id);

			svc.borrarAsignacion(a);
			return SUCCESS;

		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

}
