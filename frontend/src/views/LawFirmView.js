import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import { getLawFirmById, postQuestion } from '../api/apiService';

const LawFirmView = () => {
    const { id } = useParams();
    const [firm, setFirm] = useState(null);

    useEffect(() => {
        getLawFirmById(id)
            .then(response => setFirm(response.data))
            .catch(error => console.error("Błąd podczas pobierania danych kancelarii:", error));
    }, [id]);

    const handleAskQuestion = () => {
        postQuestion("To jest treść pytania do kancelarii.")
            .then(response => alert(response.data));
    };

    if (!firm) {
        return <div>Ładowanie...</div>;
    }

    return (
        <div className="card">
            <h2>{firm.name}</h2>
            <p><strong>Adres:</strong> {firm.address}</p>
            <hr />
            <p>{firm.description}</p>
            <hr />
            <h3>Skontaktuj się z kancelarią</h3>
            <p>Masz pytanie do specjalistów z tej kancelarii? Użyj poniższego przycisku.</p>
            <button onClick={handleAskQuestion}>Zadaj pytanie</button>
        </div>
    );
};

export default LawFirmView;