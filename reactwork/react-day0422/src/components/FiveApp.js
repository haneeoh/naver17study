import React, { useEffect, useState } from 'react';
import { Switch } from '@mui/material';


const FiveApp = () => {
    // const [visible, setVisible] = useState('visible');
    const[visible,setVisible] = useState('hidden');
    const[number,setNumber]=useState(100);
    const [cnt, setCnt] = useState(1);

    // useEffect(()=>{
    //     console.log("처음에도 호출되고 state 변수가 변경될때마다 호출된다");
    // });

    // useEffect(() => {
    //     console.log("처음 로딩시 딱 한번만 호출된다")
    // }, []);
    //
    // useEffect(()=>{
    //     console.log("count가 변경될때 처리할 코드를 넣어주세요")
    // },[cnt])
    //
    // useEffect(()=>{
    //     console.log("number이 변경될때 처리할 코드를 넣어주세요")
    // },[number])

    useEffect(()=>{
        console.log("count 와 number이 변경될때 처리할 코드를 넣어주세요")
    },[cnt,number])

    return (
        <div>
            <h3 className='alert alert-success'>
                FiveApp </h3>
            <br/>
            <Switch color="secondary"
            onChange={(e)=>setVisible(e.target.checked?'visible':'hidden')}/>
            <br/>
            <img alt='' src={require('../image2/12.jpg')}
                 style={{width: '200px', visibility: visible}}/>
            <hr/>
            <h1>count:{cnt}</h1>
            <h1>number:{number}</h1>
            <button onClick={()=>setCnt(cnt+1)}>count증가</button>
            <br/>
            <button onClick={()=>setNumber(number+1)}>number증가</button>
            <br/>
            <button onClick={()=>{
                setCnt(cnt+2);
                setNumber(number+5)
            }}>count와 number 모두증가</button>
        </div>
    );
};

export default FiveApp;