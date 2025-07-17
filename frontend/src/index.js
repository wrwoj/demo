import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import { RoleProvider } from './context/RoleContext';
import { BrowserRouter } from 'react-router-dom'; // Import
import './index.css';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <React.StrictMode>
        <BrowserRouter>
            <RoleProvider>
                <App />
            </RoleProvider>
        </BrowserRouter>
    </React.StrictMode>
);