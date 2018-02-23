/**   
 * Copyright © 2018 
 * @Package: com.example.demo   
 * @date: 2018年2月23日 下午1:49:47 
 */
package com.example.demo;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import org.junit.Test;
import com.example.utils.RSA.Base64Utils;
import com.example.utils.RSA.RSAUtils;
import com.example.utils.RSA.SecurityUtils;

/**
 * 
 * @Description:rsa测试 
 * @author: cmk
 * @date:   2018年2月23日 下午1:55:15
 */

public class RSATest {
	
	@Test
	public void create() throws Exception {
//    RSAUtils.createSecretKey();
    String content ="太阳当空照";
    String publicString="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCIRVveclvnZC96Z0kYrPTmRr+TfPUlBja4Xsz+Ly4D97F6b1/+OflYhDaetUnC8PyHkPdHltud/JhisibzG8JfHUdrEySpPPhIMoAQEmHDfsZ9Kz/WYhfivd+Q2LKRtp+FoKZ6Is6B0la25wBxZeoykMAZbqpN0elafP0Z8u8msQIDAQAB";
    String privateString="MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAIhFW95yW+dkL3pnSRis9OZGv5N89SUGNrhezP4vLgP3sXpvX/45+ViENp61ScLw/IeQ90eW2538mGKyJvMbwl8dR2sTJKk8+EgygBASYcN+xn0rP9ZiF+K935DYspG2n4WgpnoizoHSVrbnAHFl6jKQwBluqk3R6Vp8/Rny7yaxAgMBAAECgYBebNEv3sZYHE/Z3WAFPTOlrThqlpe3xAp+zxH0v/R+w0+zqyE1JC7naxX9+1jVP+98cLMoZBxh6PoeyZu7sWyJPZbGtolZuM0LXaJV8t+y3oVFvUZq4gbNPA6JnEdMsOxC2ALX6y5o/l1XRA8FequJ19Ogh9q1yI0m0d1wL6BAAQJBANu87xnxru+W+BSTdEdHxqeU5Yq6MUjKEvifi+nVIt6UUiHGRydsz3nGSJ4uyYTwnADhUhtWu5M/SWGgVHOmv7ECQQCewkTg6dO1Z/bI549W5Y0Y5qj/f3z1fImap/YUcv7orfwF9TzkZBX8cBvWR3dX9fo1xzw+2ywfwWigIUxEZ5cBAkA2x4kL/LZRwF8kMgZg5sHdcT8wMG6s6MOF+7BToPDKcEtxZA7FA1lN0GK2HI/cdmdNyN5BNoQYl0Rh9ChZlI5hAkBQeII3Su5/vhHOJel3D2XkoE47K6DoQdbx6H8IQH3K7R2Y24Sg88ZdLWo+w/zPPiQ0jCeSaL/F3OAugpJI/gUBAkBfcYoB9+VY5VbGkTI96x5YTW6rR54sGn1SiuHKT/Om9repR764ya9qC5a6dZGafQ19F0+kWEAfCFN0AMo7MVgY";
    PublicKey publicKey =RSAUtils.loadPublicKey(publicString);
    byte[] enc =RSAUtils.encryptData(content.getBytes(), publicKey);
    String encString =Base64Utils.encode(enc);
    System.out.println("加密后："+encString);
    PrivateKey privateKey =RSAUtils.loadPrivateKey(privateString);
    byte[] dec = RSAUtils.decryptData(Base64Utils.decode(encString), privateKey);	
    String decString =new String(dec);
    System.out.println("解密后："+decString);
	}
	
	
	@Test
	public void createFile() {
		SecurityUtils.createSecretKeyFile("E:\\rsa");
	}
	
	/**
	 * 加密解密（文件）
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		String plainTest="十步杀一人，千里不留痕";
		String publicPath ="E:\\rsa\\publicKey.keystore";
		String privatePath ="E:\\rsa\\privateKey.keystore";
		String encString = SecurityUtils.encryptByPublicFile(plainTest, publicPath);
		System.out.println("密文："+encString);
		String decString =SecurityUtils.decryptByPrivateFile(encString, privatePath);
		System.out.println("解密后的明文："+decString);
	}
	
	/**
	 * 加密解密（String）
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception {
		String plainTest="十步杀一人，千里不留痕";
		String publicString ="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCY3TsAHS9cITCgocOU2t3zbMvsHTPE2gxoJhOkAx6b4k17IVasqVGJl4I414dpj/IqpKiFGUgykbKmq438B1ioi/mD+sRw4++wLGfay4y8rTPAZFrIfHCJHuBLSq3dlMfj6AP0wXg+/Hi+e5FR5VYIY133N2S3W0B+7TgMgGd+9QIDAQAB";
		String privateString ="MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAJjdOwAdL1whMKChw5Ta3fNsy+wdM8TaDGgmE6QDHpviTXshVqypUYmXgjjXh2mP8iqkqIUZSDKRsqarjfwHWKiL+YP6xHDj77AsZ9rLjLytM8BkWsh8cIke4EtKrd2Ux+PoA/TBeD78eL57kVHlVghjXfc3ZLdbQH7tOAyAZ371AgMBAAECgYBJlKPjyCiV1jwL9hGowzl3BPWbr+rNZI/4SevGVOIU8veMv11zOwVOj6lVJxm9TFarBBtCBgtknBE8fPOZTwfzSsPGzseV5lgNlHtFtkUh+E/VLgVhqWOxeTOl1oObzv9PlKGMdGR+tsNroZm1KZUfgbm8AHesktIgrSDTtbxWAQJBANDbwQTRBbmWXCDrEplyEkE70JLAl3wCshc8MHTbtyXkpGzyt/q44lGekVlAwEMaLxp6IwxoPk3Db1PQH/mi4MECQQC7XgVKEbLjNkmrXWhHT22o/vPQBf7T4djO03TQhKG6xXXzMdGoNe5r1DuaaGerAxUq4ufm++mfLpNQW4iPRbc1AkBAubmpmnVhvF00vmT3NMi/ep/6usC3Z8Z1OOvzaxvpHGBwew/VHXLVxIRa2pw6r2SlmfA+qheU1dosaTVfkcCBAkBq5i6gXs6wQZXwdl97Z/7Jz4QtaG5GVvGKtyxLl5BqbiRod0EF9pcr4C+NXgnfkOevyzvCFnHpBvq3ezHDhGQNAkB/NKDGaVg+Z3qz0P7mFqSXnlqVUxmGRc9XOuEsAZC4ykYqsPMQJ0rWPhZRm7DAIWhOwaDgqh4ZVVk07EY6Z/JZ";
		String encString = SecurityUtils.encryptByPublicString(plainTest, publicString);
		System.out.println("密文："+encString);
		String decString =SecurityUtils.decryptByPrivateString(encString, privateString);
		System.out.println("解密后的明文："+decString);
	}
	
	

}
