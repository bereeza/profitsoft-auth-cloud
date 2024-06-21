import React from "react";
import ListItemMUI from '@mui/material/ListItem';

const ListItem = ({ children }) => {
    const style = {
        display: 'flex',
        alignItems: 'center',
        border: '2px solid black',
        borderRadius: '8px',
        background: '#3fb560',
        color: 'white',
        margin: '5px',
        padding: '10px',
    };

    return (
        <ListItemMUI style={style}>
            {children}
        </ListItemMUI>
    );
};

export default ListItem;