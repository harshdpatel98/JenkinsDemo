package com.harsh.salesforce;

public class Test {
	
	static String test = "<p>Google Email and Apps is TIU's standard for email, calendaring, document storage, mobile integration, and team collaboration.<strong>Login using your TIU username and password</strong>. To reset passwords visit&nbsp;<a href=\"https://password.tiu.edu\" target=\"_blank\" rel=\"noopener\">password.tiu.edu</a> .&nbsp;</p>\r\n" + 
			"<div id=\"ldapName_present\">Your email address is [ldap]@tiu.edu. Your password is only known by the user.</div>\r\n" + 
			"<div id=\"ldapName_absence\"><em>Your email address is pending.</em> It will be available shortly and you will be emailed when your personal credentials have been created.</div>";
	
	public static void main(String[] args) {
		
		String send = "Your email address is [ldap]@tiu.edu. Your password is only known by the user.";
	
		test = test.replaceAll(send,"");
		
		System.out.println(test);
		
	}
	

}
