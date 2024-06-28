CREATE INDEX album_index ON song (album);
CREATE INDEX genre_index ON song (genre);

INSERT INTO artist (artist_id, artist_name, artist_country)
VALUES (1, 'Linkin Park', 'USA');
INSERT INTO artist (artist_id, artist_name, artist_country)
VALUES (2, 'Sum 41', 'Canada');
INSERT INTO artist (artist_id, artist_name, artist_country)
VALUES (3, 'Thousand Foot Krutch', 'Canada');
INSERT INTO artist (artist_id, artist_name, artist_country)
VALUES (4, 'Foo Fighters', 'USA');
INSERT INTO artist (artist_id, artist_name, artist_country)
VALUES (5, 'Green Day', 'USA');
INSERT INTO artist (artist_id, artist_name, artist_country)
VALUES (6, 'Audioslave', 'USA');

INSERT INTO song (title, duration, album, genre, artist_id)
VALUES ('Numb', 3.24, 'Meteora', 'Alternative Rock', 1);
INSERT INTO song (title, duration, album, genre, artist_id)
VALUES ('In the End', 4.19, 'Hybrid Theory', 'Nu Metal', 1);
INSERT INTO song (title, duration, album, genre, artist_id)
VALUES ('What I''ve Done', 3.06, 'Minutes to Midnight', 'Alternative Rock', 1);

INSERT INTO song (title, duration, album, genre, artist_id)
VALUES ('Fat Lip', 3.01, 'All Killer No Filler', 'Pop Punk', 2);
INSERT INTO song (title, duration, album, genre, artist_id)
VALUES ('Pieces', 3.28, 'Chuck', 'Alternative Rock', 2);
INSERT INTO song (title, duration, album, genre, artist_id)
VALUES ('With Me', 3.43, 'Underclass Hero', 'Pop Punk', 2);

INSERT INTO song (title, duration, album, genre, artist_id)
VALUES ('Move', 3.24, 'The Art of Breaking', 'Christian Rock', 3);
INSERT INTO song (title, duration, album, genre, artist_id)
VALUES ('Fire It Up', 3.38, 'Welcome to the Masquerade', 'Christian Rock', 3);
INSERT INTO song (title, duration, album, genre, artist_id)
VALUES ('Untraveled Road', 4.11, 'Oxygen: Inhale', 'Christian Rock', 3);

INSERT INTO song (title, duration, album, genre, artist_id)
VALUES ('Rope', 4.11, 'Wasting Light', 'Alternative Rock', 4);
INSERT INTO song (title, duration, album, genre, artist_id)
VALUES ('All My Life', 4.10, 'One by One', 'Alternative Rock', 4);
INSERT INTO song (title, duration, album, genre, artist_id)
VALUES ('The Pretender', 5.20, 'Echoes, Silence, Patience & Grace', 'Alternative Rock', 4);

INSERT INTO song (title, duration, album, genre, artist_id)
VALUES ('Boulevard of Broken Dreams', 3.22, 'American Idiot', 'Punk Rock', 5);
INSERT INTO song (title, duration, album, genre, artist_id)
VALUES ('Basket Case', 2.41, 'Dookie', 'Punk Rock', 5);
INSERT INTO song (title, duration, album, genre, artist_id)
VALUES ('Bang Bang', 3.00, 'Revolution Radio', 'Punk Rock', 5);

INSERT INTO song (title, duration, album, genre, artist_id)
VALUES ('Like a Stone', 4.52, 'Audioslave', 'Alternative Rock', 6);
INSERT INTO song (title, duration, album, genre, artist_id)
VALUES ('Be Yourself', 3.54, 'Out of Exile', 'Alternative Rock', 6);
INSERT INTO song (title, duration, album, genre, artist_id)
VALUES ('Original Fire', 5.41, 'Revelations', 'Alternative Rock', 6);
