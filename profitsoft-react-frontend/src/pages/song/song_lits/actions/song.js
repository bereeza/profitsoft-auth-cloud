import {
    ERROR_RECEIVE_SONG_LIST,
    RECEIVE_SONG_LIST,
    REQUEST_SONG_LIST,
} from "pages/song/song_lits/constants/songActionTypes";
import axios from "axios";

const errorReceiveSongList = (err) => ({
    payload: err,
    type: ERROR_RECEIVE_SONG_LIST
})

const requestSongList = () => ({
    type: REQUEST_SONG_LIST
})

const receiveSongList = (data) => ({
    payload: data,
    type: RECEIVE_SONG_LIST
})

const getSongList = () => {
    return axios.get('http://localhost:8080/song');
};

const fetchSongList = () => {
    return (dispatch) => {
        dispatch(requestSongList());
        return getSongList()
            .then(response => response.data())
            .then(data => {
                dispatch(receiveSongList(data));
                return data;
            })
            .catch(err => {
                dispatch(errorReceiveSongList(err.message));
                throw err;
            });
    };
};

const songAction = {
    fetchSongList,
}

export default songAction;