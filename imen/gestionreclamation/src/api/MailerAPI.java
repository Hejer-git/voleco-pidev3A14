/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

/**
 *
 * @author imen
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailerAPI {
    private final String username;
    private final String password;
    private final Properties properties;

    public MailerAPI(String username, String password) {
        this.username = username;
        this.password = password;

        // Configure SMTP properties
        properties = new Properties();
        properties.setProperty("mail.smtp.host", "smtp.gmail.com"); // Change to your SMTP server
        properties.setProperty("mail.smtp.port", "587");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
    }

    public void sendEmail(String to, String subject, String text) throws MessagingException {
        Session session = Session.getInstance(properties,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject(subject);
        message.setText(text);
       String content = new String("<!doctype html>\n" +
"<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
"  <head>\n" +
"    <meta charset=\"UTF-8\">\n" +
"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"    <style type=\"text/css\">\n" +
"      p {\n" +
"        margin: 10px 0;\n" +
"        padding: 0;\n" +
"      }\n" +
"      table {\n" +
"        border-collapse: collapse;\n" +
"      }\n" +
"      #templatePreheader {\n" +
"        background-color: #F9EC26;\n" +
"        background-image: url(\"https://img.freepik.com/vecteurs-libre/vecteur-explosion-oups_53876-17099.jpg\");\n" +
"        background-repeat: no-repeat;\n" +
"        background-position: center;\n" +
"        background-size: cover;\n" +
"        border-top: 0;\n" +
"        border-bottom: 0;\n" +
"        padding-top: 50px;\n" +
"        padding-bottom: 200px;\n" +
"      }\n" +
"      #templateFooter {\n" +
"        background-color: #F9EC26;\n" +
"        background-image: url(\"https://img.freepik.com/vecteurs-libre/vecteur-explosion-oups_53876-17099.jpg\");\n" +
"        background-repeat: no-repeat;\n" +
"        background-position: center;\n" +
"        background-size: cover;\n" +
"        border-top: 1px none;\n" +
"        border-bottom: 0;\n" +
"        padding-top: 9px;\n" +
"        padding-bottom: 9px;\n" +
"      }\n" +
"    </style>\n" +
"  </head>\n" +
"  <body style=\"height: 100%;margin: 0;padding: 0;width: 100%;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;background-color: #F9EC26;\">\n" +
"    <span class=\"mcnPreviewText\" style=\"display:none; font-size:0px; line-height:0px; max-height:0px; max-width:0px; opacity:0; overflow:hidden; visibility:hidden; mso-hide:all;\">Design goodness in your inbox</span>\n" +
"   <center>\n" +
"      <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" height=\"100%\" width=\"100%\" id=\"bodyTable\" style=\"border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;height: 100%;margin: 0;padding: 0;width: 100%;background-color: #F9EC26;\">\n" +
"        <tr>\n" +
"          <td align=\"center\" valign=\"top\" id=\"bodyCell\" style=\"mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;height: 100%;margin: 0;padding: 0;width: 100%;border-top: 0;\">\n" +
"\n" +
"            <!-- BEGIN TEMPLATE // -->\n" +
"            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"              <tr>\n" +
"                <td align=\"center\" valign=\"top\" id=\"templatePreheader\" style=\"background:#F9EC26 url(&quot;https://img.freepik.com/vecteurs-libre/vecteur-explosion-oups_53876-17099.jpg&quot;) no-repeat center/cover;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;background-color: #F9EC26;background-image: url(https://img.freepik.com/vecteurs-libre/vecteur-explosion-oups_53876-17099.jpg);background-repeat: no-repeat;background-position: center;background-size: cover;border-top: 0;border-bottom: 0;padding-top: 50px;padding-bottom: 200px;\">\n" +
"\n" +
"                  <!--[if (gte mso 9)|(IE)]>\n" +
"                                    <table align=\"center\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"600\" style=\"width:600px;\">\n" +
"                                    <tr>\n" +
"                                    <td align=\"center\" valign=\"top\" width=\"600\" style=\"width:600px;\">\n" +
"                                    <![endif]-->\n" +
"                  <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"templateContainer\" style=\"border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;max-width: 600px !important;\">\n" +
"                    <tr>\n" +
"                      <td valign=\"top\" class=\"preheaderContainer\" style=\"mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\"></td>\n" +
"                    </tr>\n" +
"                  </table>\n" +
"</td>\n" +
"              </tr>\n" +
"              <tr>\n" +
"                <td align=\"center\" valign=\"top\" id=\"templateHeader\" style=\"background:#F9EC26 none no-repeat center/cover;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;background-color: #F9EC26;background-image: none;background-repeat: no-repeat;background-position: center;background-size: cover;border-top: 0;border-bottom: 0;padding-top: 10px;padding-bottom: 10px;\">\n" +
"\n" +
"                  <!--[if (gte mso 9)|(IE)]>\n" +
"                                    <table align=\"center\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"600\" style=\"width:600px;\">\n" +
"                                    <tr>\n" +
"                                    <td align=\"center\" valign=\"top\" width=\"600\" style=\"width:600px;\">\n" +
"                                    <![endif]-->\n" +
"                  <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"templateContainer\" style=\"border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;max-width: 600px !important;\">\n" +
"                    <tr>\n" +
"                      <td valign=\"top\" class=\"headerContainer\" style=\"mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnTextBlock\" style=\"min-width: 100%;border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"                          <tbody class=\"mcnTextBlockOuter\">\n" +
"                            <tr>\n" +
"                              <td valign=\"top\" class=\"mcnTextBlockInner\" style=\"padding-top: 9px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"\n" +
"                                <!--[if mso]>\n" +
"				<table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" style=\"width:100%;\">\n" +
"				<tr>\n" +
"				<![endif]-->\n" +
"                                <!--[if mso]>\n" +
"				<td valign=\"top\" width=\"600\" style=\"width:600px;\">\n" +
"				<![endif]-->\n" +
"                                <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"max-width: 100%;min-width: 100%;border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\" width=\"100%\" class=\"mcnTextContentContainer\">\n" +
"                                  <tbody>\n" +
"                                    <tr>\n" +
"                                      <td valign=\"top\" class=\"mcnTextContent\" style=\"padding: 0px 18px 9px;line-height: 150%;text-align: left;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;word-break: break-word;color: #202020;font-family: Helvetica;font-size: 16px;\">\n" +
"                                        <h1 class=\"null\" style=\"display: block;margin: 0;padding: 0;color: #191414;font-family: 'Helvetica Neue', Helvetica, Arial, Verdana, sans-serif;font-size: 50px;font-style: normal;font-weight: bold;line-height: 100%;letter-spacing: -1px;text-align: left;\"><strong id=\"docs-internal-guid-c96d5d6b-7fff-41e6-ddc2-68b3ab98ba80\">Sorry To inform You,But a client added a claim :(</strong></h1>\n" +
"                                      </td>\n" +
"                                    </tr>\n" +
"                                  </tbody>                              \n" +
"                              </td>\n" +
"                            </tr>\n" +
"                          </tbody>\n" +
"                        </table>\n" +
"                      </td>\n" +
"                    </tr>\n" +
"                  </table></td>\n" +
"              </tr>\n" +
"              <tr>\n" +
"                <td align=\"center\" valign=\"top\" id=\"templateBody\" style=\"background:#F9EC26 none no-repeat center/cover;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;background-color: #F9EC26;background-image: none;background-repeat: no-repeat;background-position: center;background-size: cover;border-top: 0;border-bottom: 0;padding-top: 9px;padding-bottom: 9px;\">\n" +
"\n" +
"                  <!--[if (gte mso 9)|(IE)]>\n" +
"                                    <table align=\"center\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"600\" style=\"width:600px;\">\n" +
"                                    <tr>\n" +
"                                    <td align=\"center\" valign=\"top\" width=\"600\" style=\"width:600px;\">\n" +
"                                    <![endif]-->\n" +
"                  <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"templateContainer\" style=\"border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;max-width: 600px !important;\">\n" +
"                    <tr>\n" +
"                      <td valign=\"top\" class=\"bodyContainer\" style=\"mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnTextBlock\" style=\"min-width: 100%;border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"                          <tbody class=\"mcnTextBlockOuter\">\n" +
"                            <tr>\n" +
"                              <td valign=\"top\" class=\"mcnTextBlockInner\" style=\"padding-top: 9px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"                                <!--[if mso]>\n" +
"				<table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" style=\"width:100%;\">\n" +
"				<tr>			\n" +
"				<td valign=\"top\" width=\"600\" style=\"width:600px;\">\n" +
"				<![endif]-->\n" +
"                                <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"max-width: 100%;min-width: 100%;border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\" width=\"100%\" class=\"mcnTextContentContainer\">\n" +
"                                  <tbody>\n" +
"                                    <tr>\n" +
"                                      <td valign=\"top\" class=\"mcnTextContent\" style=\"padding-top: 0;padding-right: 18px;padding-bottom: 9px;padding-left: 18px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;word-break: break-word;color: #191414;font-family: 'Helvetica Neue', Helvetica, Arial, Verdana, sans-serif;font-size: 16px;line-height: 150%;text-align: left;\">\n" +
"                                        Some one is not satisfied <br>\n" +
"                                        <br>\n" +
"                                        To resolve this problem, try to contact him....&nbsp;<br>\n" +
"                                        <br>                                    \n" +
"                                      </td>\n" +
"                                    </tr>\n" +
"                                  </tbody>\n" +
"                                </table>\n" +
"                                 <div class='spacer_block' style='height:10px;line-height:10px;font-size:1px;'>&#8202;</div>\n" +
"													<table class='button_block block-3' width='100%' border='0' cellpadding='10' cellspacing='0' role='presentation' style='mso-table-lspace: 0pt; mso-table-rspace: 0pt;'>\n" +
"														<tr> \n" +
"															<td class='pad'>\n" +
"																<div class='alignment' align='center'>\n" +
"																	<!--[if mso]><v:roundrect xmlns:v='urn:schemas-microsoft-com:vml' xmlns:w='urn:schemas-microsoft-com:office:word' href='www.example.com' style='height:43px;width:160px;v-text-anchor:middle;' arcsize='10%' strokeweight='0.75pt' strokecolor='#101' fillcolor='#101'><w:anchorlock/><v:textbox inset='0px,0px,0px,0px'><center style='color:#ffffff; font-family:Arial, sans-serif; font-size:16px'><![endif]--><a href='' target='_blank' style='text-decoration:none;display:inline-block;color:#ffffff;background-color:#101;border-radius:4px;width:auto;border-top:1px solid #101;font-weight:undefined;border-right:1px solid #101;border-bottom:1px solid #101;border-left:1px solid #101;padding-top:5px;padding-bottom:5px;font-family:Arial, Helvetica Neue, Helvetica, sans-serif;font-size:16px;text-align:center;mso-border-alt:none;word-break:keep-all;'><span style='padding-left:20px;padding-right:20px;font-size:16px;display:inline-block;letter-spacing:normal;'><span style='font-size: 16px; line-height: 2; word-break: break-word; mso-line-height-alt: 32px;'>"+username+"</span></span></a>\n" +
"																	<!--[if mso]></center></v:textbox></v:roundrect><![endif]-->\n" +
"																</div>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"													<div class='spacer_block' style='height:20px;line-height:20px;font-size:1px;'>&#8202;</div>\n" +
"\n" +
"                              </td>\n" +
"                            </tr>\n" +
"                          </tbody>\n" +
"                        </table>\n" +
"                      </td>\n" +
"                    </tr>\n" +
"                  </table>\n" +
"                </td>\n" +
"              </tr>\n" +
"              <tr>\n" +
"                <td align=\"center\" valign=\"top\" id=\"templateFooter\" style=\"background:#F9EC26 url(&quot;&quot;) no-repeat center/cover;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;background-color: #F9EC26;background-image: url();background-repeat: no-repeat;background-position: center;background-size: cover;border-top: 1px none;border-bottom: 0;padding-top: 9px;padding-bottom: 9px;\">\n" +
"                  <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"templateContainer\" style=\"border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;max-width: 600px !important;\">\n" +
"                    <tr>\n" +
"                      <td valign=\"top\" class=\"footerContainer\" style=\"mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnFollowBlock\" style=\"min-width: 100%;border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"                          <tbody class=\"mcnFollowBlockOuter\">\n" +
"                            <tr>\n" +
"                              <td align=\"center\" valign=\"top\" style=\"padding: 9px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\" class=\"mcnFollowBlockInner\">\n" +
"                                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnFollowContentContainer\" style=\"min-width: 100%;border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"                                  <tbody>\n" +
"                                    <tr>\n" +
"                                      <td align=\"center\" style=\"padding-left: 9px;padding-right: 9px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"                                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"min-width: 100%;border: 1px none;border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\" class=\"mcnFollowContent\">\n" +
"                                          <tbody>\n" +
"                                            <tr>\n" +
"                                              <td align=\"center\" valign=\"top\" style=\"padding-top: 9px;padding-right: 9px;padding-left: 9px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"                                                <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"                                                  <tbody>\n" +
"                                                    <tr>\n" +
"                                                      <td align=\"center\" valign=\"top\" style=\"mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"                                                        <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"display: inline;border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"                                                          <tbody>\n" +
"                                                            <tr>\n" +
"                                                              <td valign=\"top\" style=\"padding-right: 10px;padding-bottom: 9px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\" class=\"mcnFollowContentItemContainer\">\n" +
"                                                                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnFollowContentItem\" style=\"border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"                                                                  <tbody>\n" +
"                                                                    <tr>\n" +
"                                                                      <td align=\"left\" valign=\"middle\" style=\"padding-top: 5px;padding-right: 10px;padding-bottom: 5px;padding-left: 9px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"                                                                        <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"\" style=\"border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"                                                                          <tbody>\n" +
"                                                                            <tr>\n" +
"                                                                              <td align=\"center\" valign=\"middle\" width=\"24\" class=\"mcnFollowIconContent\" style=\"mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"                                                                                <a href=\"\" target=\"_blank\" style=\"mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\"><img src=\"https://cdn-icons-png.flaticon.com/512/2673/2673650.png\" alt=\"Twitter\" style=\"display: block;border: 0;height: auto;outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;\" height=\"24\" width=\"24\" class=\"\"></a>\n" +
"                                                                              </td>\n" +
"                                                                            </tr>\n" +
"                                                                          </tbody>\n" +
"                                                                        </table>\n" +
"                                                                      </td>\n" +
"                                                                    </tr>\n" +
"                                                                  </tbody>\n" +
"                                                                </table>\n" +
"                                                              </td>\n" +
"                                                            </tr>\n" +
"                                                          </tbody>\n" +
"                                                        </table>\n" +
"                                                        <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"display: inline;border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"                                                          <tbody>\n" +
"                                                            <tr>\n" +
"                                                              <td valign=\"top\" style=\"padding-right: 10px;padding-bottom: 9px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\" class=\"mcnFollowContentItemContainer\">\n" +
"                                                                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnFollowContentItem\" style=\"border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"                                                                  <tbody>\n" +
"                                                                    <tr>\n" +
"                                                                      <td align=\"left\" valign=\"middle\" style=\"padding-top: 5px;padding-right: 10px;padding-bottom: 5px;padding-left: 9px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"                                                                        <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"\" style=\"border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"                                                                          <tbody>\n" +
"                                                                            <tr>\n" +
"                                                                              <td align=\"center\" valign=\"middle\" width=\"24\" class=\"mcnFollowIconContent\" style=\"mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"                                                                                <a href=\"\" target=\"_blank\" style=\"mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\"><img src=\"https://cdn-images.mailchimp.com/icons/social-block-v2/outline-dark-link-48.png\" alt=\"Website\" style=\"display: block;border: 0;height: auto;outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;\" height=\"24\" width=\"24\" class=\"\"></a>\n" +
"                                                                              </td>\n" +
"                                                                            </tr>\n" +
"                                                                          </tbody>\n" +
"                                                                        </table>\n" +
"                                                                      </td>\n" +
"                                                                    </tr>\n" +
"                                                                  </tbody>\n" +
"                                                                </table>\n" +
"                                                              </td>\n" +
"                                                            </tr>\n" +
"                                                          </tbody>\n" +
"                                                        </table>\n" +
"                                                        <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"display: inline;border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"                                                          <tbody>\n" +
"                                                            <tr>\n" +
"                                                              <td valign=\"top\" style=\"padding-right: 0;padding-bottom: 9px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\" class=\"mcnFollowContentItemContainer\">\n" +
"                                                                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnFollowContentItem\" style=\"border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"                                                                  <tbody>\n" +
"                                                                    <tr>\n" +
"                                                                      <td align=\"left\" valign=\"middle\" style=\"padding-top: 5px;padding-right: 10px;padding-bottom: 5px;padding-left: 9px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"                                                                        <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"\" style=\"border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"                                                                          <tbody>\n" +
"                                                                            <tr>\n" +
"                                                                              <td align=\"center\" valign=\"middle\" width=\"24\" class=\"mcnFollowIconContent\" style=\"mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"                                                                                <a href=\"\" target=\"_blank\" style=\"mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\"><img src=\"https://cdn-images.mailchimp.com/icons/social-block-v2/outline-dark-instagram-48.png\" alt=\"Link\" style=\"display: block;border: 0;height: auto;outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;\" height=\"24\" width=\"24\" class=\"\"></a>\n" +
"                                                                              </td>\n" +
"                                                                            </tr>\n" +
"                                                                          </tbody>\n" +
"                                                                        </table>\n" +
"                                                                      </td>\n" +
"                                                                    </tr>\n" +
"                                                                  </tbody>\n" +
"                                                                </table>\n" +
"                                                              </td>\n" +
"                                                            </tr>\n" +
"                                                          </tbody>\n" +
"                                                        </table>\n" +
"                                                      </td>\n" +
"                                                    </tr>\n" +
"                                                  </tbody>\n" +
"                                                </table>\n" +
"                                              </td>\n" +
"                                            </tr>\n" +
"                                          </tbody>\n" +
"                                        </table>\n" +
"                                      </td>\n" +
"                                    </tr>\n" +
"                                  </tbody>\n" +
"                                </table>\n" +
"                              </td>\n" +
"                            </tr>\n" +
"                          </tbody>\n" +
"                        </table>\n" +
"                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnTextBlock\" style=\"min-width: 100%;border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"                          <tbody class=\"mcnTextBlockOuter\">\n" +
"                            <tr>\n" +
"                              <td valign=\"top\" class=\"mcnTextBlockInner\" style=\"padding-top: 9px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"                                <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"max-width: 100%;min-width: 100%;border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\" width=\"100%\" class=\"mcnTextContentContainer\">\n" +
"                                  <tbody>\n" +
"                                    <tr>\n" +
"                                      <td valign=\"top\" class=\"mcnTextContent\" style=\"padding-top: 0;padding-right: 18px;padding-bottom: 9px;padding-left: 18px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;word-break: break-word;color: #191414;font-family: Helvetica;font-size: 12px;line-height: 150%;text-align: center;\">\n" +
"                                        © Voleco Airline<br>\n" +
"                                        <br>                                      \n" +
"                                      </td>\n" +
"                                    </tr>\n" +
"                                  </tbody>\n" +
"                                </table>\n" +
"                              </td>\n" +
"                            </tr>\n" +
"                          </tbody>\n" +
"                        </table>\n" +
"                      </td>\n" +
"                    </tr>\n" +
"                  </table>                 \n" +
"                </td>\n" +
"              </tr>\n" +
"            </table> <!-- // END TEMPLATE -->\n" +
"          </td>\n" +
"        </tr>\n" +
"      </table>\n" +
"    </center>\n" +
"   											\n" +
"</html>");
        message.setContent(content, "text/html");
        Transport.send(message);
        System.out.println("Sent message successfully....");
    }
}