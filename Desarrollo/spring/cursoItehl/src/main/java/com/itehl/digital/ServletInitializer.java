package com.itehl.digital;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Inicio de la aplicación spring boot
 * @author ferney
 *
 */
public class ServletInitializer extends SpringBootServletInitializer {

	/**
	 * Inicializa la aplicación mediante la configuración
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CursoItehlApplication.class);
	}

}
