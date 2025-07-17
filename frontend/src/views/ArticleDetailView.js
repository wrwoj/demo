import React, { useState, useEffect } from 'react';
import { useParams, Link } from 'react-router-dom';
import { getArticleById } from '../api/apiService';

const ArticleDetailView = () => {
    const { id } = useParams(); // Pobierz ID z URL
    const [article, setArticle] = useState(null);

    useEffect(() => {
        getArticleById(id)
            .then(response => setArticle(response.data))
            .catch(error => console.error("Błąd podczas pobierania artykułu:", error));
    }, [id]);

    if (!article) {
        return <div>Ładowanie...</div>;
    }

    return (
        <div className="card">
            <h2>{article.title}</h2>
            <p><strong>Autor:</strong> {article.author} | <strong>Data publikacji:</strong> {article.date}</p>
            <hr />
            <p style={{ whiteSpace: 'pre-wrap' }}>{article.content}</p>
            <hr />
            <p>
                Artykuł przygotowany przez:
                <Link to={`/law-firm/${article.lawFirmId}`}>
                    <strong> Kancelarię Prawną (kliknij, aby zobaczyć szczegóły)</strong>
                </Link>
            </p>
        </div>
    );
};

export default ArticleDetailView;