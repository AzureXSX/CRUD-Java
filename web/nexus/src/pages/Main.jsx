import React, { useEffect, useState } from "react";
import styles from "../styles/Main.module.scss";
import Product from "../components/Product.jsx";
import { useRoutes } from "react-router-dom";


function Main() {

    const [products, updateProducts] = useState([]);
   
    useEffect(() => {   
        fetch("/products")
        .then((response) => response.json())
        .then((data) => {
            updateProducts(data);
            console.log(data);
        });
    }, []);

    return (
        <>
            <div className={styles.MainDiv}>
                {products.map((product) => {
                    return <Product 
                    Id={product.productId}
                    key={product.productId}
                    name={product.productName}
                    description={product.description}
                    price={product.price}
                    updateProducts={updateProducts}
                    >
                    </Product>
                })}
                <button className={styles.addButton} onClick={() => {
                        window.location.href = "/add";
                }}>Add Product</button>
            </div>
        </>
    );
}

export default Main;