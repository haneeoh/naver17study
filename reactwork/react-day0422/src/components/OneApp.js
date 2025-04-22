import React, {useState} from 'react';
import './mystyle.css';
import photo1 from '../image/1.jpg';

const OneApp = () => {
    const [irum, setIrum] = useState('이해성');
    const [age, setAge] = useState(20);
    const style1 = {
        color: 'green',
        backgroundColor: '#fcfc00',
        width: '400px',
        border: '5px groove tomato',
        textAlign: 'center'
    }
    return (
        <div>
            <h3>OneApp-복습과 간단한 데이터 입력 이벤트</h3>
            <h5 style={style1}>스타일 적용방법 #1-변수로 지정하는 방법</h5>
            <h5 style={{
                color: 'aqua', fontFamily: 'Single Day',
                border: '3px inset gold', width: '350px'
            }}>스타일 적용방법 #2-직접 지정하는 방법</h5>
            <h5 className='myfont'>스타일 적용방법 #3-클래스적용</h5>
            <img alt='' src={photo1} style={{width: '150px'}}/>
            <h6>이름과 나이 입력하기</h6>
            <h2 style={{backgroundColor: 'orange'}}>
                이 름 : {irum}<br/>
                나 이 : {age}세
            </h2>
            <input type='text' placeholder='이름 입력' value={irum}
                   onChange={(e) => setIrum(e.target.value)}/>
            <input type='text' placeholder='나이 입력' value={age}
                   onChange={(e) => setAge(e.target.value)}/>
        </div>
    );
};

export default OneApp;