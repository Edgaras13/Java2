package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception{
//        List<String> list9 = List.of("a", "b", "c");
//        List<String> list10 = new ArrayList<>();
//
//        list10.addAll(list9);
//        list10.add("d");
//        list10.forEach(System.out::println);

//        HttpClient httpClient = HttpClient.newHttpClient();
//
//        HttpRequest httpRequest = HttpRequest.newBuilder()
//                .uri(new URI("http://api.population.io:80/1.0/population/2019/Lithuania/"))
//                .GET()
//                .build();
//
//        HttpResponse<String> response = httpClient
//                .send(httpRequest, HttpResponse.BodyHandlers.ofString());
//        List<Stat> list = new ArrayList<>();
//        ObjectMapper mapper = new ObjectMapper();
//
//        BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Projects\\Java2\\Java11\\src\\main\\java\\com\\company\\file.json"));
//        writer.write(response.body());
//        writer.close();
//        Stat zero = mapper.readValue(new File("D:\\Projects\\Java2\\Java11\\src\\main\\java\\com\\company\\file.json"), Stat.class);
//        System.out.println(zero.toString());
    }
}
