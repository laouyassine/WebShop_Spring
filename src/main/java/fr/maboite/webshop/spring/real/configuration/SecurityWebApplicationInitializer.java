package fr.maboite.webshop.spring.real.configuration;

/**
 * Ajoute springSecurityFilterChain pour chacune des URLs traitées
 * par l'application
 */
public class SecurityWebApplicationInitializer /* extends AbstractSecurityWebApplicationInitializer */ {

	// @Override
	protected boolean enableHttpSessionEventPublisher() {
		return true;
	}

}