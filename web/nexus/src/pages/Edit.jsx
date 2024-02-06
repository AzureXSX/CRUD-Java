import React from "react";
import styles from "../styles/Edit.module.scss";
import { useParams } from 'react-router-dom';
import { editProduct } from "../js/buttonEvents.js";

function Edit() {
    let { id } = useParams();
    return (
        <>
           <div className={styles.MainDiv}>
                <input type="text" id="name" placeholder="Product Name"></input>
                <input type="text" id="description" placeholder="Description"></input>
                <input type="text" id="price" placeholder="Price"></input>    
                <button className={styles.addButton} onClick={async () => {
                    await editProduct(id);
                }}>Update</button> 
                <input type="file" id="file" name="file" accept="image/*" multiple></input>
           </div>
        </>
    );
}

export default Edit;