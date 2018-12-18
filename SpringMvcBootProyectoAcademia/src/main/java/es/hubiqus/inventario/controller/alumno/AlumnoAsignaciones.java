package es.hubiqus.inventario.controller.alumno;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.hubiqus.inventario.model.Alumno;
import es.hubiqus.inventario.service.AsignacionSvc;

@Controller
public class AlumnoAsignaciones {

	private static final String ATT_LISTA = "lista";
	private static final String ATT_ERROR = "error";

	private static final String SUCCESS = "asignacionesalumno";
	private static final String ERROR = "error";

	@Autowired
	private AsignacionSvc svc;

	@Autowired
	private HttpSession session;

	//Metodo que envia la lista de asignaciones del alumno a la jsp.
	@RequestMapping(value = "/alumnoasignaciones", method = RequestMethod.GET)
	public String execute(Model model) {
		try {

			// Se busca la lista de asignaciones (citas) que tiene el alumno.
			Alumno alumno = (Alumno) session.getAttribute("alumno");
			model.addAttribute(ATT_LISTA, svc.verAsignacionesPorAlumno(alumno));
			return SUCCESS;

		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

}
