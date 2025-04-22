// RecipeReviewCard.jsx
import * as React from 'react';
import { styled } from '@mui/material/styles';
import {
    Card, CardHeader, CardMedia, CardContent,
    CardActions, Collapse, Avatar, IconButton, Typography
} from '@mui/material';
import { red } from '@mui/material/colors';
import FavoriteIcon from '@mui/icons-material/Favorite';
import ShareIcon from '@mui/icons-material/Share';
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';
import MoreVertIcon from '@mui/icons-material/MoreVert';
import food from '../image/1.jpg';

const ExpandMore = styled((props) => {
    const { expand, ...other } = props;
    return <IconButton {...other} />;
})(({ theme }) => ({
    marginLeft: 'auto',
    transition: theme.transitions.create('transform', {
        duration: theme.transitions.duration.shortest,
    }),
    transform: props => (props.expand ? 'rotate(180deg)' : 'rotate(0deg)')
}));

export default function RecipeReviewCard() {
    const [expanded, setExpanded] = React.useState(false);
    const handleExpandClick = () => setExpanded(!expanded);

    return (
        <Card sx={{ maxWidth: 345, margin: '20px auto' }}>
            <CardHeader
                avatar={<Avatar sx={{ bgcolor: red[500] }} aria-label="recipe">R</Avatar>}
                action={<IconButton><MoreVertIcon /></IconButton>}
                title="Shrimp and Chorizo Paella"
                subheader="September 14, 2016"
            />
            <CardMedia
                component="img"
                height="194"
                image={food}
                alt="Paella dish"
            />
            <CardContent>
                <Typography variant="body2" color="text.secondary">
                    This impressive paella is a perfect party dish...
                </Typography>
            </CardContent>
            <CardActions disableSpacing>
                <IconButton><FavoriteIcon /></IconButton>
                <IconButton><ShareIcon /></IconButton>
                <ExpandMore
                    expand={expanded}
                    onClick={handleExpandClick}
                    aria-expanded={expanded}
                    aria-label="show more"
                >
                    <ExpandMoreIcon />
                </ExpandMore>
            </CardActions>
            <Collapse in={expanded} timeout="auto" unmountOnExit>
                <CardContent>
                    <Typography paragraph>Method:</Typography>
                    <Typography paragraph>Heat 1/2 cup of the broth...</Typography>
                </CardContent>
            </Collapse>
        </Card>
    );
}