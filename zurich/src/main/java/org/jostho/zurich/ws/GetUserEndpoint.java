package org.jostho.zurich.ws;

import org.jostho.zurich.domain.User;
import org.jostho.zurich.jaxb.GetUserRQ;
import org.jostho.zurich.jaxb.GetUserRS;
import org.jostho.zurich.jaxb.UserType;
import org.jostho.zurich.service.UserService;
import org.springframework.oxm.Marshaller;
import org.springframework.ws.server.endpoint.AbstractMarshallingPayloadEndpoint;

public class GetUserEndpoint extends AbstractMarshallingPayloadEndpoint{

	private UserService userService;
	
	private Marshaller marshaller;

	public GetUserEndpoint(UserService userService, Marshaller marshaller) {
		super(marshaller) ;
		this.userService = userService ;
	}

	/*
	 * This is the entry point to the application. Trace the flow from here 
	 * 
	 * @see org.springframework.ws.server.endpoint.AbstractMarshallingPayloadEndpoint#invokeInternal(java.lang.Object)
	 */
	@Override
	protected Object invokeInternal(Object input) throws Exception {
		GetUserRQ request = (GetUserRQ) input ;
		
		User user = userService.getUser(request.getUserId()); 
		
		GetUserRS response = new GetUserRS() ;
		response.setUser(buildUserType(user)) ;	
				
		return response ; 
	}


	/*
	 * Mapping from User to UserType
	 */
	private UserType buildUserType(User user) {
		UserType userType = new UserType() ;
		if(user != null) {
			userType.setUserId(user.getId()) ;
			userType.setFirstName(user.getFirstName()) ;
			userType.setLastName(user.getLastName()) ;
			userType.setEmail(user.getEmail()) ;
		}
		
		return userType;
	}

}
