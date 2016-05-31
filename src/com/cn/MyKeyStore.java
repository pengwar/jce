/**
 * 
 */
package com.cn;

import java.security.KeyStore;
import java.security.KeyStoreSpi;
import java.security.Provider;

/**
 * @author onslaught_2014
 *
 */
public class MyKeyStore extends KeyStore {

	protected MyKeyStore(KeyStoreSpi keyStoreSpi, Provider provider, String type) {
		super(keyStoreSpi, provider, type);
	}

}
