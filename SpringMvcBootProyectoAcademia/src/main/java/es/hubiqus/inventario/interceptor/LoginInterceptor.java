package es.hubiqus.inventario.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import es.hubiqus.inventario.model.Alumno;
import es.hubiqus.inventario.model.Profesor;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	private static final String INDEX = "/index.jsp";

	//Metodo que no deja acceder al portal si no eres alumno o profesor.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		Alumno alumno = (Alumno) request.getSession().getAttribute("alumno");
		Profesor profesor = (Profesor) request.getSession().getAttribute("profesor");

		if (alumno == null && profesor == null) {
			if (!uri.endsWith("/alumnologin") && !uri.endsWith("/profesorlogin") && !uri.endsWith("/alumnoidentificar")
					&& !uri.endsWith("/profesoridentificar")) {
				// Redirigir al inicio en caso de acceso prohibido
				response.sendRedirect(request.getContextPath() + INDEX);
				return false;
			}

		}

		return true;
	}

}
