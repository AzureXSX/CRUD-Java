import React from 'react';
import ReactDOM from 'react-dom/client';
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import reportWebVitals from './reportWebVitals';
import './styles/index.scss';

import Main from './pages/Main';
import Edit from './pages/Edit';
import Add from './pages/Add';


const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <BrowserRouter>
  <Routes>
      <Route path="/" element={<Main></Main>}></Route>
      <Route path="/edit/:id" element={<Edit></Edit>}></Route>
      <Route path="/add" element={<Add></Add>}></Route>
  </Routes>
</BrowserRouter>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
