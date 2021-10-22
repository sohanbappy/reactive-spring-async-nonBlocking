package com.reactivespring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class ReactiveSpringApplication {

    public static void main(String[] args) {
        //Stream, filter
        List<String> list = Stream.of("abcd", "def", "rst").collect(Collectors.toList())
                .stream().filter(e -> e.contains("d")).collect(Collectors.toList());
        //forEach, Lambda
        list.stream().forEach(e -> System.out.println(e.toUpperCase()));

        SpringApplication.run(ReactiveSpringApplication.class, args);
    }

}
