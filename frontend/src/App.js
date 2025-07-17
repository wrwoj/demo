import React from 'react';
import { Routes, Route } from 'react-router-dom';
import Header from './components/shared/Header';
import HomeView from './views/HomeView';
import ArticleDetailView from './views/ArticleDetailView';
import LawFirmView from './views/LawFirmView';
import './App.css';

function App() {
    return (
        <div className="App">
            <Header />
            <main className="container">
                <Routes>
                    <Route path="/" element={<HomeView />} />
                    <Route path="/article/:id" element={<ArticleDetailView />} />
                    <Route path="/law-firm/:id" element={<LawFirmView />} />
                </Routes>
            </main>
        </div>
    );
}

export default App;