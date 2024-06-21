import React, {useState, useEffect} from 'react';
import IconButton from '../../../../../components/IconButton';
import IconDelete from '../../../../../components/icons/Delete';
import songAction from '../../actions/song';
import {useDispatch} from 'react-redux';
import Typography from '../../../../../components/Typography';
import List from '../../../../../components/List';
import ListItem from '../../../../../components/ListItem';
import ListItemText from '../../../../../components/ListItemText';
import Pagination from '../../../../../components/Pagination';
import {useLocation} from 'react-router-dom';
import queryString from 'query-string';

const SongList = () => {
    const dispatch = useDispatch();
    const location = useLocation();
    const queryParams = queryString.parse(location.search);
    const pageNumber = queryParams.page ? parseInt(queryParams.page) : 1;
    const [songs, setSongs] = useState([]);
    const [currentPage, setCurrentPage] = useState(pageNumber);
    const songsPerPage = 5;

    useEffect(() => {
        songAction.fetchSongList()(dispatch)
            .then((data) => {
                setSongs(data);
            });
    }, [dispatch]);

    const handlePageChange = (page) => {
        const newQueryParams = queryString.stringify({...queryParams, page});
        window.history.replaceState({}, '', `${location.pathname}?${newQueryParams}`);
        setCurrentPage(page);
    };

    const getCurrentSongs = () => {
        const startIndex = (currentPage - 1) * songsPerPage;
        return songs.slice(startIndex, startIndex + songsPerPage);
    };
    const totalPages = Math.ceil(songs.length / songsPerPage);

    return (
        <>
            {songs.length > 0 ? (
                <>
                    <List>
                        {getCurrentSongs().map((song) => (
                            <ListItem key={song.id}>
                                <ListItemText primary={`${song.id}`}/>
                                <ListItemText primary={song.title}/>
                                <ListItemText primary={`${song.album}`}/>
                                <IconButton>
                                    <IconDelete size={32}/>
                                </IconButton>
                            </ListItem>
                        ))}
                    </List>
                    <Pagination
                        currentPage={currentPage}
                        totalPages={totalPages}
                        onPageChange={handlePageChange}
                    />
                </>
            ) : (
                <Typography>No data</Typography>
            )}
        </>
    );
};

export default SongList;
