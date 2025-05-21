# Use the official Node image as the base image (runtime environment)
FROM node:18-alpine

# Create a working directory within the container (equivalent to creating a folder)
WORKDIR /app

# Install the dependencies first (copy package.json and package-lock.json)
COPY package*.json ./

RUN npm install

# Then copy the entire project's source code into the container
COPY . .

# Perform a packaged build of the project (npm run build if using vite)
RUN npm run build

# Hosting static front-end pages with Nginx mirrors
FROM nginx:alpine

# Copy the built front-end static files to Nginx's default html directory
COPY --from=0 /app/dist /usr/share/nginx/html

# Expose the container's port 80 (the default web access port)
EXPOSE 80

# Start the nginx service
CMD ["nginx", "-g", "daemon off;"]
