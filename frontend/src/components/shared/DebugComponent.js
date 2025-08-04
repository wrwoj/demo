import React, { useState } from 'react';
import { 
    testNginxHealth, 
    testNginxDebug, 
    getPublishedArticles,
    testBackendPing,
    testBackendSimple,
    testBackendHealth,
    testBackendDirect,
    testExternalProxy
} from '../../api/apiService';

const DebugComponent = () => {
    const [results, setResults] = useState({});

    const testEndpoint = async (name, testFunction) => {
        try {
            console.log(`Testing ${name}...`);
            const response = await testFunction();
            setResults(prev => ({
                ...prev,
                [name]: { success: true, data: response.data, status: response.status }
            }));
            console.log(`${name} result:`, response.data);
        } catch (error) {
            console.error(`${name} error:`, error);
            setResults(prev => ({
                ...prev,
                [name]: { 
                    success: false, 
                    error: error.message, 
                    status: error.response?.status,
                    data: error.response?.data
                }
            }));
        }
    };

    const runAllTests = async () => {
        setResults({});
        await testEndpoint('nginx-health', testNginxHealth);
        await testEndpoint('nginx-debug', testNginxDebug);
        await testEndpoint('external-proxy', testExternalProxy);
        await testEndpoint('backend-direct', testBackendDirect);
        await testEndpoint('backend-ping', testBackendPing);
        await testEndpoint('backend-simple', testBackendSimple);
        await testEndpoint('backend-health', testBackendHealth);
        await testEndpoint('api-articles', getPublishedArticles);
    };

    return (
        <div style={{ padding: '20px', border: '1px solid #ccc', margin: '20px' }}>
            <h3>Debug Component</h3>
            <button onClick={runAllTests} style={{ marginBottom: '10px' }}>
                Run All Tests
            </button>
            
            <div>
                <h4>Test Results:</h4>
                {Object.entries(results).map(([name, result]) => (
                    <div key={name} style={{ margin: '10px 0', padding: '10px', border: '1px solid #ddd' }}>
                        <h5>{name}</h5>
                        <p>Status: {result.success ? 'SUCCESS' : 'FAILED'}</p>
                        <p>HTTP Status: {result.status}</p>
                        {result.success ? (
                            <pre>{JSON.stringify(result.data, null, 2)}</pre>
                        ) : (
                            <div>
                                <p>Error: {result.error}</p>
                                {result.data && <pre>{JSON.stringify(result.data, null, 2)}</pre>}
                            </div>
                        )}
                    </div>
                ))}
            </div>
        </div>
    );
};

export default DebugComponent; 