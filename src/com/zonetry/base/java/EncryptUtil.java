package com.zonetry.base.java;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;

import com.zonetry.base.util.Log;
 

/**
 * <P>加密／解密工具</P>
 * @author Richard
 * @version 1.0.0
 * @since 1.0.0
 */
public final class EncryptUtil {


	
	private final static String MD5 = "MD5";
	private final static String HMAC_SHA1 = "HmacSHA1";
	private final static String DES = "DES";
	private static SecretKeyFactory DES_SECRET_KEY_FACTORY;
	private final static String DES_KEY = "!q@w#e$r%t^y&u*i1A2S3D4F5G6H7J8K";
	private final static byte[] DES_KEY_BYTES = DES_KEY.getBytes(StandardCharsets.UTF_8);
	private static SecretKey DES_SECRET_KEY;
	private final static char[] HEXS = {
		'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'
	};
	
	static {
		//DES加密算法初始化
		try {
			DES_SECRET_KEY_FACTORY = SecretKeyFactory.getInstance(DES);
			DESKeySpec keyspec = new DESKeySpec(DES_KEY_BYTES);
			DES_SECRET_KEY = DES_SECRET_KEY_FACTORY.generateSecret(keyspec);
		} catch(InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException e) {
			Log.e("Failed to create DES key spec.", e);
		}
	}
	
	/**********************************************************************************
	 * <PRE>
	 * MD5加密。
	 * 参数为NULL时, 返回NULL。
	 * 加密失败时, 返回NULL。
	 * </PRE>
	 * @param source 未加密字符串
	 * @return 已加密字符串
	 *********************************************************************************/
	public static String encryptMD5(String source) {
		if(source == null) {
			return null;
		}
		try {
			//MD5摘要算法
			MessageDigest md = MessageDigest.getInstance(MD5);
			
			//更新摘要
			byte[] src = source.getBytes(StandardCharsets.UTF_8);
			md.update(src);
			
			//密文
			byte[] target = md.digest();
			
			//密文转换成十六进制
			final int SIZE = target.length;
			int n = 0;
			char[] result = new char[SIZE * 2];
			
			for(int i = 0; i < SIZE; i++) {
				byte b = target[i];
				result[n++] = HEXS[b >>> 4 & 0xf];
				result[n++] = HEXS[b & 0xf];
			}
			
			return new String(result);
			
		} 
		catch(Exception e) {
			return null;
		}
	}
	
	/**********************************************************************************
	 * <P>计算HMAC-SHA1签名(使用UTF-8编码)</P>
	 * @param data 计算签名的数据
	 * @param key 计算签名时使用的KEY
	 * @return 
	 *********************************************************************************/
	public final static byte[] hmacSha1(String data, String key) {
		try {
			SecretKeySpec signKey = new SecretKeySpec(
				key.getBytes(StandardCharsets.UTF_8), 
				HMAC_SHA1
			);
			Mac mac = Mac.getInstance(HMAC_SHA1);
			mac.init(signKey);
			return mac.doFinal(data.getBytes(StandardCharsets.UTF_8));
		} catch(NoSuchAlgorithmException | InvalidKeyException | IllegalStateException e) {
			Log.e("Failed to caculate HMAC-SHA1 signature.", e);
			return null;
		}
	}
	
	/**********************************************************************************
	 * <PRE>
	 * 使用系统默认秘钥进行 DES 加密.
	 * 失败时, 返回 NULL .
	 * </PRE>
	 * @param source
	 * @return 
	 *********************************************************************************/
	public final static String encryptDES(String source) {
		if(source == null) {
			return null;
		}
		try {
			// DES加密
			Cipher cipher = Cipher.getInstance(DES);
			cipher.init(Cipher.ENCRYPT_MODE, DES_SECRET_KEY, new SecureRandom());
			byte[] bytes = cipher.doFinal(source.getBytes(StandardCharsets.UTF_8));
			
			//转换成Base64格式
			return Base64.getEncoder().encodeToString(bytes);
		} 
		catch ( NoSuchAlgorithmException | 
				NoSuchPaddingException | 
				InvalidKeyException | 
				IllegalBlockSizeException | 
				BadPaddingException | 
				RuntimeException e) {
			Log.e("Failed to encrypt by DES.", e);
		}
		return null;
	}
	
	/**********************************************************************************
	 * <PRE>
	 * 使用指定安全密钥进行DES加密.
	 * 失败时返回 NULL .
	 * </PRE>
	 * @param source
	 * @param secretKey 安全密钥
	 * @return 
	 *********************************************************************************/
	public final static String encryptDES(String source, String secretKey) {
		if(source == null || secretKey == null) {
			return null;
		}
		try {
			// DES加密
			DESKeySpec keyspec = new DESKeySpec(secretKey.getBytes(StandardCharsets.UTF_8));
			SecretKey key = DES_SECRET_KEY_FACTORY.generateSecret(keyspec);
			
			Cipher cipher = Cipher.getInstance(DES);
			cipher.init(Cipher.ENCRYPT_MODE, key, new SecureRandom());
			byte[] bytes = cipher.doFinal(source.getBytes(StandardCharsets.UTF_8));
			
			//转换成Base64格式
			return Base64.getEncoder().encodeToString(bytes);
		} 
		catch ( NoSuchAlgorithmException | 
				NoSuchPaddingException | 
				InvalidKeyException | 
				IllegalBlockSizeException | 
				BadPaddingException | 
				InvalidKeySpecException |
				RuntimeException e) {
			Log.e("Failed to encrypt by DES.", e);
		} 
		return null;
	}
	
	/**********************************************************************************
	 * <PRE>
	 * 使用系统默认秘钥进行 DES 解密.
	 * 失败时, 返回 NULL .
	 * </PRE>
	 * @param source
	 * @return 
	 *********************************************************************************/
	public final static String decryptDES(String source) {
		if(source == null) {
			return null;
		}
		try {
			byte[] bytes = Base64.getDecoder().decode(source);
			Cipher cipher = Cipher.getInstance(DES);
			cipher.init(Cipher.DECRYPT_MODE, DES_SECRET_KEY, new SecureRandom());
			return new String(cipher.doFinal(bytes), StandardCharsets.UTF_8);
		} 
		catch ( NoSuchAlgorithmException | 
				NoSuchPaddingException | 
				InvalidKeyException | 
				IllegalBlockSizeException | 
				BadPaddingException | 
				RuntimeException e) {
			Log.e("Failed to decrypt by DES.", e);
		}
		return null;
	}
	
	/**********************************************************************************
	 * <PRE>
	 * 使用指定安全密钥进行DES解密.
	 * 失败时返回 NULL .
	 * </PRE>
	 * @param source
	 * @param secretKey 安全密钥
	 * @return 
	 *********************************************************************************/
	public final static String decryptDES(String source, String secretKey) {
		if(source == null || secretKey == null) {
			return null;
		}
		try {
			byte[] bytes = Base64.getDecoder().decode(source);
			
			DESKeySpec keyspec = new DESKeySpec(secretKey.getBytes(StandardCharsets.UTF_8));
			SecretKey key = DES_SECRET_KEY_FACTORY.generateSecret(keyspec);
			
			Cipher cipher = Cipher.getInstance(DES);
			cipher.init(Cipher.DECRYPT_MODE, key, new SecureRandom());
			
			return new String(cipher.doFinal(bytes), StandardCharsets.UTF_8);
		} 
		catch ( NoSuchAlgorithmException | 
				NoSuchPaddingException | 
				InvalidKeyException | 
				IllegalBlockSizeException | 
				BadPaddingException | 
				InvalidKeySpecException |
				RuntimeException e) {
			Log.e("Failed to decrypt by DES.", e);
		}
		return null;
	}
	
	/**********************************************************************************
	 * <P>获取DES算法的系统默认秘钥</P>
	 * @return 
	 *********************************************************************************/
	public final static String getDESKey() {
		return DES_KEY;
	}
	
	/**********************************************************************************
	 * <P>获取DES算法的系统默认秘钥</P>
	 * @return 
	 *********************************************************************************/
	public final static byte[] getDESKeyBytes() {
		return DES_KEY_BYTES;
	}
	

    /**
     * 默认的加密方法
	 * @param source
	 * @return
	 */
	public final static String encrypt(String source) {

		return encryptDES(source,getDESKey());
	}

	/**
	 * 默认的解密方法
	 * @param source
	 * @return
     */
	public final static String decrypt(String source) {
		return decryptDES(source,getDESKey());
	}
}
