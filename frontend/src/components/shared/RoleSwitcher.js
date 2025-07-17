import React from 'react';
import {useRole} from '../../context/RoleContext';
import {useNavigate} from 'react-router-dom';

const RoleSwitcher = () => {
    const {role, setRole} = useRole();
    const navigate = useNavigate();

    const handleRoleChange = (newRole) => {
        setRole(newRole);
        navigate('/');
    };

    return (
        <div className="role-switcher">
            <button
                disabled={role === 'USER'}
                onClick={() => handleRoleChange('USER')}
            >
                👤 Widok Użytkownika
            </button>
            <button
                disabled={role === 'PROVIDER'}
                onClick={() => handleRoleChange('PROVIDER')}
            >
                ⚖️ Widok Prawnika
            </button>
            <button
                disabled={role === 'OWNER'}
                onClick={() => handleRoleChange('OWNER')}
            >
                👑 Widok Właściciela
            </button>
            <button
                disabled={role === 'ADMIN'}
                onClick={() => handleRoleChange('ADMIN')}
            >
                ⚙️ Widok Administratora
            </button>
        </div>
    );
};

export default RoleSwitcher;