package src.entity;

//import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import src.main.GamePanel;
import src.main.KeyHandler;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;


    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        
        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        solidArea = new Rectangle(8,16,32,32);

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){

        //starting position of player
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;

        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {

        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/res/player/player_back.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/player/player_back.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/player/player_front.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/player/player_front.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/player/player_left.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/player/player_left.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/player/player_right.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/player/player_right.png"));

        } catch(IOException e) {
            e.printStackTrace();
        }

    }

    public void update() {
        
        if(keyH.upPressed == true || keyH.downPressed == true || 
           keyH.leftPressed == true || keyH.rightPressed == true){

            if (keyH.upPressed == true) {
                direction = "up";          
            }else if (keyH.downPressed == true) {
                direction = "down";               
            }else if (keyH.leftPressed == true) {
                direction = "left";                
            }else if (keyH.rightPressed == true) {
                direction = "right";     
            }

            //check tile collision
            collisionOn = false;
            gp.cChecker.checkTile(this);

            //if collision is FALSE: player can move
            if (collisionOn == false){
                switch (direction){
                    case "up":
                        worldY -= speed;
                        break;

                    case "down":
                        worldY += speed;
                        break;

                    case "left":
                        worldX -= speed;
                        break;

                    case "right":
                        worldX += speed;
                        break;

                }
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

        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);


    }
    
}
