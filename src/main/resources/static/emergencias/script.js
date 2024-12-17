document.addEventListener('DOMContentLoaded', () => {
    const bedOccupancyChartCtx = document.getElementById('bedOccupancyChart').getContext('2d');
    const bedOccupancyChart = new Chart(bedOccupancyChartCtx, {
        type: 'bar',
        data: {
            labels: ['Ocupadas', 'Disponibles'],
            datasets: [{
                label: 'Camas',
                data: [0, 0],
                backgroundColor: ['#ff6384', '#36a2eb']
            }]
        },
        options: {
            responsive: true,
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });

    const updateBedOccupancyChart = (occupied, available) => {
        bedOccupancyChart.data.datasets[0].data = [occupied, available];
        bedOccupancyChart.update();
    };

    const fetchPatients = () => {
        fetch('/emergencias/pacientes')
            .then(response => response.json())
            .then(patients => {
                const patientList = document.getElementById('patient-list');
                patientList.innerHTML = '';
                patients.forEach(patient => {
                    const listItem = document.createElement('li');
                    listItem.textContent = `${patient.nombre}, ${patient.edad} años, ${patient.nacionalidad}`;
                    patientList.appendChild(listItem);
                });
                updateBedOccupancyChart(patients.length, 100 - patients.length);
            })
            .catch(error => console.error('Error fetching patients:', error));
    };

    document.getElementById('admit-patient-form').addEventListener('submit', event => {
        event.preventDefault();
        const patientName = document.getElementById('patient-name').value;
        const patientAge = document.getElementById('patient-age').value;
        const patientNationality = document.getElementById('patient-nationality').value;
        fetch('/emergencias/admision', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ nombre: patientName, edad: patientAge, nacionalidad: patientNationality })
        })
            .then(response => response.json())
            .then(() => {
                fetchPatients();
                document.getElementById('admit-patient-form').reset();
            })
            .catch(error => console.error('Error admitting patient:', error));
    });

    fetchPatients();
});