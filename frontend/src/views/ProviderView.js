import React, { useState, useEffect } from 'react';
import { getProviderQuestions, markQuestionAsAnswered, postNewArticle } from '../api/apiService';

const ProviderView = () => {
    const [questions, setQuestions] = useState([]);

    const [title, setTitle] = useState('');
    const [content, setContent] = useState('');
    const [category, setCategory] = useState('');

    useEffect(() => {
        getProviderQuestions().then(response => setQuestions(response.data));
    }, []);

    const handleAnswer = (id) => {
        markQuestionAsAnswered(id).then(response => {
            alert(response.data);
            setQuestions(prev => prev.filter(q => q.id !== id));
        });
    };

    const handleArticleSubmit = (e) => {
        e.preventDefault();
        if (!title || !content || !category) {
            alert("Proszę wypełnić wszystkie pola!");
            return;
        }

        const articleData = { title, content, category };

        postNewArticle(articleData).then(response => {
            alert(response.data);
            setTitle('');
            setContent('');
            setCategory('');
        }).catch(error => {
            console.error("Błąd podczas dodawania artykułu:", error);
            alert("Wystąpił błąd.");
        });
    };

    return (
        <div>
            <div className="card">
                <h2>Pytania od Użytkowników</h2>
                <table className="styled-table">
                    <thead>
                    <tr>
                        <th>Tytuł Pytania</th>
                        <th>Autor</th>
                        <th>Status</th>
                        <th>Akcja</th>
                    </tr>
                    </thead>
                    <tbody>
                    {questions.map(q => (
                        <tr key={q.id}>
                            <td>{q.title}</td>
                            <td>{q.author}</td>
                            <td><span className="status-badge status-waiting">{q.status}</span></td>
                            <td><button onClick={() => handleAnswer(q.id)}>Oznacz jako odpowiedziane</button></td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>

            <div className="card">
                <h2>Dodaj nowy artykuł</h2>
                <form onSubmit={handleArticleSubmit} className="article-form">
                    <div className="form-group">
                        <label htmlFor="title">Tytuł artykułu</label>
                        <input
                            type="text"
                            id="title"
                            value={title}
                            onChange={(e) => setTitle(e.target.value)}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="category">Kategoria</label>
                        <input
                            type="text"
                            id="category"
                            placeholder="np. Prawo rodzinne"
                            value={category}
                            onChange={(e) => setCategory(e.target.value)}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="content">Treść</label>
                        <textarea
                            id="content"
                            rows="10"
                            value={content}
                            onChange={(e) => setContent(e.target.value)}
                        ></textarea>
                    </div>
                    <button type="submit" className="submit-btn">Prześlij do weryfikacji</button>
                </form>
            </div>
        </div>
    );
};

export default ProviderView;