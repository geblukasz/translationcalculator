package com.translationcalculator.translationform.config;

import com.fasterxml.jackson.dataformat.yaml.snakeyaml.Yaml;
import com.translationcalculator.translationform.utils.LoadAsJavaObject;

import java.io.IOException;
import java.io.InputStream;

public class ConfigYml {

    private int port;
    private String path;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "ConfigYml{" +
                "port='" + port + '\'' +
                ", path='" + path + '\'' +
                '}';
    }

    public void readYamlFile(){
        Yaml yaml = new Yaml();
        try (InputStream in = LoadAsJavaObject.class
                .getResourceAsStream("/configApp.yml")) {
            ConfigYml ConfigYml = yaml.loadAs(in, ConfigYml.class);
            this.port = ConfigYml.port;
            this.path = ConfigYml.path;
            System.out.println("Configuration: " + ConfigYml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}