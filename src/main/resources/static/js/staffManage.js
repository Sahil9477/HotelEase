// load staff list
function loadStaffList() {
    fetch('http://localhost:8080/employees')
        .then(response => {
            console.log('Response status:', response.status);
            return response.json();
        })
        .then(data => {
            console.log('Employee data received:', data);
            const staffList = document.getElementById('staffList');
            staffList.innerHTML = '';
            data.forEach(employee => {
                staffList.innerHTML += `
                    <tr>
                        <td>${employee.employeeID}</td>
                        <td>${employee.employeeName}</td>
                        <td>${employee.employeePosition}</td>
                        <td>${employee.employeeDepartment}</td>
                        <td>
                            <button onclick="editEmployee(${employee.employeeID})" class="bg-blue-500 text-white rounded px-2 py-1">Edit</button>
                            <button onclick="deleteEmployee(${employee.employeeID})" class="bg-red-500 text-white rounded px-2 py-1">Delete</button>
                        </td>
                    </tr>
                `;
            });
        })
        .catch(error => console.error('Error fetching employee list:', error));
}

// add employee
function addEmployee() {
    const name = document.getElementById('EmployeeName').value;
    const position = document.getElementById('EmployeePosition').value;
    const department = document.getElementById('EmployeeDepartment').value;

    fetch('http://localhost:8080/employees', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            employeeName: name,
            employeePosition: position,
            employeeDepartment: department
        })
    }).then(response => {
        if (response.ok) {
            alert('add success');
            loadStaffList();
            // Clear the form
            document.getElementById('EmployeeName').value = '';
            document.getElementById('EmployeePosition').selectedIndex = 0;
            document.getElementById('EmployeeDepartment').selectedIndex = 0;
        } else {
            alert('add failed');
        }
    }).catch(error => console.error('Error adding employee:', error));
}

console.log("staffManage.js loaded successfully");

// 删除员工
function deleteEmployee(id) {
    if (confirm('Are you sure to delete this employee?')) {
        fetch(`http://localhost:8080/employees/${id}`, {
            method: 'DELETE'
        }).then(response => {
            if (response.ok) {
                alert('delete success');
                loadStaffList();
            } else {
                alert('delete failed');
            }
        });
    }
}

// edit employee
function editEmployee(id) {
    fetch(`http://localhost:8080/employees/${id}`)
        .then(response => response.json())
        .then(employee => {
            document.getElementById('EmployeeID').value = employee.employeeID;
            document.getElementById('EmployeeName').value = employee.employeeName;
            document.getElementById('EmployeePosition').value = employee.employeePosition;
            document.getElementById('EmployeeDepartment').value = employee.employeeDepartment;
        });
}

// update employee
function updateEmployee() {
    const id = document.getElementById('EmployeeID').value;
    const name = document.getElementById('EmployeeName').value;
    const position = document.getElementById('EmployeePosition').value;
    const department = document.getElementById('EmployeeDepartment').value;

    fetch(`http://localhost:8080/employees/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            employeeName: name,
            employeePosition: position,
            employeeDepartment: department
        })
    }).then(response => {
        if (response.ok) {
            alert('edit success');
            loadStaffList();
        } else {
            alert('edit failed');
        }
    });
}

console.log("staffManage.js loaded successfully");