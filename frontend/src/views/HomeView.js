import React from 'react';
import { useRole } from '../context/RoleContext';
import UserView from './UserView';
import ProviderView from './ProviderView';
import AdminView from './AdminView';
import OwnerView from './OwnerView';

const HomeView = () => {
    const { role } = useRole();

    switch (role) {
        case 'PROVIDER':
            return <ProviderView />;
        case 'ADMIN':
            return <AdminView />;
        case 'OWNER':
            return <OwnerView />;
        case 'USER':
        default:
            return <UserView />;
    }
};

export default HomeView;