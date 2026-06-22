import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed;

    //don't use
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //get number for key that was pressed
        int code = e.getKeyCode(); 

        //check which key was pressed
        if(code == KeyEvent.VK_W){
            upPressed = true;
        }

        if(code == KeyEvent.VK_A){
            leftPressed = true;
        }

        if(code == KeyEvent.VK_S){
            downPressed = true;    
        }

        if(code == KeyEvent.VK_D){
            rightPressed = true;    
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        //get key pressed
        int code = e.getKeyCode();

        //check which key was released
        if(code == KeyEvent.VK_W){
            upPressed = false;
        }

        if(code == KeyEvent.VK_A){
            leftPressed = false;      
        }

        if(code == KeyEvent.VK_S){
            downPressed = false;          
        }

        if(code == KeyEvent.VK_D){
            rightPressed = false;         
        }

    }
    

    
}
