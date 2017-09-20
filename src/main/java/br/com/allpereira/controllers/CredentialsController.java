package br.com.allpereira.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.allpereira.models.User;
import br.com.allpereira.security.CredentialsSecurityService;
import br.com.allpereira.services.UserService;
import br.com.allpereira.utils.JsonResult;
import br.com.allpereira.utils.JsonResult.JsonResultCode;

@RestController
@RequestMapping(value = "/credentials")
public class CredentialsController {

    @Autowired
    UserService userService;

    @Autowired
    CredentialsSecurityService credentialsSecurityService;
    
    
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<JsonResult> verifyCredentials(@RequestBody User user) {
    	User authorizedUser = credentialsSecurityService.authorize(user);
    	
    	if(authorizedUser != null) {
    		String base64 = new String( Base64.encode( (authorizedUser.getFederalID()+":"+user.getPassword()).getBytes() ) );
    		
    		return new ResponseEntity<>(new JsonResult(base64, authorizedUser, JsonResultCode.SUCCESS), HttpStatus.OK);
    	} else {
    		return new ResponseEntity<>(new JsonResult("Seu usuário ou senha estão incorretos.", null, JsonResultCode.DONE) ,HttpStatus.UNAUTHORIZED);
    	}
    	
    }
    
}
