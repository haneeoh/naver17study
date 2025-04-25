import { Alert } from '@mui/material';
import React, {useState} from 'react';
import {Routes, useNavigate,Route} from "react-router-dom";
import {ShopDetail, ShopForm, ShopList} from "../shopcomponents";
import axios from "axios";
import FourWriteShop from "./FourWriteShop";


const FiveApp = () => {
    const url = "http://localhost:8090/react";
    const [shoplist, setShopList] = useState([]);
    // 추가하는 함수
    const addShopEvent = (shopdata) => {
        console.log(shopdata);
        axios.post(url + "/addshop", shopdata)
            .then(res => {
                console.log(res);
                getList();
            })
            .catch(error => {
                console.log("insert 오류" + error)
            })
    }
    // db에서 데이터를 가져오는 함수
    const getList = () => {
        axios.get(url + "/shoplist")
            .then(res => {
                setShopList(res.data)
            })
            .catch(error => {
                console.log(error)
            })
    }
    const navi=useNavigate();
    return (
        <div>
            <Alert severity='success'
                        style={{fontSize:'25px'}}>FiveApp</Alert>
            <div style={{margin:'20px'}}>
                {/**/}
                <button type={'button'} className={'btn btn-sm btn-outline-secondary'}
                onClick={() => navi("/five/list")}>Shop목록</button>
                &nbsp;&nbsp;
                <button type={'button'} className={'btn btn-sm btn-outline-secondary'}
                        onClick={() => navi("/five/form")}>Shop추가</button>
                <br/><br/>
                <Routes>
                    <Route path='/' element={<ShopList/>}/>
                    <Route path='list' element={<ShopList/>}/>
                    <Route path='form' element={<ShopForm onSave={addShopEvent}/>} />
                    <Route path='detail/:num' element={<ShopDetail/>}/>
                </Routes>
            </div>
        </div>
    );
};

export default FiveApp;