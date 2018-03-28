package lt.train.spotting.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import lt.train.spotting.users.UserRepository;

@EnableGlobalMethodSecurity(prePostEnabled=true)
//@EnableGlobalMethodSecurity(securedEnabled=true,prePostEnabled=true) //sitas yra is ITakademijos
@EnableWebSecurity
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@Configuration
@EnableAspectJAutoProxy
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	private CustomUserDetailsService userDetailsServ;
	
	//copy-paste tiesiai is internetinio pvz. Paziuret, kuo ji pakeisti
	private static String REALM="MY_TEST_REALM";
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsServ)
			.passwordEncoder(new PasswordEncoder() {
			//cia paimtas a la passencoderis, kuris is tikruju nieko rimto nedaro. 
				//norint galima apsirasyti savo passencoderi
				//ir dar galima juos issikelti i 2 isorinius atskirus metodus
				@Override
				public String encode(CharSequence charSequence) {
					return charSequence.toString();
				}
				
				@Override
				public boolean matches(CharSequence arg0, String arg1) {
					// TODO Auto-generated method stub
					return true;
				}
			});
	}
	
	@Override
	protected void configure (HttpSecurity http) throws Exception{
		http.csrf().disable()
			.authorizeRequests()
				.antMatchers("/", "/swagger-ui.html").permitAll()	
				.antMatchers("/trains/**").authenticated()//.hasRole("ADMIN")
			//virsuje jis cia pasako, kad jei ateini iki linkucio, kur yra
			//"trains" url'e, tai tu ten tada padaryk autentikacija. O visi kiti
			//requestai (zemiau einantys), leisk arba kai prisijunges, arba leisk viksa
				.antMatchers("/vagons/**").authenticated()
				.anyRequest().permitAll()
			.and()
			.httpBasic().realmName(REALM).authenticationEntryPoint(getBasicAuthEntryPoint())
			.and()
			. sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		//zemiau einantys buvo paimti is youtube tutorialso, katrie buvo pakeisti above reikalu
//			.and()
//			formLogin().permitAll() //sitas nuves tiesiai i Spring logina. Jei noriu i savo: formLogin().loginPage("mano psl url").permitAll();
			.and()
			.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");
		
		http.exceptionHandling().accessDeniedPage("/403");
		http.headers().frameOptions().disable();
		
		//P.S. Neuzmirsk pt nueit i kontroleri ir sudet @PreAuthorize 
	}
	
	public CustomBasicAuthenticationEntryPoint getBasicAuthEntryPoint() {
		return new CustomBasicAuthenticationEntryPoint();
	}
	
	
}
