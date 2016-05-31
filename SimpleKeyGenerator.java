/**
 * 
 */
package com.cn.test.provider;

import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.KeyGeneratorSpi;
import javax.crypto.SecretKey;

/**
 * @author onslaught_2014
 *
 */
public class SimpleKeyGenerator extends KeyGeneratorSpi {

	private SecureRandom random = new SecureRandom();  
    private int keySize = 128;  
    private int offset = 3;  
    @Override  
    protected SecretKey engineGenerateKey() {  
        offset = random.nextInt();  
        return new SimpleKey(random,keySize,offset);  
    }  
  
    @Override  
    protected void engineInit(SecureRandom secureRandom) {  
        this.random = secureRandom;  
    }  
  
    @Override  
    protected void engineInit(AlgorithmParameterSpec arg0, SecureRandom arg1)  
            throws InvalidAlgorithmParameterException {  
        throw new InvalidAlgorithmParameterException("no support operation");  
    }  
  
    @Override  
    protected void engineInit(int keySize, SecureRandom secureRandom) {  
        this.keySize = keySize;  
        this.random = secureRandom;  
    }  

}
