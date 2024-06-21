import React from "react";
import ListItemTextMUI from "@mui/material/ListItemText";

const ListItemText = ({ primary }) => {
    const style = {
        flex: 1,
        textAlign: 'left',
        maxHeight: '40px'
    };
    return (
        <ListItemTextMUI style={style} primary={primary} />
    );
};

export default ListItemText;