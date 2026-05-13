document.addEventListener("DOMContentLoaded", () => {
    if (window.location.pathname.includes("products.html")) {
        loadProducts();
        const form = document.getElementById("productForm");
        form.addEventListener("submit", (e) => {
            e.preventDefault();
            saveProduct();
        });
    } else if (window.location.pathname.includes("inventory.html")) {
        loadInventory();
        const form = document.getElementById("inventoryForm");
        form.addEventListener("submit", (e) => {
            e.preventDefault();
            saveInventory();
        });
    } else if (window.location.pathname.includes("alerts.html")) {
        loadAlerts();
    }
});

// Base URL of your Spring Boot API
const API_BASE_URL = "http://localhost:8083/api";

// Product APIs
function loadProducts() {
    fetch(`${API_BASE_URL}/products`)
        .then(res => res.json())
        .then(data => {
            const tbody = document.getElementById("productTable").querySelector("tbody");
            tbody.innerHTML = "";
            data.forEach(product => {
                tbody.innerHTML += `
                    <tr>
                        <td>${product.product_id}</td>
                        <td>${product.productName}</td>
                        <td>${product.brand || ''}</td>
                        <td>${product.category || ''}</td>
                        <td>${product.shelfLifeDays || ''}</td>
                        <td>${product.createdAt ? new Date(product.createdAt).toLocaleString() : ''}</td>
                        <td>
                            <button onclick="editProduct(${product.product_id})">Edit</button>
                            <button onclick="deleteProduct(${product.product_id})">Delete</button>
                        </td>
                    </tr>
                `;
            });
        })
        .catch(err => console.error("Error loading products:", err));
}


function saveProduct() {
    const id = document.getElementById("product_id").value;
    const name = document.getElementById("product_name").value;
    const brand = document.getElementById("brand") ? document.getElementById("brand").value : '';
    const category = document.getElementById("category").value;
    const shelfLife = document.getElementById("shelf_life_days").value;

    const product = {
        productName: name,
        brand: brand,
        category: category,
        shelfLifeDays: shelfLife
    };

    const method = id ? "PUT" : "POST";
    const url = id ? `${API_BASE_URL}/products/${id}` : `${API_BASE_URL}/products`;


    fetch(url, {
        method: method,
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(product)
    })
    .then(res => res.json())
    .then(() => {
        loadProducts();
        document.getElementById("productForm").reset();
    })
    .catch(err => console.error("Error saving product:", err));
}

function editProduct(id) {
fetch(`${API_BASE_URL}/products/${id}`)

        .then(res => res.json())
        .then(product => {
            document.getElementById("product_id").value = product.product_id;
            document.getElementById("product_name").value = product.productName;
            if(document.getElementById("brand")) {
                document.getElementById("brand").value = product.brand || '';
            }
            document.getElementById("category").value = product.category;
            document.getElementById("shelf_life_days").value = product.shelfLifeDays;
        })
        .catch(err => console.error("Error fetching product:", err));
}

function deleteProduct(id) {
fetch(`${API_BASE_URL}/products/${id}`, { method: "DELETE" })

        .then(() => loadProducts())
        .catch(err => console.error("Error deleting product:", err));
}

// Inventory APIs
function loadInventory() {
   fetch(`${API_BASE_URL}/inventories`)

        .then(res => res.json())
        .then(data => {
            const tbody = document.getElementById("inventoryTable").querySelector("tbody");
            tbody.innerHTML = "";
            data.forEach(item => {
                tbody.innerHTML += `
                    <tr>
                        <td>${item.inventoryId}</td>
                        <td>${item.productId}</td>
                        <td>${item.batchNo}</td>
                        <td>${item.manufactureDate ? new Date(item.manufactureDate).toLocaleDateString() : ''}</td>
                        <td>${item.expiryDate ? new Date(item.expiryDate).toLocaleDateString() : ''}</td>
                        <td>${item.quantity}</td>
                        <td>${item.warehouseLocation || ''}</td>
                        <td>${item.lastUpdated ? new Date(item.lastUpdated).toLocaleString() : ''}</td>
                    </tr>
                `;
            });
        })
        .catch(err => console.error("Error loading inventory:", err));
}

function saveInventory() {
    const id = document.getElementById("inventory_id").value;
    const product_id = document.getElementById("product_id").value;
    const batch_no = document.getElementById("batch_no").value;
    const manufacture_date = document.getElementById("manufacture_date").value;
    const expiry_date = document.getElementById("expiry_date").value;
    const quantity = document.getElementById("quantity").value;
    const location = document.getElementById("warehouse_location").value;

    const inventory = {
        product_id: product_id,
        batch_no: batch_no,
        manufacture_date: manufacture_date,
        expiry_date: expiry_date,
        quantity: quantity,
        warehouse_location: location
    };

    const method = id ? "PUT" : "POST";
   const url = id ? `${API_BASE_URL}/inventory/${id}` : `${API_BASE_URL}/inventory`;


    fetch(url, {
        method: method,
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(inventory)
    })
    .then(res => res.json())
    .then(() => {
        loadInventory();
        document.getElementById("inventoryForm").reset();
    })
    .catch(err => console.error("Error saving inventory:", err));
}

// Alerts APIs
function loadAlerts() {
  fetch(`${API_BASE_URL}/alerts`)

        .then(res => res.json())
        .then(data => {
            const tbody = document.getElementById("alertsTable").querySelector("tbody");
            tbody.innerHTML = "";
            data.forEach(alert => {
                tbody.innerHTML += `
                    <tr>
                        <td>${alert.alertId}</td>
                        <td>${alert.productId}</td>
                        <td>${alert.inventoryId}</td>
                        <td>${alert.alertType || ''}</td>
                        <td>${alert.alertMessage || ''}</td>
                        <td>${alert.alertDate ? new Date(alert.alertDate).toLocaleString() : ''}</td>
                        <td>${alert.resolved ? "Yes" : "No"}</td>
                    </tr>
                `;
            });
        })
        .catch(err => console.error("Error loading alerts:", err));
        
}
