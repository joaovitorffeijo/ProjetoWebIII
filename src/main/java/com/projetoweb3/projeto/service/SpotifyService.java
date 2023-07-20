package com.projetoweb3.projeto.service;

import com.projetoweb3.projeto.model.SpotifyAlbum;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import se.michaelthelin.spotify.SpotifyApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class SpotifyService {

    private static String accessToken = "BQBuClNeE1Q7ZkItVOoPs-gAvg70AiLdoe0LdHAel3iyh27okJjRjHvp83jqJgJJPo66yfHZFhhT0PmIdkv7dSE-ypsleq8KqGI2GlsV6f4jZFfiaeg";
    private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
            .setAccessToken(accessToken)
            .build();
    public String searchDiscography(String artist) {
        StringBuilder albumDetailsString = new StringBuilder();
        boolean artistFound = false;

        try {
            String encodedArtist = URLEncoder.encode(artist, StandardCharsets.UTF_8);
            URL url = new URL(getSpotifyApiUrl(encodedArtist));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", "Bearer " + accessToken);

            String response = sendSpotifyApiRequest(connection);
            JSONObject jsonResponse = new JSONObject(response);
            JSONArray itemsArray = jsonResponse.getJSONObject("albums").getJSONArray("items");

            albumDetailsString.append(parseAlbumDetails(itemsArray, artist));
            connection.disconnect();
        } catch (IOException e) {
            albumDetailsString.append("Error: ").append(e.getMessage());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        // Return the album details as a single string
        return albumDetailsString.toString();
    }

    private String getSpotifyApiUrl(String artist) {
        return "https://api.spotify.com/v1/search?q=" + artist + "&type=album";
    }

    private String sendSpotifyApiRequest(HttpURLConnection connection) throws IOException {
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            return response.toString();
        } else {
            return "Error: HTTP " + responseCode;
        }
    }

    private String parseAlbumDetails(JSONArray itemsArray, String artist) throws JSONException {
        List<SpotifyAlbum> spotifyAlbumList = new ArrayList<>();
        boolean artistFound = false;
        StringBuilder albumDetailsString = new StringBuilder();

        for (int i = 0; i < itemsArray.length(); i++) {
            JSONObject albumObject = itemsArray.getJSONObject(i);
            String artistName = albumObject.getJSONArray("artists").getJSONObject(0).getString("name");
            String albumName = albumObject.getString("name");
            String releaseDate = albumObject.getString("release_date");

            if (artistName.equals(artist)) {
                if (!artistFound) {
                    albumDetailsString.append("Artist: ").append(artistName).append("\n");
                    artistFound = true;
                }
                albumDetailsString.append("Album: ").append(albumName).append("\n");
                albumDetailsString.append("Release Date: ").append(releaseDate).append("\n\n");

                SpotifyAlbum spotifyAlbum = new SpotifyAlbum(artistName, albumName, releaseDate);
                spotifyAlbumList.add(spotifyAlbum);
            }
        }

        return albumDetailsString.toString();
    }
}
