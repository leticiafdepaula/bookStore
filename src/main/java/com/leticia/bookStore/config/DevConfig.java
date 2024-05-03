package com.leticia.bookStore.config;

import com.leticia.bookStore.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile ("dev")
public class DevConfig {

    @Autowired
    private DBService dbService;

    @Value ("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;
   @Bean
   public Boolean instanciaBaseDeDados() {
      if (strategy.equals ("create")) {
        this.dbService.instanciaBaseDeDados ();
      }
       return false;
   }
}
