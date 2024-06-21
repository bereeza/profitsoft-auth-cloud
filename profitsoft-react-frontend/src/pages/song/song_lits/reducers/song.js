import {
    ERROR_RECEIVE_SONG_LIST,
    RECEIVE_SONG_LIST,
    REQUEST_SONG_LIST,
} from "../constants/songActionTypes";

const initialState = {
    errors: [],
    songList: [],
    isLoading: false,
}

const convertErrors = err => err.map(err => ({
    code: err.code,
    description: err.description,
}));

export default function Reducer(state = initialState, action) {
    switch (action.type) {
        case REQUEST_SONG_LIST:
            return {...state, isLoading: true}
        case RECEIVE_SONG_LIST:
            return {...state, songList: action.payload, isLoading: false}
        case ERROR_RECEIVE_SONG_LIST:
            return {...state, errors: convertErrors(action.payload), isLoading: false}
        default: return state;
    }
}