package com.translationcalculator.translationform.utils;

import com.fasterxml.jackson.dataformat.yaml.snakeyaml.Yaml;
import com.translationcalculator.translationform.config.ConfigYml;

import java.io.IOException;
import java.io.InputStream;

public class LoadAsJavaObject {

        public static void main(String[] args) throws IOException {
            Yaml yaml = new Yaml();
            try (InputStream in = LoadAsJavaObject.class
                    .getResourceAsStream("/configApp.yml")) {
                ConfigYml ConfigYml = yaml.loadAs(in, ConfigYml.class);
                System.out.println("Configuration: " + ConfigYml);
            }
    }
}