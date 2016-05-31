/**
 * 
 */
package com.cn;

import java.security.AccessController;
import java.security.AuthProvider;
import java.security.PrivilegedAction;
import java.security.SecurityPermission;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;

/**
 * @author onslaught_2014
 *
 */
public class MyProvider extends AuthProvider {
	
	private static String name = "MyProvider";  
	private static String info = "this is a test provider for keyStore";  
	private static double version = 1.0d;  
	
	public MyProvider() {  
        super(name, version, info); 
                //ÊÚÈ¨  
        AccessController.doPrivileged(new PrivilegedAction<Object>() {  
            @Override  
            public Object run() {  
                put("KeyStore.MyKeyStore", "com.cn.MyKeyStore");
                return null;  
            }  
  
        });  
  
    }  

	protected MyProvider(String name, double version, String info) {
		super(name, version, info);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 4410425943260879003L;

	@Override
	public void login(Subject subject, CallbackHandler handler)
			throws LoginException {
		 SecurityManager sm = System.getSecurityManager();  
	        sm.checkPermission(new SecurityPermission("authProvider."  
	                + this.getName()));  
		
	}

	@Override
	public void logout() throws LoginException {
		
	}

	@Override
	public void setCallbackHandler(CallbackHandler handler) {
		
	}

}