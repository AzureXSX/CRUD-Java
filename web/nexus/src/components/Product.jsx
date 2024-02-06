import React from "react";
import styles from "../styles/Product.module.scss";
import { deleteProduct, editProduct } from "../js/buttonEvents.js";

function Product(props) {
    return (
        <>
            <div className={styles.Product}>
                <p>{props.name}</p>
                <p>{props.description}</p>
                <p>${props.price}</p>
                <button className={styles.editButton} onClick={() => window.location.href = `/edit/${props.Id}`}>Edit</button>
                <button className={styles.deleteButton} onClick={() => deleteProduct(props.Id, props.updateProducts)}>Delete</button>
            </div>
        </>
    );
}

export default Product;