package life.zkf.hustcatdog;

import life.zkf.hustcatdog.service.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import life.zkf.hustcatdog.service.storage.StorageProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class HustcatdogApplication {

    private StorageService storageService;

    public static void main(String[] args) {
        SpringApplication.run(HustcatdogApplication.class, args);
    }

    @Bean
    CommandLineRunner init(StorageService storageService) {
        this.storageService = storageService;
        return (args) -> {
            //storageService.deleteAll();
            storageService.init();
        };
    }
}
