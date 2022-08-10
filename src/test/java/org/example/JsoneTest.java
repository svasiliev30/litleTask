package org.example;

import static org.junit.Assert.assertTrue;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * Unit test for simple App.
 */
public class JsoneTest {

    private static final String filePath = "C:\\Project\\testing\\artistsData1.json";

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try (InputStream inputStream = new FileInputStream(filePath)) {
            ArtistsHolder star = objectMapper.readValue(inputStream, ArtistsHolder.class);
            Set<Artist> artists = star.getArtists();

            artists.stream()
                    .max(Comparator.comparing(this::getRank))
                    .ifPresent(artist -> System.out.println(artist.name + ":" + artist.getRank()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Integer getRank(Artist a) {
        int rank = Integer.MIN_VALUE;
        try {
            rank = Integer.parseInt(a.getRank());
        } catch (Exception e) {
            System.out.println("error:" + e.getMessage());
        }
        return rank;
    }
}
/**
 * try (InputStream inputStream = new FileInputStream(filePath)) {
 * <p>
 * Star star = objectMapper.readValue(inputStream, Star.class);
 * for (Iterator<Artist> iterator = star.getArtists().iterator();
 * iterator.hasNext(); ) {
 * Artist artist = (Artist) iterator.next();
 * if (artist.getRank() == null)
 * artistMap.put(artist.getId(), null);
 * else {
 * try {
 * artistMap.put(artist.getId(), Integer.valueOf(artist.getRank()));
 * } catch (Exception e) {
 * artistMap.put(artist.getId(), null);
 * }
 * }
 * }
 * } catch (IOException e) {
 * e.printStackTrace();
 * }
 * <p>
 * for (Integer value : artistMap.values()) {
 * if (value != null && value > maxValue) {
 * maxValue = value;
 * }
 * }
 * <p>
 * Integer finalMaxValue = maxValue;
 * <p>
 * artistMap.entrySet().stream().
 * filter(artist -> artist.getValue() == finalMaxValue).
 * forEach(artist -> System.out.println("Артист с самым большим рангом - " + artist.getKey() + "." +
 * "\n составил " + artist.getValue()));
 */