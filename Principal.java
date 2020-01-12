
import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Principal {

    public Principal() {}

    public static void main(String[] args) throws AWTException {
        new Principal().iconeNotificacao();
    }
    
    
    public void iconeNotificacao()throws AWTException {
   
            if (SystemTray.isSupported()) {

                SystemTray tray = SystemTray.getSystemTray();
                Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("circulo.gif"));

                MouseListener mouseListener = new MouseListener() {              
                    public void mouseClicked(MouseEvent e) {} public void mouseEntered(MouseEvent e) {}
                    public void mouseExited(MouseEvent e) {}  public void mouseReleased(MouseEvent e) {}
                    @Override
                    public void mousePressed(MouseEvent e) {
                        System.out.println("notificacao !!!");                 
                    }
                };
                TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
                trayIcon.setToolTip("Notificacao de host ativo");
                tray.add(trayIcon);
                trayIcon.addMouseListener(mouseListener);
                trayIcon.setImageAutoSize(true);
                trayIcon.displayMessage("Host esta ativo", "O host esta ativo", TrayIcon.MessageType.INFO);
            }   
    }
    
}
