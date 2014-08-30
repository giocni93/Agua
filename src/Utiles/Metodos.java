package Utiles;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Metodos {
    
    public void Solo_Numeros(JTextField a)
    {
        a.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e)
            {
                char c = e.getKeyChar();
                if((Character.isLetter(c)))
                {
                   e.consume();
                }
                else
                {
                    if(((int)e.getKeyChar() != 20) && ((int)e.getKeyChar() != 44) && 
                            (((int)e.getKeyChar() < 48) || ((int)e.getKeyChar() > 57)))
                    {
                       e.consume();
                    }
                }
            }
        });
    }
    
    public void Limite_Caracteres(JTextField a,int limite)
    {
        final int limit = limite;
        a.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e)
            {
                JTextField c =(JTextField) e.getComponent();
                if(c.getText().length() == limit)
                {
                    //getToolkit().beep(); //producir un sonido
                    e.consume();
                }  
            }
        });
    }
    
    public boolean Validar_Email (String email) 
    {
        // Establecer el patron
        Pattern p = Pattern.compile("[-\\w\\.]+@\\w+\\.\\w+");

        // Asociar el string al patron
        Matcher m = p.matcher(email);

       // Comprobar si encaja
        boolean estado = m.matches();
        if(!estado)
        {
            JOptionPane.showMessageDialog(null,"El correo electrónico es incorrecto, por favor digite un correo válido "
                    + ", por ejemplo:\n usuario_001@hotmail.com",
                    "Error",JOptionPane.ERROR_MESSAGE);
        }
       return estado;
    }
    
    public boolean campo_vacio(JTextField txt,String campo)
    {
        String cadena = txt.getText().trim();
        if(cadena.compareTo("") == 0)
        {
            JOptionPane.showMessageDialog(null,"El campo '"+campo+"' se encuentra vacio, por favor ingrese un valor en dicho campo.",
                                          "Error",JOptionPane.ERROR_MESSAGE);
            txt.requestFocus();
            return true;
        }
        return false;
    }
/*    
    public boolean enviarEmail(String destino,String asunto,String mensaje)
    {
        // Datos de configuracion;
        String correoServidor = "fernandoeventos2014@gmail.com";
        String contrasenaCorreo = "q1u2e3r4u5b6i7n8";
        String usuario = "fernando camargo";
        
        try
        {
            // Propiedades de la conexión
            Properties props = new Properties();
            
            // Nombre del host de correo, es smtp.gmail.com
            props.setProperty("mail.smtp.host", "smtp.gmail.com"); 
            
            // TLS si está disponible
            props.setProperty("mail.smtp.starttls.enable", "true");
            
            // Puerto de gmail para envio de correos
            props.setProperty("mail.smtp.port", "587");
            
            // Nombre del usuario
            props.setProperty("mail.smtp.user", usuario);
            
            // Si requiere o no usuario y password para conectarse.
            props.setProperty("mail.smtp.auth", "true");

            // Preparamos la sesion
            Session session = Session.getDefaultInstance(props);
            
            // Construimos el mensaje
            MimeMessage message = new MimeMessage(session);
            
            // Quien envia el correo
            message.setFrom(new InternetAddress(correoServidor));
            
            // A quien va dirigido
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(destino));
            
            // Asunto
            message.setSubject(asunto);
            
            // Mensaje
            message.setText(mensaje);

            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            
            System.out.println("antes");
            // correo fuente con su contraseña
            t.connect(correoServidor, contrasenaCorreo);
            System.out.println("despues");
            
            
            // enviar
            t.sendMessage(message, message.getAllRecipients());
            
            // Cierre.
            t.close();
            
            return true;
        }
        catch (MessagingException e)
        {
            JOptionPane.showMessageDialog(null,"Eror de conexion, revise si tiene acceso a internet \n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
*/ 
}
