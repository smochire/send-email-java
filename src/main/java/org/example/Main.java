package org.example;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        // Informations d'authentification pour le serveur SMTP
        String smtpHost = "smtp.gmail.com"; // Remplacez par le serveur SMTP de votre fournisseur de messagerie
        int smtpPort = 587; // Le port peut varier selon votre fournisseur de messagerie
        String senderEmail = "your.email@gmail.com";
        String senderPassword = "your.app.password";

        // Destinataire et contenu du message
        String receiverEmail = "email.receiver@mail.com";
        String subject = "Test d'envoi de mail en Java";
        String body = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
                "\n" +
                "<head>\n" +
                "\n" +
                "  <!--[if gte mso 9]>\n" +
                "  <xml>\n" +
                "    <o:OfficeDocumentSettings>\n" +
                "      <o:AllowPNG/>\n" +
                "      <o:PixelsPerInch>96</o:PixelsPerInch>\n" +
                "    </o:OfficeDocumentSettings>\n" +
                "  </xml>\n" +
                "  <![endif]-->\n" +
                "\n" +
                "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "  <meta name=\"x-apple-disable-message-reformatting\">\n" +
                "  <!--[if !mso]><!--><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><!--<![endif]-->\n" +
                "\n" +
                "    <!-- Your title goes here -->\n" +
                "    <title>Newsletter</title>\n" +
                "    <!-- End title -->\n" +
                "\n" +
                "    <!-- Start stylesheet -->\n" +
                "    <style type=\"text/css\">\n" +
                "      a,a[href],a:hover, a:link, a:visited {\n" +
                "        /* This is the link colour */\n" +
                "        text-decoration: none!important;\n" +
                "        color: #0000EE;\n" +
                "      }\n" +
                "      .link {\n" +
                "        text-decoration: underline!important;\n" +
                "      }\n" +
                "      p, p:visited {\n" +
                "        /* Fallback paragraph style */\n" +
                "        font-size:15px;\n" +
                "        line-height:24px;\n" +
                "        font-family:'Helvetica', Arial, sans-serif;\n" +
                "        font-weight:300;\n" +
                "        text-decoration:none;\n" +
                "        color: #000000;\n" +
                "      }\n" +
                "      h1 {\n" +
                "        /* Fallback heading style */\n" +
                "        font-size:22px;\n" +
                "        line-height:24px;\n" +
                "        font-family:'Helvetica', Arial, sans-serif;\n" +
                "        font-weight:normal;\n" +
                "        text-decoration:none;\n" +
                "        color: #000000;\n" +
                "      }\n" +
                "      .ExternalClass p, .ExternalClass span, .ExternalClass font, .ExternalClass td {line-height: 100%;}\n" +
                "      .ExternalClass {width: 100%;}\n" +
                "    </style>\n" +
                "    <!-- End stylesheet -->\n" +
                "\n" +
                "</head>\n" +
                "\n" +
                "  <!-- You can change background colour here -->\n" +
                "  <body style=\"text-align: center; margin: 0; padding-top: 10px; padding-bottom: 10px; padding-left: 0; padding-right: 0; -webkit-text-size-adjust: 100%;background-color: #f2f4f6; color: #000000\" align=\"center\">\n" +
                "  \n" +
                "  <!-- Fallback force center content -->\n" +
                "  <div style=\"text-align: center;\">\n" +
                "\n" +
                "    <!-- Email not displaying correctly -->\n" +
                "    <table align=\"center\" style=\"text-align: center; vertical-align: middle; width: 600px; max-width: 600px;\" width=\"600\">\n" +
                "      <tbody>\n" +
                "        <tr>\n" +
                "          <td style=\"width: 596px; vertical-align: middle;\" width=\"596\">\n" +
                "\n" +
                "            <p style=\"font-size: 11px; line-height: 20px; font-family: 'Helvetica', Arial, sans-serif; font-weight: 400; text-decoration: none; color: #000000;\">Is this email not displaying correctly? <a class=\"link\" style=\"text-decoration: underline;\" target=\"_blank\" href=\"https://fullsphere.co.uk/html-emails/free-template/\"><u>Click here</u></a> to view in browser</p>\n" +
                "\n" +
                "          </td>\n" +
                "        </tr>\n" +
                "      </tbody>\n" +
                "    </table>\n" +
                "    <!-- Email not displaying correctly -->\n" +
                "    \n" +
                "    <!-- Start container for logo -->\n" +
                "    <table align=\"center\" style=\"text-align: center; vertical-align: top; width: 600px; max-width: 600px; background-color: #ffffff;\" width=\"600\">\n" +
                "      <tbody>\n" +
                "        <tr>\n" +
                "          <td style=\"width: 596px; vertical-align: top; padding-left: 0; padding-right: 0; padding-top: 15px; padding-bottom: 15px;\" width=\"596\">\n" +
                "\n" +
                "            <!-- Your logo is here -->\n" +
                "            <img style=\"width: 180px; max-width: 180px; height: 85px; max-height: 85px; text-align: center; color: #ffffff;\" alt=\"Logo\" src=\"https://fullsphere.co.uk/misc/free-template/images/logo-white-background.jpg\" align=\"center\" width=\"180\" height=\"85\">\n" +
                "\n" +
                "          </td>\n" +
                "        </tr>\n" +
                "      </tbody>\n" +
                "    </table>\n" +
                "    <!-- End container for logo -->\n" +
                "\n" +
                "    <!-- Hero image -->\n" +
                "    <img style=\"width: 600px; max-width: 600px; height: 350px; max-height: 350px; text-align: center;\" alt=\"Hero image\" src=\"https://fullsphere.co.uk/misc/free-template/images/hero.jpg\" align=\"center\" width=\"600\" height=\"350\">\n" +
                "    <!-- Hero image -->\n" +
                "\n" +
                "    <!-- Start single column section -->\n" +
                "    <table align=\"center\" style=\"text-align: center; vertical-align: top; width: 600px; max-width: 600px; background-color: #ffffff;\" width=\"600\">\n" +
                "        <tbody>\n" +
                "          <tr>\n" +
                "            <td style=\"width: 596px; vertical-align: top; padding-left: 30px; padding-right: 30px; padding-top: 30px; padding-bottom: 40px;\" width=\"596\">\n" +
                "\n" +
                "              <h1 style=\"font-size: 20px; line-height: 24px; font-family: 'Helvetica', Arial, sans-serif; font-weight: 600; text-decoration: none; color: #000000;\">Single column, dolor sit amet</h1>\n" +
                "\n" +
                "              <p style=\"font-size: 15px; line-height: 24px; font-family: 'Helvetica', Arial, sans-serif; font-weight: 400; text-decoration: none; color: #919293;\">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam mattis ante sed imperdiet euismod. Vivamus fermentum bibendum turpis, et tempor dui. Sed vitae lectus egestas, finibus purus ac, rutrum mauris.</p>              \n" +
                "\n" +
                "              <p style=\"font-size: 15px; line-height: 24px; font-family: 'Helvetica', Arial, sans-serif; font-weight: 400; text-decoration: none; color: #919293;\">You can download this template <a target=\"_blank\" style=\"text-decoration: underline; color: #000000;\" href=\"https://fullsphere.co.uk/misc/free-template/html-email-template.zip\" download=\"HTML Email Template\"><u>here</u></a></p>\n" +
                "\n" +
                "              <!-- Start button (You can change the background colour by the hex code below) -->\n" +
                "              <a href=\"#\" target=\"_blank\" style=\"background-color: #000000; font-size: 15px; line-height: 22px; font-family: 'Helvetica', Arial, sans-serif; font-weight: normal; text-decoration: none; padding: 12px 15px; color: #ffffff; border-radius: 5px; display: inline-block; mso-padding-alt: 0;\">\n" +
                "                  <!--[if mso]>\n" +
                "                  <i style=\"letter-spacing: 25px; mso-font-width: -100%; mso-text-raise: 30pt;\">&nbsp;</i>\n" +
                "                <![endif]-->\n" +
                "\n" +
                "                  <span style=\"mso-text-raise: 15pt; color: #ffffff;\">Learn more</span>\n" +
                "                  <!--[if mso]>\n" +
                "                  <i style=\"letter-spacing: 25px; mso-font-width: -100%;\">&nbsp;</i>\n" +
                "                <![endif]-->\n" +
                "              </a>\n" +
                "              <!-- End button here -->\n" +
                "\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "        </tbody>\n" +
                "      </table>\n" +
                "      <!-- End single column section -->\n" +
                "      \n" +
                "      <!-- Start image -->\n" +
                "      <img style=\"width: 600px; max-width: 600px; height: 240px; max-height: 240px; text-align: center;\" alt=\"Image\" src=\"https://fullsphere.co.uk/misc/free-template/images/image-2.jpg\" align=\"center\" width=\"600\" height=\"240\">\n" +
                "      <!-- End image -->\n" +
                "\n" +
                "      <!-- Start heading for double column section -->\n" +
                "      <table align=\"center\" style=\"text-align: center; vertical-align: top; width: 600px; max-width: 600px; background-color: #ffffff;\" width=\"600\">\n" +
                "        <tbody>\n" +
                "          <tr>\n" +
                "            <td style=\"width: 596px; vertical-align: top; padding-left: 30px; padding-right: 30px; padding-top: 30px; padding-bottom: 0;\" width=\"596\">\n" +
                "\n" +
                "              <h1 style=\"font-size: 20px; line-height: 24px; font-family: 'Helvetica', Arial, sans-serif; font-weight: 600; text-decoration: none; color: #000000; margin-bottom: 0;\">Double column, dolor sit amet</h1>\n" +
                "\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "        </tbody>\n" +
                "      </table>\n" +
                "      <!-- End heading for double column section -->\n" +
                "\n" +
                "      <!-- Start double column section -->\n" +
                "      <table align=\"center\" style=\"text-align: center; vertical-align: top; width: 600px; max-width: 600px; background-color: #ffffff;\" width=\"600\">\n" +
                "        <tbody> \n" +
                "            <tr>      \n" +
                "              <td style=\"width: 252px; vertical-align: top; padding-left: 30px; padding-right: 15px; padding-top: 0; padding-bottom: 30px; text-align: center;\" width=\"252\">\n" +
                "\n" +
                "                <p style=\"font-size: 15px; line-height: 24px; font-family: 'Helvetica', Arial, sans-serif; font-weight: 400; text-decoration: none; color: #919293;\">Vivamus felis velit, iaculis eu eros sed, consequat viverra libero. Aliquam ipsum eros, imperdiet eget fermentum eget, cursus a sapien.</p>\n" +
                "              \n" +
                "              </td>\n" +
                "\n" +
                "              <td style=\"width: 252px; vertical-align: top; padding-left: 15px; padding-right: 30px; padding-top: 0; padding-bottom: 30px; text-align: center;\" width=\"252\">              \n" +
                "                <p style=\"font-size: 15px; line-height: 24px; font-family: 'Helvetica', Arial, sans-serif; font-weight: 400; text-decoration: none; color: #919293;\">Pellentesque mollis bibendum sollicitudin. Aenean tempor eros at risus mollis gravida. Aenean in urna eget elit pretium ultrices eu vitae elit.</p>\n" +
                "\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "        </tbody>\n" +
                "      </table>\n" +
                "      <!-- End double column section -->\n" +
                "\n" +
                "      <!-- Start image -->\n" +
                "      <img style=\"width: 600px; max-width: 600px; height: 240px; max-height: 240px; text-align: center;\" alt=\"Image\" src=\"https://fullsphere.co.uk/misc/free-template/images/image-3.jpg\" align=\"center\" width=\"600\" height=\"240\">\n" +
                "      <!-- End image -->\n" +
                "\n" +
                "      <!-- Start footer -->\n" +
                "      <table align=\"center\" style=\"text-align: center; vertical-align: top; width: 600px; max-width: 600px; background-color: #000000;\" width=\"600\">\n" +
                "        <tbody>\n" +
                "          <tr>\n" +
                "            <td style=\"width: 596px; vertical-align: top; padding-left: 30px; padding-right: 30px; padding-top: 30px; padding-bottom: 30px;\" width=\"596\">\n" +
                "\n" +
                "              <!-- Your inverted logo is here -->\n" +
                "              <img style=\"width: 180px; max-width: 180px; height: 85px; max-height: 85px; text-align: center; color: #ffffff;\" alt=\"Logo\" src=\"https://fullsphere.co.uk/misc/free-template/images/logo-black-background.jpg\" align=\"center\" width=\"180\" height=\"85\">\n" +
                "\n" +
                "              <p style=\"font-size: 13px; line-height: 24px; font-family: 'Helvetica', Arial, sans-serif; font-weight: 400; text-decoration: none; color: #ffffff;\">\n" +
                "                Address line 1, London, L2 4LN\n" +
                "              </p>\n" +
                "\n" +
                "              <p style=\"margin-bottom: 0; font-size: 13px; line-height: 24px; font-family: 'Helvetica', Arial, sans-serif; font-weight: 400; text-decoration: none; color: #ffffff;\">\n" +
                "                <a target=\"_blank\" style=\"text-decoration: underline; color: #ffffff;\" href=\"https://fullsphere.co.uk\">\n" +
                "                  www.fullsphere.co.uk\n" +
                "                </a>\n" +
                "              </p>\n" +
                "\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "        </tbody>\n" +
                "      </table>\n" +
                "      <!-- End footer -->\n" +
                "    \n" +
                "      <!-- Start unsubscribe section -->\n" +
                "      <table align=\"center\" style=\"text-align: center; vertical-align: top; width: 600px; max-width: 600px;\" width=\"600\">\n" +
                "        <tbody>\n" +
                "          <tr>\n" +
                "            <td style=\"width: 596px; vertical-align: top; padding-left: 30px; padding-right: 30px; padding-top: 30px; padding-bottom: 30px;\" width=\"596\">\n" +
                "              \n" +
                "              <p style=\"font-size: 12px; line-height: 12px; font-family: 'Helvetica', Arial, sans-serif; font-weight: normal; text-decoration: none; color: #000000;\">\n" +
                "                Not wanting to receive these emails?\n" +
                "              </p>\n" +
                "\n" +
                "              <p style=\"font-size: 12px; line-height: 12px; font-family: 'Helvetica', Arial, sans-serif; font-weight: normal; text-decoration: none; color: #000000;\">\n" +
                "                You can <a style=\"text-decoration: underline; color: #000000;\" href=\"insert-unsubscribe-link-here\"><u>unsubscribe here</u></a>\n" +
                "              </p>\n" +
                "\n" +
                "              <p style=\"font-size: 12px; line-height: 12px; font-family: 'Helvetica', Arial, sans-serif; font-weight: normal; text-decoration: none; color: #919293; margin-top: 30px;\">\n" +
                "                Email template built by <a style=\"text-decoration: none; color: #919293;\" href=\"https://fullsphere.co.uk\"><u>FullSphere</u></a>\n" +
                "              </p>\n" +
                "\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "        </tbody>\n" +
                "      </table>\n" +
                "      <!-- End unsubscribe section -->\n" +
                "  \n" +
                "  </div>\n" +
                "\n" +
                "  </body>\n" +
                "\n" +
                "</html>";
        byte[] bytes = body.getBytes();
        String bodyIso = new String(bytes,StandardCharsets.ISO_8859_1);

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", smtpHost);
        properties.put("mail.smtp.port", smtpPort);
        properties.put("mail.smtp.connectiontimeout", 25000);
        properties.put("mail.smtp.timeout", 23000);
        properties.put("mail.smtp.writetimeout", 25000);
        properties.put("mail.default-encoding", StandardCharsets.ISO_8859_1);



        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            // Création du message
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiverEmail));
            message.setSubject(subject);
            message.setText(body, StandardCharsets.UTF_8.name(),"html");


            Transport.send(message);

            System.out.println("Le message a été envoyé avec succès!");

        } catch (MessagingException e) {
            e.printStackTrace();
            System.err.println("Une erreur est survenue lors de l'envoi du message.");
        }
    }
}