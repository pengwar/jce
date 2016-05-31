/**
 * 
 */
package com.cn;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;

/**
 * @author onslaught_2014
 *
 */
public class Test {

	/**
	 * @param args
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws KeyStoreException 
	 */
	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException, KeyStoreException {
		MyProvider mp = new MyProvider();
		Security.addProvider(mp);
		KeyStore ks = KeyStore.getInstance("MyKeyStore", mp);

	}

}
