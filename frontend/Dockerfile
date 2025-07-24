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

# CORRECTED COMMAND
# This now exports a DOLLAR variable to protect Nginx's internal variables
# before substituting the backend URL.
CMD ["/bin/sh", "-c", "export DOLLAR='$' && export NGINX_BACKEND_URL=http://$NGINX_BACKEND_HOST:$NGINX_BACKEND_PORT && envsubst < /etc/nginx/templates/default.conf.template > /etc/nginx/conf.d/default.conf && nginx -g 'daemon off;'"]

EXPOSE 80