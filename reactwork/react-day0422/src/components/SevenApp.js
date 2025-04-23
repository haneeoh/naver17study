import React from 'react';
import {Alert} from "@mui/material";


const SevenApp = () => {
    const names = ['이효리', '강호동', '이영자', '손나은', '변우석', '강지영',]
    // 방법1
    const namelist = names.map((name, index) => <h5 key={index}>{index}:{name}</h5>);
    return (
        <div>
            <h3 className='alert alert-success'>SevenApp-map</h3>
            {/*키값 없으면 콘솔 오류남*/}
            <h5>배열변수 없이 1부터 10까지 반복출력하기</h5>
            {/*{*/}
            {/*    Array.from({length: 10}, (_, index) => (*/}
            {/*        <div key={index}>{index + 1}</div>*/}
            {/*    ))*/}
            {/*}*/}

            {
                [...new Array(10)].map((_, index) => <b key={index}>{index + 1}&nbsp;</b>)
            }
            <hr/>
            <h5>mycar 폴더에 mycar 이미지를 넣고 mycar 1부터 15번까지 이미지 출력하기</h5>
            {
                [...new Array(15)].map((_, index) => <img key={index} alt=''
                                                          src={require(`../mycar/mycar${index + 1}.png`)}
                                                          style={{width: '100px'}}/>)
            }
            <hr/>

            {namelist}
            {/* 배열 반복문을 직접 넣는 방법*/}
            {
                names.map((name, index) =>
                    <Alert key={index} severity='secondary'>{index}:{name}
                        <img alt='' src={require(`../image2/${index + 1}.jpg`)} style={{width: '100px'}}/>
                    </Alert>)
            }
        </div>
    );
};

export default SevenApp;