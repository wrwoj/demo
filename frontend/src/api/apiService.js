import axios from 'axios';

// Add request/response interceptors for debugging
axios.interceptors.request.use(
    config => {
        console.log('API Request:', config.method?.toUpperCase(), config.url);
        return config;
    },
    error => {
        console.error('API Request Error:', error);
        return Promise.reject(error);
    }
);

axios.interceptors.response.use(
    response => {
        console.log('API Response:', response.status, response.config.url);
        return response;
    },
    error => {
        console.error('API Response Error:', error.response?.status, error.config?.url, error.message);
        return Promise.reject(error);
    }
);

// --- User Endpoints ---
export const getPublishedArticles = () => axios.get('/api/articles');
export const postQuestion = (question) => axios.post('/api/questions', { question });
export const getArticleById = (id) => axios.get(`/api/articles/${id}`);
export const getLawFirmById = (id) => axios.get(`/api/law-firms/${id}`);
export const getCommentsForArticle = (articleId) => axios.get(`/api/articles/${articleId}/comments`);
export const postCommentForArticle = (articleId, content) => axios.post(`/api/articles/${articleId}/comments`, content);

// --- Provider Endpoints ---
export const getProviderQuestions = () => axios.get('/api/provider/questions');
export const markQuestionAsAnswered = (id) => axios.post(`/api/provider/questions/${id}/answer`);
export const postNewArticle = (articleData) => axios.post('/api/provider/articles', articleData);

// --- Admin Endpoints ---
export const getAdminUsers = () => axios.get('/api/admin/users');
export const blockAdminUser = (id) => axios.post(`/api/admin/users/${id}/block`);
export const deleteAdminUser = (id) => axios.delete(`/api/admin/users/${id}`);
export const getAdminArticles = () => axios.get('/api/admin/articles');
export const approveAdminArticle = (id) => axios.post(`/api/admin/articles/${id}/approve`);
export const promoteAdminArticle = (id) => axios.post(`/api/admin/articles/${id}/promote`);
export const getAdminCategories = () => axios.get('/api/admin/categories');
export const adminPostNewLawFirm = (firmData) => axios.post('/api/admin/law-firms', firmData);

// --- Owner Endpoints ---
export const getOwnerAnsweredQuestions = (lawFirmId) => axios.get(`/api/owner/answered-questions/${lawFirmId}`);
export const getOwnerSubscription = (lawFirmId) => axios.get(`/api/owner/subscription/${lawFirmId}`);
export const postOwnerNewLawyer = (lawyerData) => axios.post('/api/owner/lawyers', lawyerData);

// --- Debug Endpoints ---
export const testNginxHealth = () => axios.get('/nginx-health');
export const testNginxDebug = () => axios.get('/nginx-debug');
export const testBackendPing = () => axios.get('/api/ping');
export const testBackendSimple = () => axios.get('/api/simple');
export const testBackendHealth = () => axios.get('/api/health');
export const testBackendDirect = () => axios.get('/test-backend');
export const testExternalProxy = () => axios.get('/test-proxy');