import React from 'react';
import Menu from '../components/Menu';
import {Routes,Route} from "react-router-dom";
import {About,Food,Home} from "../pages";

const RouterMain = () => {
    return (
        <div>
            <Menu/>
            <hr style={{clear:'both'}}/>
            <Routes>
                <Route path="/" element={<Home/>}/>
                <Route path="/home/*" element={<Home/>}/>

                {/* <Route path="/about" element={<About/>}/> */}
                <Route path="/about" element={<About/>}>
                    <Route path=':emp' element={<About/>}/>
                </Route>

                {/*<Route path="/food" element={<Food/>}/>*/}
                <Route path="/food" element={<Food/>}>
                    <Route path=':food1' element={<Food/>}/>
                    <Route path=':food1/:food2' element={<Food/>}/>
                </Route>

                <Route path='/login/*' element={
                   <div>
                       <h2>로그인 페이지는 작업중입니다</h2>
                       <About/>
                       <Food/>
                   </div>
                }/>
                {/*그 이외의 모든 매핑주소일 경우 호출*/}
                <Route path='*' element={
                   <div>
                       <h2>잘못된 url 주소입니다.</h2>
                       <img alt={''} src={require('../image/errorpage.jpg')}/>
                   </div>
                }/>
            </Routes>
        </div>
    );
};

export default RouterMain;