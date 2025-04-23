import React, {useState} from 'react';
import {Alert, Button} from "@mui/material";
import {DeleteForeverSharp} from "@mui/icons-material";

const SixApp = () => {
    const [inputArray, setInputArray] = useState([]);
    const [inputs, setInputs] = useState({
        name: '',
        nickname: '',
        hp: '',
        addr: ''
    });

    //각 데이터 입력시 Inputs의 각 멤버값에 넣어주기
    const changeData = (e) => {
        //e.target.name, e.target.value //각 name 값과 value 값 얻음
        let {name, value} = e.target;

        setInputs({
            ...inputs, //기존의 Inputs 객체를 펼쳐서 넣음 -> 펼침연산자
            [name]: value //입력하는 태그의 name 과 value 를 넣어준다
        });
    }
    return (
        <div>
            <Alert severity='success'>SixApp-입력값들을 하나의 객체에 넣기</Alert>
            <table className={'table table-bordered'} style={{width: '320px'}}>
                <thead>
                <tr>
                    <th className='table-success' width="120">name</th>
                    <th>
                        <input type='text' className='form-control'
                               name="name" value={inputs.name} onChange={changeData}/>
                    </th>
                </tr>
                <tr>
                    <th className='table-success' width="120">nickname</th>
                    <th>
                        <input type='text' className='form-control'
                               name="nickname" value={inputs.nickname} onChange={changeData}/>
                    </th>
                </tr>
                <tr>
                    <th className='table-success' width="120">hp</th>
                    <th>
                        <input type='text' className='form-control'
                               name="hp" value={inputs.hp} onChange={changeData}/>
                    </th>
                </tr>
                <tr>
                    <th className='table-success' width="120">addr</th>
                    <th>
                        <input type='text' className='form-control'
                               name="addr" value={inputs.addr} onChange={changeData}/>
                    </th>
                </tr>
                <tr>
                    <td colSpan={2} align='center'>
                        <Button variant='outlined' color="warning"
                        onClick={()=>setInputArray(inputArray.concat(inputs))}>
                            add</Button>
                        <Button variant='outlined' color="warning"
                        onClick={()=>setInputs({
                            nickname: '',
                            name: '',
                            hp: '',
                            addr: ''
                        })}>
                            reset</Button>
                    </td>
                </tr>
                <tr style={{height: '100px'}} className={'table-info'}>
                    <td colSpan={2}>
                        <h5>
                            name : {inputs.name}<br/>
                            nickname : {inputs.nickname}<br/>
                            hp : {inputs.hp}<br/>
                            addr : {inputs.addr}<br/>
                        </h5>
                    </td>
                </tr>
                </thead>
            </table>
            <hr/>
            <table className={'table table-bordered'} style={{width: '600px'}}>
                <thead>
                <tr className={'table-success'}>
                    <th width="50">num</th>
                    <th width="100">name</th>
                    <th width="100">nickname</th>
                    <th width="150">hp</th>
                    <th width="150">addr</th>
                    <th>delete</th>
                </tr>
                </thead>
                <tbody>
                {
                    inputArray.map((data, idx) =>
                        <tr key={idx}>
                            <td align="center">{idx + 1}</td>
                            <td>{data.name}</td>
                            <td>{data.nickname}</td>
                            <td>{data.hp}</td>
                            <td>{data.addr}</td>
                            <td align="center"><DeleteForeverSharp
                            style={{color:'red',cursor:"pointer"}}
                            onClick={()=>{
                                setInputArray(inputArray.filter((d,i)=>i!==idx));
                            }}/></td>
                        </tr>
                    )
                }
                </tbody>
            </table>
        </div>
    );
};

export default SixApp;