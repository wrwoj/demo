import React, { useState, useEffect } from 'react';
import * as api from '../api/apiService';

const LOGGED_IN_OWNER_FIRM_ID = 'lf1';

const OwnerView = () => {
    const [questions, setQuestions] = useState([]);
    const [subscription, setSubscription] = useState(null);

    useEffect(() => {
        api.getOwnerAnsweredQuestions(LOGGED_IN_OWNER_FIRM_ID)
            .then(res => setQuestions(res.data));

        api.getOwnerSubscription(LOGGED_IN_OWNER_FIRM_ID)
            .then(res => setSubscription(res.data));
    }, []);

    const handleAddLawyer = () => {
        const newLawyerData = { name: "Nowy Prawnik", email: "nowy@example.com" };
        api.postOwnerNewLawyer(newLawyerData).then(res => alert(res.data));
    };

    return (
        <div>
            <h2>Panel Właściciela Kancelarii</h2>

            <div className="card">
                <h3>Odpowiedzi na pytania (Twoi Prawnicy)</h3>
                <table className="styled-table">
                    <thead>
                    <tr><th>Tytuł Pytania</th><th>Status</th><th>ID Prawnika, który odp.</th></tr>
                    </thead>
                    <tbody>
                    {questions.map(q => (
                        <tr key={q.id}>
                            <td>{q.title}</td>
                            <td><span className="status-badge status-active">{q.status}</span></td>
                            <td>{q.answeredByProviderId}</td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>

            <div className="card">
                <h3>Zarządzanie Prawnikami</h3>
                <p>Dodaj nowe konto prawnika do swojej kancelarii.</p>
                <button onClick={handleAddLawyer}>Dodaj Nowego Prawnika</button>
            </div>

            <div className="card">
                <h3>Twoja Subskrypcja</h3>
                {subscription ? (
                    <>
                        <p><strong>Plan:</strong> {subscription.planName}</p>
                        <p><strong>Status:</strong> {subscription.status}</p>
                        <p><strong>Następna płatność:</strong> {subscription.nextPaymentDate}</p>
                        <button>Zarządzaj Planem</button>
                    </>
                ) : <p>Ładowanie danych subskrypcji...</p>}
            </div>
        </div>
    );
};

export default OwnerView;