

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
        images: [],
    }
    
    // Get the files from the input
    var fileInput = document.getElementById('file');
    var files = fileInput.files;
    
    // Keep track of how many files have been processed
    var filesProcessed = 0;
    
    // This function will be called for each file
    var processFile = function(file, reader) {
        reader.onload = async function() {
            var base64String = reader.result.split(",")[1];
            product.images.push(base64String);
    
            filesProcessed++;

            console.log('filesProcessedssed');
    
            if (filesProcessed === files.length) {

                console.log('succes');
                const response = await fetch('/update/' + id, {
                    method: 'PUT',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(product),
                });
            
                if (response.ok) {
                    alert('Updated product with id: ' + id)
                    window.location.href = "/";
                } else {
                    alert('product not updated')
                }
            }
        }
    
        reader.readAsDataURL(file);
    }
    
    // Process each file
    for (var i = 0; i < files.length; i++) {
        var reader = new FileReader();
        processFile(files[i], reader);
    }

    
}


async function addProduct() {


    var product = {
        productName: document.getElementById('name').value,
        description: document.getElementById('description').value,
        price: document.getElementById('price').value,
        images: [],
    }
    
    // Get the files from the input
    var fileInput = document.getElementById('file');
    var files = fileInput.files;
    
    // Keep track of how many files have been processed
    var filesProcessed = 0;
    
    // This function will be called for each file
    var processFile = function(file, reader) {
        reader.onload = async function() {
            var base64String = reader.result.split(",")[1];
            product.images.push(base64String);
    
            filesProcessed++;

            console.log('filesProcessedssed');
    
            // If all files have been processed, send the request
            if (filesProcessed === files.length) {

                console.log('succes');
                const response = await fetch('/add', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(product),
                });
                if (response.ok) {
                    alert('Added product with')
                    window.location.href = "/";
                } else {
                    alert('product not added')
                }
            }
        }
    
        reader.readAsDataURL(file);
    }
    
    // Process each file
    for (var i = 0; i < files.length; i++) {
        var reader = new FileReader();
        processFile(files[i], reader);
    }

   
}

export {deleteProduct}
export {editProduct}
export {addProduct}