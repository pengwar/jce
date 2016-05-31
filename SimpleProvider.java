/**
 * 
 */
package com.cn.test.provider;

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
public class SimpleProvider extends AuthProvider {

	/**
	 * 
	 */
	private static final long serialVersionUID = -52376285955734686L;

	private static String name = "SimpleProvider";

	private static double version = 1.0d;

	private static String info = "just for test";
	
	public SimpleProvider(){
		super(name, version, info);
		AccessController.doPrivileged(new PrivilegedAction<Object>() {
			@Override
			public Object run() {
				// 放入自己的基础实现类
				// 格式：类型.算法
				put("KeyGenerator.SimpleKeyGenerator", "com.cn.test.provider.SimpleKeyGenerator");
				put("SecretKey.SimpleKey", "com.cn.test.provider.SimpleKey");
				return null;
			}
		});
	}

	public String getName() {  
        return name;  
    }  
  
    public String getInfo() {  
        return info;  
    }  
  
    public double getVersion() {  
        return version;  
    }  
  
    public static interface Tst {  
    }  
  
    @Override  
    public void login(Subject subject, CallbackHandler handler)  
            throws LoginException {  
        SecurityManager sm = System.getSecurityManager();  
        sm.checkPermission(new SecurityPermission(this.getName()));  
    }  
  
    @Override  
    public void logout() throws LoginException {  
  
    }  
  
    @Override  
    public void setCallbackHandler(CallbackHandler handler) {
  
    };  

}
