package com.in28minutes.learn_spring_aop.aopexample.data;

import org.springframework.stereotype.Component;

@Component
public class DataService1 {

    // Talks to a database and returns info back

    public int[] retrieveData(){
        return new int[] {11, 22, 33, 44,55};
    }

}
