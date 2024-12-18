package com.example.Learning_Navigator.Learning_Navigator.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ThirdPartyService {

    private final RestTemplate restTemplate;

    public ThirdPartyService(){
        this.restTemplate = new RestTemplate();
    }

    public ResponseEntity<String> thirdPartyCall(int numbers){

        String url = "http://numbersapi.com/" + numbers;
        return restTemplate.getForEntity(url, String.class);
    }
}
