package io.erkki.devrss;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Files;

public class TestFiles {

    public static String mockitoPage() {
        try {
            return Files.readString(new ClassPathResource("mockito-core.html").getFile().toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
