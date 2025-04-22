import React, {useEffect,useState} from 'react';
import img1 from '../image2/16.jpg';
import { Button } from '@mui/material';


const SixApp = () => {
    const[cnt,setCnt]=useState(1);
    const[show,setShow]=useState(true);
    useEffect(() => {
        cnt % 3 === 0 ? setShow(false) : setShow(true);
    }, [cnt]);

    return (
        <div>
            <h3 className='alert alert-success'>SixApp</h3>
            <h5> count가 3의 배수일때마다 사진 숨기기</h5>
            <Button variant='contained' color='success'
            onClick={()=>{
                setCnt(cnt+1);
                //비동기 특성상 순서대로진행안됨
                // if(cnt%3===0) setShow(false);
                // else setShow(true);
            }}>count증가</Button>
            <br/>
            <b style={{fontSize: '4em',color:'red'}}>{cnt}</b>
            <br/><br/>
            {
                show&&
            <img alt='' src={img1} style={{width: '300px'}}/>
            }
        </div>
    );
};

export default SixApp;