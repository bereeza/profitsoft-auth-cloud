import React, { useMemo } from 'react';
import IntlProvider from 'misc/providers/IntlProvider';
import useLocationSearch from 'misc/hooks/useLocationSearch';

import getMessages from './intl';
import SongList from './containers/SongList';
import {Provider} from "react-redux";
import configureStore from "../../../misc/redux/configureStore";
import rootReducer from "../song_lits/reducers/";

const store = configureStore(rootReducer);

function Index(props) {
    const {
        lang,
    } = useLocationSearch();
    const messages = useMemo(() => getMessages(lang), [lang]);
    return (
        <Provider store={store}>
            <IntlProvider messages={messages}>
                <SongList {...props} />
            </IntlProvider>
        </Provider>
    );
}

export default Index;
