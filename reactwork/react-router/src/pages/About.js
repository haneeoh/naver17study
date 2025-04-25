import React from 'react';
import {Alert} from "@mui/material";
import {useParams} from "react-router-dom";

const About = () => {
    const {emp}=useParams();
    console.log(emp);

    return (
        <div>
            <Alert sevrity={'success'} style={{fontsize:'20px'}}>
                About component
            </Alert>
            {
                emp==null?
                    <div>
                        <h2>저는 취업 준비생입니다</h2>
                    </div>
                    :
                    <div>
                        <h2>저는 {emp}에 다니고 있습니다</h2>
                    </div>
            }
        </div>
    );
};

export default About;