# legal-advice-frontend/Dockerfile

# Stage 1: Build the React application
FROM node:18-alpine AS build
WORKDIR /app
COPY package.json ./
RUN npm install
COPY . .
RUN npm run build

# Stage 2: Serve the application using Nginx
FROM nginx:1.21.3-alpine
COPY --from=build /app/build /usr/share/nginx/html
RUN rm /etc/nginx/conf.d/default.conf

# Copy the Nginx config template
COPY nginx/nginx.conf /etc/nginx/templates/default.conf.template

# This is the most robust way to start the container.
# It tells envsubst to ONLY substitute the NGINX_BACKEND_URL variable.
CMD ["/bin/sh", "-c", "envsubst '${NGINX_BACKEND_URL}' < /etc/nginx/templates/default.conf.template > /etc/nginx/conf.d/default.conf && nginx -g 'daemon off;'"]

EXPOSE 80