import axios from 'axios';

// --- User Endpoints ---
export const getPublishedArticles = () => axios.get('/api/articles');
export const postQuestion = (question) => axios.post('/api/questions', { question });

// --- Provider Endpoints ---
export const getProviderQuestions = () => axios.get('/api/provider/questions');
export const markQuestionAsAnswered = (id) => axios.post(`/api/provider/questions/${id}/answer`);

// --- Admin Endpoints ---
export const getAdminUsers = () => axios.get('/api/admin/users');
export const blockAdminUser = (id) => axios.post(`/api/admin/users/${id}/block`);
export const deleteAdminUser = (id) => axios.delete(`/api/admin/users/${id}`);

export const getAdminArticles = () => axios.get('/api/admin/articles');
export const approveAdminArticle = (id) => axios.post(`/api/admin/articles/${id}/approve`);
export const promoteAdminArticle = (id) => axios.post(`/api/admin/articles/${id}/promote`);

export const postNewArticle = (articleData) => axios.post('/api/provider/articles', articleData);

export const adminPostNewLawFirm = (firmData) => axios.post('/api/admin/law-firms', firmData);

// --- Owner Endpoints ---
export const getOwnerAnsweredQuestions = (lawFirmId) => axios.get(`/api/owner/answered-questions/${lawFirmId}`);
export const getOwnerSubscription = (lawFirmId) => axios.get(`/api/owner/subscription/${lawFirmId}`);
export const postOwnerNewLawyer = (lawyerData) => axios.post('/api/owner/lawyers', lawyerData);
export const getArticleById = (id) => axios.get(`/api/articles/${id}`);
export const getLawFirmById = (id) => axios.get(`/api/law-firms/${id}`);