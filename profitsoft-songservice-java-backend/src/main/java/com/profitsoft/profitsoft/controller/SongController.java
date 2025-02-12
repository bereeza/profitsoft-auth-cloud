package com.profitsoft.profitsoft.controller;

import com.profitsoft.profitsoft.dto.Result;
import com.profitsoft.profitsoft.dto.Response;
import com.profitsoft.profitsoft.dto.UploadedResult;
import com.profitsoft.profitsoft.dto.song.SongDetailInfoDto;
import com.profitsoft.profitsoft.dto.song.SongInfoDto;
import com.profitsoft.profitsoft.dto.song.SongQueryDto;
import com.profitsoft.profitsoft.dto.song.SongSaveDto;
import com.profitsoft.profitsoft.exception.song.SongNotFoundException;
import com.profitsoft.profitsoft.service.song.SongService;
import com.profitsoft.profitsoft.util.CSVManager;
import com.profitsoft.profitsoft.util.JSONParser;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

/**
 * The main controller that works with the main entity - Song
 */
@RestController
@RequestMapping("/api/song")
@RequiredArgsConstructor
public class SongController {

    /**
     * Song Service for interaction between the controller & DB
     */
    private final SongService songService;

    /**
     * To create a new valid song. Incorrect entity = 400 Bad request
     *
     * @param songSaveDto - valid entity of songSaveDto
     * @return - response with SongDetailInfoDto data
     */
    @PostMapping
    public ResponseEntity<SongDetailInfoDto> addSong(@Valid @RequestBody SongSaveDto songSaveDto) {
        return ResponseEntity
                .ok(songService.save(songSaveDto));
    }

    /**
     * To get a song by id
     *
     * @param id - song id
     * @return - response with SongDetailInfoDto data
     */
    @GetMapping("/{id}")
    public ResponseEntity<Optional<SongDetailInfoDto>> getSongById(@PathVariable long id) {
        return ResponseEntity
                .ok(songService.getSongById(id));
    }

    /**
     * To update a song with valid entity.
     * User can put a completely new entity or partial param.
     * Incorrect entity = 400 Bad request
     *
     * @param id   - song id
     * @param song - new valid entity
     * @return - response with SongDetailInfoDto data
     */
    @PutMapping("/{id}")
    public ResponseEntity<SongDetailInfoDto> updateSongById(
            @PathVariable long id, @Valid @RequestBody SongSaveDto song) {
        return ResponseEntity
                .ok(songService.updateSongById(id, song));
    }

    /**
     * To delete an existing song.
     *
     * @param id - song id
     * @return - response with successful message or 404 Not found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteSongById(@PathVariable long id) {
        try {
            songService.deleteSongById(id);
            return ResponseEntity.ok(new Response("Song deleted successfully"));
        } catch (SongNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response(ex.getMessage()));
        }
    }

    /**
     * To get all songs by criteria
     *
     * @param query - criteria for filtering
     * @return - result entity with data & total_page (counter)
     */
    @PostMapping("_list")
    public Result<SongInfoDto> getAllSongs(@RequestBody SongQueryDto query) {
        Page<SongInfoDto> songPage = songService.getSongsByCriteria(query);
        return new Result<>(songPage.getContent(), songPage.getTotalPages());
    }

    /**
     * To get all songs by criteria & save result
     *
     * @param query    - criteria for filtering
     * @param response - response from HttpServletResponse (header, type, etc.)
     */
    @PostMapping("_report")
    public void getAllSongsReport(@RequestBody SongQueryDto query, HttpServletResponse response) {
        query.setSize(Integer.MAX_VALUE);
        query.setStartPage(0);

        Page<SongInfoDto> songPage = songService.getSongsByCriteria(query);
        List<SongInfoDto> songs = songPage.getContent();
        CSVManager.save(songs, response);
    }

    /**
     * To upload a data file to the service
     *
     * @param file - json file with data
     * @return - response with result ( Successfully & Failed)
     */
    @PostMapping("/upload")
    public Response uploadSong(@RequestParam("file") MultipartFile file) {
        UploadedResult<SongSaveDto> result = JSONParser.upload(file);
        songService.saveAllSongs(result.getData());
        return new Response(String.format("Successfully uploaded: %d. Failed: %d",
                result.getCounter(), result.getFailedRecords()));
    }
}
