import React from 'react';
import styled from "styled-components";
import {AlignVerticalBottom, Apple, DeleteForever, Face4} from '@mui/icons-material';
import RecipeReviewCard from "./RecipeReviewCard";

/*
https://styled-components.com/docs/basics#getting-started

# with npm
npm install styled-components

# with yarn
yarn add styled-components

설명
styled-components태그가 지정된 템플릿 리터럴(백틱)을 활용하여 구성 요소의 스타일을 지정합니다.
*/
export default function FourApp() {
    const Title = styled.h2` color: orange;
        font-size: 1.5em;
        background-color: yellow;
        width: 250px;
        text-align: center; `;
    const MyButton = styled.button` color: blue;
        background-color: lavenderblush;
        border: 5px inset green;
        width: 130px; `;
    const TomatoButton = styled(MyButton)` color: tomato;
        border-color: tomato; `;

    return (
        <div>
            <h3 className='alert alert-success'>스타일드 컴포넌트 예제</h3>
            <Title>Hello React!!!</Title>
            <Title>안녕하세요</Title>
            <button>기본 버튼</button>&nbsp;
            <MyButton>MyButton</MyButton>&nbsp;
            <TomatoButton>TomatoButton</TomatoButton>
            <h5>Material Icons</h5>
            <DeleteForever />
            <Apple style={{ color: 'red' }} />
            <AlignVerticalBottom />
            <Face4 />
            <h2 style={{ textAlign: 'center' }}>나의 요리카드</h2>
            <RecipeReviewCard />
        </div>
    );
}