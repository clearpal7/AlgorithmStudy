package streamstudy;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class GCDemo {

    static final int[] iArray = new int[2*1024*1024];

    public static void main(String[] args) {
        Flux.just("Spring", "Spring Boot", "Reactive Spring Boot")
                .map(s -> s.concat("flux"));
                //.subscribe(System.out::println);

        Mono.just("Spring")
                .map(s -> s.concat("flux"))
                .subscribe(System.out::println);
    }
}
