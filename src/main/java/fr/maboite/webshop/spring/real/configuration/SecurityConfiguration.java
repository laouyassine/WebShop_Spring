package fr.maboite.webshop.spring.real.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//@Configuration
//@EnableWebSecurity
/*@EnableMethodSecurity(
        prePostEnabled = true,  // Enables @PreAuthorize and @PostAuthorize
        securedEnabled = true, // Enables @Secured 
        jsr250Enabled = true    // Enables @RolesAllowed (Ensures JSR-250 annotations are enabled)
 )*/
public class SecurityConfiguration {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		// Réutilisation de HttpSecurity fourni par SpringSecurity
		http
				.authorizeHttpRequests(requests -> requests
						// / et /home peuvent être requêtées par tout le monde
						.requestMatchers("/", "/home").permitAll()
						// Toute autre requête ne peut être émise que par une personne
						// authentifiée
						.requestMatchers("/ws").authenticated()
						.anyRequest().authenticated())
				// la page de login est accessible via /login
				// et est accessible par tout le monde
				.formLogin(form -> form
						.loginPage("/login")
						.permitAll())
				// La page de logout est aussi accessible
				// par tout le monde
				.logout(logout -> logout.logoutUrl("/logout")
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET")).permitAll());
		return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		// La méthode ci-dessous est dépréciée : il n'est pas conseillé
		// de mettre en dur un login et un mot de passe, mais de
		// récupérer un utilisateur d'une base de données, ou d'un
		// référentiel d'utilisateurs (annuaire LDAP)
		@SuppressWarnings("deprecation")
		UserDetails user = User.withDefaultPasswordEncoder()
				.username("user")
				.password("password")
				.authorities("USER")
				.build();
		// Renvoie une implémentation de UserDetailsService
		// qui stocke les utilisateurs en mémoire (ici, un seul utilisateur)
		return new InMemoryUserDetailsManager(user);
	}

}