package com.neo.trainer.serviceimp.login;


import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.stereotype.Component;
import com.neo.trainer.model.login.User;
import com.neo.trainer.model.onlinetest.Candidate;
import com.neo.trainer.service.login.LoginService;
import com.neo.trainer.service.onlinetest.LoginCandidateService;

// TODO: Auto-generated Javadoc
//@Service("authMgr")
//@Configuration
/**
 * The Class CustomAuthenticationProvider.
 */
@Component("authenticationProvider")
public class CustomAuthenticationProvider implements AuthenticationProvider {

	/** The Constant AUTHORITIES. */
	static final List<GrantedAuthority> AUTHORITIES = new ArrayList<GrantedAuthority>();

	/** The Constant log. */
	private static final Logger log = LoggerFactory
			.getLogger(CustomAuthenticationProvider.class);
	// TODO Auto-generated constructor stub

	/** The login serv. */
	@Autowired
	LoginService loginServ;

	/** The candlogin serv. */
	@Autowired
	LoginCandidateService candloginServ;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.authentication.AuthenticationProvider#
	 * authenticate(org.springframework.security.core.Authentication)
	 */

	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		  
		// TODO Auto-generated method stub
		Candidate c=null;
		log.info("at custom authenticaton provider" + loginServ);
		UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;
		String username = String.valueOf(auth.getPrincipal());
		String password = String.valueOf(auth.getCredentials());
		if (username.trim().length() < 1) {
			throw new BadCredentialsException("User name is required ");
		}

		if (password.trim().length() < 1) {
			throw new BadCredentialsException("Password is required ");
		}

		log.info("\n\nusername: " + username + "password: " + password);
		log.info("\n\nusername: " + username + "password: "
				+ password);
		User u = loginServ.getUser(username);
		if(u==null)
			throw new BadCredentialsException("Invalid user name and password");
		if(!u.getPassword().equals(password))  
		{        
			throw new BadCredentialsException("Invalid user name and password");
		}   
		if(u==null){
		   
			 c = candloginServ.getCand(username);
		}
		
		if (AUTHORITIES != null) {
			log.info("AUTHORITIES: " + AUTHORITIES.size());
			AUTHORITIES.clear();
			log.info("AUTHORITIES.size(): after clearing---------->"
					+ AUTHORITIES.size()); 
		}
		if (u != null && password.equals(u.getPassword())) {
			
			List<String> list_role = loginServ.getUserRoles(u);
			for (int i = 0; i < list_role.size(); i++) { 
				System.out.println("");
				AUTHORITIES.add(new GrantedAuthorityImpl(list_role.get(i)));
			 
			}

		} else if (c != null && password.equals(c.getPassword())) {
			 
			//AUTHORITIES.add(new GrantedAuthorityImpl("Cand_User"));
		} else {
			throw new BadCredentialsException(
					"Username/Password does not match for "
							+ auth.getPrincipal());

		}
  
		log.info("AUTHORITIES: " + AUTHORITIES);
		return new UsernamePasswordAuthenticationToken(username, password,
				AUTHORITIES);
	} 

	/**
	 * Supports.
	 * 
	 * @param authentication
	 *            the authentication
	 * @return true, if successful
	 */

	public boolean supports(Class<? extends Object> authentication) {
		// TODO Auto-generated method stub
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
