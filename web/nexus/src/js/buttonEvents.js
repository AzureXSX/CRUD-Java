

async function deleteProduct(id, updateProducts) {
    alert('delete product with id: ' + id)

    const response = await fetch('/delete/' + id, {
        method: 'DELETE',
    });

    if (response.ok) {
        var data = await response.json();
        updateProducts(data);
        alert('Product deleted')
    } else {
        alert('Product not deleted')
    }
}

async function editProduct(id) {


    var product = {
        productName: document.getElementById('name').value,
        description: document.getElementById('description').value,
        price: document.getElementById('price').value,
    }

    const response = await fetch('/update/' + id, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(product),
    });

    if (response.ok) {
        alert('Updated product with id: ' + id)
    } else {
        alert('product not updated')
    }
}


async function addProduct() {
    var product = {
        productName: document.getElementById('name').value,
        description: document.getElementById('description').value,
        price: document.getElementById('price').value,
    }

    const response = await fetch('/add', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(product),
    });

    if (response.ok) {
        alert('Added product with')
    } else {
        alert('product not added')
    }
}

export {deleteProduct}
export {editProduct}
export {addProduct}