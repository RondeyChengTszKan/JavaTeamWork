package la.bean;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import la.servlet.model.*;

public class CartBean {
    private Map<Integer,OrderItem>items=new HashMap<Integer,OrderItem>();
    private int total;

    public CartBean(){

    }

    public Map<Integer,OrderItem>getItems(){
        return items;
    }

    public void addCart(OrderItem bean, int nums){
        OrderItem item=(OrderItem)items.get(new Integer(bean.getId()));
        if(item==null){
            bean.setQuantity(nums);
            items.put(new Integer(bean.getId()),bean);}
        else{item.setQuantity(nums+item.getQuantity());
            item.setQuantity(nums+item.getQuantity());
        }
        recalcTotal();

    }

    public void deleteCart(int itemCode){
        items.remove(new Integer(itemCode));
        recalcTotal();
    }

    public int getTotal() {
        return total;
    }

    public void recalcTotal() {
        total=0;
        Collection<OrderItem>list=items.values();
        for(OrderItem item:list){
            total+=item.getPrice()*item.getQuantity();
        }
    }

}
