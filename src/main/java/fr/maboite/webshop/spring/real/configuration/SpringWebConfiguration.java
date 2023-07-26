package fr.maboite.webshop.spring.real.configuration;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.extras.springsecurity6.dialect.SpringSecurityDialect;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

@Configuration
@EnableWebMvc
@ComponentScan("fr.maboite.webshop.mvc")
public class SpringWebConfiguration implements WebMvcConfigurer, ApplicationContextAware {

	private ApplicationContext applicationContext;

	public SpringWebConfiguration() {
		super();
	}

	public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	/*
	 * Externalisation des messages
	 */
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
		resourceBundleMessageSource.setBasename("Messages");
		return resourceBundleMessageSource;
	}

	/* **************************************************************** */
	/* THYMELEAF-SPECIFIC ARTIFACTS */
	/*
	 * TemplateResolver sera utilisé par TemplateEngine et TemplateEngine sera
	 * utilisé par ViewResolver
	 */
	/* **************************************************************** */

	/**
	 * Permet de gérer les templates
	 * 
	 * @return
	 */
	@Bean
	public SpringResourceTemplateResolver templateResolver() {
		// SpringResourceTemplateResolver permet de gérer les templates et est configuré
		// ici
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setApplicationContext(this.applicationContext);
		templateResolver.setPrefix("/WEB-INF/templates/");
		templateResolver.setSuffix(".html");
		// HTML est la valeur par défaut, mais ajouté ici pour l'expliciter
		templateResolver.setTemplateMode(TemplateMode.HTML);
		// Template cache est à true par défaut
		// Mettez le à false si vous voulez que les templates soient modifiés
		// automatiquement
		templateResolver.setCacheable(false);
		return templateResolver;
	}

	/**
	 * Crée un templateEngine, nécessaire pour gérer les templates, l'expression
	 * language et les messages exernalisés. 
	 * Ce templateEngine permet en plus d'interpréter les attributs de SpringSecurityDialect
	 * , ils sont précédés par sec: dans les templates.
	 * 
	 * @return
	 */
	@Bean
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setEnableSpringELCompiler(true);
		templateEngine.setTemplateResolver(templateResolver());
		templateEngine.addDialect(new SpringSecurityDialect() );
		return templateEngine;
	}

	/**
	 * Crée un view Resolver pour SpringMVC. En l'occurence un view Resolver
	 * Thymeleaf Les View resolvers s'exécutent après le contrôleur et arrête son
	 * exécution. Ils reçoivent le nom de la vue à traiter et doivent créer et
	 * configurer l'objet {@link View} qui correspond
	 * 
	 * @return
	 */
	@Bean
	public ThymeleafViewResolver viewResolver() {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine());
		return viewResolver;
	}

	/*
	 * Configure le Dispatcher pour servir les ressources statiques
	 */
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/images/**").addResourceLocations("/images/");
		registry.addResourceHandler("/css/**").addResourceLocations("/css/");
		registry.addResourceHandler("/js/**").addResourceLocations("/js/");
		registry.addResourceHandler("/openapi/**").addResourceLocations("/openapi/");
	}

	/**
	 * Ajoute une configuration CORS pour permettre aux navigateurs d'envoyer des
	 * requêtes à ce site à partir de n'importe quel autre. Cette configuration
	 * est trop permissive dans un cadre professionnel mais servira pour les exemples.
	 * @return
	 */
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}

}