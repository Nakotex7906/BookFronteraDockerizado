# Etapa 1: Construcción (Build) con Node
FROM node:18-alpine AS build
WORKDIR /app

# Copiamos package.json y package-lock.json (si existe)
COPY package*.json ./
RUN npm install

# Copiamos el resto del código
COPY . .

# Construimos la aplicación para producción
# IMPORTANTE: Definimos la URL de la API como relativa para que Nginx la maneje
ENV VITE_API_URL=/api/v1
RUN npm run build

# Etapa 2: Servidor Web (Nginx)
FROM nginx:alpine

# Copiamos la configuración personalizada de Nginx
COPY nginx.conf /etc/nginx/conf.d/default.conf

# Copiamos los archivos compilados de React (carpeta dist) al directorio de Nginx
COPY --from=build /app/dist /usr/share/nginx/html

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]