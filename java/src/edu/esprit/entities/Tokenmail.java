/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

/**
 *
 * @author ahmed
 */
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class Tokenmail {

   public void sendtoken(String token,String mail) {    
      
    String host="ssl0.ovh.net";  
  final String user="ahmed@mega.tn";//change accordingly  
  final String password="ahmed1234";//change accordingly  
    
  String to=mail;//change accordingly  
  
   //Get the session object  
   Properties props = new Properties();  
   props.put("mail.smtp.host",host);  
   props.put("mail.smtp.auth", "true");  
     
   Session session = Session.getDefaultInstance(props,  
    new javax.mail.Authenticator() {  
      protected PasswordAuthentication getPasswordAuthentication() {  
    return new PasswordAuthentication(user,password);  
      }  
    });  
  
   //Compose the message  
    try {  
     MimeMessage message = new MimeMessage(session);  
     message.setFrom(new InternetAddress(user));  
     message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
     message.setSubject("Account Verification");  
     
    String content = new String("<!DOCTYPE html>\n" +
"<html xmlns:v='urn:schemas-microsoft-com:vml' xmlns:o='urn:schemas-microsoft-com:office:office' lang='en'>\n" +
"\n" +
"<head>\n" +
"	<title></title>\n" +
"	<meta http-equiv='Content-Type' content='text/html; charset=utf-8'>\n" +
"	<meta name='viewport' content='width=device-width, initial-scale=1.0'>\n" +
"	<!--[if mso]><xml><o:OfficeDocumentSettings><o:PixelsPerInch>96</o:PixelsPerInch><o:AllowPNG/></o:OfficeDocumentSettings></xml><![endif]-->\n" +
"	<style>\n" +
"		* {\n" +
"			box-sizing: border-box;\n" +
"		}\n" +
"\n" +
"		body {\n" +
"			margin: 0;\n" +
"			padding: 0;\n" +
"		}\n" +
"\n" +
"		a[x-apple-data-detectors] {\n" +
"			color: inherit !important;\n" +
"			text-decoration: inherit !important;\n" +
"		}\n" +
"\n" +
"		#MessageViewBody a {\n" +
"			color: inherit;\n" +
"			text-decoration: none;\n" +
"		}\n" +
"\n" +
"		p {\n" +
"			line-height: inherit\n" +
"		}\n" +
"\n" +
"		.desktop_hide,\n" +
"		.desktop_hide table {\n" +
"			mso-hide: all;\n" +
"			display: none;\n" +
"			max-height: 0px;\n" +
"			overflow: hidden;\n" +
"		}\n" +
"\n" +
"		.image_block img+div {\n" +
"			display: none;\n" +
"		}\n" +
"\n" +
"		.menu_block.desktop_hide .menu-links span {\n" +
"			mso-hide: all;\n" +
"		}\n" +
"\n" +
"		@media (max-width:700px) {\n" +
"\n" +
"			.desktop_hide table.icons-inner,\n" +
"			.social_block.desktop_hide .social-table {\n" +
"				display: inline-block !important;\n" +
"			}\n" +
"\n" +
"			.icons-inner {\n" +
"				text-align: center;\n" +
"			}\n" +
"\n" +
"			.icons-inner td {\n" +
"				margin: 0 auto;\n" +
"			}\n" +
"\n" +
"			.fullMobileWidth,\n" +
"			.image_block img.big,\n" +
"			.row-content {\n" +
"				width: 100% !important;\n" +
"			}\n" +
"\n" +
"			.menu-checkbox[type=checkbox]~.menu-links {\n" +
"				display: none !important;\n" +
"				padding: 5px 0;\n" +
"			}\n" +
"\n" +
"			.menu-checkbox[type=checkbox]:checked~.menu-trigger .menu-open {\n" +
"				display: none !important;\n" +
"			}\n" +
"\n" +
"			.menu-checkbox[type=checkbox]:checked~.menu-links,\n" +
"			.menu-checkbox[type=checkbox]~.menu-trigger {\n" +
"				display: block !important;\n" +
"				max-width: none !important;\n" +
"				max-height: none !important;\n" +
"				font-size: inherit !important;\n" +
"			}\n" +
"\n" +
"			.menu-checkbox[type=checkbox]~.menu-links>a,\n" +
"			.menu-checkbox[type=checkbox]~.menu-links>span.label {\n" +
"				display: block !important;\n" +
"				text-align: center;\n" +
"			}\n" +
"\n" +
"			.menu-checkbox[type=checkbox]:checked~.menu-trigger .menu-close {\n" +
"				display: block !important;\n" +
"			}\n" +
"\n" +
"			.mobile_hide {\n" +
"				display: none;\n" +
"			}\n" +
"\n" +
"			.stack .column {\n" +
"				width: 100%;\n" +
"				display: block;\n" +
"			}\n" +
"\n" +
"			.mobile_hide {\n" +
"				min-height: 0;\n" +
"				max-height: 0;\n" +
"				max-width: 0;\n" +
"				overflow: hidden;\n" +
"				font-size: 0px;\n" +
"			}\n" +
"\n" +
"			.desktop_hide,\n" +
"			.desktop_hide table {\n" +
"				display: table !important;\n" +
"				max-height: none !important;\n" +
"			}\n" +
"		}\n" +
"\n" +
"		#memu-r7c0m2:checked~.menu-links {\n" +
"			background-color: #000000 !important;\n" +
"		}\n" +
"\n" +
"		#memu-r7c0m2:checked~.menu-links a,\n" +
"		#memu-r7c0m2:checked~.menu-links span {\n" +
"			color: #ffffff !important;\n" +
"		}\n" +
"	</style>\n" +
"</head>\n" +
"\n" +
"<body style='background-color: #fff0e3; margin: 0; padding: 0; -webkit-text-size-adjust: none; text-size-adjust: none;'>\n" +
"	<table class='nl-container' width='100%' border='0' cellpadding='0' cellspacing='0' role='presentation' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #fff0e3;'>\n" +
"		<tbody>\n" +
"			<tr>\n" +
"				<td>\n" +
"					<table class='row row-1' align='center' width='100%' border='0' cellpadding='0' cellspacing='0' role='presentation' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt;'>\n" +
"						<tbody>\n" +
"							<tr>\n" +
"								<td>\n" +
"									<table class='row-content stack' align='center' border='0' cellpadding='0' cellspacing='0' role='presentation' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 680px;' width='680'>\n" +
"										<tbody>\n" +
"											<tr>\n" +
"												<td class='column column-1' width='100%' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;'>\n" +
"													<div class='spacer_block' style='height:30px;line-height:30px;font-size:1px;'>&#8202;</div>\n" +
"												</td>\n" +
"											</tr>\n" +
"										</tbody>\n" +
"									</table>\n" +
"								</td>\n" +
"							</tr>\n" +
"						</tbody>\n" +
"					</table>\n" +
"					<table class='row row-2' align='center' width='100%' border='0' cellpadding='0' cellspacing='0' role='presentation' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt;'>\n" +
"						<tbody>\n" +
"							<tr>\n" +
"								<td>\n" +
"									<table class='row-content stack' align='center' border='0' cellpadding='0' cellspacing='0' role='presentation' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 680px;' width='680'>\n" +
"										<tbody>\n" +
"											<tr>\n" +
"												<td class='column column-1' width='33.333333333333336%' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;'>\n" +
"													<div class='spacer_block' style='height:0px;line-height:0px;font-size:1px;'>&#8202;</div>\n" +
"												</td>\n" +
"												<td class='column column-2' width='33.333333333333336%' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;'>\n" +
"													<table class='image_block block-1' width='100%' border='0' cellpadding='0' cellspacing='0' role='presentation' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt;'>\n" +
"														<tr>\n" +
"															<td class='pad' style='width:100%;padding-right:0px;padding-left:0px;'>\n" +
"																<div class='alignment' align='center' style='line-height:10px'><img src='https://d1oco4z2z1fhwp.cloudfront.net/templates/default/7631/logo_password_header.png' style='display: block; height: auto; border: 0; width: 147px; max-width: 100%;' width='147' alt='Company Logo' title='Company Logo'></div>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"												</td>\n" +
"												<td class='column column-3' width='33.333333333333336%' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;'>\n" +
"													<div class='spacer_block' style='height:0px;line-height:0px;font-size:1px;'>&#8202;</div>\n" +
"												</td>\n" +
"											</tr>\n" +
"										</tbody>\n" +
"									</table>\n" +
"								</td>\n" +
"							</tr>\n" +
"						</tbody>\n" +
"					</table>\n" +
"					<table class='row row-3' align='center' width='100%' border='0' cellpadding='0' cellspacing='0' role='presentation' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt;'>\n" +
"						<tbody>\n" +
"							<tr>\n" +
"								<td>\n" +
"									<table class='row-content stack' align='center' border='0' cellpadding='0' cellspacing='0' role='presentation' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 680px;' width='680'>\n" +
"										<tbody>\n" +
"											<tr>\n" +
"												<td class='column column-1' width='100%' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;'>\n" +
"													<div class='spacer_block' style='height:10px;line-height:10px;font-size:1px;'>&#8202;</div>\n" +
"												</td>\n" +
"											</tr>\n" +
"										</tbody>\n" +
"									</table>\n" +
"								</td>\n" +
"							</tr>\n" +
"						</tbody>\n" +
"					</table>\n" +
"					<table class='row row-4' align='center' width='100%' border='0' cellpadding='0' cellspacing='0' role='presentation' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt;'>\n" +
"						<tbody>\n" +
"							<tr>\n" +
"								<td>\n" +
"									<table class='row-content stack' align='center' border='0' cellpadding='0' cellspacing='0' role='presentation' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 680px;' width='680'>\n" +
"										<tbody>\n" +
"											<tr>\n" +
"												<td class='column column-1' width='100%' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;'>\n" +
"													<table class='image_block block-1' width='100%' border='0' cellpadding='0' cellspacing='0' role='presentation' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt;'>\n" +
"														<tr>\n" +
"															<td class='pad' style='width:100%;padding-right:0px;padding-left:0px;'>\n" +
"																<div class='alignment' align='center' style='line-height:10px'><img class='big' src='https://d1oco4z2z1fhwp.cloudfront.net/templates/default/7631/round_corner_top.png' style='display: block; height: auto; border: 0; width: 680px; max-width: 100%;' width='680' alt='Top round corners' title='Top round corners'></div>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"												</td>\n" +
"											</tr>\n" +
"										</tbody>\n" +
"									</table>\n" +
"								</td>\n" +
"							</tr>\n" +
"						</tbody>\n" +
"					</table>\n" +
"					<table class='row row-5' align='center' width='100%' border='0' cellpadding='0' cellspacing='0' role='presentation' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt;'>\n" +
"						<tbody>\n" +
"							<tr>\n" +
"								<td>\n" +
"									<table class='row-content stack' align='center' border='0' cellpadding='0' cellspacing='0' role='presentation' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffffff; color: #000000; width: 680px;' width='680'>\n" +
"										<tbody>\n" +
"											<tr>\n" +
"												<td class='column column-1' width='100%' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;'>\n" +
"													<table class='image_block block-1' width='100%' border='0' cellpadding='15' cellspacing='0' role='presentation' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt;'>\n" +
"														<tr>\n" +
"															<td class='pad'>\n" +
"																<div class='alignment' align='center' style='line-height:10px'><img class='fullMobileWidth' src='https://d1oco4z2z1fhwp.cloudfront.net/templates/default/7631/password_reset.png' style='display: block; height: auto; border: 0; width: 374px; max-width: 100%;' width='374' alt='Resetting Password' title='Resetting Password'></div>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"													<div class='spacer_block' style='height:35px;line-height:35px;font-size:1px;'>&#8202;</div>\n" +
"													<table class='heading_block block-3' width='100%' border='0' cellpadding='0' cellspacing='0' role='presentation' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt;'>\n" +
"														<tr>\n" +
"															<td class='pad' style='width:100%;text-align:center;'>\n" +
"																<h1 style='margin: 0; color: #101010; font-size: 27px; font-family: Arial, Helvetica Neue, Helvetica, sans-serif; line-height: 120%; text-align: center; direction: ltr; font-weight: normal; letter-spacing: normal; margin-top: 0; margin-bottom: 0;'><strong>Verify your account</strong></h1>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"												</td>\n" +
"											</tr>\n" +
"										</tbody>\n" +
"									</table>\n" +
"								</td>\n" +
"							</tr>\n" +
"						</tbody>\n" +
"					</table>\n" +
"					<table class='row row-6' align='center' width='100%' border='0' cellpadding='0' cellspacing='0' role='presentation' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt;'>\n" +
"						<tbody>\n" +
"							<tr>\n" +
"								<td>\n" +
"									<table class='row-content stack' align='center' border='0' cellpadding='0' cellspacing='0' role='presentation' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffffff; color: #000000; width: 680px;' width='680'>\n" +
"										<tbody>\n" +
"											<tr>\n" +
"												<td class='column column-1' width='16.666666666666668%' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;'>\n" +
"													<div class='spacer_block' style='height:0px;line-height:0px;font-size:1px;'>&#8202;</div>\n" +
"												</td>\n" +
"												<td class='column column-2' width='66.66666666666667%' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-top: 5px; padding-bottom: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;'>\n" +
"													<table class='text_block block-1' width='100%' border='0' cellpadding='0' cellspacing='0' role='presentation' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;'>\n" +
"														<tr>\n" +
"															<td class='pad' style='padding-bottom:10px;padding-left:20px;padding-right:10px;padding-top:10px;'>\n" +
"																<div style='font-family: sans-serif'>\n" +
"																	<div class style='font-size: 12px; mso-line-height-alt: 21.6px; color: #848484; line-height: 1.8; font-family: Arial, Helvetica Neue, Helvetica, sans-serif;'>\n" +
"																		<p style='margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 25.2px;'><span style='font-size:14px;'></span></p>\n" +
"																	</div>\n" +
"																</div>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"													<div class='spacer_block' style='height:10px;line-height:10px;font-size:1px;'>&#8202;</div>\n" +
"													<table class='button_block block-3' width='100%' border='0' cellpadding='10' cellspacing='0' role='presentation' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt;'>\n" +
"														<tr>\n" +
"															<td class='pad'>\n" +
"																<div class='alignment' align='center'>\n" +
"																	<!--[if mso]><v:roundrect xmlns:v='urn:schemas-microsoft-com:vml' xmlns:w='urn:schemas-microsoft-com:office:word' href='"+token+"' style='height:43px;width:160px;v-text-anchor:middle;' arcsize='10%' strokeweight='0.75pt' strokecolor='#101' fillcolor='#101'><w:anchorlock/><v:textbox inset='0px,0px,0px,0px'><center style='color:#ffffff; font-family:Arial, sans-serif; font-size:16px'><![endif]--><a href='"+token+"' target='_blank' style='text-decoration:none;display:inline-block;color:#ffffff;background-color:#101;border-radius:4px;width:auto;border-top:1px solid #101;font-weight:undefined;border-right:1px solid #101;border-bottom:1px solid #101;border-left:1px solid #101;padding-top:5px;padding-bottom:5px;font-family:Arial, Helvetica Neue, Helvetica, sans-serif;font-size:16px;text-align:center;mso-border-alt:none;word-break:keep-all;'><span style='padding-left:20px;padding-right:20px;font-size:16px;display:inline-block;letter-spacing:normal;'><span style='font-size: 16px; line-height: 2; word-break: break-word; mso-line-height-alt: 32px;'>Click here</span></span></a>\n" +
"																	<!--[if mso]></center></v:textbox></v:roundrect><![endif]-->\n" +
"																</div>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"													<div class='spacer_block' style='height:20px;line-height:20px;font-size:1px;'>&#8202;</div>\n" +
"												</td>\n" +
"												<td class='column column-3' width='16.666666666666668%' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-top: 5px; padding-bottom: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;'>\n" +
"													<div class='spacer_block' style='height:0px;line-height:0px;font-size:1px;'>&#8202;</div>\n" +
"												</td>\n" +
"											</tr>\n" +
"										</tbody>\n" +
"									</table>\n" +
"								</td>\n" +
"							</tr>\n" +
"						</tbody>\n" +
"					</table>\n" +
"					<table class='row row-7' align='center' width='100%' border='0' cellpadding='0' cellspacing='0' role='presentation' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt;'>\n" +
"						<tbody>\n" +
"							<tr>\n" +
"								<td>\n" +
"									<table class='row-content stack' align='center' border='0' cellpadding='0' cellspacing='0' role='presentation' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 680px;' width='680'>\n" +
"										<tbody>\n" +
"											<tr>\n" +
"												<td class='column column-1' width='100%' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;'>\n" +
"													<table class='image_block block-1' width='100%' border='0' cellpadding='0' cellspacing='0' role='presentation' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt;'>\n" +
"														<tr>\n" +
"															<td class='pad' style='width:100%;padding-right:0px;padding-left:0px;'>\n" +
"																<div class='alignment' align='center' style='line-height:10px'><img class='big' src='https://d1oco4z2z1fhwp.cloudfront.net/templates/default/7631/round_corner_bottom.png' style='display: block; height: auto; border: 0; width: 679px; max-width: 100%;' width='679' alt='Bottom round corners' title='Bottom round corners'></div>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"												</td>\n" +
"											</tr>\n" +
"										</tbody>\n" +
"									</table>\n" +
"								</td>\n" +
"							</tr>\n" +
"						</tbody>\n" +
"					</table>\n" +
"					<table class='row row-8' align='center' width='100%' border='0' cellpadding='0' cellspacing='0' role='presentation' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt;'>\n" +
"						<tbody>\n" +
"							<tr>\n" +
"								<td>\n" +
"									<table class='row-content stack' align='center' border='0' cellpadding='0' cellspacing='0' role='presentation' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 680px;' width='680'>\n" +
"										<tbody>\n" +
"											<tr>\n" +
"												<td class='column column-1' width='100%' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;'>\n" +
"													<div class='spacer_block' style='height:20px;line-height:20px;font-size:1px;'>&#8202;</div>\n" +
"													<table class='social_block block-2' width='100%' border='0' cellpadding='0' cellspacing='0' role='presentation' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt;'>\n" +
"														<tr>\n" +
"															<td class='pad' style='text-align:center;padding-top:10px;padding-right:10px;padding-bottom:15px;padding-left:10px;'>\n" +
"																<div class='alignment' align='center'>\n" +
"																	<table class='social-table' width='144px' border='0' cellpadding='0' cellspacing='0' role='presentation' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt; display: inline-block;'>\n" +
"																	</table>\n" +
"																</div>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"													<table class='menu_block block-3' width='100%' border='0' cellpadding='0' cellspacing='0' role='presentation' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt;'>\n" +
"														<tr>\n" +
"															<td class='pad' style='text-align:center;color:#101010;font-family:inherit;font-size:14px;'>\n" +
"																<table width='100%' cellpadding='0' cellspacing='0' border='0' role='presentation' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt;'>\n" +
"																	<tr>\n" +
"																		<td class='alignment' style='text-align:center;font-size:0px;'>\n" +
"																			<!--[if !mso]><!--><input class='menu-checkbox' id='memu-r7c0m2' type='checkbox' style='display:none !important;max-height:0;visibility:hidden;'>\n" +
"																			<!--<![endif]-->\n" +
"																			<div class='menu-trigger' style='display:none;max-height:0px;max-width:0px;font-size:0px;overflow:hidden;'><label class='menu-label' for='memu-r7c0m2' style='height: 36px; width: 36px; display: inline-block; cursor: pointer; mso-hide: all; user-select: none; align: center; text-align: center; color: #ffffff; text-decoration: none; background-color: #000000; border-radius: 0;'><span class='menu-open' style='mso-hide:all;font-size:26px;line-height:36px;'>☰</span><span class='menu-close' style='display:none;mso-hide:all;font-size:26px;line-height:36px;'>✕</span></label></div>\n" +
"																			<div class='menu-links'>\n" +
"																				<!--[if mso]><table role='presentation' border='0' cellpadding='0' cellspacing='0' align='center' style=''><tr style='text-align:center;'><![endif]-->\n" +
"																				<!--[if mso]></td><![endif]-->\n" +
"																				<!--[if mso]></td><![endif]-->\n" +
"																				<!--[if mso]></td><![endif]-->\n" +
"																				<!--[if mso]></td><![endif]-->\n" +
"																				<!--[if mso]></tr></table><![endif]-->\n" +
"																			</div>\n" +
"																		</td>\n" +
"																	</tr>\n" +
"																</table>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"												</td>\n" +
"											</tr>\n" +
"										</tbody>\n" +
"									</table>\n" +
"								</td>\n" +
"							</tr>\n" +
"						</tbody>\n" +
"					</table>\n" +
"					<table class='row row-9' align='center' width='100%' border='0' cellpadding='0' cellspacing='0' role='presentation' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt;'>\n" +
"						<tbody>\n" +
"							<tr>\n" +
"								<td>\n" +
"									<table class='row-content stack' align='center' border='0' cellpadding='0' cellspacing='0' role='presentation' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 680px;' width='680'>\n" +
"										<tbody>\n" +
"											<tr>\n" +
"												<td class='column column-1' width='16.666666666666668%' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;'>\n" +
"													<div class='spacer_block' style='height:0px;line-height:0px;font-size:1px;'>&#8202;</div>\n" +
"												</td>\n" +
"												<td class='column column-2' width='66.66666666666667%' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;'>\n" +
"													<div class='spacer_block' style='height:35px;line-height:35px;font-size:1px;'>&#8202;</div>\n" +
"												</td>\n" +
"												<td class='column column-3' width='16.666666666666668%' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;'>\n" +
"													<div class='spacer_block' style='height:0px;line-height:0px;font-size:1px;'>&#8202;</div>\n" +
"												</td>\n" +
"											</tr>\n" +
"										</tbody>\n" +
"									</table>\n" +
"								</td>\n" +
"							</tr>\n" +
"						</tbody>\n" +
"					</table>\n" +
"					<table class='row row-10' align='center' width='100%' border='0' cellpadding='0' cellspacing='0' role='presentation' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt;'>\n" +
"						<tbody>\n" +
"							<tr>\n" +
"								<td>\n" +
"									<table class='row-content stack' align='center' border='0' cellpadding='0' cellspacing='0' role='presentation' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 680px;' width='680'>\n" +
"										<tbody>\n" +
"											<tr>\n" +
"												<td class='column column-1' width='100%' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;'>\n" +
"													<table class='icons_block block-1' width='100%' border='0' cellpadding='0' cellspacing='0' role='presentation' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt;'>\n" +
"														<tr>\n" +
"															<td class='pad' style='vertical-align: middle; color: #9d9d9d; font-family: inherit; font-size: 15px; padding-bottom: 5px; padding-top: 5px; text-align: center;'>\n" +
"																<table width='100%' cellpadding='0' cellspacing='0' role='presentation' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt;'>\n" +
"																	<tr>\n" +
"																		<td class='alignment' style='vertical-align: middle; text-align: center;'>\n" +
"																			<!--[if vml]><table align='left' cellpadding='0' cellspacing='0' role='presentation' style='display:inline-block;padding-left:0px;padding-right:0px;mso-table-lspace: 0pt;mso-table-rspace: 0pt;'><![endif]-->\n" +
"																			<!--[if !vml]><!-->\n" +
"																			<table class='icons-inner' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt; display: inline-block; margin-right: -4px; padding-left: 0px; padding-right: 0px;' cellpadding='0' cellspacing='0' role='presentation'>\n" +
"																				<!--<![endif]-->\n" +
"																				<tr>\n" +
"																				</tr>\n" +
"																			</table>\n" +
"																		</td>\n" +
"																	</tr>\n" +
"																</table>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"												</td>\n" +
"											</tr>\n" +
"										</tbody>\n" +
"									</table>\n" +
"								</td>\n" +
"							</tr>\n" +
"						</tbody>\n" +
"					</table>\n" +
"				</td>\n" +
"			</tr>\n" +
"		</tbody>\n" +
"	</table><!-- End -->\n" +
"</body>\n" +
"\n" +
"</html>");
    //message.setText("This is simple program of sending email using JavaMail API");  
    message.setContent(content, "text/html");

    //send the message  
     Transport.send(message);  
  
     System.out.println("message sent successfully...");  
   
     } catch (MessagingException e) 
     {
         e.printStackTrace();
     }  
   }
}