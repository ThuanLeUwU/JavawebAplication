/*To
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thuanlm.cart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author lthua
 */
public class CartObject implements Serializable{
    private  Map<String, Integer> items;

//    public CartObject(Map<String, Integer> items) {
//        this.items = items;
//    }
    
     public Map<String, Integer> getItems() {
        return items;
    }

    
    public void addItemToCart (String id) {
        //1.check available items ?
        if (this.items == null) {
            this.items = new HashMap<>();
        }//end items are not existed 
        //2. drop item to cart
        
        int quanlity = 1;
        if (this.items.containsKey(id)){
            quanlity = this.items.get(id) + 1;
        }
        
        this.items.put(id, quanlity);
        
    }
    
    public void removeItemFromCart(String id) {
        //1. check available items 
        if (this.items == null) {
            return;
        }
        
        //2. remove items from cart 
        if (this.items.containsKey(id)) {
            this.items.remove(id);
            if (this.items.isEmpty()) {
                this.items = null;
            }
        }
    }
}
