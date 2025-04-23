import React, {useRef, useState} from 'react';
import {Alert, Button} from "@mui/material";

const FiveApp = () => {
    const [result,setResult] = useState('');
    const nameRef=useRef('');
    const javaRef=useRef(0);
    const reactRef=useRef(0);

    //버튼 이벤트
    const btnResultEvent=()=>{
        //입력값들 가져오기
        let name=nameRef.current.value;
        let java=javaRef.current.value;
        let react=reactRef.current.value;

        //점수가 숫자가 아닐경우 종료
        if(isNaN(java)){
            alert("자바점수는 숫자로만 입력해주세요");
            return;
        }

        if (isNaN(react)){
            alert("리액트점수는 숫자로만 입력해주세요");
            return;
        }

        //총점, 평균 구하기
        let total=Number(java)+Number(react);
        let avg=total/2;

        let s=`
        이름 : ${name}
        java Score : ${java}
        React Score : ${react}
        Total Score : ${total}
        Average Score : ${avg}
        `;

        setResult(s);

        //종료 후 입력값 초기화
        nameRef.current.value='';
        javaRef.current.value='';
        reactRef.current.value='';
        nameRef.current.focus();

    }
    return (
        <div>
            <Alert severity='success'>FiveApp - useRef 응용</Alert>
            <table className={'table table-bordered'} style={{width:'320px'}}>
                <thead>
                    <tr>
                        <th className='table-success' width="120">이름</th>
                        <th>
                            <input type='text' className='form-control'
                            ref={nameRef}/>
                        </th>
                    </tr>
                    <tr>
                        <th className='table-success' width="120">Java Score</th>
                        <th>
                            <input type='text' className='form-control'
                            ref={javaRef}/>
                        </th>
                    </tr>
                    <tr>
                        <th className='table-success' width="120">React Score</th>
                        <th>
                            <input type='text' className='form-control'
                            ref={reactRef}/>
                        </th>
                    </tr>
                <tr>
                    <td colspan={2} align='center'>
                        <Button variant='outlined' color="warning"
                        onClick={btnResultEvent}>Total Score</Button>
                    </td>
                </tr>
                </thead>
            </table>
            <div style={{whiteSpace:'pre-line', marginTop:'20px'}}>
                {result}
            </div>
        </div>
    );
};

export default FiveApp;