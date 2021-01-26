

import java.util.ArrayList;
import java.util.List;

public class LiquorService {

    public List getAvailableBrands(model.LiquorType type){

        List brands = new ArrayList();

        if(type.equals(model.LiquorType.WINE)){
            brands.add("Adrianna Vineyard");
            brands.add(("J. P. Chenet"));

        }else if(type.equals(model.LiquorType.WHISKY)){
            brands.add("Glenfiddich");
            brands.add("Johnnie Walker");

        }else if(type.equals(model.LiquorType.BEER)){
            brands.add("Corona");

        }else {
            brands.add("No Brand Available");
        }
        return brands;
    }
}
