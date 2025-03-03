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
                        <td class="px-4 text-center">${employee.employeeID}</td>
                        <td class="px-4 text-center">${employee.employeeName}</td>
                        <td class="px-4 text-center">${employee.employeePosition}</td>
                        <td class="px-4 text-center">${employee.employeeDepartment}</td>
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

// delete staff
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

// filter employee list
function filterStaffList() {
    console.log("Filtering staff list...");

    const searchKeyword = document.getElementById("searchKeyword").value.trim().toLowerCase();
    const filterPosition = document.getElementById("filterPosition").value.trim();
    const filterDepartment = document.getElementById("filterDepartment").value.trim();

    fetch("http://localhost:8080/employees")
        .then(response => response.json())
        .then(data => {
            console.log("Original employee data:", data);

            let filteredEmployees = data.filter(employee => {
                const matchesName = employee.employeeName.toLowerCase().includes(searchKeyword);
                const matchesPosition = filterPosition === "" || employee.employeePosition === filterPosition;
                const matchesDepartment = filterDepartment === "" || employee.employeeDepartment === filterDepartment;
                
                return matchesName && matchesPosition && matchesDepartment;
            });

            console.log("Filtered employees:", filteredEmployees);
            renderEmployeeList(filteredEmployees);
        })
        .catch(error => console.error("Error filtering employee list:", error));
}

//Render staff list(For 'filterStaffList()' filtering results)
function renderEmployeeList(employees) {
    const staffList = document.getElementById('staffList');
    staffList.innerHTML = ''; //Clear old data

    employees.forEach(employee => {
        staffList.innerHTML += `
            <tr>
                <td class="px-4 text-center">${employee.employeeID}</td>
                <td class="px-4 text-center">${employee.employeeName}</td>
                <td class="px-4 text-center">${employee.employeePosition}</td>
                <td class="px-4 text-center">${employee.employeeDepartment}</td>
                <td class="px-4 text-center">
                    <button onclick="editEmployee(${employee.employeeID})" class="bg-green-500 text-white rounded px-2 py-1">Edit</button>
                    <button onclick="deleteEmployee(${employee.employeeID})" class="bg-red-500 text-white rounded px-2 py-1">Delete</button>
                </td>
            </tr>
        `;
    });
}


document.addEventListener('DOMContentLoaded', function() {
    loadStaffList();
});

console.log("staffManage.js loaded successfully");