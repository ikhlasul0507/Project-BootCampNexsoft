import redis.clients.jedis.Jedis;

import java.util.List;

public class RedisListJava {
    public static void main(String[] args) {
        //Connecting to Redis server on localhost
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server sucessfully");
        //store data in redis list
        String listKey = "tutorial";
        jedis.lpush(listKey, "Redis");
        jedis.lpush(listKey, "Mongodb");
        jedis.lpush(listKey, "Mysql");
        // Get the stored data and print it
        List<String> list = jedis.lrange(listKey, 0 ,2);
        for(int i = 0; i<list.size(); i++) {
            System.out.println("Stored string in redis:: "+list.get(i));
        }
    }
}
