import {Typography} from "@mui/material";
import {useIntl} from "react-intl";

function EntityDetails() {
    const {formatMessage} = useIntl()

    return (
        <Typography>
            {formatMessage({ id: 'title' })}
        </Typography>
    )
}

export default EntityDetails;