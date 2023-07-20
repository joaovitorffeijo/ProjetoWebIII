package com.projetoweb3.projeto.controller;

import com.projetoweb3.projeto.service.ChatGPTService;
import com.projetoweb3.projeto.service.SpotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiMashupController {

    private final ChatGPTService chatGPTService;

    private final SpotifyService spotifyService;

    @Autowired
    public ApiMashupController(ChatGPTService chatGPTService, SpotifyService spotifyService) {
        this.chatGPTService = chatGPTService;
        this.spotifyService = spotifyService;
    }

    private String getArtistDiscography(String artist) {
        String response = spotifyService.searchDiscography(artist);
        return response;
    }

    private String getChatGPTCarrerDescriptionByDiscography(String discography){
        String response = chatGPTService.careerDescription(discography);
        return response;
    }

    @PostMapping("/test/spotify")
    public ResponseEntity<String> artistDiscography(@RequestBody String artist) {
        String response = spotifyService.searchDiscography(artist);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/test/chatgpt")
    public ResponseEntity<String> describeArtistCareerByDiscographyTest(@RequestBody String album) {
        String response = chatGPTService.careerDescription(album);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/mashup")
    public ResponseEntity<String> describeArtistCareerByDiscography(@RequestBody String artist) {
        String discography = getArtistDiscography(artist);
        String description = getChatGPTCarrerDescriptionByDiscography(discography);
        return ResponseEntity.ok(description);
    }
}

