package es.hubiqus.inventario.controller.alumno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.hubiqus.inventario.service.ProfesorSvc;

@Controller
public class Listar {

	private static final String ATT_LISTA = "lista";
	private static final String ATT_ERROR = "error";

	private static final String SUCCESS = "resultadoalumno";
	private static final String ERROR = "error";

	@Autowired
	private ProfesorSvc svc;

	//Metodo que envia la lista de todos los profesores del sistema a una jsp.
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String execute(Model model) {
		try {

			// Se anade listado de todos los profesores del sistema.
			model.addAttribute(ATT_LISTA, svc.verProfesores());
			return SUCCESS;

		} catch (Exception e) {
			// Si no es posible ver el listado de profesores, se lanza mensaje de
			// error.
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

}
