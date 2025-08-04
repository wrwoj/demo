# Legal Advice Platform

A full-stack legal advice platform with React frontend and Spring Boot backend.

## Project Structure

- `frontend/` - React application with nginx for production serving
- `src/` - Spring Boot backend application
- `Dockerfile` - Backend container configuration
- `frontend/Dockerfile` - Frontend container configuration
- `render.yaml` - Render deployment configuration

## Local Development

### Backend
```bash
cd src
./mvnw spring-boot:run
```

### Frontend
```bash
cd frontend
npm install
npm start
```

## Deployment on Render

The application is configured for deployment on Render with two services:

1. **Backend Service** (`legal-backend`) - Spring Boot application
2. **Frontend Service** (`legal-frontend`) - React + Nginx

### Configuration

The `render.yaml` file configures:
- Backend service on port 8080
- Frontend service with nginx proxy to backend
- Environment variables for service communication

### Troubleshooting

If the example data is not loading on Render:

1. **Check Backend Logs**: Look for startup logs showing mock data verification
2. **Test Health Endpoint**: Visit `/api/health` to verify backend is running
3. **Check Nginx Configuration**: Verify `${NGINX_BACKEND_URL}` is set correctly
4. **Test API Endpoints**: Try direct API calls to `/api/articles`

### Debugging Steps

1. **Backend Health Check**:
   ```
   curl https://your-backend-url.onrender.com/api/health
   ```

2. **Test Articles Endpoint**:
   ```
   curl https://your-backend-url.onrender.com/api/articles
   ```

3. **Check Frontend Network Tab**: Look for failed API requests in browser dev tools

### Common Issues

1. **CORS Issues**: Backend is configured to allow all origins
2. **Proxy Configuration**: Frontend uses nginx to proxy `/api` requests to backend
3. **Environment Variables**: Ensure `NGINX_BACKEND_URL` is set in frontend service

### 502 Error Troubleshooting

If you're getting 502 errors:

1. **Check Backend Service Status**:
   - Visit the backend URL directly: `https://legal-backend-xxx.onrender.com/api/health`
   - If this fails, the backend service is not starting properly

2. **Check Environment Variables**:
   - Verify `NGINX_BACKEND_URL` is set correctly in the frontend service
   - The URL should point to the backend service

3. **Check Service Types**:
   - Both services should be `web` type (not `pserv`)
   - This allows the frontend to access the backend

4. **Debug Endpoints**:
   - `/api/debug` - Shows system information and mock data status
   - `/api/status` - Shows service status and data counts

5. **Check Logs**:
   - Backend logs should show startup messages and mock data loading
   - Frontend logs should show nginx proxy configuration

### Service Configuration

- **Backend**: `web` service type, port 8080
- **Frontend**: `web` service type, nginx proxy to backend
- **Environment**: `NGINX_BACKEND_URL` set from backend service URL

## API Endpoints

### User Endpoints
- `GET /api/articles` - Get published articles
- `GET /api/articles/{id}` - Get article by ID
- `GET /api/law-firms/{id}` - Get law firm by ID
- `POST /api/questions` - Submit a question
- `GET /api/articles/{id}/comments` - Get article comments
- `POST /api/articles/{id}/comments` - Add comment

### Admin Endpoints
- `GET /api/admin/users` - Get all users
- `GET /api/admin/articles` - Get all articles
- `POST /api/admin/articles/{id}/approve` - Approve article

### Provider Endpoints
- `GET /api/provider/questions` - Get provider questions
- `POST /api/provider/articles` - Create new article

### Owner Endpoints
- `GET /api/owner/answered-questions/{lawFirmId}` - Get answered questions
- `GET /api/owner/subscription/{lawFirmId}` - Get subscription info

### Debug Endpoints
- `GET /api/health` - Simple health check
- `GET /api/status` - Service status with data counts
- `GET /api/debug` - Detailed system information

## Mock Data

The application uses `MockDataService` to provide sample data:
- Articles with different statuses (Zatwierdzony, Oczekuje)
- Users with different roles (OWNER, PROVIDER)
- Law firms with descriptions
- Questions and comments
- Categories and subscriptions

## Development Notes

- Backend uses H2 in-memory database
- Frontend uses React Router for navigation
- Nginx serves frontend and proxies API requests to backend
- CORS is configured to allow all origins for development 