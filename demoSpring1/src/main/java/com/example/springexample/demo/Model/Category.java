package com.example.springexample.demo.Model;

import java.util.concurrent.atomic.AtomicLong;

public class Category {
    private static final AtomicLong counter=  new AtomicLong();
    private long id;
    private String name;

    public Category() {
        this.id = counter.incrementAndGet();
    }

    public Category(long id,String name) {
        this.id = id;
        this.name = name;
    }

    public static AtomicLong getCounter() {
        return counter;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime*result+(int)(id^(id>>>32));
        return result;
    }
    @Override
    public boolean equals(Object obj){
        if (this==obj)
            return true;
        if (this==null)
            return false;
        if (getClass()!=obj.getClass())
            return false;
        Category other = (Category) obj;
        if(id!= other.id)
            return false;
        return true;
    }
    @Override
    public String toString(){
        return "Category [id="+id+",name="+name+"]";
    }
}
