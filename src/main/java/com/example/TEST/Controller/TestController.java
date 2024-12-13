package com.example.TEST.Controller;

import com.example.TEST.Dto.ResponseDto;
import com.example.TEST.Service.TestService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TestController {
    @Autowired
    TestService service;

    final String uri = "https://jsonplaceholder.typicode.com/posts";
    RestTemplate restTemplate = new RestTemplate();
    String result = restTemplate.getForObject(uri, String.class);
    JSONObject root = new JSONObject(result);
    JSONArray data = root.names();

    @CrossOrigin
    @GetMapping()
    public List<ResponseDto> getData(){
        for (int i = 0; i < data.length(); i++) {
            System.out.println(data.getJSONObject(i));

        }

        return null;
    }

}
