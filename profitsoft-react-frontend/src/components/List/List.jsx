import React from 'react';
import ListMUI from '@mui/material/List';

const List = ({
     width,
     children
}) => {
    const style = {
        width: width || '100%',
    };

    return (
        <ListMUI style={style}>
            {children}
        </ListMUI>
    );
};

export default List;