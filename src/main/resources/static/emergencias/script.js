const board = document.getElementById('board-emergencias');
const gridWidth = 9; // columns
const gridHeight = 7; // rows

if (board) {
    // Create the board with roads and cells
    for (let i = 0; i < gridWidth * gridHeight; i++) {
        const cell = document.createElement('div');
        const row = Math.floor(i / gridWidth); // Current row
        const col = i % gridWidth;            // Current column

        if (row === 3 && (col === 1 || col === 3 || col === 5 || col === 7)) {
            // Intersection of horizontal and vertical roads
            cell.classList.add('cell', 'intersection-road');
        } else if (row === 3) {
            // Horizontal road
            cell.classList.add('cell', 'horizontal-road');
        } else if (col === 1 || col === 3 || col === 5 || col === 7) {
            // Vertical roads
            cell.classList.add('cell', 'vertical-road');
        } else {
            // Normal cell
            cell.classList.add('cell');
        }

        board.appendChild(cell);
    }

    // Fetch and render emergency units
    fetch('http://localhost:8083/emergencias/unidades')
        .then(response => response.json())
        .then(units => {
            units.forEach(unit => {
                const index = Math.floor(Math.random() * gridWidth * gridHeight);
                const cell = board.children[index];

                const unitDiv = document.createElement('div');
                unitDiv.classList.add('unit');
                unitDiv.textContent = unit.nombre;
                cell.appendChild(unitDiv);

                // Animate the unit
                setInterval(() => {
                    const newIndex = Math.floor(Math.random() * gridWidth * gridHeight);
                    const newCell = board.children[newIndex];
                    newCell.appendChild(unitDiv);
                }, 2000);
            });
        })
        .catch(error => console.error('Error fetching units:', error));

    // Fetch and render vehicle list
    fetch('http://localhost:8083/emergencias/unidades')
        .then(response => response.json())
        .then(vehicles => {
            const vehicleList = document.getElementById('vehicle-list');
            vehicleList.innerHTML = ''; // Clear the list before adding new vehicles
            vehicles.forEach(vehicle => {
                const listItem = document.createElement('li');
                listItem.textContent = `${vehicle.nombre} - Location: (${vehicle.latitude}, ${vehicle.longitude})`;
                vehicleList.appendChild(listItem);
            });
        })
        .catch(error => console.error('Error fetching vehicles:', error));
} else {
    console.error('Element with id "board-emergencias" not found.');
}