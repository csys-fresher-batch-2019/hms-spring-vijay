package com.vijaysankar.hmgsystems.mail;

import java.io.IOException;
import java.time.LocalDate;

public class Testconfirm {
	public static void main(int appid, int patientid, int doctorid, LocalDate appdate, String apptime, String mail) throws IOException {
		String subject ="This is to remind you of your hospital appointment";
		Mail.send("multihospitalmanagement@gmail.com","hmgsystems458191",mail, subject,appid,patientid,doctorid,appdate,apptime);		
	}
}
