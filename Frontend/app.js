const API_URL = "http://localhost:8080/mytodos"; // Your backend API URL

// Function to fetch and display all todos
async function fetchTodos() {
    const response = await fetch(API_URL);
    const todos = await response.json();
    
    const todoList = document.getElementById("todo-list");
    todoList.innerHTML = ""; // Clear the list before adding new items

    todos.forEach(todo => {
        const li = document.createElement("li");
        li.className = "list-group-item d-flex justify-content-between align-items-center";
        li.innerHTML = `
            ${todo.title} 
            <button class="btn btn-danger btn-sm" onclick="deleteTodo(${todo.id})">Delete</button>
        `;
        todoList.appendChild(li);
    });
}

// Function to add a new todo
async function addTodo() {
    const titleInput = document.getElementById("todo-title");
    const title = titleInput.value.trim();
    
    if (!title) {
        alert("Please enter a todo title!");
        return;
    }

    const response = await fetch(API_URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ title, completed: false })
    });

    if (response.ok) {
        titleInput.value = ""; // Clear input field
        fetchTodos(); // Refresh the list
    }
}

// Function to delete a todo
async function deleteTodo(id) {
    await fetch(`${API_URL}/${id}`, {
        method: "DELETE"
    });
    fetchTodos(); // Refresh the list
}

// Load todos when the page loads
fetchTodos();


