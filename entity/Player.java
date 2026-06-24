package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;


    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){

        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {

        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/player_back.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/player_back.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/player_front.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/player_front.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/player_left.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/player_left.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/player_right.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/player_right.png"));

        } catch(IOException e) {
            e.printStackTrace();
        }

    }

    public void update() {
        
        if(keyH.upPressed == true || keyH.downPressed == true || 
           keyH.leftPressed == true || keyH.rightPressed == true){

            if (keyH.upPressed == true) {
                direction = "up";
                y -= speed;
            }else if (keyH.downPressed == true) {
                direction = "down";
                y += speed;
            }else if (keyH.leftPressed == true) {
                direction = "left";
                x -= speed;
            }else if (keyH.rightPressed == true) {
                direction = "right";
                x += speed;
            }

            spriteCounter++;

            //change how fast the sprite changed
            if (spriteCounter > 12) {
                if(spiriteNum == 1) {
                    spiriteNum = 2;
                }else if (spiriteNum == 2) {
                    spiriteNum = 1;
                }

                spriteCounter = 0; 
            }
        }
    }

    public void draw(Graphics g2) {

        // g2.setColor(Color.white);
        // g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;

        if (direction.equals("up")) {
            if(spiriteNum == 1){
                image = up1; 
            }
            if(spiriteNum == 2){
                image = up2;
            }

        }else if (direction.equals("down")){
            if(spiriteNum == 1){
                image = down1; 
            }
            if(spiriteNum == 2){
                image = down2;
            }

        }else if (direction.equals("left")){
            if(spiriteNum == 1){
                image = left1; 
            }
            if(spiriteNum == 2){
                image = left2;
            }

        }else if (direction.equals("right")){
            if(spiriteNum == 1){
                image = right1; 
            }
            if(spiriteNum == 2){
                image = right2;
            }

        }

        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);


    }
    
}
