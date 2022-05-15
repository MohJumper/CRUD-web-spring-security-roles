package com.management;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class EncodingPassword {

	public static void main(String[] args) {
		encrypt_password ();

	}
	
	public static void encrypt_password () {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		String encodedPassword = passwordEncoder.encode("spock");
		
		System.out.println(encodedPassword);
	}


}
