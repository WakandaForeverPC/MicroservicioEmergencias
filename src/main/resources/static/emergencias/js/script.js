// Función para obtener y mostrar las unidades de emergencia
function obtenerUnidades() {
    fetch('/emergencias/unidades')
        .then(response => response.json())
        .then(data => {
            const unitList = document.getElementById('unit-list');
            unitList.innerHTML = ''; // Limpiar la lista antes de agregar las nuevas unidades
            data.forEach(unit => {
                const listItem = document.createElement('li');
                listItem.textContent = `${unit.name} - Ubicación: (${unit.latitude}, ${unit.longitude})`;
                unitList.appendChild(listItem);
            });
        })
        .catch(error => console.error('Error al obtener unidades:', error));
}

// Función para enviar una alerta
function enviarAlerta() {
    const alerta = document.getElementById('alertMessage').value;

    if (alerta) {
        fetch('/emergencias/alerta', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(alerta),
        })
            .then(response => response.text())
            .then(data => alert(data)) // Mostrar la respuesta de la API
            .catch(error => console.error('Error al enviar la alerta:', error));
    } else {
        alert('Por favor, ingrese un mensaje de alerta.');
    }
}

// Función para iniciar un rescate
function iniciarRescate() {
    const ubicacion = document.getElementById('rescueLocation').value;

    if (ubicacion) {
        fetch('/emergencias/rescatar', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(ubicacion),
        })
            .then(response => response.text())
            .then(data => alert(data)) // Mostrar la respuesta de la API
            .catch(error => console.error('Error al iniciar el rescate:', error));
    } else {
        alert('Por favor, ingrese una ubicación para el rescate.');
    }
}

obtenerUnidades();
