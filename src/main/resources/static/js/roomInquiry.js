//Store all room data returned from the back end
let allRooms = [];

//Store the room that the user has selected
let selectedRooms = [];

//After the DOM loads, get all the rooms first
document.addEventListener('DOMContentLoaded', () => {
    fetch('/rooms')
      .then(resp => resp.json())
      .then(data => {
        //Save all room data to the global variable and mark isSelected
        allRooms = data.map(room => ({
          ...room,
          isSelected: false, //By default all rooms are not selected
        }));
        //Initial render: Displays all rooms
        renderRooms(allRooms);
      })
      .catch(err => console.error('Error fetching rooms:', err));
  
    //Bind the search button event
    const searchBtn = document.getElementById('searchBtn');
    if (searchBtn) {
      searchBtn.addEventListener('click', () => {
        filterRooms();
      });
    }
});

/**
 * Render the Search Results table
 * @param {Array} rooms - An array of rooms to display
 */
function renderRooms(rooms) {
  const roomsTableBody = document.querySelector('#roomsTable tbody');
  if (!roomsTableBody) return;

  roomsTableBody.innerHTML = ''; //Clear old content

  //Only rooms that are not selected are displayed
  const toDisplay = rooms.filter(r => !r.isSelected);
  toDisplay.forEach(room => {
    roomsTableBody.innerHTML += `
      <tr>
        <td class="border px-4 py-2 text-center">${room.roomNumber}</td>
        <td class="border px-4 py-2 text-center">${room.roomType}</td>
        <td class="border px-4 py-2 text-center">${room.roomPrice}</td>
        <td class="border px-4 py-2 text-center">
          <button
            class="bg-green-500 text-white px-2 py-1 rounded"
            onclick="addRoom(${room.roomNumber})">
            Add
          </button>
        </td>
      </tr>
    `;
  });
}

//Front-end search (Filter by room type only)
function filterRooms() {
    //Gets the value of the drop-down box
    const roomTypeSelect = document.getElementById('roomType');
    if (!roomTypeSelect) return;
  
    const selectedType = roomTypeSelect.value; // "all"、"Deluxe"、"Standard"、"Suite", etc
    let filtered = allRooms;
    if (selectedType && selectedType !== 'all') {
      filtered = filtered.filter(r => r.roomType === selectedType);
    }
    //Render filtered results (automatically filter selected rooms)
    renderRooms(filtered);
}
  
/**
 * Add Rooms to "Selected Rooms"
 * @param {number} roomNumber - Select the room number
 */
function addRoom(roomNumber) {
    //Find the corresponding room in allRooms
    const room = allRooms.find(r => r.roomNumber === roomNumber);
    if (!room) return;

    //Check whether it has been added
    const alreadySelected = selectedRooms.some(r => r.roomNumber === roomNumber);
    if (!alreadySelected) {
      selectedRooms.push(room);
      room.isSelected = true; //Mark as selected
    }

    //Re-render the selected rooms and search results
    renderSelectedRooms();
    filterRooms();
}

//Render the "Selected Rooms" table and calculate the total price
function renderSelectedRooms() {
  const selectedBody = document.getElementById('selectedRoomsBody');
  if (!selectedBody) return;

  selectedBody.innerHTML = '';

  let total = 0;
  selectedRooms.forEach(room => {
    selectedBody.innerHTML += `
      <tr>
        <td class="border px-4 py-2 text-center">${room.roomNumber}</td>
        <td class="border px-4 py-2 text-center">${room.roomType}</td>
        <td class="border px-4 py-2 text-center">${room.roomPrice}</td>
        <td class="border px-4 py-2 text-center">
          <button
            class="bg-red-500 text-white px-2 py-1 rounded"
            onclick="removeRoom(${room.roomNumber})">
            Remove
          </button>
        </td>
      </tr>
    `;
    total += room.roomPrice || 0;
  });

  //show total price
  const totalPriceEl = document.getElementById('totalPrice');
  if (totalPriceEl) {
    totalPriceEl.textContent = total;
  }
}

/**
 *Remove a room from Selected Rooms
 * @param {number} roomNumber - Number of the room to be removed
 */
function removeRoom(roomNumber) {
  //Find the room in selectedRooms
  const room = selectedRooms.find(r => r.roomNumber === roomNumber);
  if (!room) return;

  //Mark isSelected = false to make it visible again in the display list
  room.isSelected = false;

  //Removes from the selectedRooms array
  selectedRooms = selectedRooms.filter(r => r.roomNumber !== roomNumber);

  //Rerender the selected rooms and search list
  renderSelectedRooms();
  filterRooms();
}
