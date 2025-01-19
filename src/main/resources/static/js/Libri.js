document.addEventListener('DOMContentLoaded', function() {
   
    fetch('/api/libri')
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            const table = document.getElementById('libriTable');
            let html = `
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Titolo</th>
                        <th>Autore</th>
                        <th>Anno di pubblicazione</th>
                        <th>Categoria</th>
                        <th>Prezzo</th>
                    </tr>
                </thead>
                <tbody>`;

           
            data.forEach(Libro => {
                html += `
                    <tr>
                        <td>${Libro.id}</td>
                        <td>${Libro.titolo}</td>
                        <td>${Libro.autore}</td>
                        <td>${Libro.anno_pubblicazione}</td>
                        <td>${Libro.categoria}</td>
                        <td>${Libro.prezzo}</td>
                    </tr>`;
            });

            html += '</tbody>';
            
           
            table.innerHTML = html;
        })
        .catch(error => console.error('Errore:', error)); 
});
