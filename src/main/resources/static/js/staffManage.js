//load staff list
function loadStaffList() {
    fetch('http://localhost:8080/employees')
        .then(response => response.json())
        .then(data => {
            console.log('Employee data received:', data);
            const staffList = document.getElementById('staffList');
            staffList.innerHTML = ''; //clean old data
            data.forEach(employee => {
                staffList.innerHTML += `
                    <tr>
                        <td class="px-4 text-center">${employee.employeeID}</td>
                        <td class="px-4 text-center">${employee.employeeName}</td>
                        <td class="px-4 text-center">${employee.employeePosition}</td>
                        <td class="px-4 text-center">${employee.employeeDepartment}</td>
                        <td class="px-4 text-center">${employee.salary}</td>
                        <td class="px-4 text-center">
                            <button onclick="editEmployee(${employee.employeeID})" class="bg-green-500 text-white rounded px-2 py-1">Edit</button>
                            <button onclick="deleteEmployee(${employee.employeeID})" class="bg-red-500 text-white rounded px-2 py-1">Delete</button>
                        </td>
                    </tr>
                `;
            });
        })
        .catch(error => console.error('Error fetching employee list:', error));
}

//add staff
function addEmployee() {
    const id = document.getElementById('EmployeeID').value.trim();
    const name = document.getElementById('EmployeeName').value.trim();
    const position = document.getElementById('EmployeePosition').value.trim();
    const department = document.getElementById('EmployeeDepartment').value.trim();

    if (!name || !position || !department) {
        alert('Please fill in the complete information.');
        return;
    }

    //If the id exists, update it
    if (id) {
        updateEmployee(id, name, position, department);
        return;
    }

    //Otherwise, perform the new operation
    fetch('http://localhost:8080/employees', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            employeeName: name,
            employeePosition: position,
            employeeDepartment: department
        })
    })
    .then(response => {
        if (response.ok) {
            alert('Successfully Added');
            loadStaffList();
            clearForm(); //clean form
        } else {
            alert('Add Failed');
        }
    })
    .catch(error => console.error('Error adding employee:', error));
}

//delete staff
function deleteEmployee(id) {
    if (!confirm('Are you sure you want to delete employees?')) return;

    fetch(`http://localhost:8080/employees/${id}`, {
        method: 'DELETE'
    })
    .then(response => {
        if (response.ok) {
            alert('Deleted Successfully');
            loadStaffList();
        } else {
            alert('Delete Failed');
        }
    })
    .catch(error => console.error('Error deleting employee:', error));
}

//edit staff
function editEmployee(id) {
    fetch(`http://localhost:8080/employees/${id}`)
        .then(response => response.json())
        .then(employee => {
            console.log("Editing employee:", employee);  // Debug log

            document.getElementById('EmployeeID').value = employee.employeeID;
            document.getElementById('EmployeeName').value = employee.employeeName;
            document.getElementById('EmployeePosition').value = employee.employeePosition;
            document.getElementById('EmployeeDepartment').value = employee.employeeDepartment;
        })
        .catch(error => console.error('Error fetching employee details:', error));
}

//update staff
function updateEmployee(id, name, position, department) {
    fetch(`http://localhost:8080/employees/${id}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            employeeID: id, //Make sure the key name matches the back end
            employeeName: name,
            employeePosition: position,
            employeeDepartment: department
        })
    })
    .then(response => {
        if (response.ok) {
            alert('Update Successful');
            loadStaffList();
            clearForm(); //clean from
        } else {
            alert('Upade Failed');
        }
    })
    .catch(error => console.error('Error updating employee:', error));
}

//clean form
function clearForm() {
    document.getElementById('EmployeeID').value = '';
    document.getElementById('EmployeeName').value = '';
    document.getElementById('EmployeePosition').selectedIndex = 0;
    document.getElementById('EmployeeDepartment').selectedIndex = 0;
}

//Gets the employee list when the page loads
document.addEventListener('DOMContentLoaded', function() {
    loadStaffList();
});

console.log("staffManage.js loaded successfully");
