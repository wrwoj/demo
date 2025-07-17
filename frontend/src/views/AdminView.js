import React, { useState, useEffect } from 'react';
import * as api from '../api/apiService';

// --- Komponent do zarządzania użytkownikami ---
const UserManagement = () => {
    // Przechowujemy użytkowników w stanie komponentu, aby móc ich modyfikować
    const [users, setUsers] = useState([]);

    useEffect(() => {
        api.getAdminUsers().then(res => setUsers(res.data));
    }, []);

    // Funkcja do usuwania użytkownika
    const handleDeleteUser = (id) => {
        api.deleteAdminUser(id).then(res => {
            alert(res.data); // Pokaż alert z API
            // Usuń użytkownika z lokalnego stanu, aby UI się odświeżyło
            setUsers(currentUsers => currentUsers.filter(user => user.id !== id));
        });
    };

    // Funkcja do zmiany statusu użytkownika
    const handleToggleUserStatus = (id) => {
        api.blockAdminUser(id).then(res => { // Używamy tego samego endpointu dla symulacji
            alert(res.data); // Pokaż alert z API
            // Zaktualizuj status użytkownika w lokalnym stanie
            setUsers(currentUsers =>
                currentUsers.map(user =>
                    user.id === id
                        ? { ...user, status: user.status === 'Aktywny' ? 'Zablokowany' : 'Aktywny' }
                        : user
                )
            );
        });
    };

    return (
        <div>
            <h3>Zarządzanie Użytkownikami (Prawnikami)</h3>
            <table className="styled-table">
                <thead>
                <tr><th>Nazwa</th><th>Email</th><th>Status</th><th>Akcje</th></tr>
                </thead>
                <tbody>
                {users.map(u => (
                    <tr key={u.id}>
                        <td>{u.name}</td>
                        <td>{u.email}</td>
                        <td>
                                <span className={`status-badge ${u.status === 'Aktywny' ? 'status-active' : 'status-blocked'}`}>
                                    {u.status}
                                </span>
                        </td>
                        <td>
                            <button onClick={() => handleToggleUserStatus(u.id)}>
                                {u.status === 'Aktywny' ? 'Blokuj' : 'Aktywuj'}
                            </button>
                            <button className="danger" onClick={() => handleDeleteUser(u.id)}>Usuń</button>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};


// --- Komponent do zarządzania artykułami ---
const ArticleManagement = () => {
    // Przechowujemy artykuły w stanie, aby móc je modyfikować
    const [articles, setArticles] = useState([]);

    useEffect(() => {
        api.getAdminArticles().then(res => setArticles(res.data));
    }, []);

    // Funkcja do zatwierdzania artykułu
    const handleApproveArticle = (id) => {
        api.approveAdminArticle(id).then(res => {
            alert(res.data);
            // Zmień status w lokalnym stanie
            setArticles(currentArticles =>
                currentArticles.map(article =>
                    article.id === id ? { ...article, status: 'Zatwierdzony' } : article
                )
            );
        });
    };

    // Funkcja do promowania artykułu
    const handleTogglePromotion = (id) => {
        api.promoteAdminArticle(id).then(res => {
            alert(res.data);
            // Przełącz flagę promocji w lokalnym stanie
            setArticles(currentArticles =>
                currentArticles.map(article =>
                    article.id === id ? { ...article, isPromoted: !article.isPromoted } : article
                )
            );
        });
    };

    return (
        <div>
            <h3>Zarządzanie Opiniami Prawnymi</h3>
            <table className="styled-table">
                <thead>
                <tr><th>Tytuł</th><th>Autor</th><th>Status</th><th>Promocja</th><th>Akcje</th></tr>
                </thead>
                <tbody>
                {articles.map(a => (
                    <tr key={a.id}>
                        <td>{a.title}</td>
                        <td>{a.author}</td>
                        <td>
                                <span className={`status-badge ${a.status === 'Zatwierdzony' ? 'status-active' : 'status-waiting'}`}>
                                    {a.status}
                                </span>
                        </td>
                        <td>{a.isPromoted ? 'Tak' : 'Nie'}</td>
                        <td>
                            {a.status !== 'Zatwierdzony' && (
                                <button onClick={() => handleApproveArticle(a.id)}>Zatwierdź</button>
                            )}
                            <button onClick={() => handleTogglePromotion(a.id)}>
                                {a.isPromoted ? 'Anuluj promocję' : 'Promuj'}
                            </button>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

// Główny widok admina (bez zmian)
const AdminView = () => (
    <div>
        <h2>Panel Administratora</h2>
        <div className="card">
            <UserManagement />
        </div>
        <div className="card">
            <ArticleManagement />
        </div>
        <div className="card">
            <h3>Zarządzanie Płatnościami i Raporty</h3>
            <p><i>(W tym miejscu znajdowałyby się komponenty do generowania faktur i przeglądania raportów)</i></p>
            <button onClick={() => alert('Faktura pro forma wygenerowana (symulacja)')}>Generuj Pro Formę</button>
        </div>
        <div className="card">
            <h3>Dodaj nową Kancelarię</h3>
            <p><i>(Prosty formularz do symulacji dodawania kancelarii)</i></p>
            <button onClick={() => {
                const firmData = { name: "Nowa Kancelaria Testowa", address: "ul. Wirtualna 1" };
                api.adminPostNewLawFirm(firmData).then(res => alert(res.data));
            }}>
                Dodaj Kancelarię Testową
            </button>
        </div>
    </div>
);

export default AdminView;