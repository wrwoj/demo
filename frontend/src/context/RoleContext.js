import React, { createContext, useState, useContext, useEffect } from 'react';

const RoleContext = createContext();

export const useRole = () => useContext(RoleContext);

export const RoleProvider = ({ children }) => {
    const [role, setRole] = useState(() => {
        return localStorage.getItem('userRole') || 'USER';
    });

    useEffect(() => {
        localStorage.setItem('userRole', role);
    }, [role]);

    const value = {
        role,
        setRole,
    };

    return <RoleContext.Provider value={value}>{children}</RoleContext.Provider>;
};