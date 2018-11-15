package com.gilpratte.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

/**
 * Test the controller endpoints
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void authenticationNoToken() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/user",
            String.class)).contains("Unauthorized").contains("401");
    }

    /**
     * This test calls the generate token endpoint the same as the follow curl does
 <pre>curl -X POST localhost:8080/token/generate-token \
 -H "Content-Type: application/json" \
 -d '{"username": "Alex123", "password": "password"}'</pre>
     * and expects the result to have json like the following
 <pre>{"token":"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJBbGV4MTIzIiwic2NvcGVzIjpbeyJhdXRob3JpdHkiOiJST0xFX0FETUlOIn1dLCJpc3MiOiJodHRwOi8vZ2lscHJhdHRlLmNvbSIsImlhdCI6MTU0MjI0NTQwOCwiZXhwIjoxNTQyMjYzNDA4fQ.eqf9V_vkVB2AoMkKBwIpyFAAWnWcmkkbmY7Ygb3m6Lw"}</pre>
     */
    @Test
    public void generateToken() throws IOException {
        // Headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Body
        Map<String, String> body = new HashMap<String, String>();
        body.put("username", "Alex123");
        body.put("password", "password");
        String bodyAsJson = mapper.writeValueAsString(body);

        // Headers and body
        HttpEntity<String> requestEnty = new HttpEntity<>(bodyAsJson, headers);

        String url = "http://localhost:" + port + "/token/generate-token";

        // Call the endpoint
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEnty, String.class);

        // Turn the json reply into a map
        TypeReference<HashMap<String, String>> typeRef
            = new TypeReference<HashMap<String, String>>() {};
        Map<String, String> responseToken = mapper.readValue(responseEntity.getBody(), typeRef);

        // Make sure there is a key with the name "token"
        assertThat(responseToken.keySet()).contains("token");
    }

}