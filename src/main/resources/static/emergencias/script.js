document.addEventListener('DOMContentLoaded', () => {
    const board = document.getElementById('board');
    const alertList = document.getElementById('alert-list');
    const rescueList = document.getElementById('rescue-list');
    const unitList = document.getElementById('unit-list');
    const gridWidth = 9; // columns
    const gridHeight = 7; // rows

    // Creacion de tablero
    for (let i = 0; i < gridWidth * gridHeight; i++) {
        const cell = document.createElement('div');
        const row = Math.floor(i / gridWidth); // Current row
        const col = i % gridWidth;            // Current column

        if (row === 3 && (col === 1 || col === 3 || col === 5 || col === 7)) {
            cell.classList.add('cell', 'intersection-road');
        } else if (row === 3) {
            cell.classList.add('cell', 'horizontal-road');
        } else if (col === 1 || col === 3 || col === 5 || col === 7) {
            cell.classList.add('cell', 'vertical-road');
        } else {
            cell.classList.add('cell');
        }

        board.appendChild(cell);
    }

    const vehicleMarkers = {};
    const alertMarkers = {};
    const rescueMarkers = {};

    const updateVehiclePosition = (vehicle) => {
        console.log('Updating vehicle position:', vehicle);
        const index = Math.floor(vehicle.y) * gridWidth + Math.floor(vehicle.x);
        const cell = board.children[index];

        if (!vehicleMarkers[vehicle.id]) {
            const vehicleDiv = document.createElement('div');
            vehicleDiv.classList.add('vehicle');
            vehicleDiv.textContent = vehicle.type;
            cell.appendChild(vehicleDiv);
            vehicleMarkers[vehicle.id] = vehicleDiv;
        } else {
            const vehicleDiv = vehicleMarkers[vehicle.id];
            vehicleDiv.style.top = `${Math.floor(vehicle.y) * 100}px`;
            vehicleDiv.style.left = `${Math.floor(vehicle.x) * 100}px`;
        }
    };

    const updateAlertPosition = (alert) => {
        console.log('Updating alert position:', alert);
        const index = Math.floor(alert.y) * gridWidth + Math.floor(alert.x);
        const cell = board.children[index];

        if (!alertMarkers[alert.mensaje]) {
            const alertDiv = document.createElement('div');
            alertDiv.classList.add('alert');
            alertDiv.textContent = alert.mensaje;
            cell.appendChild(alertDiv);
            alertMarkers[alert.mensaje] = alertDiv;
        }
    };

    const updateRescuePosition = (rescue) => {
        console.log('Updating rescue position:', rescue);
        const index = Math.floor(rescue.y) * gridWidth + Math.floor(rescue.x);
        const cell = board.children[index];

        if (!rescueMarkers[rescue.descripcion]) {
            const rescueDiv = document.createElement('div');
            rescueDiv.classList.add('rescue');
            rescueDiv.textContent = rescue.descripcion;
            cell.appendChild(rescueDiv);
            rescueMarkers[rescue.descripcion] = rescueDiv;
        }
    };

    const fetchAndUpdateVehicles = () => {
        fetch('/emergencias/vehiculos')
            .then(response => response.json())
            .then(vehicles => {
                console.log('Fetched vehicles:', vehicles);
                unitList.innerHTML = '';
                vehicles.forEach(vehicle => {
                    updateVehiclePosition(vehicle);
                    const unitItem = document.createElement('li');
                    unitItem.textContent = `${vehicle.type} (${vehicle.x}, ${vehicle.y})`;
                    unitList.appendChild(unitItem);
                });
            })
            .catch(error => console.error('Error fetching vehicles:', error));
    };

    const fetchAndDisplayAlerts = () => {
        fetch('/emergencias/alertas')
            .then(response => response.json())
            .then(alerts => {
                console.log('Fetched alerts:', alerts);
                alertList.innerHTML = ''; // Clear the list before updating
                alerts.forEach(alert => {
                    updateAlertPosition(alert);
                    const alertItem = document.createElement('li');
                    alertItem.textContent = `${alert.mensaje} (${alert.x}, ${alert.y})`;
                    alertList.appendChild(alertItem);
                });
            })
            .catch(error => console.error('Error fetching alerts:', error));
    };

    const fetchAndDisplayRescues = () => {
        fetch('/emergencias/rescates')
            .then(response => response.json())
            .then(rescues => {
                console.log('Fetched rescues:', rescues);
                rescueList.innerHTML = '';
                rescues.forEach(rescue => {
                    updateRescuePosition(rescue);
                    const rescueItem = document.createElement('li');
                    rescueItem.textContent = `${rescue.descripcion} (${rescue.x}, ${rescue.y})`;
                    rescueList.appendChild(rescueItem);
                });
            })
            .catch(error => console.error('Error fetching rescues:', error));
    };

    fetchAndUpdateVehicles();
    fetchAndDisplayAlerts();
    fetchAndDisplayRescues();
});