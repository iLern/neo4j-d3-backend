package com.example.neo4jd3;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class ReactorTests {

    @Test
    public void test1() {
        Mono.just("Craig") // a Mono
                .map(String::toUpperCase) // a Mono
                .map(n -> "Hello " + n + " !") // a Mono
                .subscribe(System.out::println);
    }

    @Test
    public void testFruit() {
        Flux<String> fruitFlux = Flux.just("Apple", "Orange", "Grape", "Banana", "Strawberry");
        fruitFlux.subscribe(
                f -> System.out.println("Here's some fruit: " + f)
        );
    }

    @Test
    public void testVerifier() {
        Flux<String> fruitFlux = Flux.just("Apple", "Orange", "Grape", "Banana", "Strawberry");
        StepVerifier.create(fruitFlux)
                .expectNext("Apple")
                .expectNext("Orange")
                .expectNext("Grape")
                .expectNext("Banana")
                .expectNext("Strawberry")
                .verifyComplete();
    }
}
