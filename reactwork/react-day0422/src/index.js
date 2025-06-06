import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import MainApp from "./components/MainApp";

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    // <React.StrictMode>
    //     {/*<App/>*/}
    //     <MainApp/>
    // </React.StrictMode>
    //컴포넌트에서 useEffect가 두번호출되는 현상을 막으려면
    <>
    <MainApp/>
    </>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
