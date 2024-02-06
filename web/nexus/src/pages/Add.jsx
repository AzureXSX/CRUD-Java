import React from "react";
import styles from "../styles/Edit.module.scss";
import { useParams } from 'react-router-dom';
import { addProduct } from "../js/buttonEvents.js";


function Add() {
    let { id } = useParams();
    return (
        <>
           <div className={styles.MainDiv}>
                <input type="text" id="name" placeholder="Product Name"></input>
                <input type="text" id="description" placeholder="Description"></input>
                <input type="text" id="price" placeholder="Price"></input>    
                <button className={styles.addButton} onClick={async () => {
                    await addProduct();
                    window.location.href = "/";
                }}>Add</button> 
           </div>
        </>
    );
}

export default Add;