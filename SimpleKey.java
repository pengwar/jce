/**
 * 
 */
package com.cn.test.provider;

import java.security.SecureRandom;

import javax.crypto.SecretKey;

/**
 * @author onslaught_2014
 *
 */
public class SimpleKey implements SecretKey {
    /**
	 * 
	 */
	private static final long serialVersionUID = 2912959605432725456L;
	protected int len;  
    protected SecureRandom random;  
    protected int offset;  

    SimpleKey(SecureRandom random, int keySize,int offset) {  
        this.len = keySize;  
        this.random = random;  
        this.offset = offset;  
    }  
    @Override  
    public String getAlgorithm() {  
        return "Simple";  
    }  
  
    @Override  
    public String getFormat() {  
        return "";  
    }  
  
    @Override  
    public byte[] getEncoded() {  
        byte[] b = new byte[len];  
        random.nextBytes(b);  
        return b;  
    }  

}
