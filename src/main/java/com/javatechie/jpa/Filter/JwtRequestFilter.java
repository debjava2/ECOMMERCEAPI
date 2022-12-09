package com.javatechie.jpa.Filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.javatechie.jpa.Util.JwtUti;
import com.javatechie.jpa.service.CustomUserDeatilService;
import com.sun.net.httpserver.Filter.Chain;


@Component
public class JwtRequestFilter extends OncePerRequestFilter{
	@Autowired
	private CustomUserDeatilService myUserDetailService;
	@Autowired
	private JwtUti jwUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		final String authorizationHeader=request.getHeader("Authorization");
		
		String username=null;
		String jwt=null;
		if(authorizationHeader!=null && authorizationHeader.startsWith("Bearer")) {
			jwt=authorizationHeader.substring(7);
			username=jwUtil.extractUsername(jwt);
		}
		
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			UserDetails userDetails=this.myUserDetailService.loadUserByUsername(username);
			if(jwUtil.validateToken(jwt, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
						new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.
				setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		filterChain.doFilter(request, response);
	}

}
