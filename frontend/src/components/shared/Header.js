import React from 'react';
import RoleSwitcher from './RoleSwitcher';

const Header = () => {
    const handleReset = () => {
        window.location.reload();
    };

    return (
        <header className="app-header">
            <h1>Portal Porad Prawnych (Demo)</h1>
            <div className="top-bar-controls">
                <button onClick={handleReset} className="reset-btn">
                    🔄 Resetuj Zmiany
                </button>
                <RoleSwitcher />
            </div>
        </header>
    );
};

export default Header;