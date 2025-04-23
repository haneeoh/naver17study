import React, {useState} from 'react';
import {Alert} from "@mui/material";

const SevenApp = () => {
    const [starArray, setStartArray] = useState([
        {
            starName: '김우빈',
            startAge: '32',
            starPhoto: '2.jpg',
            starAddress: '서울시 강남구',
            starPhone: '010-1234-5678'
        },
        {
            starName: '설현',
            startAge: '22',
            starPhoto: '15.jpg',
            starAddress: '서울시 영등포구',
            starPhone: '010-1234-1278'
        },
        {
            starName: '신민아',
            startAge: '31',
            starPhoto: '17.jpg',
            starAddress: '제주도 애월읍',
            starPhone: '010-4587-5678'
        },
        {
            starName: '신세경',
            startAge: '33',
            starPhoto: '18.jpg',
            starAddress: '부산시 해운대구',
            starPhone: '010-4342-5678'
        },
        {
            starName: '배수지',
            startAge: '29',
            starPhoto: '19.jpg',
            starAddress: '성남시 분당구',
            starPhone: '010-1234-1323'
        }
    ]);
    return (
        <div>
            <Alert severity='success'>SevenApp-배열 테이터 출력</Alert>
            <table className={'table table-bordered'} style={{width: '400px',margin:'20px'}}>
                <tbody>
                {
                    // starArray.map((star, idx) =>
                    //     <tr key={idx}>
                    //         <td width='100px' align='center'>
                    //             <img src={require(`../Star/${star.starPhoto}`)} style={{width: '80px'}}/>
                    //         </td>
                    //         <td>
                    //             <tr>
                    //                 <td>name : {star.starName}</td>
                    //             </tr>
                    //             <tr>
                    //                 <td>age : {star.startAge}</td>
                    //             </tr>
                    //             <tr>
                    //                 <td>addr : {star.starAddress}</td>
                    //             </tr>
                    //             <tr>
                    //                 <td>phone : {star.starPhone}</td>
                    //             </tr>
                    //         </td>
                    //     </tr>)
                    starArray.map((data,idx)=>
                    <>
                        <tr>
                            <td rowSpan={5} align='center' width='30' style={{verticalAlign:'middle'}}>
                                {idx+1}</td>
                        </tr>
                        <tr>
                            <td rowSpan={4} align='center' style={{verticalAlign: 'middle'}}>
                                <img alt='' src={require(`../Star/${data.starPhoto}`)} style={{width: '130px'}}/>
                            </td>
                            <td>name : {data.starName}</td>
                        </tr>
                        <tr>
                            <td>age : {data.startAge}세</td>
                        </tr>
                        <tr>
                            <td>phone : {data.starPhone}</td>
                        </tr>
                        <tr>
                            <td>addr : {data.starAddress}</td>
                        </tr>
                    </>
                    )
                }
                </tbody>
            </table>
        </div>
    );
};

export default SevenApp;