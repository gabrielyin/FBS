package Modules;

import javafx.scene.image.Image;

public class Item {
    String ITEM;
    Image IMG;
    
    public Item() {
    
    }
    
    public Item(String ITEM,Image IMG){
        this.ITEM = ITEM;
        this.IMG = IMG;
    }
    
    public String getItem(){
        return ITEM;
    }
    
    public void setItem(String ITEM){
        this.ITEM = ITEM;
    }
    
    public Image getImg(){
        return IMG;
    }
    
    public void setImg(Image IMG){
        this.IMG = IMG;
    }
}
