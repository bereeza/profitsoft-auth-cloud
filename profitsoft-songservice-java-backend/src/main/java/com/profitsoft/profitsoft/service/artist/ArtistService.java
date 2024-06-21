package com.profitsoft.profitsoft.service.artist;

import com.profitsoft.profitsoft.dto.artist.ArtistSaveDto;
import com.profitsoft.profitsoft.dto.artist.ArtistInfoDto;
import com.profitsoft.profitsoft.entity.Artist;
import com.profitsoft.profitsoft.exception.artist.ArtistNotFoundException;
import com.profitsoft.profitsoft.repository.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service for manipulating the artist
 */
@Service
@RequiredArgsConstructor
public class ArtistService {

    // artist repository for performing entity operations
    private final ArtistRepository artistRepository;

    // To save artist in repository
    public String save(ArtistSaveDto artist) {
        Artist savedArtist = extractArtist(artist);
        artistRepository.save(savedArtist);
        return String.valueOf(savedArtist.getArtistId());
    }

    private Artist extractArtist(ArtistSaveDto artist) {
        return Artist.builder()
                .artistId(artist.getArtistId())
                .artistCountry(artist.getArtistCountry())
                .artistName(artist.getArtistName())
                .artistName(artist.getArtistName())
                .build();
    }

    // To get all Artist (ArtistInfoDto)
    public List<ArtistInfoDto> getAllArtists() {
        return artistRepository.findAll().stream()
                .map(this::extractArtistInfo)
                .toList();
    }

    // To delete an artist with existing id or get exception
    public void deleteArtistById(long id) {
        Optional<Artist> artist = artistRepository.findById(id);
        if (artist.isPresent()) {
            artistRepository.deleteById(id);
        } else {
            throw new ArtistNotFoundException("Artist not found");
        }
    }

    // To update an artist with existing id
    public void updateArtistById(long id, ArtistSaveDto artist) {
        Optional<Artist> artistOptional = artistRepository.findById(id);
        if (artistOptional.isPresent()) {
            Artist existingArtist = artistOptional.get();
            updateArtist(artist, existingArtist);
            artistRepository.save(existingArtist);
        }
    }

    private void updateArtist(ArtistSaveDto artist, Artist existingArtist) {
        existingArtist.setArtistName(artist.getArtistName());
        existingArtist.setArtistCountry(artist.getArtistCountry());
        existingArtist.setSongs(artist.getSongs());
    }

    private ArtistInfoDto extractArtistInfo(Artist artist) {
        return ArtistInfoDto.builder()
                .id(artist.getArtistId())
                .artistCountry(artist.getArtistCountry())
                .artistName(artist.getArtistName())
                .build();
    }
}
