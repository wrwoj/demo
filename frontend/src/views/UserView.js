import React, { useState, useEffect } from 'react';
import { getPublishedArticles } from '../api/apiService';
import { Link } from 'react-router-dom'; // Import Link

const UserView = () => {
    const [articles, setArticles] = useState([]);

    useEffect(() => {
        getPublishedArticles().then(response => setArticles(response.data));
    }, []);

    return (
        <div>
            <h2>Artykuły i Opinie Prawne</h2>
            <div className="articles-list">
                {articles.map(article => (
                    <div key={article.id} className="card">
                        {/* Każdy artykuł jest teraz linkiem */}
                        <Link to={`/article/${article.id}`} style={{ textDecoration: 'none', color: 'inherit' }}>
                            <h3>{article.title}</h3>
                            <p>Autor: {article.author} | Kategoria: {article.category}</p>
                        </Link>
                    </div>
                ))}
            </div>
        </div>
    );
};

export default UserView;