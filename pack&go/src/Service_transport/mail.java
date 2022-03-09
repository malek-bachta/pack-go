/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service_transport;
package app.mail;
import Entities_transport.Transport;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.session;


/**
 *
 * @author Soulaima ben romdhan
 */
public class mail {
    
   

    public static void sendMail(String recepient) throws Exception {
        System.out.println("preparing to send email");

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String myAccountEmail = "xxxxx@gmail.com";
        String myAccountPassword = "xxxxx";
       
        
        session session = session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, myAccountPassword);
            }
        });

       message message = prepareMessageBlock(session, myAccountEmail,recepient );
       Transport.send(message);
        System.out.println("message sent successfully");
    }

    private static Message prepareMessageBlock(session session, String myAccountEmail) {

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("my first email");
            message.setText("hey there,\n look my email");
            return message;

        } catch (Exception ex) {
            Logger.getLogger(mail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
}
   /* private static Message prepareMessageDeblock(Session session, String myAccountEmail, String recepient) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Demande de déblocage");
            message.setText("Certain utilisateur demande un déblocage.\n Verifier la liste des patients pour pouvoir les débloquer\n Cordialement");
            return message;

        } catch (Exception ex) {
            Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private static Message prepareMessageReclamation(Session session, String myAccountEmail, String recepient, String text) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Reclamation");
            message.setText("Bonjour, l'un des medecins à reclamer à cette question qui présente des termes de violence \n * " + text + " * \n  Merci de bloqué cet utilisateur si c'est nécessaire \n Cordialement");
            return message;

        } catch (Exception ex) {
            Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private static Message prepareMessageNouvelleReponseAjoute(Session session, String myAccountEmail, String recepient) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Reponse ajouté");
            message.setText("Bonjour,  une réponse à votre question est ajouté,   \n  Vérifier votre compte \n Cordialement");
            return message;

        } catch (Exception ex) {
            Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

 if (code == 1) { //Si le code=1 envoyé un mail de blocage
            Message message = prepareMessageBlock(session, myAccountEmail, recepient);
            Transport.send(message);

        }
        if (code == 2) {// si le code=2 envoyé un mail de débloblocage
            Message message = prepareMessageDeblock(session, myAccountEmail, recepient);
            Transport.send(message);
        }
        if (code == 3) { // si le code=3 envoyé une réclamation
            Message message = prepareMessageReclamation(session, myAccountEmail, recepient, text);
            Transport.send(message);
        }
        if (code == 4) { // si le code=3 envoyé une réclamation
            Message message = prepareMessageNouvelleReponseAjoute(session, myAccountEmail, recepient);
            Transport.send(message);
        }*/