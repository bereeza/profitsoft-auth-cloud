package com.profitsoft.profitsoft.controller;

import com.profitsoft.profitsoft.dto.Response;
import com.profitsoft.profitsoft.dto.artist.ArtistSaveDto;
import com.profitsoft.profitsoft.dto.artist.ArtistInfoDto;
import com.profitsoft.profitsoft.exception.artist.ArtistNotFoundException;
import com.profitsoft.profitsoft.service.artist.ArtistService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Secondary controller responsible for manipulating the artist
 */
@RestController
@RequestMapping("/api/artist")
@RequiredArgsConstructor
public class ArtistController {

    /**
     * Artist Service for interaction between the controller & DB
     */
    private final ArtistService artistService;

    /**
     * To get list with artist
     *
     * @return - list response with Artist data ( Artist entity is incomplete )
     */
    @GetMapping
    public ResponseEntity<List<ArtistInfoDto>> getAllArtists() {
        return ResponseEntity
                .ok(artistService.getAllArtists());
    }

    /**
     * To create a new valid artist. Incorrect entity = 400 Bad request
     *
     * @param artist - valid entity of artist
     * @return - response with ArtistSaveDto data
     */
    @PostMapping
    public Response addArtist(@Valid @RequestBody ArtistSaveDto artist) {
        return new Response(artistService.save(artist));
    }

    /**
     * To update an artist with valid entity artist.
     * User can put a completely new entity or partial param.
     * Incorrect entity = 400 Bad request
     *
     * @param id     - artist id
     * @param artist - new valid entity
     * @return - response with message
     */
    @PutMapping("/{id}")
    public Response updateArtistById(@PathVariable long id, @Valid @RequestBody ArtistSaveDto artist) {
        artistService.updateArtistById(id, artist);
        return new Response("Artist updated successfully");
    }

    /**
     * To delete an existing artist.
     *
     * @param id - artist id
     * @return - response with successful message or 404 Not found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteArtistById(@PathVariable long id) {
        try {
            artistService.deleteArtistById(id);
            return ResponseEntity.ok(new Response("Artist deleted successfully"));
        } catch (ArtistNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response(ex.getMessage()));
        }
    }
}

