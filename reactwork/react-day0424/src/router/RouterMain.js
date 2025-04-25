import React from 'react';
import {Routes,Route} from "react-router-dom";
import Menu from '../components/Menu';
import {OneApp,TwoApp,ThreeApp,FourApp,FiveApp,SixApp,SevenApp,EightApp} from '../components';

const RouterMain = () => {
    return (
        <div>
            <Menu/>
            <hr style={{clear: 'both'}}/>
            <Routes>
                <Route path="/" element={<OneApp/>}/>
                <Route path="/two" element={<TwoApp/>}/>
                <Route path="/three" element={<ThreeApp/>}/>
                <Route path="/four" element={<FourApp/>}/>
                <Route path="/five/*" element={<FiveApp/>}/>
                <Route path="/six" element={<SixApp/>}/>
                <Route path="/seven" element={<SevenApp/>}/>
                <Route path="/eight" element={<EightApp/>}/>
                <Route path="*" element={
                    <div>404</div>
                }/>
            </Routes>
        </div>
    );
};

export default RouterMain;