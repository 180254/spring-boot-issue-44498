package com.example.demo;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.aop.TimedAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Bean
  public TimedAspect timedAspect() {
    return new TimedAspect();
  }

  @Service
  public static class DemoService {

    public DemoService(DemoFactory demoFactory) {
      Thread initThread = new Thread(demoFactory::initSomething);
      initThread.setName("DemoService-initThread");
      initThread.start();
    }
  }

  @Service
  public static class DemoFactory {

    @Timed(value = "init_timed")
    void initSomething() {
      System.out.println("INIT SOMETHING");
    }
  }
}
