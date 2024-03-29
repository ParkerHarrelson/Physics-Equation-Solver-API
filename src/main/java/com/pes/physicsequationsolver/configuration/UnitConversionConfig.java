package com.pes.physicsequationsolver.configuration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class UnitConversionConfig {

    @Bean
    public Map<String, Map<String, Double>> conversionFactors() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        TypeReference<HashMap<String, Map<String, Double>>> typeRef = new TypeReference<>() {};
        InputStream inputStream = TypeReference.class
                .getResourceAsStream("/conversionFactors.yml");
        return mapper.readValue(inputStream, typeRef);
    }
}

