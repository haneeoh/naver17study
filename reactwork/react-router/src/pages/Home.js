import React from 'react';
import {Alert, Button} from "@mui/material";
import {NavLink, Routes, Route, useNavigate} from "react-router-dom";
import HomeSub1 from "./HomeSub1";
import HomeSub2 from "./HomeSub2";
import HomeSub3 from "./HomeSub3";
const Home = () => {
    const navi=useNavigate();
    return (
        <div>
            <Alert sevrity={'success'} style={{fontsize:'20px'}}>
                Home component
            </Alert>
            <button type={'button'} className={'btn btn-sm btn-danger'}
            onClick={()=>navi("/food")}>Food로 이동</button>
            &nbsp;
            <button type={'button'} className={'btn btn-sm btn-danger'}
                    onClick={()=>navi("/food/8")}>Food #2로 이동</button>
            &nbsp;
            <button type={'button'} className={'btn btn-sm btn-danger'}
                    onClick={()=>navi("/food/12/10")}>Food#3로 이동</button>
            &nbsp;
            <button type={'button'} className={'btn btn-sm btn-danger'}
                    onClick={()=>navi("/about/Naver")}>About으로 이동</button>
            <div style={{margin:'30px'}}>
                <NavLink to={"/home/sub1"}>경치1</NavLink>
                &nbsp;&nbsp;&nbsp;
                <NavLink to={"/home/sub2"}>경치2</NavLink>
                &nbsp;&nbsp;&nbsp;
                <NavLink to={"/home/sub3"}>경치3</NavLink>
            </div>
            <Routes>
                <Route path={'sub1'} element={<HomeSub1/>}/>
                <Route path={'sub2'} element={<HomeSub2/>}/>
                <Route path={'sub3'} element={<HomeSub3/>}/>
            </Routes>
        </div>
    );
};

export default Home;