import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

public class RedisKeyJava {
    public static void main(String[] args) {

        //Connecting to Redis server on localhost
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server sucessfully");
        //store data in redis list
        // Get the stored data and print it
        Set<String> list = jedis.keys("*");

        if(list.isEmpty()){
            System.out.println("Data List Not Found");
        }
        for (String x : list){
            System.out.println("list if stored keys ::" +x);
        }

//        System.out.println(list.toArray());
//
//        String [] arr = (String[]) list.toArray();
//        for(int i = 0; i< arr.length; i++) {
//            System.out.println("List of stored keys:: "+arr[i]);
//        }
    }
}
