import React, { useState, useEffect } from "react";
import styles from "../styles/Product.module.scss";
import { deleteProduct, editProduct } from "../js/buttonEvents.js";
import { Carousel } from 'react-responsive-carousel';
import "react-responsive-carousel/lib/styles/carousel.min.css";

function Product(props) {
    var base64Strings = props.images;
    const [images, setImages] = useState([]);

    useEffect(() => {
        const newImages = base64Strings
    .filter(base64String => base64String.length >= 10 ) // Remove empty strings
    .map(base64String => "data:image/png;base64," + base64String);
        setImages(newImages);
    }, [base64Strings]);

    useEffect(() => {
        
    }, [images]); //


    function displayImages() {
        return images.length > 0 ? (
            <Carousel showThumbs={false} className={styles.CX}>
                {images.map((image, index) => {
                    if (image) {
                        return (
                            <div key={index}>
                                <img src={image} onError={(e)=>{e.target.onerror = null; e.target.src="path/to/default/image.png"}} />
                            </div>
                        );
                    }
                    return null;
                })}
            </Carousel>
        ) : null;
    }

    return (
        <>
            <div className={styles.Product}>
                <p>{props.name}</p>
                <p>{props.description}</p>
                <p>${props.price}</p>
                <button className={styles.editButton} onClick={() => window.location.href = `/edit/${props.Id}`}>Edit</button>
                <button className={styles.deleteButton} onClick={() => deleteProduct(props.Id, props.updateProducts)}>Delete</button>
                
            </div>
            {displayImages()}
        </>
    );
}

export default Product;