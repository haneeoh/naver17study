import React, {useState} from 'react';
import photo1 from '../image2/1.jpg';
import photo2 from '../image2/2.jpg';
import photo3 from '../image2/9.jpg';
import photo4 from '../image2/12.jpg';

const ThreeApp = () => {
    const [photo, setPhoto] = useState(photo2);
    const [width, setWidth] = useState(200);
    const [show, setShow] = useState(false);
    const [borderStyle, setBorderStyle] = useState('dashed');
    const [text, setText] = useState('리액트 문제 다풀면 복습 100% 보장');


    return (
        <div>
            <h3 className='alert alert-success'>ThreeApp</h3>
            <h3 style={{color: 'hotpink'}}>오늘의 문제</h3>
            <hr/>
            <label>
                <input type='checkbox'
                       onClick={(e) => setShow(e.target.checked)}/>
            사진숨김
            </label>
            <button style={{marginLeft: '50px'}}
                className={'btn btn-outline-danger'} onClick={() => setWidth(width - 10)}>점점 작게</button>
            &nbsp;&nbsp;
            <button className={'btn btn-outline-danger'} onClick={() => setWidth(width + 10)}>점점 크게</button>
            <br/><br/>
            <input type='text' className='form-control' style={{width: '400px'}}
                   value={text} onChange={(e) => setText(e.target.value)}/>
            <br/><br/>
            <div style={{float: 'left'}}>
                <select className={'form-select'} style={{width: '150px'}}
                        onChange={(e) => setPhoto(e.target.value)}>
                    <option value={photo1}>여진구</option>
                    <option value={photo2} selected>김우빈</option>
                    <option value={photo3}>강동원</option>
                    <option value={photo4}>박보영</option>
                </select>
                <br/><br/>
                <select className={'form-select'} style={{width: '150px'}}
                        onChange={(e) => setBorderStyle(e.target.value)}>
                    <option selected>dashed</option>
                    <option>solid</option>
                    <option>double</option>
                    <option>groove</option>
                </select>
            </div>
            {
                !show &&
                <img alt='' src={photo}
                     style={{border: `10px ${borderStyle} pink`, width: `${width}px`, marginLeft: '50px'}}/>
            }
            <h3 className='alert alert-info' style={{width: '400px'}}>{text}</h3>
        </div>
    );
};

export default ThreeApp;