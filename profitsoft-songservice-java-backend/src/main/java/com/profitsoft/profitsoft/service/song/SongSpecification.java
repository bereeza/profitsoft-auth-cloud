package com.profitsoft.profitsoft.service.song;

import com.profitsoft.profitsoft.entity.Song;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class SongSpecification {
    public static Specification<Song> byAlbumAndGenre(String album, String genre) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (album != null && !album.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("album"), album));
            }
            if (genre != null && !genre.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("genre"), genre));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
