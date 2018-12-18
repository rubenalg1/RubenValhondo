package es.hubiqus.inventario.controller.profesor;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.hubiqus.inventario.model.Profesor;
import es.hubiqus.inventario.service.ProfesorSvc;

@Controller
public class ProfesorLogin {

	private static final String SUCCESS = "profesorlogin";
	private static final String MSG_ERROR = "usuario.login.error";

	@Autowired
	private ProfesorSvc svc;

	@Autowired
	private HttpSession session;

	// Metodo que lleva a la pagina de login.
	@RequestMapping(value = "/profesoridentificar", method = RequestMethod.GET)
	public String ejecutar(@ModelAttribute Profesor profesor, Model model) {

	

		return SUCCESS;
	}

	//Metodo que comprueba si el login es correcto y en ese caso, de acceso al
	//menu de profesor.
	@RequestMapping(value = "/profesorlogin", method = RequestMethod.POST)
	public String execute(@Valid Profesor profesor, BindingResult result, Model model) {

		try {
			// No tiene en cuenta validación del resto de campos (registro)
			if (result.getFieldError("user") != null || result.getFieldError("pass") != null) {
				return "profesorlogin";
			} else {
				// Buscamos el alumno por su usuario y contrasena.
				Profesor res = svc.buscarPorUsuarioyContrasena(profesor.getUser(), profesor.getPass());
				if (res == null) {
					// Asignamos el error al id para filtrado en formulario
					result.rejectValue("id", MSG_ERROR);
					return "profesorlogin";
				} else {

					// Si no hay errores, se le lleva al menu de alumnos.
					session.setAttribute("profesor", res);
					return "menuprofesor";
				}
			}
		} catch (Exception ex) {
			// Asignamos el error al id para filtrado en formulario
			result.rejectValue("id", MSG_ERROR);
			return "profesorlogin";
		}
	}

	@RequestMapping(value = "/profesormenu", method = RequestMethod.GET)
	public String irmenu(@ModelAttribute Profesor profesor, Model model) {

		// Nos manda a la jsp de menu para el alumno
		return "menuprofesor";

	}

}
